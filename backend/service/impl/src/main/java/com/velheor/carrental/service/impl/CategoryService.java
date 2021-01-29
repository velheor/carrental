package com.velheor.carrental.service.impl;

import com.velheor.carrental.dao.api.ICategoryDAO;
import com.velheor.carrental.dto.CategoryDTO;
import com.velheor.carrental.models.Category;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.service.api.ICategoryService;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService implements ICategoryService {

  private final ICategoryDAO categoryDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  CategoryService(ICategoryDAO categoryDAO, ObjectMapperUtils objectMapperUtils) {
    this.categoryDAO = categoryDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public CategoryDTO findByIdCategoryWithCarsModelBrandDTO(int id) {
    return objectMapperUtils.map(
        categoryDAO.findByIdCategoryWithCarsModelBrand(id), CategoryDTO.class);
  }

  @Override
  public List<CategoryDTO> findAllAndSortWithDirectionCategoryWithCarsModelBrandDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findAllAndSortWithDirectionCategoryWithCarsModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        CategoryDTO.class);
  }

  @Override
  public CategoryDTO findOneByCriteriaCategoryWithCarsModelBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        categoryDAO.findOneByCriteriaCategoryWithCarsModelBrand(fieldCriteriaMap),
        CategoryDTO.class);
  }

  @Override
  public List<CategoryDTO> findAllByCriteriaCategoryWithCarsModelBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findAllByCriteriaCategoryWithCarsModelBrand(fieldCriteriaMap),
        CategoryDTO.class);
  }

  @Override
  public List<CategoryDTO> findByNotNullCategoryWithCarsModelBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        categoryDAO.findByNotNullCategoryWithCarsModelBrand(fields), CategoryDTO.class);
  }

  @Override
  public List<CategoryDTO> findByNullCategoryWithCarsModelBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        categoryDAO.findByNullCategoryWithCarsModelBrand(fields), CategoryDTO.class);
  }

  @Override
  public List<CategoryDTO> findAndSortCategoryWithCarsModelBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        categoryDAO.findAndSortCategoryWithCarsModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        CategoryDTO.class);
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
