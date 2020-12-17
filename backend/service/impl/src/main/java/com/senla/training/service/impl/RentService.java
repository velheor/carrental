package com.senla.training.service.impl;

import com.senla.training.dao.api.ICarDAO;
import com.senla.training.dao.api.IPriceHistoryDAO;
import com.senla.training.dao.api.IRentDAO;
import com.senla.training.dto.RentDTO;
import com.senla.training.models.Rent;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IRentService;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RentService implements IRentService {

  private final IRentDAO rentDAO;

  private final ICarDAO carDAO;

  private final IPriceHistoryDAO priceHistoryDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  RentService(
      IRentDAO rentDAO,
      ICarDAO carDAO,
      IPriceHistoryDAO priceHistoryDAO,
      ObjectMapperUtils objectMapperUtils) {
    this.priceHistoryDAO = priceHistoryDAO;
    this.objectMapperUtils = objectMapperUtils;
    this.rentDAO = rentDAO;
    this.carDAO = carDAO;
  }

  @Override
  public RentDTO
  findByIdRentWithUserStatusHistoryCarModelBrandDTO(int id) {
    return objectMapperUtils.map(
        rentDAO.findByIdRentWithUserStatusHistoryCarModelBrand(id),
        RentDTO.class);
  }

  @Override
  public List<RentDTO>
  findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrandDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        RentDTO.class);
  }

  @Override
  public RentDTO
  findOneByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        rentDAO.findOneByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriteriaMap),
        RentDTO.class);
  }

  @Override
  public List<RentDTO>
  findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findAllByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriteriaMap),
        RentDTO.class);
  }

  @Override
  public List<RentDTO>
  findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        rentDAO.findByNotNullRentWithUserStatusHistoryCarModelBrand(fields),
        RentDTO.class);
  }

  @Override
  public List<RentDTO>
  findByNullRentWithUserStatusHistoryCarModelBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        rentDAO.findByNullRentWithUserStatusHistoryCarModelBrand(fields),
        RentDTO.class);
  }

  @Override
  public List<RentDTO>
  findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findAndSortRentWithUserStatusHistoryCarModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        RentDTO.class);
  }

  @Override
  public RentDTO create(
      RentDTO entityDTO) {
    rentDAO.create(objectMapperUtils.map(entityDTO, Rent.class));
    return entityDTO;
  }

  @Override
  public RentDTO update(
      RentDTO entityDTO) {
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
