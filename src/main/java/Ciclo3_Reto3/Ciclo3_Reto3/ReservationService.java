/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3_Reto3.Ciclo3_Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL - PC
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository crudMethods;

    public List<Reservation> getAll() {
        return crudMethods.getAll();
    }

    public Optional<Reservation> getOne(int id) {
        return crudMethods.getOne(id);
    }

    public Reservation save(Reservation one) {
        if (one.getIdReservation() == null) {
            return crudMethods.save(one);
        } else {
            Optional<Reservation> evt = crudMethods.getOne(one.getIdReservation());
            if (evt.isEmpty()) {
                return crudMethods.save(one);
            } else {
                return one;
            }
        }
    }
}
