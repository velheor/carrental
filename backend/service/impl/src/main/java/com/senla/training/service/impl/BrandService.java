package com.senla.training.service.impl;

import com.senla.training.dao.api.IBrandDAO;
import com.senla.training.dto.BrandDTO;
import com.senla.training.models.Brand;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IBrandService;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  public BrandDTO findByIdBrandWithModelsDTO(int id) {
    return objectMapperUtils.map(brandDAO.findByIdBrandWithModels(id), BrandDTO.class);
  }

  @Override
  public List<BrandDTO> findAllAndSortWithDirectionBrandWithModelsDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        brandDAO.findAllAndSortWithDirectionBrandWithModels(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        BrandDTO.class);
  }

  @Override
  public BrandDTO findOneByCriteriaBrandWithModelsDTO(Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        brandDAO.findOneByCriteriaBrandWithModels(fieldCriteriaMap), BrandDTO.class);
  }

  @Override
  public List<BrandDTO> findAllByCriteriaBrandWithModelsDTO(Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        brandDAO.findAllByCriteriaBrandWithModels(fieldCriteriaMap), BrandDTO.class);
  }

  @Override
  public List<BrandDTO> findByNotNullBrandWithModelsDTO(List<String> fields) {
    return objectMapperUtils.mapAll(brandDAO.findByNotNullBrandWithModels(fields), BrandDTO.class);
  }

  @Override
  public List<BrandDTO> findByNullBrandWithModelsDTO(List<String> fields) {
    return objectMapperUtils.mapAll(brandDAO.findByNullBrandWithModels(fields), BrandDTO.class);
  }

  @Override
  public List<BrandDTO> findAndSortBrandWithModelsDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        brandDAO.findAndSortBrandWithModels(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        BrandDTO.class);
  }

  @Override
  public BrandDTO create(BrandDTO entityDTO) {
    return objectMapperUtils.map(
        brandDAO.create(objectMapperUtils.map(entityDTO, Brand.class)), BrandDTO.class);
  }

  @Override
  public BrandDTO update(BrandDTO entityDTO) {
    return objectMapperUtils.map(
        brandDAO.update(objectMapperUtils.map(entityDTO, Brand.class)), BrandDTO.class);
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
