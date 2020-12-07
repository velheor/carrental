package com.senla.training.dao.api;

import com.senla.training.models.Brand;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IBrandDAO extends IGenericDAO<Brand> {
  Brand findByIdBrandWithModel(int id);

  List<Brand> findAllAndSortWithDirectionBrandWithModel(Map<String, Direction> fieldDirectionMap);

  Brand findOneByCriteriaBrandWithModel(Map<String, Object> fieldCriteriaMap);

  List<Brand> findAllByCriteriaBrandWithModel(Map<String, Object> fieldCriteriaMap);

  List<Brand> findByNotNullBrandWithModel(List<String> fields);

  List<Brand> findByNullBrandWithModel(List<String> fields);

  List<Brand> findLessThanBrandWithModel(Map<String, Number> fieldNumberMap);

  List<Brand> findGreaterThanBrandWithModel(Map<String, Number> fieldNumberMap);

  List<Brand> findAndSortBrandWithModel(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<Brand> findContainBrandWithModel(Map<String, String> fieldStringMap);
}
