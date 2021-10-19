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
    
    public Client update(Client one) {
        if (one.getIdClient() != null) {
            Optional<Client> e = crudMethods.getOne(one.getIdClient());
            if (e.isPresent()) {
                if (one.getEmail() != null) {
                    e.get().setEmail(one.getEmail());
                }
                if (one.getPassword() != null) {
                    e.get().setPassword(one.getPassword());
                }
                if (one.getName() != null) {
                    e.get().setName(one.getName());
                }
                if (one.getAge() != null) {
                    e.get().setAge(one.getAge());
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
