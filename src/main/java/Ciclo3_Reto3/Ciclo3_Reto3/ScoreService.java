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
public class ScoreService {
    
    @Autowired
    private ScoreRepository crudMethods;

    public List<Score> getAll() {
        return crudMethods.getAll();
    }

    public Optional<Score> getOne(int id) {
        return crudMethods.getOne(id);
    }

    public Score save(Score one) {
        if (one.getIdScore() == null) {
            return crudMethods.save(one);
        } else {
            Optional<Score> evt = crudMethods.getOne(one.getIdScore());
            if (evt.isEmpty()) {
                return crudMethods.save(one);
            } else {
                return one;
            }
        }
    }
}
