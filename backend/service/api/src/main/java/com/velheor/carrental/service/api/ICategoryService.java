package com.velheor.carrental.service.api;

import com.velheor.carrental.dto.CategoryDTO;
import java.util.List;
import java.util.Map;

public interface ICategoryService extends IGenericService<CategoryDTO> {

  CategoryDTO findByIdCategoryWithCarsModelBrandDTO(int id);

  List<CategoryDTO> findAllAndSortWithDirectionCategoryWithCarsModelBrandDTO(
      Map<String, String> fieldDirectionMap);

  CategoryDTO findOneByCriteriaCategoryWithCarsModelBrandDTO(Map<String, Object> fieldCriteriaMap);

  List<CategoryDTO> findAllByCriteriaCategoryWithCarsModelBrandDTO(
      Map<String, Object> fieldCriteriaMap);

  List<CategoryDTO> findByNotNullCategoryWithCarsModelBrandDTO(List<String> fields);

  List<CategoryDTO> findByNullCategoryWithCarsModelBrandDTO(List<String> fields);

  List<CategoryDTO> findAndSortCategoryWithCarsModelBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);
}
