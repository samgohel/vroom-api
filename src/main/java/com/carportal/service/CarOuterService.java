package com.carportal.service;

import com.carportal.entity.CarOuter;
import java.util.Optional;

public interface CarOuterService {

  void saveCarOuter(CarOuter entity, Long carDetailId);

  Optional<CarOuter> findById(Long carEngineId);

  Optional<CarOuter> updateById(CarOuter carOuter, Long carOuterId);

  void deleteById(Long carDetailId);

}
