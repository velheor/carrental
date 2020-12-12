package com.senla.training.service.impl;

import com.senla.training.dao.api.IPriceHistoryDAO;
import com.senla.training.dto.pricehistory.PriceHistoryDTO;
import com.senla.training.dto.pricehistory.PriceHistoryWithCarModelBrandDTO;
import com.senla.training.models.PriceHistory;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IPriceHistoryService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceHistoryService implements IPriceHistoryService {
  private final IPriceHistoryDAO priceHistoryDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  PriceHistoryService(IPriceHistoryDAO priceHistoryDAO, ObjectMapperUtils objectMapperUtils) {
    this.priceHistoryDAO = priceHistoryDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public PriceHistoryWithCarModelBrandDTO findByIdPriceHistoryWithCarModelBrandDTO(int id) {
    return objectMapperUtils.map(
        priceHistoryDAO.findByIdPriceHistoryWithCarModelBrand(id),
        PriceHistoryWithCarModelBrandDTO.class);
  }

  @Override
  public List<PriceHistoryWithCarModelBrandDTO>
      findAllAndSortWithDirectionPriceHistoryWithCarModelBrandDTO(
          Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findAllAndSortWithDirectionPriceHistoryWithCarModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        PriceHistoryWithCarModelBrandDTO.class);
  }

  @Override
  public PriceHistoryWithCarModelBrandDTO findOneByCriteriaPriceHistoryWithCarModelBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        priceHistoryDAO.findOneByCriteriaPriceHistoryWithCarModelBrand(fieldCriteriaMap),
        PriceHistoryWithCarModelBrandDTO.class);
  }

  @Override
  public List<PriceHistoryWithCarModelBrandDTO> findAllByCriteriaPriceHistoryWithCarModelBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findAllByCriteriaPriceHistoryWithCarModelBrand(fieldCriteriaMap),
        PriceHistoryWithCarModelBrandDTO.class);
  }

  @Override
  public List<PriceHistoryWithCarModelBrandDTO> findByNotNullPriceHistoryWithCarModelBrandDTO(
      List<String> fields) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findByNotNullPriceHistoryWithCarModelBrand(fields),
        PriceHistoryWithCarModelBrandDTO.class);
  }

  @Override
  public List<PriceHistoryWithCarModelBrandDTO> findByNullPriceHistoryWithCarModelBrandDTO(
      List<String> fields) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findByNullPriceHistoryWithCarModelBrand(fields),
        PriceHistoryWithCarModelBrandDTO.class);
  }

  @Override
  public List<PriceHistoryWithCarModelBrandDTO> findLessThanPriceHistoryWithCarModelBrandDTO(
      Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findLessThanPriceHistoryWithCarModelBrand(fieldNumberMap),
        PriceHistoryWithCarModelBrandDTO.class);
  }

  @Override
  public List<PriceHistoryWithCarModelBrandDTO> findGreaterThanPriceHistoryWithCarModelBrandDTO(
      Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findGreaterThanPriceHistoryWithCarModelBrand(fieldNumberMap),
        PriceHistoryWithCarModelBrandDTO.class);
  }

  @Override
  public List<PriceHistoryWithCarModelBrandDTO> findAndSortPriceHistoryWithCarModelBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findAndSortPriceHistoryWithCarModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        PriceHistoryWithCarModelBrandDTO.class);
  }

  @Override
  public List<PriceHistoryWithCarModelBrandDTO> findContainPriceHistoryWithCarModelBrandDTO(
      Map<String, String> fieldStringMap) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findContainPriceHistoryWithCarModelBrand(fieldStringMap),
        PriceHistoryWithCarModelBrandDTO.class);
  }

  @Override
  public PriceHistoryDTO create(PriceHistoryDTO entityDTO) {
    priceHistoryDAO.create(objectMapperUtils.map(entityDTO, PriceHistory.class));
    return entityDTO;
  }

  @Override
  public PriceHistoryDTO update(PriceHistoryDTO entityDTO) {
    priceHistoryDAO.update(objectMapperUtils.map(entityDTO, PriceHistory.class));
    return entityDTO;
  }

  @Override
  public void delete(PriceHistoryDTO entityDTO) {
    priceHistoryDAO.delete(objectMapperUtils.map(entityDTO, PriceHistory.class));
  }

  @Override
  public void deleteById(int id) {
    priceHistoryDAO.deleteById(id);
  }
}
