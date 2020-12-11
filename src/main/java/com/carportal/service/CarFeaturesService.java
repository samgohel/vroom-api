package com.carportal.service;

import java.util.Optional;

import com.carportal.model.CarFeatures;

public interface CarFeaturesService {

	public abstract void saveCarFeatures(CarFeatures entity, Long carDetailId);

	public abstract Optional<CarFeatures> findById(Long carEngineId);

	public abstract Optional<CarFeatures> updateById(CarFeatures carFeatures, Long carEngineId);

	public abstract void deleteById(Long carDetailsId);

}
