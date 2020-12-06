package com.senla.training.service.impl;

import com.senla.training.dao.api.ICarDAO;
import com.senla.training.dto.car.CarDTO;
import com.senla.training.dto.car.CarWithModelCategoryPriceHistoryBrandDTO;
import com.senla.training.models.Car;
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
  public CarWithModelCategoryPriceHistoryBrandDTO findByIdCarWithModelCategoryPriceHistoryBrandDTO(
      int id) {
    return objectMapperUtils.map(
        carDAO.findByIdCarWithModelCategoryPriceHistoryBrand(id),
        CarWithModelCategoryPriceHistoryBrandDTO.class);
  }

  @Override
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrandDTO(
          Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        carDAO.findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrand(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        CarWithModelCategoryPriceHistoryBrandDTO.class);
  }

  @Override
  public CarWithModelCategoryPriceHistoryBrandDTO
      findOneByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(
          Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        carDAO.findOneByCriteriaCarWithModelCategoryPriceHistoryBrand(fieldCriteriaMap),
        CarWithModelCategoryPriceHistoryBrandDTO.class);
  }

  @Override
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findAllByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(
          Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        carDAO.findAllByCriteriaCarWithModelCategoryPriceHistoryBrand(fieldCriteriaMap),
        CarWithModelCategoryPriceHistoryBrandDTO.class);
  }

  @Override
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findByNotNullCarWithModelCategoryPriceHistoryBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        carDAO.findByNotNullCarWithModelCategoryPriceHistoryBrand(fields),
        CarWithModelCategoryPriceHistoryBrandDTO.class);
  }

  @Override
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findByNullCarWithModelCategoryPriceHistoryBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        carDAO.findByNullCarWithModelCategoryPriceHistoryBrand(fields),
        CarWithModelCategoryPriceHistoryBrandDTO.class);
  }

  @Override
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findLessThanCarWithModelCategoryPriceHistoryBrandDTO(Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        carDAO.findLessThanCarWithModelCategoryPriceHistoryBrand(fieldNumberMap),
        CarWithModelCategoryPriceHistoryBrandDTO.class);
  }

  @Override
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findGreaterThanCarWithModelCategoryPriceHistoryBrandDTO(Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        carDAO.findGreaterThanCarWithModelCategoryPriceHistoryBrand(fieldNumberMap),
        CarWithModelCategoryPriceHistoryBrandDTO.class);
  }

  @Override
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findAndSortCarWithModelCategoryPriceHistoryBrandDTO(
          Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        carDAO.findAndSortCarWithModelCategoryPriceHistoryBrand(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        CarWithModelCategoryPriceHistoryBrandDTO.class);
  }

  @Override
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findContainCarWithModelCategoryPriceHistoryBrandDTO(Map<String, String> fieldStringMap) {
    return objectMapperUtils.mapAll(
        carDAO.findContainCarWithModelCategoryPriceHistoryBrand(fieldStringMap),
        CarWithModelCategoryPriceHistoryBrandDTO.class);
  }

  @Override
  public CarDTO create(CarDTO entityDTO) {
    return objectMapperUtils.map(
        carDAO.create(objectMapperUtils.map(entityDTO, Car.class)), CarDTO.class);
  }

  @Override
  public CarDTO update(CarDTO entityDTO) {
    return objectMapperUtils.map(
        carDAO.update(objectMapperUtils.map(entityDTO, Car.class)), CarDTO.class);
  }

  @Override
  public void delete(CarDTO entityDTO) {
    carDAO.delete(objectMapperUtils.map(entityDTO, Car.class));
  }

  @Override
  public void deleteById(int id) {
    carDAO.deleteById(id);
  }
}
