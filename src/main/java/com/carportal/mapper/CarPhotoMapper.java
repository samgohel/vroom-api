package com.carportal.mapper;

import com.carportal.entity.CarPhoto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CarPhoto.class)
public interface CarPhotoMapper {

}
