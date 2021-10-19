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
public class MessageService {
    
    @Autowired
    private MessageRepository crudMethods;

    public List<Message> getAll() {
        return crudMethods.getAll();
    }

    public Optional<Message> getOne(int id) {
        return crudMethods.getOne(id);
    }

    public Message save(Message one) {
        if (one.getIdMessage() == null) {
            return crudMethods.save(one);
        } else {
            Optional<Message> evt = crudMethods.getOne(one.getIdMessage());
            if (evt.isEmpty()) {
                return crudMethods.save(one);
            } else {
                return one;
            }
        }
    }
    
    public Message update(Message one) {
        if (one.getIdMessage() != null) {
            Optional<Message> e = crudMethods.getOne(one.getIdMessage());
            if (e.isPresent()) {
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
