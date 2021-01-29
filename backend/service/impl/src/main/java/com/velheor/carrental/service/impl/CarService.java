package com.velheor.carrental.service.impl;

import com.velheor.carrental.dao.api.ICarDAO;
import com.velheor.carrental.dto.CarDTO;
import com.velheor.carrental.models.Car;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.service.api.ICarService;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CarService implements ICarService {

  private final ICarDAO carDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  public CarService(ICarDAO carDAO, ObjectMapperUtils objectMapperUtils) {
    this.carDAO = carDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public CarDTO findByIdCarWithModelCategoryPriceHistoryBrandDTO(int id) {
    return objectMapperUtils.map(
        carDAO.findByIdCarWithModelCategoryPriceHistoryBrand(id), CarDTO.class);
  }

  @Override
  public List<CarDTO> findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrandDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        carDAO.findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrand(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        CarDTO.class);
  }

  @Override
  public CarDTO findOneByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        carDAO.findOneByCriteriaCarWithModelCategoryPriceHistoryBrand(fieldCriteriaMap),
        CarDTO.class);
  }

  @Override
  public List<CarDTO> findAllByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        carDAO.findAllByCriteriaCarWithModelCategoryPriceHistoryBrand(fieldCriteriaMap),
        CarDTO.class);
  }

  @Override
  public List<CarDTO> findByNotNullCarWithModelCategoryPriceHistoryBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        carDAO.findByNotNullCarWithModelCategoryPriceHistoryBrand(fields), CarDTO.class);
  }

  @Override
  public List<CarDTO> findByNullCarWithModelCategoryPriceHistoryBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        carDAO.findByNullCarWithModelCategoryPriceHistoryBrand(fields), CarDTO.class);
  }

  @Override
  public List<CarDTO> findAndSortCarWithModelCategoryPriceHistoryBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        carDAO.findAndSortCarWithModelCategoryPriceHistoryBrand(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        CarDTO.class);
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
