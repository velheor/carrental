package com.velheor.carrental.service.impl;

import com.velheor.carrental.dao.api.IModelDAO;
import com.velheor.carrental.dto.ModelDTO;
import com.velheor.carrental.models.Model;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.service.api.IModelService;
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
  public ModelDTO findOneByCriteriaModelWithBrandDTO(Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        modelDAO.findOneByCriteriaModelWithBrand(fieldCriteriaMap), ModelDTO.class);
  }

  @Override
  public List<ModelDTO> findAllByCriteriaModelWithBrandDTO(Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        modelDAO.findAllByCriteriaModelWithBrand(fieldCriteriaMap), ModelDTO.class);
  }

  @Override
  public List<ModelDTO> findByNotNullModelWithBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(modelDAO.findByNotNullModelWithBrand(fields), ModelDTO.class);
  }

  @Override
  public List<ModelDTO> findByNullModelWithBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(modelDAO.findByNullModelWithBrand(fields), ModelDTO.class);
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
  public ModelDTO create(ModelDTO entityDTO) {
    return objectMapperUtils.map(
        modelDAO.create(objectMapperUtils.map(entityDTO, Model.class)), ModelDTO.class);
  }

  @Override
  public ModelDTO update(ModelDTO entityDTO) {
    return objectMapperUtils.map(
        modelDAO.update(objectMapperUtils.map(entityDTO, Model.class)), ModelDTO.class);
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
