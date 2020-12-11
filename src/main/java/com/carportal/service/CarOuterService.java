package com.carportal.service;

import java.util.Optional;

import com.carportal.model.CarOuter;

public interface CarOuterService {

	public abstract void saveCarOuter(CarOuter entity, Long carDetailId);

	public abstract Optional<CarOuter> findById(Long carEngineId);

	public abstract Optional<CarOuter> updateById(CarOuter carOuter, Long carOuterId);

	public abstract void deleteById(Long carDetailId);

}
