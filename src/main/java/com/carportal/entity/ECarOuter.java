package com.carportal.entity;

import com.carportal.constants.ApplicationConstants;
import com.carportal.constants.ApplicationConstants.Db;
import com.carportal.entity.common.AuditableEntity;
import com.carportal.enums.BodyType;
import com.carportal.enums.BrakeType;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Entity
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Table(schema = Db.TBL_SCHEMA_CAR_PORTAL, name = Db.TBL_CAR_OUTER)
@AttributeOverride(name = ApplicationConstants.Column.ID, column = @Column(name = ApplicationConstants.Column.CAR_OUTER_ID))
public class ECarOuter extends AuditableEntity {

  @Column(name = ApplicationConstants.Column.CAR_BODY_TYPE, nullable = false)
  private BodyType carBodyType; // Enum: SEDAN, SUV, HATCHBACK, COUPE, etc.

  @Column(name = ApplicationConstants.Column.COLOR, nullable = false)
  private String color;

  @Column(name = ApplicationConstants.Column.LENGTH, nullable = false)
  private double length;

  @Column(name = ApplicationConstants.Column.HEIGHT, nullable = false)
  private double height;

  @Column(name = ApplicationConstants.Column.WIDTH, nullable = false)
  private double width;

  @Column(name = ApplicationConstants.Column.GROUND_CLEARANCE, nullable = false)
  private double groundClearance;

  @Column(name = ApplicationConstants.Column.BOOT_SPACE, nullable = false)
  private double bootSpace;

  @Column(name = ApplicationConstants.Column.SEATING_CAPACITY, nullable = false)
  private int seatingCapacity;

  @Column(name = ApplicationConstants.Column.FUEL_TANK_CAPACITY, nullable = false)
  private double fuelTankCapacity;

  @Column(name = ApplicationConstants.Column.NO_OF_DOORS, nullable = false)
  private int noOfDoors;

  @Column(name = ApplicationConstants.Column.FRONT_BRAKE_TYPE, nullable = false)
  private BrakeType frontBrakeType; // Enum: DISC, DRUM

  @Column(name = ApplicationConstants.Column.REAR_BRAKE_TYPE, nullable = false)
  private BrakeType rearBrakeType; // Enum: DISC, DRUM

  @MapsId
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "carDetailId")
  private ECarDetails eCarDetails;

}
