package com.carportal.mapper;

import com.carportal.entity.ECarPhoto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ECarPhoto.class)
public interface CarPhotoMapper {

}
