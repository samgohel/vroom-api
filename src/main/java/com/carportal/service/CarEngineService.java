package com.carportal.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carportal.model.CarEngine;

@Service
public interface CarEngineService {

	public abstract void saveCarEngine(CarEngine entity, Long carDetailId);

	public abstract Optional<CarEngine> findById(Long carEngineId);

	public abstract Optional<CarEngine> updateById(CarEngine carEngine, Long carEngineId);

	public abstract void deleteById(Long carDetailId);

}
