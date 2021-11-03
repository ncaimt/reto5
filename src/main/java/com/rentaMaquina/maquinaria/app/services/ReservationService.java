
package com.rentaMaquina.maquinaria.app.services;

import com.rentaMaquina.maquinaria.app.entities.Reservation;
import com.rentaMaquina.maquinaria.app.repositories.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author nacai
 */
@Service
public class ReservationService {
    
    @Autowired 
    private ReservationRepository repository;
    
    // GET consultar todos los registros
    public List<Reservation> getReservations(){
        return repository.findAll();
    }
    
    // `POST crear or registrar
    public Reservation saveReservation(Reservation reservation){
        //reservation.setStatus("created");
        System.out.println(reservation.getStartDate());
        System.out.println(reservation.getDevolutionDate());
        return repository.save(reservation);
        
    }
    // peticion put para actualizar  (PUT)
    public Reservation updateReservation(Reservation reservation){
        Reservation existingReservation = repository.findById(reservation.getIdReservation()).orElse(null);
        existingReservation.setStartDate(reservation.getStartDate());
        existingReservation.setDevolutionDate(reservation.getDevolutionDate());
        return repository.save(existingReservation);
    
    }
    
    // delete o eliminar
    public String deleteReservation(int id){
        repository.deleteById(id);
        return "Reservacion eliminada"+id;
    }
    
    /*
    @Query("select * from reservation where a.creationDateTime <= :creationDateTime")
    public List<Reservation> getReportDates(String dateInicio, String DateEnd){
        
      
    }
        */
    
}
