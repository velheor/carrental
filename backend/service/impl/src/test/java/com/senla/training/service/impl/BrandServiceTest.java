package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.senla.training.dao.api.IBrandDAO;
import com.senla.training.dto.BrandDTO;
import com.senla.training.models.Brand;
import com.senla.training.models.enums.Direction;
import com.senla.training.objectmapper.ObjectMapperUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class BrandServiceTest {

  private final Brand brand;
  private final BrandDTO brandDTO;
  private final List<Brand> brands;
  private final List<BrandDTO> brandDTOList;
  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  @InjectMocks private BrandService brandService;
  @Mock private IBrandDAO brandDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  public BrandServiceTest() {
    MockitoAnnotations.initMocks(this);

    brands = new ArrayList<>();
    this.brand = Mockito.spy(Brand.class);
    Brand brand = Mockito.spy(Brand.class);

    brands.add(this.brand);
    brands.add(brand);

    brandDTOList = new ArrayList<>();
    this.brandDTO = Mockito.spy(BrandDTO.class);
    BrandDTO brandDTO = Mockito.spy(BrandDTO.class);

    brandDTOList.add(this.brandDTO);
    brandDTOList.add(brandDTO);

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
  }

  @Test
  void findByIdBrandWithModelsDTO() {
    given(brandDAO.findByIdBrandWithModels(1)).willReturn(brand);
    given(objectMapperUtils.map(brand, BrandDTO.class)).willReturn(brandDTO);
    assertEquals(brandDTO, brandService.findByIdBrandWithModelsDTO(1));

    given(brandDAO.findByIdBrandWithModels(1)).willReturn(null);
    assertNull(brandService.findByIdBrandWithModelsDTO(1));

    given(brandDAO.findByIdBrandWithModels(1)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> brandService.findByIdBrandWithModelsDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionBrandWithModelsDTO() {
    given(brandDAO.findAllAndSortWithDirectionBrandWithModels(fieldDirectionMap))
        .willReturn(brands);
    given(objectMapperUtils.mapAll(brands, BrandDTO.class)).willReturn(brandDTOList);
    assertEquals(
        brandDTOList,
        brandService.findAllAndSortWithDirectionBrandWithModelsDTO(fieldDirectionStringMap));

    given(brandDAO.findAllAndSortWithDirectionBrandWithModels(fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(brands, BrandDTO.class)).willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        brandService.findAllAndSortWithDirectionBrandWithModelsDTO(fieldDirectionStringMap));

    given(brandDAO.findAllAndSortWithDirectionBrandWithModels(fieldDirectionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> brandService.findAllAndSortWithDirectionBrandWithModelsDTO(fieldDirectionStringMap));
  }

  @Test
  void findOneByCriteriaBrandWithModelsDTO() {
    given(brandDAO.findOneByCriteriaBrandWithModels(fieldCriterionMap)).willReturn(brand);
    given(objectMapperUtils.map(brand, BrandDTO.class)).willReturn(brandDTO);
    assertEquals(brandDTO, brandService.findOneByCriteriaBrandWithModelsDTO(fieldCriterionMap));

    given(brandDAO.findOneByCriteriaBrandWithModels(fieldCriterionMap)).willReturn(null);
    given(objectMapperUtils.map(brand, BrandDTO.class)).willReturn(null);
    assertNull(brandService.findOneByCriteriaBrandWithModelsDTO(fieldCriterionMap));

    given(brandDAO.findOneByCriteriaBrandWithModels(fieldCriterionMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> brandService.findOneByCriteriaBrandWithModelsDTO(fieldCriterionMap));
  }

  @Test
  void findAllByCriteriaBrandWithModelsDTO() {
    given(brandDAO.findAllByCriteriaBrandWithModels(fieldCriterionMap)).willReturn(brands);
    given(objectMapperUtils.mapAll(brands, BrandDTO.class)).willReturn(brandDTOList);
    assertEquals(brandDTOList, brandService.findAllByCriteriaBrandWithModelsDTO(fieldCriterionMap));

    given(brandDAO.findAllByCriteriaBrandWithModels(fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(brands, BrandDTO.class)).willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(), brandService.findAllByCriteriaBrandWithModelsDTO(fieldCriterionMap));

    given(brandDAO.findAllByCriteriaBrandWithModels(fieldCriterionMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> brandService.findAllByCriteriaBrandWithModelsDTO(fieldCriterionMap));
  }

  @Test
  void findByNotNullBrandWithModelsDTO() {
    given(brandDAO.findByNotNullBrandWithModels(fields)).willReturn(brands);
    given(objectMapperUtils.mapAll(brands, BrandDTO.class)).willReturn(brandDTOList);
    assertEquals(brandDTOList, brandService.findByNotNullBrandWithModelsDTO(fields));

    given(brandDAO.findByNotNullBrandWithModels(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(brands, BrandDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), brandService.findByNotNullBrandWithModelsDTO(fields));

    given(brandDAO.findByNotNullBrandWithModels(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> brandService.findByNotNullBrandWithModelsDTO(fields));
  }

  @Test
  void findByNullBrandWithModelsDTO() {
    given(brandDAO.findByNullBrandWithModels(fields)).willReturn(brands);
    given(objectMapperUtils.mapAll(brands, BrandDTO.class)).willReturn(brandDTOList);
    assertEquals(brandDTOList, brandService.findByNullBrandWithModelsDTO(fields));

    given(brandDAO.findByNullBrandWithModels(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(brands, BrandDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), brandService.findByNullBrandWithModelsDTO(fields));

    given(brandDAO.findByNullBrandWithModels(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> brandService.findByNullBrandWithModelsDTO(fields));
  }

  @Test
  void findAndSortBrandWithModelsDTO() {
    given(brandDAO.findAndSortBrandWithModels(fieldDirectionMap, fieldCriterionMap))
        .willReturn(brands);
    given(objectMapperUtils.mapAll(brands, BrandDTO.class)).willReturn(brandDTOList);
    assertEquals(
        brandDTOList,
        brandService.findAndSortBrandWithModelsDTO(fieldDirectionStringMap, fieldCriterionMap));

    given(brandDAO.findAndSortBrandWithModels(fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(brands, BrandDTO.class)).willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        brandService.findAndSortBrandWithModelsDTO(fieldDirectionStringMap, fieldCriterionMap));

    given(brandDAO.findAndSortBrandWithModels(fieldDirectionMap, fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            brandService.findAndSortBrandWithModelsDTO(fieldDirectionStringMap, fieldCriterionMap));
  }

  @Test
  void create() {
    given(brandDAO.create(brand)).willReturn(brand);
    given(objectMapperUtils.map(brandDTO, Brand.class)).willReturn(brand);
    given(objectMapperUtils.map(brand, BrandDTO.class)).willReturn(brandDTO);
    assertEquals(brandDTO, brandService.create(brandDTO));

    given(brandDAO.create(brand)).willReturn(null);
    assertNull(brandService.create(brandDTO));

    given(brandDAO.create(brand)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> brandService.create(brandDTO));
  }

  @Test
  void update() {
    given(brandDAO.update(brand)).willReturn(brand);
    given(objectMapperUtils.map(brandDTO, Brand.class)).willReturn(brand);
    given(objectMapperUtils.map(brand, BrandDTO.class)).willReturn(brandDTO);
    assertEquals(brandDTO, brandService.update(brandDTO));

    given(brandDAO.update(brand)).willReturn(null);
    assertNull(brandService.update(brandDTO));

    given(brandDAO.update(brand)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> brandService.update(brandDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(brandDTO, Brand.class)).willReturn(brand);
    brandService.delete(brandDTO);
    verify(brandDAO, atLeastOnce()).delete(brand);

    given(brandDAO.update(brand)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> brandService.update(brandDTO));
  }

  @Test
  void deleteById() {
    int id = 1;
    brandService.deleteById(id);
    verify(brandDAO, atLeastOnce()).deleteById(id);
  }
}
