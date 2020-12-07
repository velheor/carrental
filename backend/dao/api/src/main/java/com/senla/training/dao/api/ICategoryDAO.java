package com.senla.training.dao.api;

import com.senla.training.models.Category;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface ICategoryDAO extends IGenericDAO<Category> {
  Category findByIdCategoryWithCategoriesCarsModelBrand(int id);

  List<Category> findAllAndSortWithDirectionCategoryWithCategoriesCarsModelBrand(
      Map<String, Direction> fieldDirectionMap);

  Category findOneByCriteriaCategoryWithCategoriesCarsModelBrand(
      Map<String, Object> fieldCriteriaMap);

  List<Category> findAllByCriteriaCategoryWithCategoriesCarsModelBrand(
      Map<String, Object> fieldCriteriaMap);

  List<Category> findByNotNullCategoryWithCategoriesCarsModelBrand(List<String> fields);

  List<Category> findByNullCategoryWithCategoriesCarsModelBrand(List<String> fields);

  List<Category> findLessThanCategoryWithCategoriesCarsModelBrand(
      Map<String, Number> fieldNumberMap);

  List<Category> findGreaterThanCategoryWithCategoriesCarsModelBrand(
      Map<String, Number> fieldNumberMap);

  List<Category> findAndSortCategoryWithCategoriesCarsModelBrand(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<Category> findContainCategoryWithCategoriesCarsModelBrand(
      Map<String, String> fieldStringMap);
}
