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

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_car_outer", schema = "carportal")
public class CarOuter implements Serializable {

	private static final long serialVersionUID = 3041022277629552029L;

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

	@Override
	public String toString() {
		return "CarOuter [carOuterId=" + carOuterId + ", carBodyType=" + carBodyType + ", color=" + color + ", length="
				+ length + ", height=" + height + ", width=" + width + ", groundClearance=" + groundClearance
				+ ", bootSpace=" + bootSpace + ", seatingCapacity=" + seatingCapacity + ", fuelTankCapacity="
				+ fuelTankCapacity + ", noOfDoors=" + noOfDoors + ", frontBrakeType=" + frontBrakeType
				+ ", rearBrakeType=" + rearBrakeType + ", carDetails=" + carDetails + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bootSpace, carBodyType, carDetails, carOuterId, color, frontBrakeType, fuelTankCapacity,
				groundClearance, height, length, noOfDoors, rearBrakeType, seatingCapacity, width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CarOuter))
			return false;
		CarOuter other = (CarOuter) obj;
		return Double.doubleToLongBits(bootSpace) == Double.doubleToLongBits(other.bootSpace)
				&& Objects.equals(carBodyType, other.carBodyType) && Objects.equals(carDetails, other.carDetails)
				&& Objects.equals(carOuterId, other.carOuterId) && Objects.equals(color, other.color)
				&& Objects.equals(frontBrakeType, other.frontBrakeType)
				&& Double.doubleToLongBits(fuelTankCapacity) == Double.doubleToLongBits(other.fuelTankCapacity)
				&& Double.doubleToLongBits(groundClearance) == Double.doubleToLongBits(other.groundClearance)
				&& Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& Double.doubleToLongBits(length) == Double.doubleToLongBits(other.length)
				&& noOfDoors == other.noOfDoors && Objects.equals(rearBrakeType, other.rearBrakeType)
				&& seatingCapacity == other.seatingCapacity
				&& Double.doubleToLongBits(width) == Double.doubleToLongBits(other.width);
	}

	public Long getCarOuterId() {
		return carOuterId;
	}

	public String getCarBodyType() {
		return carBodyType;
	}

	public String getColor() {
		return color;
	}

	public double getLength() {
		return length;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public double getGroundClearance() {
		return groundClearance;
	}

	public double getBootSpace() {
		return bootSpace;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public double getFuelTankCapacity() {
		return fuelTankCapacity;
	}

	public int getNoOfDoors() {
		return noOfDoors;
	}

	public String getFrontBrakeType() {
		return frontBrakeType;
	}

	public String getRearBrakeType() {
		return rearBrakeType;
	}

	public CarDetails getCarDetails() {
		return carDetails;
	}

	public void setCarOuterId(Long carOuterId) {
		this.carOuterId = carOuterId;
	}

	public void setCarBodyType(String carBodyType) {
		this.carBodyType = carBodyType;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setGroundClearance(double groundClearance) {
		this.groundClearance = groundClearance;
	}

	public void setBootSpace(double bootSpace) {
		this.bootSpace = bootSpace;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public void setFuelTankCapacity(double fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}

	public void setNoOfDoors(int noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

	public void setFrontBrakeType(String frontBrakeType) {
		this.frontBrakeType = frontBrakeType;
	}

	public void setRearBrakeType(String rearBrakeType) {
		this.rearBrakeType = rearBrakeType;
	}

	public void setCarDetails(CarDetails carDetails) {
		this.carDetails = carDetails;
	}

}
