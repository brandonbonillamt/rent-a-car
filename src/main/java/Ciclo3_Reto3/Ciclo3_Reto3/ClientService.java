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
public class ClientService {
    
    @Autowired
    private ClientRepository crudMethods;

    public List<Client> getAll() {
        return crudMethods.getAll();
    }

    public Optional<Client> getOne(int id) {
        return crudMethods.getOne(id);
    }

    public Client save(Client one) {
        if (one.getIdClient() == null) {
            return crudMethods.save(one);
        } else {
            Optional<Client> evt = crudMethods.getOne(one.getIdClient());
            if (evt.isEmpty()) {
                return crudMethods.save(one);
            } else {
                return one;
            }
        }
    }
}
