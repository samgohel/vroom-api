package com.carportal.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_car_photos", schema = "carportal")
public class CarPhoto implements Serializable {

	private static final long serialVersionUID = -1843017022135764300L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long carPhotosId;

	@ManyToOne(fetch = FetchType.LAZY)
	private CarDetails carDetails;

	@Override
	public String toString() {
		return "CarPhoto [carPhotosId=" + carPhotosId + ", carDetails=" + carDetails + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carDetails, carPhotosId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CarPhoto))
			return false;
		CarPhoto other = (CarPhoto) obj;
		return Objects.equals(carDetails, other.carDetails) && Objects.equals(carPhotosId, other.carPhotosId);
	}

	public Long getCarPhotosId() {
		return carPhotosId;
	}

	public void setCarPhotosId(Long carPhotosId) {
		this.carPhotosId = carPhotosId;
	}

	public CarDetails getCarDetails() {
		return carDetails;
	}

	public void setCarDetails(CarDetails carDetails) {
		this.carDetails = carDetails;
	}

}
