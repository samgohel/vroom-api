package com.carportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carportal.model.CarFeatures;

public interface CarFeaturesRepository extends JpaRepository<CarFeatures, Long> {

}
