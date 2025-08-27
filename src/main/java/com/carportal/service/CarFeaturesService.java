package com.carportal.service;

import com.carportal.entity.CarFeatures;
import java.util.Optional;

public interface CarFeaturesService {

  void saveCarFeatures(CarFeatures entity, Long carDetailId);

  Optional<CarFeatures> findById(Long carEngineId);

  Optional<CarFeatures> updateById(CarFeatures carFeatures, Long carEngineId);

  void deleteById(Long carDetailsId);

}
