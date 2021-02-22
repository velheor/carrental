package com.velheor.carrental.service.impl;

import com.velheor.carrental.dao.api.RentRepository;
import com.velheor.carrental.dto.RentDTO;
import com.velheor.carrental.models.Rent;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.service.api.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService implements IRentService {

  private final RentRepository rentRepository;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  RentService(RentRepository rentRepository, ObjectMapperUtils objectMapperUtils) {
    this.rentRepository = rentRepository;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public RentDTO findById(Integer id) {
    return rentRepository.findById(id).map(car -> objectMapperUtils.map(car, RentDTO.class))
        .orElse(null);
  }

  @Override
  public RentDTO create(RentDTO entityDTO) {
    return objectMapperUtils.map(
        rentRepository.save(objectMapperUtils.map(entityDTO, Rent.class)), RentDTO.class);
  }

  @Override
  public RentDTO update(RentDTO entityDTO) {
    if (rentRepository.findById(entityDTO.getId()).isPresent()) {
      objectMapperUtils.map(
          rentRepository.save(objectMapperUtils.map(entityDTO, Rent.class)), RentDTO.class);
    }
    return null;
  }

  @Override
  public void delete(RentDTO entityDTO) {
    rentRepository.delete(objectMapperUtils.map(entityDTO, Rent.class));
  }

  @Override
  public void deleteById(int id) {
    rentRepository.deleteById(id);
  }
}
