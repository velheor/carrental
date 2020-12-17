package com.senla.training.dao.api;

import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IGenericDAO<T> extends ICrudDAO<T> {

  T findById(int id);

  List<T> findAllAndSortWithDirection(Map<String, Direction> fieldDirectionMap);

  T findOneByCriteria(Map<String, Object> fieldCriterionMap);

  List<T> findAllByCriteria(Map<String, Object> fieldCriterionMap);

  List<T> findByNotNull(List<String> fields);

  List<T> findByNull(List<String> fields);

  List<T> findAndSort(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

}
