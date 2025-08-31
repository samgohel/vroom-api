package com.carportal.service;

import com.carportal.entity.ECarFeatures;
import java.util.Optional;

public interface CarFeaturesService {

  void saveCarFeatures(ECarFeatures entity, Long carDetailId);

  Optional<ECarFeatures> findById(Long carEngineId);

  Optional<ECarFeatures> updateById(ECarFeatures ECarFeatures, Long carEngineId);

  void deleteById(Long carDetailsId);

}
