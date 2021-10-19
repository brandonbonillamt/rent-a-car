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
    
    public Score update(Score one) {
        if (one.getIdScore() != null) {
            Optional<Score> e = crudMethods.getOne(one.getIdScore());
            if (e.isPresent()) {
                if (one.getStars() != null) {
                    e.get().setStars(one.getStars());
                }
                if (one.getMessageText() != null) {
                    e.get().setMessageText(one.getMessageText());
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
