package com.carportal.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carportal.repository.CarPhotoRepository;
import com.carportal.service.CarDetailService;
import com.carportal.service.CarPhotoService;

@Service
@Transactional(rollbackOn = Exception.class)
public class CarPhotoServiceImpl implements CarPhotoService {

	private CarPhotoRepository carPhotoRepository;

	private CarDetailService carDetailService;

	@Autowired
	public CarPhotoServiceImpl(CarPhotoRepository carPhotoRepository, CarDetailService carDetailService) {
		this.carPhotoRepository = carPhotoRepository;
		this.carDetailService = carDetailService;
	}

}
