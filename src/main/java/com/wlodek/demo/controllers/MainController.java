package com.wlodek.demo.controllers;

import com.wlodek.demo.model.ReservationModel;
import com.wlodek.demo.model.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.Calendar;

@Controller
public class MainController {

@Autowired

ReservationRepository reservationRepository;

    @GetMapping("/")
    @ResponseBody

    public String index() {
        ReservationModel model = new ReservationModel();
        model.setAdres("Warszawa");
        model.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
        model.setFirstname("Lukasz");
        model.setLastname("Dupowski");
        reservationRepository.save(model);
        //reservationRepository.deleteAll();
        return "Hej zapisalem dane";

    }




}
