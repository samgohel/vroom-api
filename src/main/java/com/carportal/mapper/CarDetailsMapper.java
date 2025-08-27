package com.carportal.mapper;

import com.carportal.entity.CarDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CarDetails.class)
public interface CarDetailsMapper {

}
