package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.senla.training.dao.api.IModelDAO;
import com.senla.training.dto.ModelDTO;
import com.senla.training.models.Model;
import com.senla.training.models.enums.Direction;
import com.senla.training.objectmapper.ObjectMapperUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ModelServiceTest {

  @InjectMocks private ModelService modelService;
  @Mock private IModelDAO modelDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  private final Model model;
  private final ModelDTO modelDTO;

  private final List<Model> models;
  private final List<ModelDTO> modelDTOList;

  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  private final Map<String, String> fieldContainMap;

  public ModelServiceTest() {
    MockitoAnnotations.initMocks(this);

    model = new Model();
    modelDTO = new ModelDTO();

    models = new ArrayList<>();
    modelDTOList = new ArrayList<>();

    models.add(model);
    models.add(new Model());

    modelDTOList.add(modelDTO);
    modelDTOList.add(new ModelDTO());

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
    fieldContainMap = new HashMap<>();
  }

  @Test
  void findByIdModelWithBrandDTO() {
    given(modelDAO.findByIdModelWithBrand(1)).willReturn(model);
    given(objectMapperUtils.map(model, ModelDTO.class)).willReturn(modelDTO);
    assertEquals(modelDTO, modelService.findByIdModelWithBrandDTO(1));

    given(modelDAO.findByIdModelWithBrand(1)).willReturn(null);
    assertNull(modelService.findByIdModelWithBrandDTO(1));

    given(modelDAO.findByIdModelWithBrand(1)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> modelService.findByIdModelWithBrandDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionModelWithBrandDTO() {
    given(modelDAO.findAllAndSortWithDirectionModelWithBrand(fieldDirectionMap)).willReturn(models);
    given(objectMapperUtils.mapAll(models, ModelDTO.class))
        .willReturn(modelDTOList);
    assertEquals(
        modelDTOList,
        modelService.findAllAndSortWithDirectionModelWithBrandDTO(fieldDirectionStringMap));

    given(modelDAO.findAllAndSortWithDirectionModelWithBrand(fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(models, ModelDTO.class)).willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        modelService.findAllAndSortWithDirectionModelWithBrandDTO(fieldDirectionStringMap));

    given(modelDAO.findAllAndSortWithDirectionModelWithBrand(fieldDirectionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> modelService.findAllAndSortWithDirectionModelWithBrandDTO(fieldDirectionStringMap));
  }

  @Test
  void findOneByCriteriaModelWithBrandDTO() {
    given(modelDAO.findOneByCriteriaModelWithBrand(fieldCriterionMap)).willReturn(model);
    given(objectMapperUtils.map(model, ModelDTO.class)).willReturn(modelDTO);
    assertEquals(
        modelDTO, modelService.findOneByCriteriaModelWithBrandDTO(fieldCriterionMap));

    given(modelDAO.findOneByCriteriaModelWithBrand(fieldCriterionMap)).willReturn(null);
    given(objectMapperUtils.map(model, ModelDTO.class)).willReturn(null);
    assertNull(modelService.findOneByCriteriaModelWithBrandDTO(fieldCriterionMap));

    given(modelDAO.findOneByCriteriaModelWithBrand(fieldCriterionMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> modelService.findOneByCriteriaModelWithBrandDTO(fieldCriterionMap));
  }

  @Test
  void findAllByCriteriaModelWithBrandDTO() {
    given(modelDAO.findAllByCriteriaModelWithBrand(fieldCriterionMap)).willReturn(models);
    given(objectMapperUtils.mapAll(models, ModelDTO.class))
        .willReturn(modelDTOList);
    assertEquals(
        modelDTOList, modelService.findAllByCriteriaModelWithBrandDTO(fieldCriterionMap));

    given(modelDAO.findAllByCriteriaModelWithBrand(fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(models, ModelDTO.class)).willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(), modelService.findAllByCriteriaModelWithBrandDTO(fieldCriterionMap));

    given(modelDAO.findAllByCriteriaModelWithBrand(fieldCriterionMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> modelService.findAllByCriteriaModelWithBrandDTO(fieldCriterionMap));
  }

  @Test
  void findByNotNullModelWithBrandDTO() {
    given(modelDAO.findByNotNullModelWithBrand(fields)).willReturn(models);
    given(objectMapperUtils.mapAll(models, ModelDTO.class))
        .willReturn(modelDTOList);
    assertEquals(modelDTOList, modelService.findByNotNullModelWithBrandDTO(fields));

    given(modelDAO.findByNotNullModelWithBrand(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(models, ModelDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), modelService.findByNotNullModelWithBrandDTO(fields));

    given(modelDAO.findByNotNullModelWithBrand(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> modelService.findByNotNullModelWithBrandDTO(fields));
  }

  @Test
  void findByNullModelWithBrandDTO() {
    given(modelDAO.findByNullModelWithBrand(fields)).willReturn(models);
    given(objectMapperUtils.mapAll(models, ModelDTO.class))
        .willReturn(modelDTOList);
    assertEquals(modelDTOList, modelService.findByNullModelWithBrandDTO(fields));

    given(modelDAO.findByNullModelWithBrand(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(models, ModelDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), modelService.findByNullModelWithBrandDTO(fields));

    given(modelDAO.findByNullModelWithBrand(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> modelService.findByNullModelWithBrandDTO(fields));
  }

  @Test
  void findContainModelWithBrandDTO() {
    given(modelDAO.findContainModelWithBrand(fieldContainMap)).willReturn(models);
    given(objectMapperUtils.mapAll(models, ModelDTO.class))
        .willReturn(modelDTOList);
    assertEquals(modelDTOList, modelService.findContainModelWithBrandDTO(fieldContainMap));

    given(modelDAO.findContainModelWithBrand(fieldContainMap)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(models, ModelDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), modelService.findContainModelWithBrandDTO(fieldContainMap));

    given(modelDAO.findContainModelWithBrand(fieldContainMap)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> modelService.findContainModelWithBrandDTO(fieldContainMap));
  }

  @Test
  void findAndSortModelWithBrandDTO() {
    given(modelDAO.findAndSortModelWithBrand(fieldDirectionMap, fieldCriterionMap))
        .willReturn(models);
    given(objectMapperUtils.mapAll(models, ModelDTO.class))
        .willReturn(modelDTOList);
    assertEquals(
        modelDTOList,
        modelService.findAndSortModelWithBrandDTO(fieldDirectionStringMap, fieldCriterionMap));

    given(modelDAO.findAndSortModelWithBrand(fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(models, ModelDTO.class)).willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        modelService.findAndSortModelWithBrandDTO(fieldDirectionStringMap, fieldCriterionMap));

    given(modelDAO.findAndSortModelWithBrand(fieldDirectionMap, fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            modelService.findAndSortModelWithBrandDTO(fieldDirectionStringMap, fieldCriterionMap));
  }

  @Test
  void create() {
    given(modelDAO.create(model)).willReturn(model);
    given(objectMapperUtils.map(modelDTO, Model.class)).willReturn(model);
    assertEquals(modelDTO, modelService.create(modelDTO));

    given(modelDAO.create(model)).willReturn(null);
    assertNull(modelService.create(modelDTO));

    given(modelDAO.create(model)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> modelService.create(modelDTO));
  }

  @Test
  void update() {
    given(modelDAO.update(model)).willReturn(model);
    given(objectMapperUtils.map(modelDTO, Model.class)).willReturn(model);
    assertEquals(modelDTO, modelService.update(modelDTO));

    given(modelDAO.update(model)).willReturn(null);
    assertNull(modelService.update(modelDTO));

    given(modelDAO.update(model)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> modelService.update(modelDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(modelDTO, Model.class)).willReturn(model);
    modelService.delete(modelDTO);
    verify(modelDAO, atLeastOnce()).delete(model);

    given(modelDAO.update(model)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> modelService.update(modelDTO));
  }

  @Test
  void deleteById() {
    int id = 1;
    modelService.deleteById(id);
    verify(modelDAO, atLeastOnce()).deleteById(id);
  }
}
