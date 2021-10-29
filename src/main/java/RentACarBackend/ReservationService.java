/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RentACarBackend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BRANDARG
 */
@Service
public class ReservationService {
    
    /**
     * Repositorio para realizar loe metodos CRUD
     */
    @Autowired
    private ReservationRepository crudMethods;

    /**
     * Metodo para consultar todos los elementos
     * @return Lista de los elementos
     */
    public List<Reservation> getAll() {
        return crudMethods.getAll();
    }

    /**
     * Método para consultar un elemento en especifico
     * @param id ID del elemento
     * @return El elemento
     */
    public Optional<Reservation> getOne(int id) {
        return crudMethods.getOne(id);
    }

    /**
     * Metodo para guardar un elemento
     * @param one El elemento a guardar
     * @return El elemento guardado
     */
    public Reservation save(Reservation one) {
        if (one.getIdReservation() == null) {
            return crudMethods.save(one);
        } else {
            Optional<Reservation> evt = crudMethods.getOne(one.getIdReservation());
            if (evt.isEmpty()) {
                return crudMethods.save(one);
            } else {
                return one;
            }
        }
    }
    
    /**
     * Metodo para actualizar un elemento
     * @param one El elemento a actualizar
     * @return El elemento actualizado
     */
    public Reservation update(Reservation one) {
        if (one.getIdReservation() != null) {
            Optional<Reservation> e = crudMethods.getOne(one.getIdReservation());
            if (e.isPresent()) {
                if (one.getStartDate() != null) {
                    e.get().setStartDate(one.getStartDate());
                }
                if (one.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(one.getDevolutionDate());
                }
                if (one.getStatus() != null) {
                    e.get().setStatus(one.getStatus());
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
    
    /**
     * Metodo para eliminar un elemento
     * @param id Id del elemento a eliminar
     * @return True si se elimina False si no
     */
    public boolean delete(int id) {
        Boolean aBoolean = getOne(id).map(one -> {
            crudMethods.delete(one);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    /*
    public List<Reservation> reservationInterval(String start, String end) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        try {
            startDate = format.parse(start);
        } catch (ParseException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date endDate = null;
        try {
            endDate = format.parse(end);
        } catch (ParseException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Reservation> reservations = new ArrayList(crudMethods.getAll());
        List<Reservation> inInterval = new ArrayList();
        
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getStartDate().compareTo(startDate) > 0 && reservations.get(i).getStartDate().compareTo(endDate) < 0) {
                inInterval.add(reservations.get(i));
            }
        }
        
        return inInterval;
    }
    
    public HashMap<String, Integer> completedVsCancelled() {
        LinkedHashMap<String, Integer> completeVsCancel = new LinkedHashMap<>();
        
        int completed = 0;
        int cancelled = 0;
        
        List<Reservation> reservations = new ArrayList(crudMethods.getAll());
        
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getStatus().equals("completed")) {
                completed++;
            } else if (reservations.get(i).getStatus().equals("cancelled")) {
                cancelled++;
            }
        }
        
        completeVsCancel.put("completed", completed);
        completeVsCancel.put("cancelled", cancelled);
        
        return completeVsCancel;
    }
    */
    
    public List<CountClient> getTopClients() {
        return crudMethods.getTopClients();
    }
    
    public StatusAmount getStatusReport() {
        List<Reservation> completed = crudMethods.getReservationByStatus("completed");
        List<Reservation> cancelled = crudMethods.getReservationByStatus("cancelled");
        
        StatusAmount report = new StatusAmount(completed.size(), cancelled.size());
        
        return report;
    }
    
    public List<Reservation> getReservationPeriod(String d1, String d2) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        try {
            dateOne = format.parse(d1);
            dateTwo = format.parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        if (dateOne.before(dateTwo)) {
            return crudMethods.getReservationPeriod(dateOne, dateTwo);
        } else {
            return new ArrayList();
        }
    }
}
