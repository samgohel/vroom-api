package com.carportal.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "carportal", name = "tbl_car_engine")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "carEngineId", scope = Long.class)
public class CarEngine implements Serializable {

	private static final long serialVersionUID = 8320070255733309423L;

	@Id
	private Long carEngineId;

	@Column(nullable = false)
	private double mileage;

	@Column(nullable = false)
	private String transmissionType;

	@Column(nullable = false)
	private String engineType;

	@Column(nullable = false)
	private double engineDisplacement;

	@Column(nullable = false)
	private double maxPower;

	@Column(nullable = false)
	private double maxTourque;

	@Column(nullable = false)
	private int numberOfCylinder;

	@Column(nullable = false)
	private String fuel;

	@Column(nullable = false)
	private String driveType;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carDetailId")
	private CarDetails carDetails;

	@Override
	public String toString() {
		return "CarEngine [carEngineId=" + carEngineId + ", mileage=" + mileage + ", transmissionType="
				+ transmissionType + ", engineType=" + engineType + ", engineDisplacement=" + engineDisplacement
				+ ", maxPower=" + maxPower + ", maxTourque=" + maxTourque + ", numberOfCylinder=" + numberOfCylinder
				+ ", fuel=" + fuel + ", driveType=" + driveType + ", carDetails=" + carDetails + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carDetails, carEngineId, driveType, engineDisplacement, engineType, fuel, maxPower,
				maxTourque, mileage, numberOfCylinder, transmissionType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CarEngine))
			return false;
		CarEngine other = (CarEngine) obj;
		return Objects.equals(carDetails, other.carDetails) && Objects.equals(carEngineId, other.carEngineId)
				&& Objects.equals(driveType, other.driveType)
				&& Double.doubleToLongBits(engineDisplacement) == Double.doubleToLongBits(other.engineDisplacement)
				&& Objects.equals(engineType, other.engineType) && Objects.equals(fuel, other.fuel)
				&& Double.doubleToLongBits(maxPower) == Double.doubleToLongBits(other.maxPower)
				&& Double.doubleToLongBits(maxTourque) == Double.doubleToLongBits(other.maxTourque)
				&& Double.doubleToLongBits(mileage) == Double.doubleToLongBits(other.mileage)
				&& numberOfCylinder == other.numberOfCylinder
				&& Objects.equals(transmissionType, other.transmissionType);
	}

	public Long getCarEngineId() {
		return carEngineId;
	}

	public double getMileage() {
		return mileage;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public String getEngineType() {
		return engineType;
	}

	public double getEngineDisplacement() {
		return engineDisplacement;
	}

	public double getMaxPower() {
		return maxPower;
	}

	public double getMaxTourque() {
		return maxTourque;
	}

	public int getNumberOfCylinder() {
		return numberOfCylinder;
	}

	public String getFuel() {
		return fuel;
	}

	public String getDriveType() {
		return driveType;
	}

	public CarDetails getCarDetails() {
		return carDetails;
	}

	public void setCarEngineId(Long carEngineId) {
		this.carEngineId = carEngineId;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public void setEngineDisplacement(double engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}

	public void setMaxPower(double maxPower) {
		this.maxPower = maxPower;
	}

	public void setMaxTourque(double maxTourque) {
		this.maxTourque = maxTourque;
	}

	public void setNumberOfCylinder(int numberOfCylinder) {
		this.numberOfCylinder = numberOfCylinder;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	public void setCarDetails(CarDetails carDetails) {
		this.carDetails = carDetails;
	}

}
