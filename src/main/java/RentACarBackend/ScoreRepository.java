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
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository crud;

    public List<Score> getAll() {
        return (List<Score>) crud.findAll();
    }

    public Optional<Score> getOne(int id) {
        return crud.findById(id);
    }

    public Score save(Score one) {
        return crud.save(one);
    }
    
    public void delete(Score one) {
        crud.delete(one);
    }
}
