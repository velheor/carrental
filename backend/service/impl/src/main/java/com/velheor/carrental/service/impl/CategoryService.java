package com.velheor.carrental.service.impl;

import com.velheor.carrental.dao.api.CategoryRepository;
import com.velheor.carrental.dto.CategoryDTO;
import com.velheor.carrental.models.Category;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.service.api.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

  private final CategoryRepository categoryRepository;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  CategoryService(CategoryRepository categoryRepository, ObjectMapperUtils objectMapperUtils) {
    this.categoryRepository = categoryRepository;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public CategoryDTO findById(Integer id) {
    return categoryRepository
        .findById(id)
        .map(car -> objectMapperUtils.map(car, CategoryDTO.class))
        .orElse(null);
  }

  @Override
  public CategoryDTO create(CategoryDTO entityDTO) {
    return objectMapperUtils.map(
        categoryRepository.save(objectMapperUtils.map(entityDTO, Category.class)),
        CategoryDTO.class);
  }

  @Override
  public CategoryDTO update(CategoryDTO entityDTO) {
    if (categoryRepository.findById(entityDTO.getId()).isPresent()) {
      objectMapperUtils.map(
          categoryRepository.save(objectMapperUtils.map(entityDTO, Category.class)),
          CategoryDTO.class);
    }
    return null;
  }

  @Override
  public void delete(CategoryDTO entityDTO) {
    categoryRepository.delete(objectMapperUtils.map(entityDTO, Category.class));
  }

  @Override
  public void deleteById(int id) {
    categoryRepository.deleteById(id);
  }
}
