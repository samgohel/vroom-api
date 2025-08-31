package com.carportal.api.rest.controller;

import static com.carportal.utils.URLConstant.MappingConstant.ROOTURL;

import com.carportal.entity.ECarFeatures;
import com.carportal.exceptions.ServiceException;
import com.carportal.service.CarFeaturesService;
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
  public ResponseEntity<ECarFeatures> addCarfeatures(@RequestBody @Valid ECarFeatures ECarFeatures,
      @RequestParam Long carDetailId) throws ServiceException {

    if (logger.isTraceEnabled()) {
      logger.trace(">> addCarfeatures()");
    }

    ECarFeatures newECarFeatures = ECarFeatures;
    carFeaturesService.saveCarFeatures(newECarFeatures, carDetailId);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{carFeatureId}")
        .buildAndExpand(newECarFeatures.getCarFeaturesId()).toUri();

    if (logger.isTraceEnabled()) {
      logger.trace("<< addCarfeatures()");
    }

    return ResponseEntity.created(uri).build();

  }
}
