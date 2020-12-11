package com.carportal.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carportal.model.CarDetails;
import com.carportal.repository.CarDetailRepository;
import com.carportal.service.CarDetailService;

@Service
@Transactional(rollbackFor = Exception.class)
public class CarDetailServiceImpl implements CarDetailService {

	private CarDetailRepository carDetailRepository;

	@Autowired
	public CarDetailServiceImpl(CarDetailRepository carDetailRepository) {
		this.carDetailRepository = carDetailRepository;
	}

	@Override
	public CarDetails saveCarDetail(CarDetails carDetails) {
		return carDetailRepository.save(carDetails);
	}

	@Override
	public Collection<CarDetails> findAll() {
		return carDetailRepository.findAll();
	}

	@Override
	public Optional<CarDetails> findById(Long carDetailId) {
		return carDetailRepository.findById(carDetailId);
	}

	@Override
	public Optional<CarDetails> updateById(CarDetails carDetails, Long carDetailId) {
		Optional<CarDetails> optionalCarDetails = Optional.of(carDetails);
		optionalCarDetails.ifPresent(car -> {
			carDetailRepository.save(carDetails);
		});
		return Optional.of(carDetails);
	}

	@Override
	public void deleteById(Long carDetailId) {
		if (carDetailRepository.findById(carDetailId).isPresent()) {
			carDetailRepository.deleteById(carDetailId);
		}
	}

}
