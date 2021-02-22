package com.velheor.carrental.service.impl;

import com.velheor.carrental.dao.api.CarRepository;
import com.velheor.carrental.dto.CarDTO;
import com.velheor.carrental.models.Car;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.service.api.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService {

  private final CarRepository carRepository;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  public CarService(CarRepository carRepository, ObjectMapperUtils objectMapperUtils) {
    this.carRepository = carRepository;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public CarDTO findById(Integer id) {
    return carRepository
        .findById(id)
        .map(car -> objectMapperUtils.map(car, CarDTO.class))
        .orElse(null);
  }

  @Override
  public CarDTO create(CarDTO entityDTO) {
    return objectMapperUtils.map(
        carRepository.save(objectMapperUtils.map(entityDTO, Car.class)), CarDTO.class);
  }

  @Override
  public CarDTO update(CarDTO entityDTO) {
    if (carRepository.findById(entityDTO.getId()).isPresent()) {
      objectMapperUtils.map(
          carRepository.save(objectMapperUtils.map(entityDTO, Car.class)), CarDTO.class);
    }
    return null;
  }

  @Override
  public void delete(CarDTO entityDTO) {
    carRepository.delete(objectMapperUtils.map(entityDTO, Car.class));
  }

  @Override
  public void deleteById(int id) {
    carRepository.deleteById(id);
  }
}
