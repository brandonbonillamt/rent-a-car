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
    
    public Car update(Car one) {
        if (one.getIdCar() != null) {
            Optional<Car> e = crudMethods.getOne(one.getIdCar());
            if (e.isPresent()) {
                if (one.getName() != null) {
                    e.get().setName(one.getName());
                }
                if (one.getBrand() != null) {
                    e.get().setBrand(one.getBrand());
                }
                if (one.getYear() != null) {
                    e.get().setYear(one.getYear());
                }
                if (one.getDescription() != null) {
                    e.get().setDescription(one.getDescription());
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
