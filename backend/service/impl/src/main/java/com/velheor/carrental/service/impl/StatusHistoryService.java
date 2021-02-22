package com.velheor.carrental.service.impl;

import com.velheor.carrental.dao.api.StatusHistoryRepository;
import com.velheor.carrental.dto.StatusHistoryDTO;
import com.velheor.carrental.models.StatusHistory;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.service.api.IStatusHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusHistoryService implements IStatusHistoryService {

  private final StatusHistoryRepository statusHistoryRepository;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  StatusHistoryService(
      StatusHistoryRepository statusHistoryRepository, ObjectMapperUtils objectMapperUtils) {
    this.statusHistoryRepository = statusHistoryRepository;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public StatusHistoryDTO findById(Integer id) {
    return statusHistoryRepository
        .findById(id)
        .map(car -> objectMapperUtils.map(car, StatusHistoryDTO.class))
        .orElse(null);
  }

  @Override
  public StatusHistoryDTO create(StatusHistoryDTO entityDTO) {
    return objectMapperUtils.map(
        statusHistoryRepository.save(objectMapperUtils.map(entityDTO, StatusHistory.class)),
        StatusHistoryDTO.class);
  }

  @Override
  public StatusHistoryDTO update(StatusHistoryDTO entityDTO) {
    if (statusHistoryRepository.findById(entityDTO.getId()).isPresent()) {
      objectMapperUtils.map(
          statusHistoryRepository.save(objectMapperUtils.map(entityDTO, StatusHistory.class)),
          StatusHistoryDTO.class);
    }
    return null;
  }

  @Override
  public void delete(StatusHistoryDTO entityDTO) {
    statusHistoryRepository.delete(objectMapperUtils.map(entityDTO, StatusHistory.class));
  }

  @Override
  public void deleteById(int id) {
    statusHistoryRepository.deleteById(id);
  }
}
