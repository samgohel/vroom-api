package com.carportal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.carportal.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(value = AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "carportal", name = "tbl_car_details")
public class CarDetails extends Auditable<String> implements Serializable {

	private static final long serialVersionUID = 4109785912216475366L;

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
		carPhoto.setCarDetails(this);
	}

	public void removeCarPhoto(CarPhoto carPhoto) {
		carPhoto.setCarDetails(null);
		this.carPhotos.remove(carPhoto);
	}

	@Override
	public String toString() {
		return "CarDetails [carDetailId=" + carDetailId + ", isActive=" + isActive + ", carManufacturer="
				+ carManufacturer + ", carModel=" + carModel + ", price=" + price + ", modelYear=" + modelYear
				+ ", kiloMeterDriven=" + kiloMeterDriven + ", description=" + description + ", owner=" + owner
				+ ", auditSection=" + ", carPhotos=" + carPhotos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carDetailId, carManufacturer, carModel, carPhotos, isActive, kiloMeterDriven, modelYear,
				owner, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CarDetails))
			return false;
		CarDetails other = (CarDetails) obj;
		return Objects.equals(carDetailId, other.carDetailId) && Objects.equals(carManufacturer, other.carManufacturer)
				&& Objects.equals(carModel, other.carModel) && Objects.equals(carPhotos, other.carPhotos)
				&& isActive == other.isActive && kiloMeterDriven == other.kiloMeterDriven
				&& modelYear == other.modelYear && Objects.equals(owner, other.owner)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	public Long getCarDetailId() {
		return carDetailId;
	}

	public boolean isActive() {
		return isActive;
	}

	public String getCarManufacturer() {
		return carManufacturer;
	}

	public String getCarModel() {
		return carModel;
	}

	public double getPrice() {
		return price;
	}

	public int getModelYear() {
		return modelYear;
	}

	public long getKiloMeterDriven() {
		return kiloMeterDriven;
	}

	public String getDescription() {
		return description;
	}

	public String getOwner() {
		return owner;
	}

	public List<CarPhoto> getCarPhotos() {
		return carPhotos;
	}

	public void setCarDetailId(Long carDetailId) {
		this.carDetailId = carDetailId;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setCarManufacturer(String carManufacturer) {
		this.carManufacturer = carManufacturer;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public void setKiloMeterDriven(long kiloMeterDriven) {
		this.kiloMeterDriven = kiloMeterDriven;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setCarPhotos(List<CarPhoto> carPhotos) {
		this.carPhotos = carPhotos;
	}

}
