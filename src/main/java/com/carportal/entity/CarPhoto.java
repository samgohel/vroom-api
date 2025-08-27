package com.carportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_car_photos", schema = "carportal")
public class CarPhoto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long carPhotosId;

  @ManyToOne(fetch = FetchType.LAZY)
  private CarDetails carDetails;

}
