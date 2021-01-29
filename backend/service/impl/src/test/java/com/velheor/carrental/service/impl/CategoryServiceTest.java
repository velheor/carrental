package com.velheor.carrental.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.velheor.carrental.dao.api.ICategoryDAO;
import com.velheor.carrental.dto.CategoryDTO;
import com.velheor.carrental.models.Category;
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

class CategoryServiceTest {

  private final Category category;
  private final CategoryDTO categoryDTO;
  private final List<Category> categories;
  private final List<CategoryDTO> categoryDTOList;
  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  @InjectMocks private CategoryService carService;
  @Mock private ICategoryDAO carDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  public CategoryServiceTest() {
    MockitoAnnotations.initMocks(this);

    categories = new ArrayList<>();
    this.category = Mockito.spy(Category.class);
    Category category = Mockito.spy(Category.class);

    categories.add(this.category);
    categories.add(category);

    categoryDTOList = new ArrayList<>();
    this.categoryDTO = Mockito.spy(CategoryDTO.class);
    CategoryDTO categoryDTO = Mockito.spy(CategoryDTO.class);

    categoryDTOList.add(this.categoryDTO);
    categoryDTOList.add(categoryDTO);

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
  }

  @Test
  void findByIdCategoryWithCarsModelBrandDTO() {
    given(carDAO.findByIdCategoryWithCarsModelBrand(1)).willReturn(category);
    given(objectMapperUtils.map(category, CategoryDTO.class)).willReturn(categoryDTO);
    assertEquals(categoryDTO, carService.findByIdCategoryWithCarsModelBrandDTO(1));

    given(carDAO.findByIdCategoryWithCarsModelBrand(1)).willReturn(null);
    assertNull(carService.findByIdCategoryWithCarsModelBrandDTO(1));

    given(carDAO.findByIdCategoryWithCarsModelBrand(1)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> carService.findByIdCategoryWithCarsModelBrandDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionCategoryWithCarsModelBrandDTO() {
    given(carDAO.findAllAndSortWithDirectionCategoryWithCarsModelBrand(fieldDirectionMap))
        .willReturn(categories);
    given(objectMapperUtils.mapAll(categories, CategoryDTO.class)).willReturn(categoryDTOList);
    assertEquals(
        categoryDTOList,
        carService.findAllAndSortWithDirectionCategoryWithCarsModelBrandDTO(
            fieldDirectionStringMap));

    given(carDAO.findAllAndSortWithDirectionCategoryWithCarsModelBrand(fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(categories, CategoryDTO.class)).willReturn(new ArrayList<>());
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
    given(objectMapperUtils.map(category, CategoryDTO.class)).willReturn(categoryDTO);
    assertEquals(
        categoryDTO, carService.findOneByCriteriaCategoryWithCarsModelBrandDTO(fieldCriterionMap));

    given(carDAO.findOneByCriteriaCategoryWithCarsModelBrand(fieldCriterionMap)).willReturn(null);
    given(objectMapperUtils.map(category, CategoryDTO.class)).willReturn(null);
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
    given(objectMapperUtils.mapAll(categories, CategoryDTO.class)).willReturn(categoryDTOList);
    assertEquals(
        categoryDTOList,
        carService.findAllByCriteriaCategoryWithCarsModelBrandDTO(fieldCriterionMap));

    given(carDAO.findAllByCriteriaCategoryWithCarsModelBrand(fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(categories, CategoryDTO.class)).willReturn(new ArrayList<>());
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
    given(objectMapperUtils.mapAll(categories, CategoryDTO.class)).willReturn(categoryDTOList);
    assertEquals(categoryDTOList, carService.findByNotNullCategoryWithCarsModelBrandDTO(fields));

    given(carDAO.findByNotNullCategoryWithCarsModelBrand(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(categories, CategoryDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), carService.findByNotNullCategoryWithCarsModelBrandDTO(fields));

    given(carDAO.findByNotNullCategoryWithCarsModelBrand(fields)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> carService.findByNotNullCategoryWithCarsModelBrandDTO(fields));
  }

  @Test
  void findByNullCategoryWithCarsModelBrandDTO() {
    given(carDAO.findByNullCategoryWithCarsModelBrand(fields)).willReturn(categories);
    given(objectMapperUtils.mapAll(categories, CategoryDTO.class)).willReturn(categoryDTOList);
    assertEquals(categoryDTOList, carService.findByNullCategoryWithCarsModelBrandDTO(fields));

    given(carDAO.findByNullCategoryWithCarsModelBrand(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(categories, CategoryDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), carService.findByNullCategoryWithCarsModelBrandDTO(fields));

    given(carDAO.findByNullCategoryWithCarsModelBrand(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> carService.findByNullCategoryWithCarsModelBrandDTO(fields));
  }

  @Test
  void findAndSortCategoryWithCarsModelBrandDTO() {
    given(carDAO.findAndSortCategoryWithCarsModelBrand(fieldDirectionMap, fieldCriterionMap))
        .willReturn(categories);
    given(objectMapperUtils.mapAll(categories, CategoryDTO.class)).willReturn(categoryDTOList);
    assertEquals(
        categoryDTOList,
        carService.findAndSortCategoryWithCarsModelBrandDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(carDAO.findAndSortCategoryWithCarsModelBrand(fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(categories, CategoryDTO.class)).willReturn(new ArrayList<>());
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
    given(objectMapperUtils.map(categoryDTO, Category.class)).willReturn(category);
    given(objectMapperUtils.map(category, CategoryDTO.class)).willReturn(categoryDTO);
    assertEquals(categoryDTO, carService.create(categoryDTO));

    given(carDAO.create(category)).willReturn(null);
    assertNull(carService.create(categoryDTO));

    given(carDAO.create(category)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> carService.create(categoryDTO));
  }

  @Test
  void update() {
    given(carDAO.update(category)).willReturn(category);
    given(objectMapperUtils.map(categoryDTO, Category.class)).willReturn(category);
    given(objectMapperUtils.map(category, CategoryDTO.class)).willReturn(categoryDTO);
    assertEquals(categoryDTO, carService.update(categoryDTO));

    given(carDAO.update(category)).willReturn(null);
    assertNull(carService.update(categoryDTO));

    given(carDAO.update(category)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> carService.update(categoryDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(categoryDTO, Category.class)).willReturn(category);
    carService.delete(categoryDTO);
    verify(carDAO, atLeastOnce()).delete(category);

    given(carDAO.update(category)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> carService.update(categoryDTO));
  }

  @Test
  void deleteById() {
    int id = 1;
    carService.deleteById(id);
    verify(carDAO, atLeastOnce()).deleteById(id);
  }
}
