package com.wlodek.demo.model.repositories;

import com.wlodek.demo.model.ReservationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationModel, Integer> {

    //    ReservationModel findByLastname(String name);
//
//    List<ReservationModel> findByLastname(String name);
//
//    List<ReservationModel> findByDateBetween(LocalDate date, LocalDate date2);
//
    List<ReservationModel> findByLastnameContaining(String name);

    List<ReservationModel> deleteByFirstnameContaining(String name);

    List<ReservationModel> findAll();




}
