package com.senla.training.service.impl;

import com.senla.training.dao.api.IBrandDAO;
import com.senla.training.dto.brand.BrandDTO;
import com.senla.training.dto.brand.BrandWithModelsDTO;
import com.senla.training.models.Brand;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IBrandService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BrandService implements IBrandService {
  private final IBrandDAO brandDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  BrandService(IBrandDAO brandDAO, ObjectMapperUtils objectMapperUtils) {
    this.brandDAO = brandDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public BrandWithModelsDTO findByIdBrandWithModelsDTO(int id) {
    return objectMapperUtils.map(brandDAO.findByIdBrandWithModels(id), BrandWithModelsDTO.class);
  }

  @Override
  public List<BrandWithModelsDTO> findAllAndSortWithDirectionBrandWithModelsDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        brandDAO.findAllAndSortWithDirectionBrandWithModels(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        BrandWithModelsDTO.class);
  }

  @Override
  public BrandWithModelsDTO findOneByCriteriaBrandWithModelsDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        brandDAO.findOneByCriteriaBrandWithModels(fieldCriteriaMap), BrandWithModelsDTO.class);
  }

  @Override
  public List<BrandWithModelsDTO> findAllByCriteriaBrandWithModelsDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        brandDAO.findAllByCriteriaBrandWithModels(fieldCriteriaMap), BrandWithModelsDTO.class);
  }

  @Override
  public List<BrandWithModelsDTO> findByNotNullBrandWithModelsDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        brandDAO.findByNotNullBrandWithModels(fields), BrandWithModelsDTO.class);
  }

  @Override
  public List<BrandWithModelsDTO> findByNullBrandWithModelsDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        brandDAO.findByNullBrandWithModels(fields), BrandWithModelsDTO.class);
  }

  @Override
  public List<BrandWithModelsDTO> findLessThanBrandWithModelsDTO(
      Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        brandDAO.findLessThanBrandWithModels(fieldNumberMap), BrandWithModelsDTO.class);
  }

  @Override
  public List<BrandWithModelsDTO> findGreaterThanBrandWithModelsDTO(
      Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        brandDAO.findGreaterThanBrandWithModels(fieldNumberMap), BrandWithModelsDTO.class);
  }

  @Override
  public List<BrandWithModelsDTO> findAndSortBrandWithModelsDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        brandDAO.findAndSortBrandWithModels(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        BrandWithModelsDTO.class);
  }

  @Override
  public List<BrandWithModelsDTO> findContainBrandWithModelsDTO(
      Map<String, String> fieldStringMap) {
    return objectMapperUtils.mapAll(
        brandDAO.findContainBrandWithModels(fieldStringMap), BrandWithModelsDTO.class);
  }

  @Override
  public BrandDTO create(BrandDTO entityDTO) {
    brandDAO.create(objectMapperUtils.map(entityDTO, Brand.class));
    return entityDTO;
  }

  @Override
  public BrandDTO update(BrandDTO entityDTO) {
    brandDAO.update(objectMapperUtils.map(entityDTO, Brand.class));
    return entityDTO;
  }

  @Override
  public void delete(BrandDTO entityDTO) {
    brandDAO.delete(objectMapperUtils.map(entityDTO, Brand.class));
  }

  @Override
  public void deleteById(int id) {
    brandDAO.deleteById(id);
  }
}
