package com.senla.training.service.impl;

import com.senla.training.dao.api.IRentDAO;
import com.senla.training.dto.rent.RentDTO;
import com.senla.training.dto.rent.RentWithUserStatusHistoryCarModelBrandDTO;
import com.senla.training.models.Rent;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IRentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RentService implements IRentService {

  private final IRentDAO rentDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  RentService(IRentDAO rentDAO, ObjectMapperUtils objectMapperUtils) {
    this.rentDAO = rentDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public RentWithUserStatusHistoryCarModelBrandDTO
      findByIdRentWithUserStatusHistoryCarModelBrandDTO(int id) {
    return objectMapperUtils.map(
        rentDAO.findByIdRentWithUserStatusHistoryCarModelBrand(id),
        RentWithUserStatusHistoryCarModelBrandDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrandDTO(
          Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        RentWithUserStatusHistoryCarModelBrandDTO.class);
  }

  @Override
  public RentWithUserStatusHistoryCarModelBrandDTO
      findOneByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
          Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        rentDAO.findOneByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriteriaMap),
        RentWithUserStatusHistoryCarModelBrandDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
          Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findAllByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriteriaMap),
        RentWithUserStatusHistoryCarModelBrandDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        rentDAO.findByNotNullRentWithUserStatusHistoryCarModelBrand(fields),
        RentWithUserStatusHistoryCarModelBrandDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findByNullRentWithUserStatusHistoryCarModelBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        rentDAO.findByNullRentWithUserStatusHistoryCarModelBrand(fields),
        RentWithUserStatusHistoryCarModelBrandDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findLessThanRentWithUserStatusHistoryCarModelBrandDTO(Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findLessThanRentWithUserStatusHistoryCarModelBrand(fieldNumberMap),
        RentWithUserStatusHistoryCarModelBrandDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findGreaterThanRentWithUserStatusHistoryCarModelBrandDTO(Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findGreaterThanRentWithUserStatusHistoryCarModelBrand(fieldNumberMap),
        RentWithUserStatusHistoryCarModelBrandDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
          Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findAndSortRentWithUserStatusHistoryCarModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        RentWithUserStatusHistoryCarModelBrandDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findContainRentWithUserStatusHistoryCarModelBrandDTO(Map<String, String> fieldStringMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findContainRentWithUserStatusHistoryCarModelBrand(fieldStringMap),
        RentWithUserStatusHistoryCarModelBrandDTO.class);
  }

  @Override
  public RentDTO create(RentDTO entityDTO) {
    rentDAO.create(objectMapperUtils.map(entityDTO, Rent.class));
    return entityDTO;
  }

  @Override
  public RentDTO update(RentDTO entityDTO) {
    rentDAO.update(objectMapperUtils.map(entityDTO, Rent.class));
    return entityDTO;
  }

  @Override
  public void delete(RentDTO entityDTO) {
    rentDAO.delete(objectMapperUtils.map(entityDTO, Rent.class));
  }

  @Override
  public void deleteById(int id) {
    rentDAO.deleteById(id);
  }
}
