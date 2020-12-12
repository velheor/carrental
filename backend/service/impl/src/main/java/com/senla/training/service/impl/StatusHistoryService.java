package com.senla.training.service.impl;

import com.senla.training.dao.api.IStatusHistoryDAO;
import com.senla.training.dto.statusHistory.StatusHistoryDTO;
import com.senla.training.dto.statusHistory.StatusHistoryWithRentDTO;
import com.senla.training.models.StatusHistory;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IStatusHistoryService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusHistoryService implements IStatusHistoryService {
  private final IStatusHistoryDAO statusHistoryDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  StatusHistoryService(IStatusHistoryDAO statusHistoryDAO, ObjectMapperUtils objectMapperUtils) {
    this.statusHistoryDAO = statusHistoryDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public StatusHistoryWithRentDTO findByIdStatusHistoryWithRentDTO(int id) {
    return objectMapperUtils.map(
        statusHistoryDAO.findByIdStatusHistoryWithRent(id), StatusHistoryWithRentDTO.class);
  }

  @Override
  public List<StatusHistoryWithRentDTO> findAllAndSortWithDirectionStatusHistoryWithRentDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        statusHistoryDAO.findAllAndSortWithDirectionStatusHistoryWithRent(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        StatusHistoryWithRentDTO.class);
  }

  @Override
  public StatusHistoryWithRentDTO findOneByCriteriaStatusHistoryWithRentDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        statusHistoryDAO.findOneByCriteriaStatusHistoryWithRent(fieldCriteriaMap),
        StatusHistoryWithRentDTO.class);
  }

  @Override
  public List<StatusHistoryWithRentDTO> findAllByCriteriaStatusHistoryWithRentDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        statusHistoryDAO.findAllByCriteriaStatusHistoryWithRent(fieldCriteriaMap),
        StatusHistoryWithRentDTO.class);
  }

  @Override
  public List<StatusHistoryWithRentDTO> findByNotNullStatusHistoryWithRentDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        statusHistoryDAO.findByNotNullStatusHistoryWithRent(fields),
        StatusHistoryWithRentDTO.class);
  }

  @Override
  public List<StatusHistoryWithRentDTO> findByNullStatusHistoryWithRentDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        statusHistoryDAO.findByNullStatusHistoryWithRent(fields), StatusHistoryWithRentDTO.class);
  }

  @Override
  public List<StatusHistoryWithRentDTO> findLessThanStatusHistoryWithRentDTO(
      Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        statusHistoryDAO.findLessThanStatusHistoryWithRent(fieldNumberMap),
        StatusHistoryWithRentDTO.class);
  }

  @Override
  public List<StatusHistoryWithRentDTO> findGreaterThanStatusHistoryWithRentDTO(
      Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        statusHistoryDAO.findGreaterThanStatusHistoryWithRent(fieldNumberMap),
        StatusHistoryWithRentDTO.class);
  }

  @Override
  public List<StatusHistoryWithRentDTO> findAndSortStatusHistoryWithRentDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        statusHistoryDAO.findAndSortStatusHistoryWithRent(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        StatusHistoryWithRentDTO.class);
  }

  @Override
  public List<StatusHistoryWithRentDTO> findContainStatusHistoryWithRentDTO(
      Map<String, String> fieldStringMap) {
    return objectMapperUtils.mapAll(
        statusHistoryDAO.findContainStatusHistoryWithRent(fieldStringMap),
        StatusHistoryWithRentDTO.class);
  }

  @Override
  public StatusHistoryDTO create(StatusHistoryDTO entityDTO) {
    statusHistoryDAO.create(objectMapperUtils.map(entityDTO, StatusHistory.class));
    return entityDTO;
  }

  @Override
  public StatusHistoryDTO update(StatusHistoryDTO entityDTO) {
    statusHistoryDAO.update(objectMapperUtils.map(entityDTO, StatusHistory.class));
    return entityDTO;
  }

  @Override
  public void delete(StatusHistoryDTO entityDTO) {
    statusHistoryDAO.delete(objectMapperUtils.map(entityDTO, StatusHistory.class));
  }

  @Override
  public void deleteById(int id) {
    statusHistoryDAO.deleteById(id);
  }
}
