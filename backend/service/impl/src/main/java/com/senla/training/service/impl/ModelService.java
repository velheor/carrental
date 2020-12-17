package com.senla.training.service.impl;

import com.senla.training.dao.api.IModelDAO;
import com.senla.training.dto.ModelDTO;
import com.senla.training.models.Model;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IModelService;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  public ModelDTO findByIdModelWithBrandDTO(int id) {
    return objectMapperUtils.map(modelDAO.findByIdModelWithBrand(id), ModelDTO.class);
  }

  @Override
  public List<ModelDTO> findAllAndSortWithDirectionModelWithBrandDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        modelDAO.findAllAndSortWithDirectionModelWithBrand(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        ModelDTO.class);
  }

  @Override
  public ModelDTO findOneByCriteriaModelWithBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        modelDAO.findOneByCriteriaModelWithBrand(fieldCriteriaMap), ModelDTO.class);
  }

  @Override
  public List<ModelDTO> findAllByCriteriaModelWithBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        modelDAO.findAllByCriteriaModelWithBrand(fieldCriteriaMap), ModelDTO.class);
  }

  @Override
  public List<ModelDTO> findByNotNullModelWithBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        modelDAO.findByNotNullModelWithBrand(fields), ModelDTO.class);
  }

  @Override
  public List<ModelDTO> findByNullModelWithBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        modelDAO.findByNullModelWithBrand(fields), ModelDTO.class);
  }

  @Override
  public List<ModelDTO> findAndSortModelWithBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        modelDAO.findAndSortModelWithBrand(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        ModelDTO.class);
  }

  @Override
  public List<ModelDTO> findContainModelWithBrandDTO(Map<String, String> fieldStringMap) {
    return objectMapperUtils.mapAll(
        modelDAO.findContainModelWithBrand(fieldStringMap), ModelDTO.class);
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
