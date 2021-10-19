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

    public Gama update(Gama one) {
        if (one.getIdGama() != null) {
            Optional<Gama> e = crudMethods.getGama(one.getIdGama());
            if (e.isPresent()) {
                if (one.getName() != null) {
                    e.get().setName(one.getName());
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
        Boolean aBoolean = getGama(id).map(one -> {
            crudMethods.delete(one);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
