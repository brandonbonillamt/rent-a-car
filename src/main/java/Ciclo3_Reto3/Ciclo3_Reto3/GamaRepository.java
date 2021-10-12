/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3_Reto3.Ciclo3_Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL - PC
 */
@Repository
public class GamaRepository {
    
    @Autowired
    private GamaCrudRepository crud;

    public List<Gama> getAll() {
        return (List<Gama>) crud.findAll();
    }

    public Optional<Gama> getGama(int id) {
        return crud.findById(id);
    }

    public Gama save(Gama gama) {
        return crud.save(gama);
    }
}