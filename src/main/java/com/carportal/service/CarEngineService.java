package com.carportal.service;

import com.carportal.entity.ECarEngine;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface CarEngineService {

  void saveCarEngine(ECarEngine entity, Long carDetailId);

  Optional<ECarEngine> findById(Long carEngineId);

  Optional<ECarEngine> updateById(ECarEngine ECarEngine, Long carEngineId);

  void deleteById(Long carDetailId);

}
