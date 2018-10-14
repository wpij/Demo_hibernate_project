package com.wlodek.demo.controllers;

import com.wlodek.demo.model.ReservationModel;
import com.wlodek.demo.model.forms.ReservationForm;
import com.wlodek.demo.model.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.List;

@Controller
public class MainController {

    @Autowired

    ReservationRepository reservationRepository;


    //ustawia strone glowna
    //@ResponseBody
    //zwraca to co w za returnem.
    @GetMapping("/")
    public String index(Model model) {

//        ReservationModel model = new ReservationModel();
//        model.setAdres("Warszawa");
//        model.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
//        model.setFirstname("Lukasz");
//        model.setLastname("Dupowski");
//
//        reservationRepository.save(model);
        //reservationRepository.deleteAll();
        model.addAttribute("reservationForm", new ReservationForm());
        model.addAttribute("reservations", reservationRepository.findAll());


        return "index";

    }

    @PostMapping
    public String index(@ModelAttribute("reservationForm") @Valid ReservationForm form,
                        BindingResult bindingResult,
                        Model model,
                        ModelMap modelMap) {

        if (bindingResult.hasErrors()) {
            return "index";
        }

        reservationRepository.save(new ReservationModel(form));

        List<ReservationModel> reservations = reservationRepository.findAll();

        modelMap.put("reservations", reservations);

        return "index";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        //     ReservationModel model = reservationRepository.findAll()

        //     return reservationRepository.findByLastname("wlodek").toString();

        //return reservationRepository.findByDateBetween(LocalDate.now(), LocalDate.now().plusYears(1)).toString();
        return reservationRepository.findByLastnameContaining("a").toString();


    }

    @Transactional
    @RequestMapping("/delete/{name}")
    @ResponseBody
    public String deleteName(@PathVariable String name) {
        reservationRepository.deleteByFirstnameContaining(name);
        return ("Usunięto " + name);
    }






}