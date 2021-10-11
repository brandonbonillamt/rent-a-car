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
public class GamaService {
    
    @Autowired
    private GamaRepository crudMethods;

    public List<Gama> getAll() {
        return crudMethods.getAll();
    }

    public Optional<Gama> getGama(int id) {
        return crudMethods.getGama(id);
    }

    public Gama save(Gama gama) {
        if (gama.getIdGama() == null) {
            return crudMethods.save(gama);
        } else {
            Optional<Gama> evt = crudMethods.getGama(gama.getIdGama());
            if (evt.isEmpty()) {
                return crudMethods.save(gama);
            } else {
                return gama;
            }
        }
    }
}
