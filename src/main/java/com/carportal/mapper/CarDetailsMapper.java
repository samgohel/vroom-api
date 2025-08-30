package com.carportal.mapper;

import com.carportal.api.rest.dto.CarDetailsDTO;
import com.carportal.entity.ECarDetails;
import com.carportal.model.CarDetailsModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarDetailsMapper {

  // Convert entity to DTO
  CarDetailsDTO toDto(ECarDetails entity);

  // Convert entity to immutable record model
  CarDetailsModel toModel(ECarDetails entity);

  // Convert immutable record model back to entity
  ECarDetails fromModel(CarDetailsModel model);

  // Convert DTO back to entity
  ECarDetails fromDto(CarDetailsDTO dto);

}
