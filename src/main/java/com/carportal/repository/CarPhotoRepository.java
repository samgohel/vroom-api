package com.carportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carportal.model.CarPhoto;

public interface CarPhotoRepository extends JpaRepository<CarPhoto, Long> {

}
