package com.senla.training.service.api;

import com.senla.training.dto.category.CategoryDTO;
import com.senla.training.dto.category.CategoryWithCarsModelBrandDTO;
import java.util.List;
import java.util.Map;

public interface ICategoryService extends IGenericService<CategoryDTO> {
  CategoryWithCarsModelBrandDTO findByIdCategoryWithCarsModelBrandDTO(int id);

  List<CategoryWithCarsModelBrandDTO> findAllAndSortWithDirectionCategoryWithCarsModelBrandDTO(
      Map<String, String> fieldDirectionMap);

  CategoryWithCarsModelBrandDTO findOneByCriteriaCategoryWithCarsModelBrandDTO(
      Map<String, Object> fieldCriteriaMap);

  List<CategoryWithCarsModelBrandDTO> findAllByCriteriaCategoryWithCarsModelBrandDTO(
      Map<String, Object> fieldCriteriaMap);

  List<CategoryWithCarsModelBrandDTO> findByNotNullCategoryWithCarsModelBrandDTO(
      List<String> fields);

  List<CategoryWithCarsModelBrandDTO> findByNullCategoryWithCarsModelBrandDTO(List<String> fields);

  List<CategoryWithCarsModelBrandDTO> findLessThanCategoryWithCarsModelBrandDTO(
      Map<String, Number> fieldNumberMap);

  List<CategoryWithCarsModelBrandDTO> findGreaterThanCategoryWithCarsModelBrandDTO(
      Map<String, Number> fieldNumberMap);

  List<CategoryWithCarsModelBrandDTO> findAndSortCategoryWithCarsModelBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<CategoryWithCarsModelBrandDTO> findContainCategoryWithCarsModelBrandDTO(
      Map<String, String> fieldStringMap);
}
