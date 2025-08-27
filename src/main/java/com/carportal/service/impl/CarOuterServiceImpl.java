package com.carportal.service.impl;

import com.carportal.entity.CarDetails;
import com.carportal.entity.CarOuter;
import com.carportal.repository.CarOuterRepository;
import com.carportal.service.CarDetailService;
import com.carportal.service.CarOuterService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class CarOuterServiceImpl implements CarOuterService {

  private CarOuterRepository carOuterRepository;

  private CarDetailService carDetailService;

  @Autowired
  public CarOuterServiceImpl(CarOuterRepository carOuterRepository,
      CarDetailService carDetailService) {
    this.carOuterRepository = carOuterRepository;
    this.carDetailService = carDetailService;
  }

  @Override
  public void saveCarOuter(CarOuter entity, Long carDetailId) {
    Optional<CarDetails> optionalCarDetails = Optional.of(carDetailService.findById(carDetailId))
        .get();
    optionalCarDetails.ifPresent(carDetails -> {
      entity.setCarDetails(carDetails);
      carOuterRepository.save(entity);
    });
  }

  @Override
  public Optional<CarOuter> findById(Long carDetailId) {
    return carOuterRepository.findById(carDetailId);
  }

  @Override
  public Optional<CarOuter> updateById(CarOuter carOuter, Long carDetailId) {
    Optional<CarDetails> optionalCarDetails = Optional.of(carDetailService.findById(carDetailId))
        .get();
    optionalCarDetails.ifPresent(carDetails -> {
      carOuter.setCarDetails(carDetails);
      carOuterRepository.save(carOuter);
    });
    return Optional.of(carOuter);
  }

  @Override
  public void deleteById(Long carDetailsId) {
    if (carOuterRepository.findById(carDetailsId).isPresent()) {
      carOuterRepository.deleteById(carDetailsId);
    }
  }

}
