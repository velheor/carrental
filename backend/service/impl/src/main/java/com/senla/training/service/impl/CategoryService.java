package com.senla.training.service.impl;

import com.senla.training.dao.api.ICategoryDAO;
import com.senla.training.dto.category.CategoryDTO;
import com.senla.training.dto.category.CategoryWithCarsModelBrandDTO;
import com.senla.training.models.Category;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.ICategoryService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
  private final ICategoryDAO categoryDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  CategoryService(ICategoryDAO categoryDAO, ObjectMapperUtils objectMapperUtils) {
    this.categoryDAO = categoryDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public CategoryWithCarsModelBrandDTO findByIdCategoryWithCarsModelBrandDTO(int id) {
    return objectMapperUtils.map(
        categoryDAO.findByIdCategoryWithCarsModelBrand(id), CategoryWithCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCarsModelBrandDTO>
      findAllAndSortWithDirectionCategoryWithCarsModelBrandDTO(
          Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findAllAndSortWithDirectionCategoryWithCarsModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        CategoryWithCarsModelBrandDTO.class);
  }

  @Override
  public CategoryWithCarsModelBrandDTO findOneByCriteriaCategoryWithCarsModelBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        categoryDAO.findOneByCriteriaCategoryWithCarsModelBrand(fieldCriteriaMap),
        CategoryWithCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCarsModelBrandDTO> findAllByCriteriaCategoryWithCarsModelBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findAllByCriteriaCategoryWithCarsModelBrand(fieldCriteriaMap),
        CategoryWithCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCarsModelBrandDTO> findByNotNullCategoryWithCarsModelBrandDTO(
      List<String> fields) {
    return objectMapperUtils.mapAll(
        categoryDAO.findByNotNullCategoryWithCarsModelBrand(fields),
        CategoryWithCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCarsModelBrandDTO> findByNullCategoryWithCarsModelBrandDTO(
      List<String> fields) {
    return objectMapperUtils.mapAll(
        categoryDAO.findByNullCategoryWithCarsModelBrand(fields),
        CategoryWithCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCarsModelBrandDTO> findLessThanCategoryWithCarsModelBrandDTO(
      Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findLessThanCategoryWithCarsModelBrand(fieldNumberMap),
        CategoryWithCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCarsModelBrandDTO> findGreaterThanCategoryWithCarsModelBrandDTO(
      Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findGreaterThanCategoryWithCarsModelBrand(fieldNumberMap),
        CategoryWithCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCarsModelBrandDTO> findAndSortCategoryWithCarsModelBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findAndSortCategoryWithCarsModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        CategoryWithCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCarsModelBrandDTO> findContainCategoryWithCarsModelBrandDTO(
      Map<String, String> fieldStringMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findContainCategoryWithCarsModelBrand(fieldStringMap),
        CategoryWithCarsModelBrandDTO.class);
  }

  @Override
  public CategoryDTO create(CategoryDTO entityDTO) {
    return objectMapperUtils.map(
        categoryDAO.create(objectMapperUtils.map(entityDTO, Category.class)), CategoryDTO.class);
  }

  @Override
  public CategoryDTO update(CategoryDTO entityDTO) {
    return objectMapperUtils.map(
        categoryDAO.update(objectMapperUtils.map(entityDTO, Category.class)), CategoryDTO.class);
  }

  @Override
  public void delete(CategoryDTO entityDTO) {
    categoryDAO.delete(objectMapperUtils.map(entityDTO, Category.class));
  }

  @Override
  public void deleteById(int id) {
    categoryDAO.deleteById(id);
  }
}
