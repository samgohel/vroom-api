package com.carportal.service.impl;

import com.carportal.entity.CarDetails;
import com.carportal.entity.CarFeatures;
import com.carportal.repository.CarFeaturesRepository;
import com.carportal.service.CarDetailService;
import com.carportal.service.CarFeaturesService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class CarFeaturesServiceImpl implements CarFeaturesService {

  private CarFeaturesRepository carFeaturesRepository;

  private CarDetailService carDetailService;

  @Autowired
  public CarFeaturesServiceImpl(CarFeaturesRepository carFeaturesRepository,
      CarDetailService carDetailService) {
    this.carFeaturesRepository = carFeaturesRepository;
    this.carDetailService = carDetailService;
  }

  @Override
  public void saveCarFeatures(CarFeatures carFeatures, Long carDetailId) {
    Optional<CarDetails> optionalCarDetails = Optional.of(carDetailService.findById(carDetailId))
        .get();
    optionalCarDetails.ifPresent(carDetails -> {
      carFeatures.setCarDetails(carDetails);
      carFeaturesRepository.save(carFeatures);
    });
  }

  @Override
  public Optional<CarFeatures> findById(Long carDetailId) {
    return carFeaturesRepository.findById(carDetailId);
  }

  @Override
  public Optional<CarFeatures> updateById(CarFeatures carFeatures, Long carDetailId) {
    Optional<CarDetails> optionalCarDetails = Optional.of(carDetailService.findById(carDetailId))
        .get();
    optionalCarDetails.ifPresent(carDetails -> {
      carFeatures.setCarDetails(carDetails);
      carFeaturesRepository.save(carFeatures);
    });
    return Optional.of(carFeatures);
  }

  @Override
  public void deleteById(Long carDetailId) {
    if (carFeaturesRepository.findById(carDetailId).isPresent()) {
      carFeaturesRepository.deleteById(carDetailId);
    }
  }

}
