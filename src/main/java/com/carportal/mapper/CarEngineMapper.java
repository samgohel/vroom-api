package com.carportal.mapper;

import com.carportal.entity.CarEngine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CarEngine.class)
public interface CarEngineMapper {

}
