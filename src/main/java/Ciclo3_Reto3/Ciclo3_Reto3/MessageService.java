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
}
