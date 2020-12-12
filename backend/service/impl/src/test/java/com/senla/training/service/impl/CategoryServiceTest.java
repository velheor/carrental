package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.senla.training.dao.api.ICategoryDAO;
import com.senla.training.dto.category.CategoryWithCarsModelBrandDTO;
import com.senla.training.models.Category;
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

class CategoryServiceTest {
  @InjectMocks private CategoryService carService;
  @Mock private ICategoryDAO carDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  private final Category category;
  private final CategoryWithCarsModelBrandDTO categoryWithCarsModelBrandDTO;

  private final List<Category> categories;
  private final List<CategoryWithCarsModelBrandDTO> categoryWithCarsModelBrandDTOList;

  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  private final Map<String, Number> fieldNumberMap;
  private final Map<String, String> fieldContainMap;

  public CategoryServiceTest() {
    MockitoAnnotations.initMocks(this);

    category = new Category();
    categoryWithCarsModelBrandDTO = new CategoryWithCarsModelBrandDTO();

    categories = new ArrayList<>();
    categoryWithCarsModelBrandDTOList = new ArrayList<>();

    categories.add(category);
    categories.add(new Category());

    categoryWithCarsModelBrandDTOList.add(categoryWithCarsModelBrandDTO);
    categoryWithCarsModelBrandDTOList.add(new CategoryWithCarsModelBrandDTO());

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
    fieldNumberMap = new HashMap<>();
    fieldContainMap = new HashMap<>();
  }

