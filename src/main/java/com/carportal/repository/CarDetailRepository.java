package com.carportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carportal.model.CarDetails;

@Repository
public interface CarDetailRepository extends JpaRepository<CarDetails, Long>, CarDetailRepositoryCustom {

}
