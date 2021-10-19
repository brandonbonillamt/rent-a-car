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
public class CarRepository {

    @Autowired
    private CarCrudRepository crud;

    public List<Car> getAll() {
        return (List<Car>) crud.findAll();
    }

    public Optional<Car> getOne(int id) {
        return crud.findById(id);
    }

    public Car save(Car one) {
        return crud.save(one);
    }
    
    public void delete(Car one) {
        crud.delete(one);
    }
}
