package com.carportal.mapper;

import com.carportal.entity.CarFeatures;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CarFeatures.class)
public interface CarFeaturesMapper {

}
