package com.carportal.service;

import com.carportal.entity.CarDetails;
import java.util.Collection;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface CarDetailService {

  CarDetails saveCarDetail(CarDetails carDetails);

  Collection<CarDetails> findAll();

  Optional<CarDetails> findById(Long carDetailsId);

  Optional<CarDetails> updateById(CarDetails carDetails, Long carDetailsId);

  void deleteById(Long carDetailsId);

}
