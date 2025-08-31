package com.carportal.repository;

import com.carportal.entity.ECarPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPhotoRepository extends JpaRepository<ECarPhoto, Long> {

}
