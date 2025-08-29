package com.carportal.entity;

import static com.carportal.constants.ApplicationConstants.Sequence.BASE_CUS_SEQ_NAME;
import static com.carportal.constants.ApplicationConstants.Sequence.STRATEGY;

import com.carportal.JpaConverter.OwnerConverter;
import com.carportal.config.PrefixedSequenceIdGenerator;
import com.carportal.constants.ApplicationConstants;
import com.carportal.constants.ApplicationConstants.Db;
import com.carportal.enums.Owner;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@GenericGenerator(name = BASE_CUS_SEQ_NAME, strategy = STRATEGY, parameters = {
    @org.hibernate.annotations.Parameter(name = PrefixedSequenceIdGenerator.PREFIX_PARAM, value = "CAR"),
    @org.hibernate.annotations.Parameter(name = PrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAM, value = "%06d")})
@EntityListeners(value = AuditingEntityListener.class)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = Db.TBL_SCHEMA_CAR_PORTAL, name = Db.TBL_CAR_DETAILS)
public class CarDetails {

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

  @JsonBackReference
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "carDetails", cascade = CascadeType.ALL, targetEntity = CarPhoto.class)
  private List<CarPhoto> carPhotos = new ArrayList<>();

  public void addCarPhoto(CarPhoto carPhoto) {
    carPhotos.add(carPhoto);
//    carPhoto.setCarDetails(this);
  }

  public void removeCarPhoto(CarPhoto carPhoto) {
//    carPhoto.setCarDetails(null);
    this.carPhotos.remove(carPhoto);
  }

}
