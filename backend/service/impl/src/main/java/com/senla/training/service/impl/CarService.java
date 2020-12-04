package com.senla.training.service.impl;

import com.senla.training.dao.api.ICarDAO;
import com.senla.training.dto.car.CarWithCategoryDTO;
import com.senla.training.models.Car;
import com.senla.training.models.enums.Direction;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.ICarService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService {

  private final ICarDAO carDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  public CarService(ICarDAO carDAO, ObjectMapperUtils objectMapperUtils) {
    this.carDAO = carDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public CarWithCategoryDTO findByIdCarWithCategoryDTO(int id) {
    return objectMapperUtils.map(carDAO.findByIdCarWithCategory(id), CarWithCategoryDTO.class);
  }

  @Override
  public List<CarWithCategoryDTO> findAllCarWithCategoryDTO() {
    return objectMapperUtils.mapAll(carDAO.findAllCarWithCategory(), CarWithCategoryDTO.class);
  }

  @Override
  public CarWithCategoryDTO createCarWithCategoryDTO(CarWithCategoryDTO carWithCategoryDTO) {
    return objectMapperUtils.map(
        carDAO.create(objectMapperUtils.map(carWithCategoryDTO, Car.class)),
        CarWithCategoryDTO.class);
  }

  @Override
  public CarWithCategoryDTO updateCarWithCategoryDTO(CarWithCategoryDTO carWithCategoryDTO) {
    return objectMapperUtils.map(
        carDAO.update(objectMapperUtils.map(carWithCategoryDTO, Car.class)),
        CarWithCategoryDTO.class);
  }

  @Override
  public void deleteCarWithCategoryDTO(CarWithCategoryDTO carWithCategoryDTO) {
    carDAO.delete(objectMapperUtils.map(carWithCategoryDTO, Car.class));
  }

  @Override
  public void deleteById(int id) {
    carDAO.deleteById(id);
  }

  @Override
  public List<CarWithCategoryDTO> sortWithDirectionCarWithCategoryDTO(
      String field, Direction direction) {
    return objectMapperUtils.mapAll(
        carDAO.sortWithDirectionCarWithCategory(field, direction), CarWithCategoryDTO.class);
  }

  @Override
  public List<CarWithCategoryDTO> sortWithDirectionCarWithCategoryDTO(
      Map<String, Direction> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        carDAO.sortWithDirectionCarWithCategory(fieldDirectionMap), CarWithCategoryDTO.class);
  }

  @Override
  public CarWithCategoryDTO findOneByCriteriaCarWithCategoryDTO(String field, Object criteria) {
    return objectMapperUtils.map(
        carDAO.findOneByCriteriaCarWithCategory(field, criteria), CarWithCategoryDTO.class);
  }

  @Override
  public List<CarWithCategoryDTO> findAllByCriteriaCarWithCategoryDTO(
      String field, Object criteria) {
    return objectMapperUtils.mapAll(
        carDAO.findAllByCriteriaCarWithCategory(field, criteria), CarWithCategoryDTO.class);
  }

  @Override
  public List<CarWithCategoryDTO> findAllByCriteriaCarWithCategoryDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        carDAO.findAllByCriteriaCarWithCategory(fieldCriteriaMap), CarWithCategoryDTO.class);
  }

  @Override
  public List<CarWithCategoryDTO> findByNotNullCarWithCategoryDTO(String field) {
    return objectMapperUtils.mapAll(
        carDAO.findByNotNullCarWithCategory(field), CarWithCategoryDTO.class);
  }

  @Override
  public List<CarWithCategoryDTO> findByNullCarWithCategoryDTO(String field) {
    return objectMapperUtils.mapAll(
        carDAO.findByNullCarWithCategory(field), CarWithCategoryDTO.class);
  }

  @Override
  public List<CarWithCategoryDTO> findLessThanCarWithCategoryDTO(String field, Number number) {
    return objectMapperUtils.mapAll(
        carDAO.findLessThanCarWithCategory(field, number), CarWithCategoryDTO.class);
  }

  @Override
  public List<CarWithCategoryDTO> findGreaterThanCarWithCategoryDTO(String field, Number number) {
    return objectMapperUtils.mapAll(
        carDAO.findGreaterThanCarWithCategory(field, number), CarWithCategoryDTO.class);
  }

  @Override
  public List<CarWithCategoryDTO> findAndSortCarWithCategoryDTO(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        carDAO.findAndSortCarWithCategory(fieldDirectionMap, fieldCriteriaMap),
        CarWithCategoryDTO.class);
  }

  @Override
  public List<CarWithCategoryDTO> findContainCarWithCategoryDTO(String field, String criteria) {
    return objectMapperUtils.mapAll(
        carDAO.findContainCarWithCategory(field, criteria), CarWithCategoryDTO.class);
  }
}