  @Test
  void findByIdCategoryWithCarsModelBrandDTO() {
    given(carDAO.findByIdCategoryWithCarsModelBrand(1)).willReturn(category);
    given(objectMapperUtils.map(category, CategoryWithCarsModelBrandDTO.class))
        .willReturn(categoryWithCarsModelBrandDTO);
    assertEquals(
        categoryWithCarsModelBrandDTO, carService.findByIdCategoryWithCarsModelBrandDTO(1));

    given(carDAO.findByIdCategoryWithCarsModelBrand(1)).willReturn(null);
    assertNull(carService.findByIdCategoryWithCarsModelBrandDTO(1));

    given(carDAO.findByIdCategoryWithCarsModelBrand(1)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> carService.findByIdCategoryWithCarsModelBrandDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionCategoryWithCarsModelBrandDTO() {
    given(carDAO.findAllAndSortWithDirectionCategoryWithCarsModelBrand(fieldDirectionMap))
        .willReturn(categories);
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(categoryWithCarsModelBrandDTOList);
    assertEquals(
        categoryWithCarsModelBrandDTOList,
        carService.findAllAndSortWithDirectionCategoryWithCarsModelBrandDTO(
            fieldDirectionStringMap));

    given(carDAO.findAllAndSortWithDirectionCategoryWithCarsModelBrand(fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        carService.findAllAndSortWithDirectionCategoryWithCarsModelBrandDTO(
            fieldDirectionStringMap));

    given(carDAO.findAllAndSortWithDirectionCategoryWithCarsModelBrand(fieldDirectionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            carService.findAllAndSortWithDirectionCategoryWithCarsModelBrandDTO(
                fieldDirectionStringMap));
  }

  @Test
  void findOneByCriteriaCategoryWithCarsModelBrandDTO() {
    given(carDAO.findOneByCriteriaCategoryWithCarsModelBrand(fieldCriterionMap))
        .willReturn(category);
    given(objectMapperUtils.map(category, CategoryWithCarsModelBrandDTO.class))
        .willReturn(categoryWithCarsModelBrandDTO);
    assertEquals(
        categoryWithCarsModelBrandDTO,
        carService.findOneByCriteriaCategoryWithCarsModelBrandDTO(fieldCriterionMap));

    given(carDAO.findOneByCriteriaCategoryWithCarsModelBrand(fieldCriterionMap)).willReturn(null);
    given(objectMapperUtils.map(category, CategoryWithCarsModelBrandDTO.class)).willReturn(null);
    assertNull(carService.findOneByCriteriaCategoryWithCarsModelBrandDTO(fieldCriterionMap));

    given(carDAO.findOneByCriteriaCategoryWithCarsModelBrand(fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> carService.findOneByCriteriaCategoryWithCarsModelBrandDTO(fieldCriterionMap));
  }

  @Test
  void findAllByCriteriaCategoryWithCarsModelBrandDTO() {
    given(carDAO.findAllByCriteriaCategoryWithCarsModelBrand(fieldCriterionMap))
        .willReturn(categories);
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(categoryWithCarsModelBrandDTOList);
    assertEquals(
        categoryWithCarsModelBrandDTOList,
        carService.findAllByCriteriaCategoryWithCarsModelBrandDTO(fieldCriterionMap));

    given(carDAO.findAllByCriteriaCategoryWithCarsModelBrand(fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        carService.findAllByCriteriaCategoryWithCarsModelBrandDTO(fieldCriterionMap));

    given(carDAO.findAllByCriteriaCategoryWithCarsModelBrand(fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> carService.findAllByCriteriaCategoryWithCarsModelBrandDTO(fieldCriterionMap));
  }

  @Test
  void findByNotNullCategoryWithCarsModelBrandDTO() {
    given(carDAO.findByNotNullCategoryWithCarsModelBrand(fields)).willReturn(categories);
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(categoryWithCarsModelBrandDTOList);
    assertEquals(
        categoryWithCarsModelBrandDTOList,
        carService.findByNotNullCategoryWithCarsModelBrandDTO(fields));

    given(carDAO.findByNotNullCategoryWithCarsModelBrand(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), carService.findByNotNullCategoryWithCarsModelBrandDTO(fields));

    given(carDAO.findByNotNullCategoryWithCarsModelBrand(fields)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> carService.findByNotNullCategoryWithCarsModelBrandDTO(fields));
  }

  @Test
  void findByNullCategoryWithCarsModelBrandDTO() {
    given(carDAO.findByNullCategoryWithCarsModelBrand(fields)).willReturn(categories);
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(categoryWithCarsModelBrandDTOList);
    assertEquals(
        categoryWithCarsModelBrandDTOList,
        carService.findByNullCategoryWithCarsModelBrandDTO(fields));

    given(carDAO.findByNullCategoryWithCarsModelBrand(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), carService.findByNullCategoryWithCarsModelBrandDTO(fields));

    given(carDAO.findByNullCategoryWithCarsModelBrand(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> carService.findByNullCategoryWithCarsModelBrandDTO(fields));
  }

  @Test
  void findLessThanCategoryWithCarsModelBrandDTO() {
    given(carDAO.findLessThanCategoryWithCarsModelBrand(fieldNumberMap)).willReturn(categories);
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(categoryWithCarsModelBrandDTOList);
    assertEquals(
        categoryWithCarsModelBrandDTOList,
        carService.findLessThanCategoryWithCarsModelBrandDTO(fieldNumberMap));

    given(carDAO.findLessThanCategoryWithCarsModelBrand(fieldNumberMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(), carService.findLessThanCategoryWithCarsModelBrandDTO(fieldNumberMap));

    given(carDAO.findLessThanCategoryWithCarsModelBrand(fieldNumberMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> carService.findLessThanCategoryWithCarsModelBrandDTO(fieldNumberMap));
  }

  @Test
  void findGreaterThanCategoryWithCarsModelBrandDTO() {
    given(carDAO.findGreaterThanCategoryWithCarsModelBrand(fieldNumberMap)).willReturn(categories);
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(categoryWithCarsModelBrandDTOList);
    assertEquals(
        categoryWithCarsModelBrandDTOList,
        carService.findGreaterThanCategoryWithCarsModelBrandDTO(fieldNumberMap));

    given(carDAO.findGreaterThanCategoryWithCarsModelBrand(fieldNumberMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(), carService.findGreaterThanCategoryWithCarsModelBrandDTO(fieldNumberMap));

    given(carDAO.findGreaterThanCategoryWithCarsModelBrand(fieldNumberMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> carService.findGreaterThanCategoryWithCarsModelBrandDTO(fieldNumberMap));
  }

  @Test
  void findContainCategoryWithCarsModelBrandDTO() {
    given(carDAO.findContainCategoryWithCarsModelBrand(fieldContainMap)).willReturn(categories);
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(categoryWithCarsModelBrandDTOList);
    assertEquals(
        categoryWithCarsModelBrandDTOList,
        carService.findContainCategoryWithCarsModelBrandDTO(fieldContainMap));

    given(carDAO.findContainCategoryWithCarsModelBrand(fieldContainMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(), carService.findContainCategoryWithCarsModelBrandDTO(fieldContainMap));

    given(carDAO.findContainCategoryWithCarsModelBrand(fieldContainMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> carService.findContainCategoryWithCarsModelBrandDTO(fieldContainMap));
  }

  @Test
  void findAndSortCategoryWithCarsModelBrandDTO() {
    given(carDAO.findAndSortCategoryWithCarsModelBrand(fieldDirectionMap, fieldCriterionMap))
        .willReturn(categories);
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(categoryWithCarsModelBrandDTOList);
    assertEquals(
        categoryWithCarsModelBrandDTOList,
        carService.findAndSortCategoryWithCarsModelBrandDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(carDAO.findAndSortCategoryWithCarsModelBrand(fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(categories, CategoryWithCarsModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        carService.findAndSortCategoryWithCarsModelBrandDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(carDAO.findAndSortCategoryWithCarsModelBrand(fieldDirectionMap, fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            carService.findAndSortCategoryWithCarsModelBrandDTO(
                fieldDirectionStringMap, fieldCriterionMap));
  }

  @Test
  void create() {
    given(carDAO.create(category)).willReturn(category);
    given(objectMapperUtils.map(categoryWithCarsModelBrandDTO, Category.class))
        .willReturn(category);
    assertEquals(categoryWithCarsModelBrandDTO, carService.create(categoryWithCarsModelBrandDTO));

    given(carDAO.create(category)).willReturn(null);
    assertNull(carService.create(categoryWithCarsModelBrandDTO));

    given(carDAO.create(category)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> carService.create(categoryWithCarsModelBrandDTO));
  }

  @Test
  void update() {
    given(carDAO.update(category)).willReturn(category);
    given(objectMapperUtils.map(categoryWithCarsModelBrandDTO, Category.class))
        .willReturn(category);
    assertEquals(categoryWithCarsModelBrandDTO, carService.update(categoryWithCarsModelBrandDTO));

    given(carDAO.update(category)).willReturn(null);
    assertNull(carService.update(categoryWithCarsModelBrandDTO));

    given(carDAO.update(category)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> carService.update(categoryWithCarsModelBrandDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(categoryWithCarsModelBrandDTO, Category.class))
        .willReturn(category);
    carService.delete(categoryWithCarsModelBrandDTO);
    verify(carDAO, atLeastOnce()).delete(category);

    given(carDAO.update(category)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> carService.update(categoryWithCarsModelBrandDTO));
  }

  @Test
  void deleteById() {
    int id = 1;
    carService.deleteById(id);
    verify(carDAO, atLeastOnce()).deleteById(id);
  }
}
