package com.carportal.mapper;

import com.carportal.api.rest.dto.CarOuterDTO;
import com.carportal.entity.ECarOuter;
import com.carportal.model.CarOuterModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ECarOuter.class)
public interface CarOuterMapper {

  CarOuterDTO toDto(ECarOuter entity);

  CarOuterModel toModel(ECarOuter entity);

  ECarOuter fromModel(CarOuterModel model);

  ECarOuter fromDto(CarOuterDTO dto);
}
