package com.carportal.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carportal.model.CarDetails;

@Service
public interface CarDetailService {

	public abstract CarDetails saveCarDetail(CarDetails carDetails);

	public abstract Collection<CarDetails> findAll();

	public abstract Optional<CarDetails> findById(Long carDetailsId);

	public abstract Optional<CarDetails> updateById(CarDetails carDetails, Long carDetailsId);

	public abstract void deleteById(Long carDetailsId);

}
