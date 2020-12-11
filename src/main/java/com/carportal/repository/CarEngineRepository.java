package com.carportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carportal.model.CarEngine;

@Repository
public interface CarEngineRepository extends JpaRepository<CarEngine, Long> {

}
