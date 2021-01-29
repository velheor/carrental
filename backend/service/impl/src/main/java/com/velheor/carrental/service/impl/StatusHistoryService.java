package com.velheor.carrental.service.impl;

import com.velheor.carrental.dao.api.IStatusHistoryDAO;
import com.velheor.carrental.dto.StatusHistoryDTO;
import com.velheor.carrental.models.StatusHistory;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.service.api.IStatusHistoryService;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StatusHistoryService implements IStatusHistoryService {

  private final IStatusHistoryDAO statusHistoryDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  StatusHistoryService(IStatusHistoryDAO statusHistoryDAO, ObjectMapperUtils objectMapperUtils) {
    this.statusHistoryDAO = statusHistoryDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public StatusHistoryDTO findByIdStatusHistoryWithRentDTO(int id) {
    return objectMapperUtils.map(
        statusHistoryDAO.findByIdStatusHistoryWithRent(id), StatusHistoryDTO.class);
  }

  @Override
  public List<StatusHistoryDTO> findAllAndSortWithDirectionStatusHistoryWithRentDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        statusHistoryDAO.findAllAndSortWithDirectionStatusHistoryWithRent(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        StatusHistoryDTO.class);
  }

  @Override
  public StatusHistoryDTO findOneByCriteriaStatusHistoryWithRentDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        statusHistoryDAO.findOneByCriteriaStatusHistoryWithRent(fieldCriteriaMap),
        StatusHistoryDTO.class);
  }

  @Override
  public List<StatusHistoryDTO> findAllByCriteriaStatusHistoryWithRentDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        statusHistoryDAO.findAllByCriteriaStatusHistoryWithRent(fieldCriteriaMap),
        StatusHistoryDTO.class);
  }

  @Override
  public List<StatusHistoryDTO> findByNotNullStatusHistoryWithRentDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        statusHistoryDAO.findByNotNullStatusHistoryWithRent(fields), StatusHistoryDTO.class);
  }

  @Override
  public List<StatusHistoryDTO> findByNullStatusHistoryWithRentDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        statusHistoryDAO.findByNullStatusHistoryWithRent(fields), StatusHistoryDTO.class);
  }

  @Override
  public List<StatusHistoryDTO> findAndSortStatusHistoryWithRentDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        statusHistoryDAO.findAndSortStatusHistoryWithRent(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        StatusHistoryDTO.class);
  }

  @Override
  public StatusHistoryDTO create(StatusHistoryDTO entityDTO) {
    return objectMapperUtils.map(
        statusHistoryDAO.create(objectMapperUtils.map(entityDTO, StatusHistory.class)),
        StatusHistoryDTO.class);
  }

  @Override
  public StatusHistoryDTO update(StatusHistoryDTO entityDTO) {
    return objectMapperUtils.map(
        statusHistoryDAO.update(objectMapperUtils.map(entityDTO, StatusHistory.class)),
        StatusHistoryDTO.class);
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
