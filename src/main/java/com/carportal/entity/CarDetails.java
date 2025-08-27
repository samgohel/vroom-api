package com.carportal.entity;

import static com.carportal.constants.ApplicationConstants.Sequence.BASE_CUS_SEQ_NAME;
import static com.carportal.constants.ApplicationConstants.Sequence.STRATEGY;

import com.carportal.config.PrefixedSequenceIdGenerator;
import com.carportal.constants.ApplicationConstants.Db;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@GenericGenerator(
    name = BASE_CUS_SEQ_NAME,
    strategy = STRATEGY,
    parameters = {
        @org.hibernate.annotations.Parameter(name = PrefixedSequenceIdGenerator.PREFIX_PARAM, value = "CAR"),
        @org.hibernate.annotations.Parameter(name = PrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAM, value = "%06d")
    }
)
@EntityListeners(value = AuditingEntityListener.class)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = Db.TBL_SCHEMA_CAR_PORTAL, name = Db.TBL_CAR_DETAILS)
public class CarDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long carDetailId;

  @Column(columnDefinition = "boolean default false")
  private boolean isActive;

  @Column(nullable = false, length = 50)
  @NotEmpty(message = "Car Manufacturer must not be empty")
  private String carManufacturer;

  @Column(nullable = false, length = 75)
  private String carModel;

  @Column(nullable = false)
  private double price;

  @Column(nullable = false)
  private int modelYear;

  @Column(nullable = false)
  private long kiloMeterDriven;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private String owner;

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
