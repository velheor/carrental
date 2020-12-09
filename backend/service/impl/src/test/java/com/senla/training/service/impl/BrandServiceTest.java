package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import com.senla.training.dao.api.IBrandDAO;
import com.senla.training.dto.brand.BrandWithModelsDTO;
import com.senla.training.models.Brand;
import com.senla.training.models.enums.Direction;
import com.senla.training.objectmapper.ObjectMapperUtils;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BrandServiceTest {
  @InjectMocks
  private BrandService brandService;
  @Mock
  private IBrandDAO brandDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  private final Brand brand;
  private final BrandWithModelsDTO brandWithModelsDTO;

  private final List<Brand> brands;
  private final List<BrandWithModelsDTO> brandWithModelsDTOList;

  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  private final Map<String, Number> fieldNumberMap;
  private final Map<String, String> fieldContainMap;

  public BrandServiceTest() {
    MockitoAnnotations.initMocks(this);

    brand = new Brand();
    brandWithModelsDTO = new BrandWithModelsDTO();

    brands = new ArrayList<>();
    brandWithModelsDTOList = new ArrayList<>();

    brands.add(brand);
    brands.add(new Brand());

    brandWithModelsDTOList.add(brandWithModelsDTO);
    brandWithModelsDTOList.add(new BrandWithModelsDTO());

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
    fieldNumberMap = new HashMap<>();
    fieldContainMap = new HashMap<>();
  }

  @Test
  void findByIdBrandWithModelsDTO() {
    given(brandDAO.findByIdBrandWithModels(1)).willReturn(brand);
    given(objectMapperUtils.map(brand, BrandWithModelsDTO.class))
            .willReturn(brandWithModelsDTO);
    assertEquals(
            brandWithModelsDTO,
            brandService.findByIdBrandWithModelsDTO(1));

    given(brandDAO.findByIdBrandWithModels(1)).willReturn(null);
    assertNull(brandService.findByIdBrandWithModelsDTO(1));

    given(brandDAO.findByIdBrandWithModels(1)).willThrow(Exception.class);
    assertThrows(
            Exception.class, () -> brandService.findByIdBrandWithModelsDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionBrandWithModelsDTO() {
    given(
            brandDAO.findAllAndSortWithDirectionBrandWithModels(
                    fieldDirectionMap))
            .willReturn(brands);
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(brandWithModelsDTOList);
    assertEquals(
            brandWithModelsDTOList,
            brandService.findAllAndSortWithDirectionBrandWithModelsDTO(
                    fieldDirectionStringMap));

    given(
            brandDAO.findAllAndSortWithDirectionBrandWithModels(
                    fieldDirectionMap))
            .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(new ArrayList<>());
    deepEquals(
            new ArrayList<>(),
            brandService.findAllAndSortWithDirectionBrandWithModelsDTO(
                    fieldDirectionStringMap));

    given(
            brandDAO.findAllAndSortWithDirectionBrandWithModels(
                    fieldDirectionMap))
            .willThrow(Exception.class);
    assertThrows(
            Exception.class,
            () ->
                    brandService.findAllAndSortWithDirectionBrandWithModelsDTO(
                            fieldDirectionStringMap));
  }

  @Test
  void findOneByCriteriaBrandWithModelsDTO() {
    given(brandDAO.findOneByCriteriaBrandWithModels(fieldCriterionMap))
            .willReturn(brand);
    given(objectMapperUtils.map(brand, BrandWithModelsDTO.class))
            .willReturn(brandWithModelsDTO);
    assertEquals(
            brandWithModelsDTO,
            brandService.findOneByCriteriaBrandWithModelsDTO(fieldCriterionMap));

    given(brandDAO.findOneByCriteriaBrandWithModels(fieldCriterionMap))
            .willReturn(null);
    given(objectMapperUtils.map(brand, BrandWithModelsDTO.class))
            .willReturn(null);
    assertNull(
            brandService.findOneByCriteriaBrandWithModelsDTO(fieldCriterionMap));

    given(brandDAO.findOneByCriteriaBrandWithModels(fieldCriterionMap))
            .willThrow(Exception.class);
    assertThrows(
            Exception.class,
            () ->
                    brandService.findOneByCriteriaBrandWithModelsDTO(
                            fieldCriterionMap));
  }

  @Test
  void findAllByCriteriaBrandWithModelsDTO() {
    given(brandDAO.findAllByCriteriaBrandWithModels(fieldCriterionMap))
            .willReturn(brands);
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(brandWithModelsDTOList);
    assertEquals(
            brandWithModelsDTOList,
            brandService.findAllByCriteriaBrandWithModelsDTO(fieldCriterionMap));

    given(brandDAO.findAllByCriteriaBrandWithModels(fieldCriterionMap))
            .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(new ArrayList<>());
    deepEquals(
            new ArrayList<>(),
            brandService.findAllByCriteriaBrandWithModelsDTO(fieldCriterionMap));

    given(brandDAO.findAllByCriteriaBrandWithModels(fieldCriterionMap))
            .willThrow(Exception.class);
    assertThrows(
            Exception.class,
            () ->
                    brandService.findAllByCriteriaBrandWithModelsDTO(
                            fieldCriterionMap));
  }

  @Test
  void findByNotNullBrandWithModelsDTO() {
    given(brandDAO.findByNotNullBrandWithModels(fields))
            .willReturn(brands);
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(brandWithModelsDTOList);
    assertEquals(
            brandWithModelsDTOList,
            brandService.findByNotNullBrandWithModelsDTO(fields));

    given(brandDAO.findByNotNullBrandWithModels(fields))
            .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(new ArrayList<>());
    deepEquals(
            new ArrayList<>(),
            brandService.findByNotNullBrandWithModelsDTO(fields));

    given(brandDAO.findByNotNullBrandWithModels(fields))
            .willThrow(Exception.class);
    assertThrows(
            Exception.class,
            () -> brandService.findByNotNullBrandWithModelsDTO(fields));
  }

  @Test
  void findByNullBrandWithModelsDTO() {
    given(brandDAO.findByNullBrandWithModels(fields))
            .willReturn(brands);
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(brandWithModelsDTOList);
    assertEquals(
            brandWithModelsDTOList,
            brandService.findByNullBrandWithModelsDTO(fields));

    given(brandDAO.findByNullBrandWithModels(fields))
            .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(new ArrayList<>());
    deepEquals(
            new ArrayList<>(), brandService.findByNullBrandWithModelsDTO(fields));

    given(brandDAO.findByNullBrandWithModels(fields))
            .willThrow(Exception.class);
    assertThrows(
            Exception.class,
            () -> brandService.findByNullBrandWithModelsDTO(fields));
  }

  @Test
  void findLessThanBrandWithModelsDTO() {
    given(brandDAO.findLessThanBrandWithModels(fieldNumberMap))
            .willReturn(brands);
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(brandWithModelsDTOList);
    assertEquals(
            brandWithModelsDTOList,
            brandService.findLessThanBrandWithModelsDTO(fieldNumberMap));

    given(brandDAO.findLessThanBrandWithModels(fieldNumberMap))
            .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(new ArrayList<>());
    deepEquals(
            new ArrayList<>(),
            brandService.findLessThanBrandWithModelsDTO(fieldNumberMap));

    given(brandDAO.findLessThanBrandWithModels(fieldNumberMap))
            .willThrow(Exception.class);
    assertThrows(
            Exception.class,
            () -> brandService.findLessThanBrandWithModelsDTO(fieldNumberMap));
  }

  @Test
  void findGreaterThanBrandWithModelsDTO() {
    given(brandDAO.findGreaterThanBrandWithModels(fieldNumberMap))
            .willReturn(brands);
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(brandWithModelsDTOList);
    assertEquals(
            brandWithModelsDTOList,
            brandService.findGreaterThanBrandWithModelsDTO(fieldNumberMap));

    given(brandDAO.findGreaterThanBrandWithModels(fieldNumberMap))
            .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(new ArrayList<>());
    deepEquals(
            new ArrayList<>(),
            brandService.findGreaterThanBrandWithModelsDTO(fieldNumberMap));

    given(brandDAO.findGreaterThanBrandWithModels(fieldNumberMap))
            .willThrow(Exception.class);
    assertThrows(
            Exception.class,
            () -> brandService.findGreaterThanBrandWithModelsDTO(fieldNumberMap));
  }

  @Test
  void findContainBrandWithModelsDTO() {
    given(brandDAO.findContainBrandWithModels(fieldContainMap))
            .willReturn(brands);
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(brandWithModelsDTOList);
    assertEquals(
            brandWithModelsDTOList,
            brandService.findContainBrandWithModelsDTO(fieldContainMap));

    given(brandDAO.findContainBrandWithModels(fieldContainMap))
            .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(new ArrayList<>());
    deepEquals(
            new ArrayList<>(),
            brandService.findContainBrandWithModelsDTO(fieldContainMap));

    given(brandDAO.findContainBrandWithModels(fieldContainMap))
            .willThrow(Exception.class);
    assertThrows(
            Exception.class,
            () -> brandService.findContainBrandWithModelsDTO(fieldContainMap));
  }

  @Test
  void findAndSortBrandWithModelsDTO() {
    given(
            brandDAO.findAndSortBrandWithModels(
                    fieldDirectionMap, fieldCriterionMap))
            .willReturn(brands);
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(brandWithModelsDTOList);
    assertEquals(
            brandWithModelsDTOList,
            brandService.findAndSortBrandWithModelsDTO(
                    fieldDirectionStringMap, fieldCriterionMap));

    given(
            brandDAO.findAndSortBrandWithModels(
                    fieldDirectionMap, fieldCriterionMap))
            .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(brands, BrandWithModelsDTO.class))
            .willReturn(new ArrayList<>());
    deepEquals(
            new ArrayList<>(),
            brandService.findAndSortBrandWithModelsDTO(
                    fieldDirectionStringMap, fieldCriterionMap));

    given(
            brandDAO.findAndSortBrandWithModels(
                    fieldDirectionMap, fieldCriterionMap))
            .willThrow(Exception.class);
    assertThrows(
            Exception.class,
            () ->
                    brandService.findAndSortBrandWithModelsDTO(
                            fieldDirectionStringMap, fieldCriterionMap));
  }

  @Test
  void create() {}

  @Test
  void update() {}

  @Test
  void delete() {}

  @Test
  void deleteById() {}
}
