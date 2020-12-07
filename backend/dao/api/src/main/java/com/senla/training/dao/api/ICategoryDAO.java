package com.senla.training.dao.api;

import com.senla.training.models.Category;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface ICategoryDAO extends IGenericDAO<Category> {
  Category findByIdCategoryWithCarsModelBrand(int id);

  List<Category> findAllAndSortWithDirectionCategoryWithCarsModelBrand(
      Map<String, Direction> fieldDirectionMap);

  Category findOneByCriteriaCategoryWithCarsModelBrand(Map<String, Object> fieldCriteriaMap);

  List<Category> findAllByCriteriaCategoryWithCarsModelBrand(Map<String, Object> fieldCriteriaMap);

  List<Category> findByNotNullCategoryWithCarsModelBrand(List<String> fields);

  List<Category> findByNullCategoryWithCarsModelBrand(List<String> fields);

  List<Category> findLessThanCategoryWithCarsModelBrand(Map<String, Number> fieldNumberMap);

  List<Category> findGreaterThanCategoryWithCarsModelBrand(Map<String, Number> fieldNumberMap);

  List<Category> findAndSortCategoryWithCarsModelBrand(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<Category> findContainCategoryWithCarsModelBrand(Map<String, String> fieldStringMap);
}
