package com.wlodek.demo.model;

import com.wlodek.demo.model.forms.ReservationForm;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "reservations")
@NoArgsConstructor

public class ReservationModel {

    @Id
    //ID klucz gowny
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Genrated Val , sam nada ID
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate date;
    private String adres;

    public ReservationModel (ReservationForm form){
        firstname = form.getFirstname();
        lastname = form.getLastname();
        date = form.getFormatedDate();
        adres = form.getAdres();
    }

}
