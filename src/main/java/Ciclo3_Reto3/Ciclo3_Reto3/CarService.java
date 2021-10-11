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
public class CarService {

    @Autowired
    private CarRepository crudMethods;

    public List<Car> getAll() {
        return crudMethods.getAll();
    }

    public Optional<Car> getOne(int id) {
        return crudMethods.getOne(id);
    }

    public Car save(Car one) {
        if (one.getIdCar() == null) {
            return crudMethods.save(one);
        } else {
            Optional<Car> evt = crudMethods.getOne(one.getIdCar());
            if (evt.isEmpty()) {
                return crudMethods.save(one);
            } else {
                return one;
            }
        }
    }
}
