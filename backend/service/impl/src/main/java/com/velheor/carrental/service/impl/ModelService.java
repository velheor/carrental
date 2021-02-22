package com.velheor.carrental.service.impl;

import com.velheor.carrental.dao.api.ModelRepository;
import com.velheor.carrental.dto.ModelDTO;
import com.velheor.carrental.models.Model;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.service.api.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService implements IModelService {

  private final ModelRepository modelRepository;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  ModelService(ModelRepository modelRepository, ObjectMapperUtils objectMapperUtils) {
    this.modelRepository = modelRepository;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public ModelDTO findById(Integer id) {
    return modelRepository
        .findById(id)
        .map(car -> objectMapperUtils.map(car, ModelDTO.class))
        .orElse(null);
  }

  @Override
  public ModelDTO create(ModelDTO entityDTO) {
    return objectMapperUtils.map(
        modelRepository.save(objectMapperUtils.map(entityDTO, Model.class)), ModelDTO.class);
  }

  @Override
  public ModelDTO update(ModelDTO entityDTO) {
    if (modelRepository.findById(entityDTO.getId()).isPresent()) {
      objectMapperUtils.map(
          modelRepository.save(objectMapperUtils.map(entityDTO, Model.class)), ModelDTO.class);
    }
    return null;
  }

  @Override
  public void delete(ModelDTO entityDTO) {
    modelRepository.delete(objectMapperUtils.map(entityDTO, Model.class));
  }

  @Override
  public void deleteById(int id) {
    modelRepository.deleteById(id);
  }
}
