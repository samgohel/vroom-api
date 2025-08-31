package com.carportal.mapper;

import com.carportal.api.rest.dto.CarFeaturesDTO;
import com.carportal.entity.ECarFeatures;
import com.carportal.model.CarFeaturesModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ECarFeatures.class)
public interface CarFeaturesMapper {

  CarFeaturesDTO toDto(ECarFeatures entity);

  CarFeaturesModel toModel(ECarFeatures entity);

  ECarFeatures fromModel(CarFeaturesModel model);

  ECarFeatures fromDto(CarFeaturesDTO dto);
}
