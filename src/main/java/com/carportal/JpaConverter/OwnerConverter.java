package com.carportal.JpaConverter;

import com.carportal.enums.Owner;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OwnerConverter extends GenericEnumConverter<Owner, String> {

  public OwnerConverter() {
    super(Owner.class);
  }

}
