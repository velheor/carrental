package com.senla.training.service.impl;

import com.senla.training.dao.api.IRentDAO;
import com.senla.training.dto.rent.RentWithUserStatusHistoryCarDTO;
import com.senla.training.models.Rent;
import com.senla.training.models.enums.Direction;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IRentService;
import java.util.List;
import java.util.Map;
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

  @Override
  public RentWithUserStatusHistoryCarDTO findByIdRentWithUserStatusHistoryCarDTO(int id) {
    return objectMapperUtils.map(
        rentDAO.findByIdRentWithUserStatusHistoryCar(id), RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarDTO> findAllRentWithUserStatusHistoryCarDTO() {
    return objectMapperUtils.mapAll(
        rentDAO.findAllRentWithUserStatusHistoryCar(), RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public RentWithUserStatusHistoryCarDTO createRentWithUserStatusHistoryCarDTO(
      RentWithUserStatusHistoryCarDTO rentWithUserStatusHistoryCarDTO) {
    return objectMapperUtils.map(
        rentDAO.create(objectMapperUtils.map(rentWithUserStatusHistoryCarDTO, Rent.class)),
        RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public RentWithUserStatusHistoryCarDTO updateRentWithUserStatusHistoryCarDTO(
      RentWithUserStatusHistoryCarDTO rentWithUserStatusHistoryCarDTO) {
    return objectMapperUtils.map(
        rentDAO.update(objectMapperUtils.map(rentWithUserStatusHistoryCarDTO, Rent.class)),
        RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public void deleteRentWithUserStatusHistoryCarDTO(
      RentWithUserStatusHistoryCarDTO rentWithUserStatusHistoryCarDTO) {
    rentDAO.delete(objectMapperUtils.map(rentWithUserStatusHistoryCarDTO, Rent.class));
  }

  @Override
  public void deleteById(int id) {
    rentDAO.deleteById(id);
  }

  @Override
  public List<RentWithUserStatusHistoryCarDTO> sortWithDirectionRentWithUserStatusHistoryCarDTO(
      String field, Direction direction) {
    return objectMapperUtils.mapAll(
        rentDAO.sortWithDirectionRentWithUserStatusHistoryCar(field, direction),
        RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarDTO> sortWithDirectionRentWithUserStatusHistoryCarDTO(
      Map<String, Direction> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        rentDAO.sortWithDirectionRentWithUserStatusHistoryCar(fieldDirectionMap),
        RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public RentWithUserStatusHistoryCarDTO findOneByCriteriaRentWithUserStatusHistoryCarDTO(
      String field, Object criteria) {
    return objectMapperUtils.map(
        rentDAO.findOneByCriteriaRentWithUserStatusHistoryCar(field, criteria),
        RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarDTO> findAllByCriteriaRentWithUserStatusHistoryCarDTO(
      String field, Object criteria) {
    return objectMapperUtils.mapAll(
        rentDAO.findAllByCriteriaRentWithUserStatusHistoryCar(field, criteria),
        RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarDTO> findAllByCriteriaRentWithUserStatusHistoryCarDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findAllByCriteriaRentWithUserStatusHistoryCar(fieldCriteriaMap),
        RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarDTO> findByNotNullRentWithUserStatusHistoryCarDTO(
      String field) {
    return objectMapperUtils.mapAll(
        rentDAO.findByNotNullRentWithUserStatusHistoryCar(field),
        RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarDTO> findByNullRentWithUserStatusHistoryCarDTO(
      String field) {
    return objectMapperUtils.mapAll(
        rentDAO.findByNullRentWithUserStatusHistoryCar(field),
        RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarDTO> findLessThanRentWithUserStatusHistoryCarDTO(
      String field, Number number) {
    return objectMapperUtils.mapAll(
        rentDAO.findLessThanRentWithUserStatusHistoryCar(field, number),
        RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarDTO> findGreaterThanRentWithUserStatusHistoryCarDTO(
      String field, Number number) {
    return objectMapperUtils.mapAll(
        rentDAO.findGreaterThanRentWithUserStatusHistoryCar(field, number),
        RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarDTO> findAndSortRentWithUserStatusHistoryCarDTO(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findAndSortRentWithUserStatusHistoryCar(fieldDirectionMap, fieldCriteriaMap),
        RentWithUserStatusHistoryCarDTO.class);
  }

  @Override
  public List<RentWithUserStatusHistoryCarDTO> findContainRentWithUserStatusHistoryCarDTO(
      String field, String criteria) {
    return objectMapperUtils.mapAll(
        rentDAO.findContainRentWithUserStatusHistoryCar(field, criteria),
        RentWithUserStatusHistoryCarDTO.class);
  }
}
