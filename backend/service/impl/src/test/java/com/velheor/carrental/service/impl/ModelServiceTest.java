package com.velheor.carrental.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.velheor.carrental.dao.api.IModelDAO;
import com.velheor.carrental.dto.ModelDTO;
import com.velheor.carrental.models.Model;
import com.velheor.carrental.models.enums.Direction;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ModelServiceTest {

  private final Model model;
  private final ModelDTO modelDTO;
  private final List<Model> models;
  private final List<ModelDTO> modelDTOList;
  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  @InjectMocks private ModelService modelService;
  @Mock private IModelDAO modelDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  public ModelServiceTest() {
    MockitoAnnotations.initMocks(this);

    models = new ArrayList<>();
    this.model = Mockito.spy(Model.class);
    Model model = Mockito.spy(Model.class);

    models.add(this.model);
    models.add(model);

    modelDTOList = new ArrayList<>();
    this.modelDTO = Mockito.spy(ModelDTO.class);
    ModelDTO modelDTO = Mockito.spy(ModelDTO.class);

    modelDTOList.add(this.modelDTO);
    modelDTOList.add(modelDTO);

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
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
    given(objectMapperUtils.mapAll(models, ModelDTO.class)).willReturn(modelDTOList);
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
    assertEquals(modelDTO, modelService.findOneByCriteriaModelWithBrandDTO(fieldCriterionMap));

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
    given(objectMapperUtils.mapAll(models, ModelDTO.class)).willReturn(modelDTOList);
    assertEquals(modelDTOList, modelService.findAllByCriteriaModelWithBrandDTO(fieldCriterionMap));

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
    given(objectMapperUtils.mapAll(models, ModelDTO.class)).willReturn(modelDTOList);
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
    given(objectMapperUtils.mapAll(models, ModelDTO.class)).willReturn(modelDTOList);
    assertEquals(modelDTOList, modelService.findByNullModelWithBrandDTO(fields));

    given(modelDAO.findByNullModelWithBrand(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(models, ModelDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), modelService.findByNullModelWithBrandDTO(fields));

    given(modelDAO.findByNullModelWithBrand(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> modelService.findByNullModelWithBrandDTO(fields));
  }

  @Test
  void findAndSortModelWithBrandDTO() {
    given(modelDAO.findAndSortModelWithBrand(fieldDirectionMap, fieldCriterionMap))
        .willReturn(models);
    given(objectMapperUtils.mapAll(models, ModelDTO.class)).willReturn(modelDTOList);
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
    given(objectMapperUtils.map(model, ModelDTO.class)).willReturn(modelDTO);
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
    given(objectMapperUtils.map(model, ModelDTO.class)).willReturn(modelDTO);
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
