package com.senla.training.service.impl;

import com.senla.training.dao.api.ICategoryDAO;
import com.senla.training.dto.category.CategoryDTO;
import com.senla.training.dto.category.CategoryWithCategoriesCarsModelBrandDTO;
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
  public CategoryWithCategoriesCarsModelBrandDTO findByIdCategoryWithCategoriesCarsModelBrandDTO(
      int id) {
    return objectMapperUtils.map(
        categoryDAO.findByIdCategoryWithCategoriesCarsModelBrand(id),
        CategoryWithCategoriesCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findAllAndSortWithDirectionCategoryWithCategoriesCarsModelBrandDTO(
          Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findAllAndSortWithDirectionCategoryWithCategoriesCarsModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        CategoryWithCategoriesCarsModelBrandDTO.class);
  }

  @Override
  public CategoryWithCategoriesCarsModelBrandDTO
      findOneByCriteriaCategoryWithCategoriesCarsModelBrandDTO(
          Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        categoryDAO.findOneByCriteriaCategoryWithCategoriesCarsModelBrand(fieldCriteriaMap),
        CategoryWithCategoriesCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findAllByCriteriaCategoryWithCategoriesCarsModelBrandDTO(
          Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findAllByCriteriaCategoryWithCategoriesCarsModelBrand(fieldCriteriaMap),
        CategoryWithCategoriesCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findByNotNullCategoryWithCategoriesCarsModelBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        categoryDAO.findByNotNullCategoryWithCategoriesCarsModelBrand(fields),
        CategoryWithCategoriesCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findByNullCategoryWithCategoriesCarsModelBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        categoryDAO.findByNullCategoryWithCategoriesCarsModelBrand(fields),
        CategoryWithCategoriesCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findLessThanCategoryWithCategoriesCarsModelBrandDTO(Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findLessThanCategoryWithCategoriesCarsModelBrand(fieldNumberMap),
        CategoryWithCategoriesCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findGreaterThanCategoryWithCategoriesCarsModelBrandDTO(Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findGreaterThanCategoryWithCategoriesCarsModelBrand(fieldNumberMap),
        CategoryWithCategoriesCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findAndSortCategoryWithCategoriesCarsModelBrandDTO(
          Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findAndSortCategoryWithCategoriesCarsModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        CategoryWithCategoriesCarsModelBrandDTO.class);
  }

  @Override
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findContainCategoryWithCategoriesCarsModelBrandDTO(Map<String, String> fieldStringMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findContainCategoryWithCategoriesCarsModelBrand(fieldStringMap),
        CategoryWithCategoriesCarsModelBrandDTO.class);
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
