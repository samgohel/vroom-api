package com.carportal.entity;

import com.carportal.constants.ApplicationConstants.Db;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = Db.TBL_SCHEMA_CAR_PORTAL, name = Db.TBL_CAR_OUTER)
public class CarOuter {

  @Id
  private Long carOuterId;

  @Column(nullable = false)
  private String carBodyType;

  @Column(nullable = false)
  private String color;

  @Column(nullable = false)
  private double length;

  @Column(nullable = false)
  private double height;

  @Column(nullable = false)
  private double width;

  @Column(nullable = false)
  private double groundClearance;

  @Column(nullable = false)
  private double bootSpace;

  @Column(nullable = false)
  private int seatingCapacity;

  @Column(nullable = false)
  private double fuelTankCapacity;

  @Column(nullable = false)
  private int noOfDoors;

  @Column(nullable = false)
  private String frontBrakeType;

  @Column(nullable = false)
  private String rearBrakeType;

  @MapsId
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "carDetailId")
  private CarDetails carDetails;

}
