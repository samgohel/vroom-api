package com.carportal.mapper;

import com.carportal.entity.CarOuter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CarOuter.class)
public interface CarOuterMapper {

}
