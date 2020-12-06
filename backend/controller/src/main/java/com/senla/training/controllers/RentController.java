package com.senla.training.controllers;

import com.senla.training.service.api.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rents")
public class RentController {

  private final IRentService rentService;

  @Autowired
  RentController(IRentService rentService) {
    this.rentService = rentService;
  }
}
