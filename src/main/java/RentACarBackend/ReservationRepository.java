/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RentACarBackend;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL - PC
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository crud;

    public List<Reservation> getAll() {
        return (List<Reservation>) crud.findAll();
    }

    public Optional<Reservation> getOne(int id) {
        return crud.findById(id);
    }

    public Reservation save(Reservation one) {
        return crud.save(one);
    }
    
    public void delete(Reservation one) {
        crud.delete(one);
    }
}
