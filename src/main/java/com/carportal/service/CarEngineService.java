package com.carportal.service;

import com.carportal.entity.CarEngine;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface CarEngineService {

  void saveCarEngine(CarEngine entity, Long carDetailId);

  Optional<CarEngine> findById(Long carEngineId);

  Optional<CarEngine> updateById(CarEngine carEngine, Long carEngineId);

  void deleteById(Long carDetailId);

}
