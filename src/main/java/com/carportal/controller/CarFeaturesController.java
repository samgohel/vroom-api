package com.carportal.controller;

import static com.carportal.utils.URLConstant.MappingConstant.ROOTURL;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carportal.exceptions.ServiceException;
import com.carportal.model.CarFeatures;
import com.carportal.service.CarFeaturesService;

@RestController
@RequestMapping(value = ROOTURL)
public class CarFeaturesController {

	private final Logger logger = LoggerFactory.getLogger(CarFeaturesController.class.getName());

	private CarFeaturesService carFeaturesService;

	@Autowired
	public CarFeaturesController(CarFeaturesService carFeaturesService) {
		if (logger.isTraceEnabled()) {
			logger.trace("** CarFeaturesController()");
		}
		this.carFeaturesService = carFeaturesService;
	}

	@PostMapping(path = "/carDetails/carFeature", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarFeatures> addCarfeatures(@RequestBody @Valid CarFeatures carFeatures,
			@RequestParam Long carDetailId) throws ServiceException {

		if (logger.isTraceEnabled()) {
			logger.trace(">> addCarfeatures()");
		}

		CarFeatures newCarFeatures = carFeatures;
		carFeaturesService.saveCarFeatures(newCarFeatures, carDetailId);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{carFeatureId}")
				.buildAndExpand(newCarFeatures.getCarFeaturesId()).toUri();

		if (logger.isTraceEnabled()) {
			logger.trace("<< addCarfeatures()");
		}

		return ResponseEntity.created(uri).build();

	}
}
