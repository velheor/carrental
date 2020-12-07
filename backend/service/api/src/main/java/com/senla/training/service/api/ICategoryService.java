package com.senla.training.service.api;

import com.senla.training.dto.category.CategoryDTO;
import com.senla.training.dto.category.CategoryWithCategoriesCarsModelBrandDTO;
import java.util.List;
import java.util.Map;

public interface ICategoryService extends IGenericService<CategoryDTO> {
  CategoryWithCategoriesCarsModelBrandDTO findByIdCategoryWithCategoriesCarsModelBrandDTO(int id);

  List<CategoryWithCategoriesCarsModelBrandDTO>
      findAllAndSortWithDirectionCategoryWithCategoriesCarsModelBrandDTO(
          Map<String, String> fieldDirectionMap);

  CategoryWithCategoriesCarsModelBrandDTO findOneByCriteriaCategoryWithCategoriesCarsModelBrandDTO(
      Map<String, Object> fieldCriteriaMap);

  List<CategoryWithCategoriesCarsModelBrandDTO>
      findAllByCriteriaCategoryWithCategoriesCarsModelBrandDTO(
          Map<String, Object> fieldCriteriaMap);

  List<CategoryWithCategoriesCarsModelBrandDTO>
      findByNotNullCategoryWithCategoriesCarsModelBrandDTO(List<String> fields);

  List<CategoryWithCategoriesCarsModelBrandDTO> findByNullCategoryWithCategoriesCarsModelBrandDTO(
      List<String> fields);

  List<CategoryWithCategoriesCarsModelBrandDTO> findLessThanCategoryWithCategoriesCarsModelBrandDTO(
      Map<String, Number> fieldNumberMap);

  List<CategoryWithCategoriesCarsModelBrandDTO>
      findGreaterThanCategoryWithCategoriesCarsModelBrandDTO(Map<String, Number> fieldNumberMap);

  List<CategoryWithCategoriesCarsModelBrandDTO> findAndSortCategoryWithCategoriesCarsModelBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<CategoryWithCategoriesCarsModelBrandDTO> findContainCategoryWithCategoriesCarsModelBrandDTO(
      Map<String, String> fieldStringMap);
}
