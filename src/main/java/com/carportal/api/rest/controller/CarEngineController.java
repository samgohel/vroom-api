package com.carportal.api.rest.controller;

import static com.carportal.utils.URLConstant.MappingConstant.ROOTURL;

import com.carportal.entity.ECarEngine;
import com.carportal.exceptions.ServiceException;
import com.carportal.service.CarEngineService;
import java.net.URI;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = ROOTURL)
public class CarEngineController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private CarEngineService carEngineService;

  @Autowired
  public CarEngineController(CarEngineService carEngineService) {
    if (logger.isTraceEnabled()) {
      logger.trace("** CarEngineController()");
    }
    this.carEngineService = carEngineService;
  }

  @PostMapping(path = "/cardetails/carengines", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ECarEngine> addCarEngine(@RequestBody @Valid ECarEngine newECarEngine,
      @RequestParam Long carDetailId) throws ServiceException {
    if (logger.isTraceEnabled()) {
      logger.trace(">> addCarEngine()");
    }
    carEngineService.saveCarEngine(newECarEngine, carDetailId);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{carEngineId}")
        .buildAndExpand(newECarEngine.getCarEngineId()).toUri();

    if (logger.isTraceEnabled()) {
      logger.trace("<< addCarEngine()");
    }

    return ResponseEntity.created(uri).build();
  }

  @GetMapping(path = "/cardetails/carengine/{carEngineId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.FOUND)
  public ECarEngine getById(@PathVariable Long carEngineId) throws Exception {
    logger.debug("CarEngine Controller getById Method");
    return carEngineService.findById(carEngineId)
        .orElseThrow(() -> new EntityNotFoundException(Long.toString(carEngineId)));
  }

}
