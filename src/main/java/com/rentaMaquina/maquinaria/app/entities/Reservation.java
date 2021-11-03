
package com.rentaMaquina.maquinaria.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.*;
//import java.util.Calendar;
//import java.util.TimeZone;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 *
 * @author nacai
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name="reservation")
public class Reservation implements Serializable  {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idReservation;
    
    @Temporal(TemporalType.DATE)
    private Calendar startDate;
    
    @Temporal(TemporalType.DATE)
    private Calendar devolutionDate;
    
    private String status;
    
     
     
    
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    private Machine machine;
    
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;
    
    @OneToOne(cascade = {CascadeType.REMOVE}, mappedBy = "reservation")
    @JsonIgnoreProperties("reservations")
    private Score score;
}