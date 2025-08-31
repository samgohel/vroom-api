package com.carportal.mapper;

import com.carportal.api.rest.dto.CarEngineDTO;
import com.carportal.entity.ECarEngine;
import com.carportal.model.CarEngineModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarEngineMapper {

  CarEngineDTO toDto(ECarEngine entity);

  CarEngineModel toModel(ECarEngine entity);

  ECarEngine fromModel(CarEngineModel model);

  ECarEngine fromDto(CarEngineDTO dto);

}
