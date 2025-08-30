package com.carportal.repository;

import com.carportal.entity.ECarDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDetailRepository extends JpaRepository<ECarDetails, Long> {

}
