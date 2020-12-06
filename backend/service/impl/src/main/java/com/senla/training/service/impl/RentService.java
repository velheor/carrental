package com.senla.training.service.impl;

import com.senla.training.dao.api.IRentDAO;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService implements IRentService {

  private final IRentDAO rentDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  RentService(IRentDAO rentDAO, ObjectMapperUtils objectMapperUtils) {
    this.rentDAO = rentDAO;
    this.objectMapperUtils = objectMapperUtils;
  }
}
