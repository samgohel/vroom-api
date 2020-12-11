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
@Table(name = "tbl_car_fetures", schema = "carportal")
public class CarFeatures implements Serializable {

	private static final long serialVersionUID = -6083212601608735455L;

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

	@Override
	public String toString() {
		return "CarFeatures [carFeaturesId=" + carFeaturesId + ", airConditioner=" + airConditioner + ", heater="
				+ heater + ", adjustableSteering=" + adjustableSteering + ", leatherSeats=" + leatherSeats
				+ ", leatherSteeringWheel=" + leatherSteeringWheel + ", powerWindowsFront=" + powerWindowsFront
				+ ", powerWindowsRear=" + powerWindowsRear + ", remoteTrunkOpener=" + remoteTrunkOpener
				+ ", remoteFuelLidOpener=" + remoteFuelLidOpener + ", rearSeatHeadrest=" + rearSeatHeadrest
				+ ", rearSeatCentreArmRest=" + rearSeatCentreArmRest + ", rearAcVents=" + rearAcVents
				+ ", navigationSystem=" + navigationSystem + ", antiLockBrakingSystem=" + antiLockBrakingSystem
				+ ", centralLocking=" + centralLocking + ", powerDoorLocks=" + powerDoorLocks + ", childSafetyLock="
				+ childSafetyLock + ", antiTheftAlarm=" + antiTheftAlarm + ", driverAirbags=" + driverAirbags
				+ ", passengerAirbag=" + passengerAirbag + ", reversingCamera=" + reversingCamera
				+ ", electricFoldingRearViewMirror=" + electricFoldingRearViewMirror + ", sunRoof=" + sunRoof
				+ ", carDetails=" + carDetails + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adjustableSteering, airConditioner, antiLockBrakingSystem, antiTheftAlarm, carDetails,
				carFeaturesId, centralLocking, childSafetyLock, driverAirbags, electricFoldingRearViewMirror, heater,
				leatherSeats, leatherSteeringWheel, navigationSystem, passengerAirbag, powerDoorLocks,
				powerWindowsFront, powerWindowsRear, rearAcVents, rearSeatCentreArmRest, rearSeatHeadrest,
				remoteFuelLidOpener, remoteTrunkOpener, reversingCamera, sunRoof);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CarFeatures))
			return false;
		CarFeatures other = (CarFeatures) obj;
		return adjustableSteering == other.adjustableSteering && airConditioner == other.airConditioner
				&& antiLockBrakingSystem == other.antiLockBrakingSystem && antiTheftAlarm == other.antiTheftAlarm
				&& Objects.equals(carDetails, other.carDetails) && Objects.equals(carFeaturesId, other.carFeaturesId)
				&& centralLocking == other.centralLocking && childSafetyLock == other.childSafetyLock
				&& driverAirbags == other.driverAirbags
				&& electricFoldingRearViewMirror == other.electricFoldingRearViewMirror && heater == other.heater
				&& leatherSeats == other.leatherSeats && leatherSteeringWheel == other.leatherSteeringWheel
				&& navigationSystem == other.navigationSystem && passengerAirbag == other.passengerAirbag
				&& powerDoorLocks == other.powerDoorLocks && powerWindowsFront == other.powerWindowsFront
				&& powerWindowsRear == other.powerWindowsRear && rearAcVents == other.rearAcVents
				&& rearSeatCentreArmRest == other.rearSeatCentreArmRest && rearSeatHeadrest == other.rearSeatHeadrest
				&& remoteFuelLidOpener == other.remoteFuelLidOpener && remoteTrunkOpener == other.remoteTrunkOpener
				&& reversingCamera == other.reversingCamera && sunRoof == other.sunRoof;
	}

	public Long getCarFeaturesId() {
		return carFeaturesId;
	}

	public boolean isAirConditioner() {
		return airConditioner;
	}

	public boolean isHeater() {
		return heater;
	}

	public boolean isAdjustableSteering() {
		return adjustableSteering;
	}

	public boolean isLeatherSeats() {
		return leatherSeats;
	}

	public boolean isLeatherSteeringWheel() {
		return leatherSteeringWheel;
	}

	public boolean isPowerWindowsFront() {
		return powerWindowsFront;
	}

	public boolean isPowerWindowsRear() {
		return powerWindowsRear;
	}

	public boolean isRemoteTrunkOpener() {
		return remoteTrunkOpener;
	}

	public boolean isRemoteFuelLidOpener() {
		return remoteFuelLidOpener;
	}

	public boolean isRearSeatHeadrest() {
		return rearSeatHeadrest;
	}

	public boolean isRearSeatCentreArmRest() {
		return rearSeatCentreArmRest;
	}

	public boolean isRearAcVents() {
		return rearAcVents;
	}

	public boolean isNavigationSystem() {
		return navigationSystem;
	}

	public boolean isAntiLockBrakingSystem() {
		return antiLockBrakingSystem;
	}

	public boolean isCentralLocking() {
		return centralLocking;
	}

	public boolean isPowerDoorLocks() {
		return powerDoorLocks;
	}

	public boolean isChildSafetyLock() {
		return childSafetyLock;
	}

	public boolean isAntiTheftAlarm() {
		return antiTheftAlarm;
	}

	public boolean isDriverAirbags() {
		return driverAirbags;
	}

	public boolean isPassengerAirbag() {
		return passengerAirbag;
	}

	public boolean isReversingCamera() {
		return reversingCamera;
	}

	public boolean isElectricFoldingRearViewMirror() {
		return electricFoldingRearViewMirror;
	}

	public boolean isSunRoof() {
		return sunRoof;
	}

	public CarDetails getCarDetails() {
		return carDetails;
	}

	public void setCarFeaturesId(Long carFeaturesId) {
		this.carFeaturesId = carFeaturesId;
	}

	public void setAirConditioner(boolean airConditioner) {
		this.airConditioner = airConditioner;
	}

	public void setHeater(boolean heater) {
		this.heater = heater;
	}

	public void setAdjustableSteering(boolean adjustableSteering) {
		this.adjustableSteering = adjustableSteering;
	}

	public void setLeatherSeats(boolean leatherSeats) {
		this.leatherSeats = leatherSeats;
	}

	public void setLeatherSteeringWheel(boolean leatherSteeringWheel) {
		this.leatherSteeringWheel = leatherSteeringWheel;
	}

	public void setPowerWindowsFront(boolean powerWindowsFront) {
		this.powerWindowsFront = powerWindowsFront;
	}

	public void setPowerWindowsRear(boolean powerWindowsRear) {
		this.powerWindowsRear = powerWindowsRear;
	}

	public void setRemoteTrunkOpener(boolean remoteTrunkOpener) {
		this.remoteTrunkOpener = remoteTrunkOpener;
	}

	public void setRemoteFuelLidOpener(boolean remoteFuelLidOpener) {
		this.remoteFuelLidOpener = remoteFuelLidOpener;
	}

	public void setRearSeatHeadrest(boolean rearSeatHeadrest) {
		this.rearSeatHeadrest = rearSeatHeadrest;
	}

	public void setRearSeatCentreArmRest(boolean rearSeatCentreArmRest) {
		this.rearSeatCentreArmRest = rearSeatCentreArmRest;
	}

	public void setRearAcVents(boolean rearAcVents) {
		this.rearAcVents = rearAcVents;
	}

	public void setNavigationSystem(boolean navigationSystem) {
		this.navigationSystem = navigationSystem;
	}

	public void setAntiLockBrakingSystem(boolean antiLockBrakingSystem) {
		this.antiLockBrakingSystem = antiLockBrakingSystem;
	}

	public void setCentralLocking(boolean centralLocking) {
		this.centralLocking = centralLocking;
	}

	public void setPowerDoorLocks(boolean powerDoorLocks) {
		this.powerDoorLocks = powerDoorLocks;
	}

	public void setChildSafetyLock(boolean childSafetyLock) {
		this.childSafetyLock = childSafetyLock;
	}

	public void setAntiTheftAlarm(boolean antiTheftAlarm) {
		this.antiTheftAlarm = antiTheftAlarm;
	}

	public void setDriverAirbags(boolean driverAirbags) {
		this.driverAirbags = driverAirbags;
	}

	public void setPassengerAirbag(boolean passengerAirbag) {
		this.passengerAirbag = passengerAirbag;
	}

	public void setReversingCamera(boolean reversingCamera) {
		this.reversingCamera = reversingCamera;
	}

	public void setElectricFoldingRearViewMirror(boolean electricFoldingRearViewMirror) {
		this.electricFoldingRearViewMirror = electricFoldingRearViewMirror;
	}

	public void setSunRoof(boolean sunRoof) {
		this.sunRoof = sunRoof;
	}

	public void setCarDetails(CarDetails carDetails) {
		this.carDetails = carDetails;
	}

}
