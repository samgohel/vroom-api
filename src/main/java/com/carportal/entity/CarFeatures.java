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
@Table(schema = Db.TBL_SCHEMA_CAR_PORTAL, name = Db.TBL_CAR_FEATURES)
public class CarFeatures {

  @Id
  private Long carFeaturesId;

  @Column(columnDefinition = "boolean default false")
  private boolean airConditioner;

  @Column(columnDefinition = "boolean default false")
  private boolean heater;

  @Column(columnDefinition = "boolean default false")
  private boolean adjustableSteering;

  @Column(columnDefinition = "boolean default false")
  private boolean leatherSeats;

  @Column(columnDefinition = "boolean default false")
  private boolean leatherSteeringWheel;

  @Column(columnDefinition = "boolean default false")
  private boolean powerWindowsFront;

  @Column(columnDefinition = "boolean default false")
  private boolean powerWindowsRear;

  @Column(columnDefinition = "boolean default false")
  private boolean remoteTrunkOpener;

  @Column(columnDefinition = "boolean default false")
  private boolean remoteFuelLidOpener;

  @Column(columnDefinition = "boolean default false")
  private boolean rearSeatHeadrest;

  @Column(columnDefinition = "boolean default false")
  private boolean rearSeatCentreArmRest;

  @Column(columnDefinition = "boolean default false")
  private boolean rearAcVents;

  @Column(columnDefinition = "boolean default false")
  private boolean navigationSystem;

  @Column(columnDefinition = "boolean default false")
  private boolean antiLockBrakingSystem;

  @Column(columnDefinition = "boolean default false")
  private boolean centralLocking;

  @Column(columnDefinition = "boolean default false")
  private boolean powerDoorLocks;

  @Column(columnDefinition = "boolean default false")
  private boolean childSafetyLock;

  @Column(columnDefinition = "boolean default false")
  private boolean antiTheftAlarm;

  @Column(columnDefinition = "boolean default false")
  private boolean driverAirbags;

  @Column(columnDefinition = "boolean default false")
  private boolean passengerAirbag;

  @Column(columnDefinition = "boolean default false")
  private boolean reversingCamera;

  @Column(columnDefinition = "boolean default false")
  private boolean electricFoldingRearViewMirror;

  @Column(columnDefinition = "boolean default false")
  private boolean sunRoof;

  @MapsId
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "carDetailId")
  private CarDetails carDetails;

}
