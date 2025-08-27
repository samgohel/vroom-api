package com.carportal.repository;

import com.carportal.entity.CarEngine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEngineRepository extends JpaRepository<CarEngine, Long> {

}
