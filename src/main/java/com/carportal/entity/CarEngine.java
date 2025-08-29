package com.carportal.entity;

import com.carportal.constants.ApplicationConstants.Db;
import com.carportal.enums.TransmissionType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = Db.TBL_SCHEMA_CAR_PORTAL, name = Db.TBL_CAR_ENGINE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "carEngineId", scope = Long.class)
public class CarEngine {

  @Column(nullable = false)
  private double mileage;

  @Column(nullable = false)
  private TransmissionType transmissionType;

  @Column(nullable = false)
  private String engineType;

  @Column(nullable = false)
  private double engineDisplacement;

  @Column(nullable = false)
  private double maxPower;

  @Column(nullable = false)
  private double maxTorque;

  @Column(nullable = false)
  private int numberOfCylinder;

  @Column(nullable = false)
  private String fuelType;

  @Column(nullable = false)
  private String driveType;

  @MapsId
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "carDetailId")
  private CarDetails carDetails;

}
