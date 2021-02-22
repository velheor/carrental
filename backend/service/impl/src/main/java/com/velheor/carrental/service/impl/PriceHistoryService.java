package com.velheor.carrental.service.impl;

import com.velheor.carrental.dao.api.PriceHistoryRepository;
import com.velheor.carrental.dto.PriceHistoryDTO;
import com.velheor.carrental.models.PriceHistory;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.service.api.IPriceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceHistoryService implements IPriceHistoryService {

  private final PriceHistoryRepository priceHistoryRepository;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  PriceHistoryService(
      PriceHistoryRepository priceHistoryRepository, ObjectMapperUtils objectMapperUtils) {
    this.priceHistoryRepository = priceHistoryRepository;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public PriceHistoryDTO findById(Integer id) {
    return priceHistoryRepository
        .findById(id)
        .map(car -> objectMapperUtils.map(car, PriceHistoryDTO.class))
        .orElse(null);
  }

  @Override
  public PriceHistoryDTO create(PriceHistoryDTO entityDTO) {
    return objectMapperUtils.map(
        priceHistoryRepository.save(objectMapperUtils.map(entityDTO, PriceHistory.class)),
        PriceHistoryDTO.class);
  }

  @Override
  public PriceHistoryDTO update(PriceHistoryDTO entityDTO) {
    if (priceHistoryRepository.findById(entityDTO.getId()).isPresent()) {
      objectMapperUtils.map(
          priceHistoryRepository.save(objectMapperUtils.map(entityDTO, PriceHistory.class)),
          PriceHistoryDTO.class);
    }
    return null;
  }

  @Override
  public void delete(PriceHistoryDTO entityDTO) {
    priceHistoryRepository.delete(objectMapperUtils.map(entityDTO, PriceHistory.class));
  }

  @Override
  public void deleteById(int id) {
    priceHistoryRepository.deleteById(id);
  }
}
