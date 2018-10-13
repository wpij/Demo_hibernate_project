package com.wlodek.demo.model.repositories;

import com.wlodek.demo.model.ReservationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationModel, Integer> {





}
