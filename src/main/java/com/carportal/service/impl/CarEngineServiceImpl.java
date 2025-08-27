package com.carportal.service.impl;

import com.carportal.entity.CarDetails;
import com.carportal.entity.CarEngine;
import com.carportal.repository.CarEngineRepository;
import com.carportal.service.CarDetailService;
import com.carportal.service.CarEngineService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CarEngineServiceImpl implements CarEngineService {

  private CarEngineRepository carEngineRepository;

  private CarDetailService carDetailService;

  @Autowired
  public CarEngineServiceImpl(CarEngineRepository carEngineRepository,
      CarDetailService carDetailService) {
    this.carEngineRepository = carEngineRepository;
    this.carDetailService = carDetailService;
  }

  @Override
  public void saveCarEngine(CarEngine entity, Long carDetailId) {
    Optional<CarDetails> optionalCarDetails = Optional.of(carDetailService.findById(carDetailId))
        .get();
    optionalCarDetails.ifPresent(carDetails -> {
      entity.setCarDetails(carDetails);
      carEngineRepository.save(entity);
    });
  }

  @Override
  public Optional<CarEngine> findById(Long carDetailId) {
    return carEngineRepository.findById(carDetailId);
  }

  @Override
  public Optional<CarEngine> updateById(CarEngine carEngine, Long carDetailId) {
    Optional<CarDetails> optionalCarDetails = Optional.of(carDetailService.findById(carDetailId))
        .get();
    optionalCarDetails.ifPresent(carDetails -> {
      carEngine.setCarDetails(carDetails);
      carEngineRepository.save(carEngine);
    });
    return Optional.of(carEngine);
  }

  @Override
  public void deleteById(Long carDetailsId) {
    if (carEngineRepository.findById(carDetailsId).isPresent()) {
      carEngineRepository.deleteById(carDetailsId);
    }
  }
}
