package com.carportal.api.controller;

import static com.carportal.utils.URLConstant.MappingConstant.ROOTURL;

import com.carportal.entity.CarOuter;
import com.carportal.exceptions.ServiceException;
import com.carportal.service.CarOuterService;
import java.net.URI;
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
public class CarOuterController {

  private final Logger logger = LoggerFactory.getLogger(CarOuterController.class.getName());

  private CarOuterService carOuterService;

  @Autowired
  public CarOuterController(CarOuterService carOuterService) {
    if (logger.isTraceEnabled()) {
      logger.trace("** CarOuterController()");
    }
    this.carOuterService = carOuterService;
  }

  @PostMapping(path = "/cardetails/carouter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CarOuter> addCarOuter(@RequestBody CarOuter carOuter,
      @RequestParam Long carDetailId)
      throws ServiceException {

    if (logger.isTraceEnabled()) {
      logger.trace(">> addCarOuter()");
    }

    CarOuter newCarOuter = carOuter;
    carOuterService.saveCarOuter(newCarOuter, carDetailId);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{carOuterId}")
        .buildAndExpand(newCarOuter.getCarOuterId()).toUri();
    if (logger.isTraceEnabled()) {
      logger.trace("<< addCarOuter()");
    }

    return ResponseEntity.created(uri).build();
  }

}
