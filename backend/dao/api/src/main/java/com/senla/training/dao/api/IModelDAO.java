package com.senla.training.dao.api;

import com.senla.training.models.Model;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IModelDAO extends IGenericDAO<Model> {
  Model findByIdModelWithBrand(int id);

  List<Model> findAllAndSortWithDirectionModelWithBrand(Map<String, Direction> fieldDirectionMap);

  Model findOneByCriteriaModelWithBrand(Map<String, Object> fieldCriteriaMap);

  List<Model> findAllByCriteriaModelWithBrand(Map<String, Object> fieldCriteriaMap);

  List<Model> findByNotNullModelWithBrand(List<String> fields);

  List<Model> findByNullModelWithBrand(List<String> fields);

  List<Model> findLessThanModelWithBrand(Map<String, Number> fieldNumberMap);

  List<Model> findGreaterThanModelWithBrand(Map<String, Number> fieldNumberMap);

  List<Model> findAndSortModelWithBrand(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<Model> findContainModelWithBrand(Map<String, String> fieldStringMap);
}
