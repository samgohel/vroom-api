package com.carportal.controller;

import static com.carportal.utils.URLConstant.MappingConstant.ROOTURL;

import java.net.URI;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carportal.model.CarDetails;
import com.carportal.service.CarDetailService;

@RestController
@RequestMapping(value = ROOTURL)
public class CarDetailController {

	private final Logger logger = LoggerFactory.getLogger(CarDetailController.class.getName());

	private CarDetailService carDetailService;

	@Autowired
	public CarDetailController(CarDetailService carDetailService) {
		if (logger.isTraceEnabled()) {
			logger.trace("** CarDetailController()");
		}
		this.carDetailService = carDetailService;
	}

	@PostMapping(path = "/cardetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarDetails> addCarDetails(@RequestBody CarDetails carDetails) {
		if (logger.isTraceEnabled()) {
			logger.trace(">> addCarDetails()");
		}
		CarDetails newCarDetails = carDetailService.saveCarDetail(carDetails);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{carDetailId}")
				.buildAndExpand(newCarDetails.getCarDetailId()).toUri();

		if (logger.isTraceEnabled()) {
			logger.trace("<< addCarDetails()");
		}

		return ResponseEntity.created(uri).build();

	}

	@GetMapping(path = "/cardetail/{carDetailId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Optional<CarDetails> getById(@PathVariable Long carDetailId) {
		logger.debug("Cardetail Controller getById Method");
		return carDetailService.findById(carDetailId);
	}

	@PutMapping(path = "/cardetail/{carDetailId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarDetails> updateCar(@PathVariable Long carDetailId, @RequestBody CarDetails carDetails) {
		logger.debug("Cardetail Controller updateCar Method");
		return new ResponseEntity<>(carDetailService.updateById(carDetails, carDetailId).get(), HttpStatus.OK);
	}

}
