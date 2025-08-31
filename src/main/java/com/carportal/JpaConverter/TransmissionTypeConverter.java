package com.carportal.JpaConverter;

import com.carportal.enums.TransmissionType;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TransmissionTypeConverter extends GenericEnumConverter<TransmissionType, String> {

  public TransmissionTypeConverter() {
    super(TransmissionType.class);
  }
}
