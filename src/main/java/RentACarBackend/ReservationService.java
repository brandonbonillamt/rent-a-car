/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RentACarBackend;

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
    
    public Reservation update(Reservation one) {
        if (one.getIdReservation() != null) {
            Optional<Reservation> e = crudMethods.getOne(one.getIdReservation());
            if (e.isPresent()) {
                if (one.getStartDate() != null) {
                    e.get().setStartDate(one.getStartDate());
                }
                if (one.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(one.getDevolutionDate());
                }
                if (one.getStatus() != null) {
                    e.get().setStatus(one.getStatus());
                }
                crudMethods.save(e.get());
                return e.get();
            } else {
                return one;
            }
        } else {
            return one;
        }
    }
    
    public boolean delete(int id) {
        Boolean aBoolean = getOne(id).map(one -> {
            crudMethods.delete(one);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
