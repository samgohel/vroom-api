package com.carportal.entity;

import com.carportal.JpaConverter.OwnerConverter;
import com.carportal.constants.ApplicationConstants;
import com.carportal.constants.ApplicationConstants.Db;
import com.carportal.enums.Owner;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = Db.TBL_SCHEMA_CAR_PORTAL, name = Db.TBL_CAR_DETAILS)
public class ECarDetails {

  @Column(name = ApplicationConstants.Column.CAR_MANUFACTURER, nullable = false, length = 50)
  @NotEmpty(message = "Car manufacturer must not be empty")
  private String carManufacturer;

  @Column(name = ApplicationConstants.Column.CAR_MODEL, nullable = false, length = 75)
  private String carModel;

  @Column(name = ApplicationConstants.Column.PRICE, nullable = false)
  private double price;

  @Column(name = ApplicationConstants.Column.MANUFACTURED_YEAR, nullable = false)
  private int manufacturedYear;

  @Column(name = ApplicationConstants.Column.REGISTRATION_YEAR, nullable = false)
  private int registrationYear;

  @Column(name = ApplicationConstants.Column.KILOMETER_DRIVEN, nullable = false)
  private long kiloMeterDriven;

  @Column(name = ApplicationConstants.Column.DESCRIPTION, nullable = false)
  private String description;

  @Column(name = ApplicationConstants.Column.OWNER, nullable = false)
  @Convert(converter = OwnerConverter.class)
  private Owner owner;

}
