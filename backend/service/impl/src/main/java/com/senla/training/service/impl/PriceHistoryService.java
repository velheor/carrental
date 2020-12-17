package com.senla.training.service.impl;

import com.senla.training.dao.api.IPriceHistoryDAO;
import com.senla.training.dto.PriceHistoryDTO;
import com.senla.training.models.PriceHistory;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IPriceHistoryService;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PriceHistoryService implements IPriceHistoryService {
  private final IPriceHistoryDAO priceHistoryDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  PriceHistoryService(IPriceHistoryDAO priceHistoryDAO, ObjectMapperUtils objectMapperUtils) {
    this.priceHistoryDAO = priceHistoryDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public PriceHistoryDTO findByIdPriceHistoryWithCarModelBrandDTO(int id) {
    return objectMapperUtils.map(
        priceHistoryDAO.findByIdPriceHistoryWithCarModelBrand(id),
        PriceHistoryDTO.class);
  }

  @Override
  public List<PriceHistoryDTO>
      findAllAndSortWithDirectionPriceHistoryWithCarModelBrandDTO(
          Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findAllAndSortWithDirectionPriceHistoryWithCarModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        PriceHistoryDTO.class);
  }

  @Override
  public PriceHistoryDTO findOneByCriteriaPriceHistoryWithCarModelBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        priceHistoryDAO.findOneByCriteriaPriceHistoryWithCarModelBrand(fieldCriteriaMap),
        PriceHistoryDTO.class);
  }

  @Override
  public List<PriceHistoryDTO> findAllByCriteriaPriceHistoryWithCarModelBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findAllByCriteriaPriceHistoryWithCarModelBrand(fieldCriteriaMap),
        PriceHistoryDTO.class);
  }

  @Override
  public List<PriceHistoryDTO> findByNotNullPriceHistoryWithCarModelBrandDTO(
      List<String> fields) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findByNotNullPriceHistoryWithCarModelBrand(fields),
        PriceHistoryDTO.class);
  }

  @Override
  public List<PriceHistoryDTO> findByNullPriceHistoryWithCarModelBrandDTO(
      List<String> fields) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findByNullPriceHistoryWithCarModelBrand(fields),
        PriceHistoryDTO.class);
  }

  @Override
  public List<PriceHistoryDTO> findAndSortPriceHistoryWithCarModelBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findAndSortPriceHistoryWithCarModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        PriceHistoryDTO.class);
  }

  @Override
  public List<PriceHistoryDTO> findContainPriceHistoryWithCarModelBrandDTO(
      Map<String, String> fieldStringMap) {
    return objectMapperUtils.mapAll(
        priceHistoryDAO.findContainPriceHistoryWithCarModelBrand(fieldStringMap),
        PriceHistoryDTO.class);
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
