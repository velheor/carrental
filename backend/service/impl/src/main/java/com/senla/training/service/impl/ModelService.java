package com.senla.training.service.impl;

import com.senla.training.dao.api.IModelDAO;
import com.senla.training.dto.model.ModelDTO;
import com.senla.training.dto.model.ModelWithBrandDTO;
import com.senla.training.models.Model;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IModelService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ModelService implements IModelService {
  private final IModelDAO modelDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  ModelService(IModelDAO modelDAO, ObjectMapperUtils objectMapperUtils) {
    this.modelDAO = modelDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public ModelWithBrandDTO findByIdModelWithBrandDTO(int id) {
    return objectMapperUtils.map(modelDAO.findByIdModelWithBrand(id), ModelWithBrandDTO.class);
  }

  @Override
  public List<ModelWithBrandDTO> findAllAndSortWithDirectionModelWithBrandDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        modelDAO.findAllAndSortWithDirectionModelWithBrand(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        ModelWithBrandDTO.class);
  }

  @Override
  public ModelWithBrandDTO findOneByCriteriaModelWithBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        modelDAO.findOneByCriteriaModelWithBrand(fieldCriteriaMap), ModelWithBrandDTO.class);
  }

  @Override
  public List<ModelWithBrandDTO> findAllByCriteriaModelWithBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        modelDAO.findAllByCriteriaModelWithBrand(fieldCriteriaMap), ModelWithBrandDTO.class);
  }

  @Override
  public List<ModelWithBrandDTO> findByNotNullModelWithBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        modelDAO.findByNotNullModelWithBrand(fields), ModelWithBrandDTO.class);
  }

  @Override
  public List<ModelWithBrandDTO> findByNullModelWithBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        modelDAO.findByNullModelWithBrand(fields), ModelWithBrandDTO.class);
  }

  @Override
  public List<ModelWithBrandDTO> findLessThanModelWithBrandDTO(Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        modelDAO.findLessThanModelWithBrand(fieldNumberMap), ModelWithBrandDTO.class);
  }

  @Override
  public List<ModelWithBrandDTO> findGreaterThanModelWithBrandDTO(
      Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        modelDAO.findGreaterThanModelWithBrand(fieldNumberMap), ModelWithBrandDTO.class);
  }

  @Override
  public List<ModelWithBrandDTO> findAndSortModelWithBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        modelDAO.findAndSortModelWithBrand(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        ModelWithBrandDTO.class);
  }

  @Override
  public List<ModelWithBrandDTO> findContainModelWithBrandDTO(Map<String, String> fieldStringMap) {
    return objectMapperUtils.mapAll(
        modelDAO.findContainModelWithBrand(fieldStringMap), ModelWithBrandDTO.class);
  }

  @Override
  public ModelDTO create(ModelDTO entityDTO) {
    modelDAO.create(objectMapperUtils.map(entityDTO, Model.class));
    return entityDTO;
  }

  @Override
  public ModelDTO update(ModelDTO entityDTO) {
    modelDAO.update(objectMapperUtils.map(entityDTO, Model.class));
    return entityDTO;
  }

  @Override
  public void delete(ModelDTO entityDTO) {
    modelDAO.delete(objectMapperUtils.map(entityDTO, Model.class));
  }

  @Override
  public void deleteById(int id) {
    modelDAO.deleteById(id);
  }
}
