package com.senla.training.dao.api;

import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IGenericDAO<T> extends ICrudDAO<T> {
  T findById(int id);

  List<T> findAll();

  List<T> sortWithDirection(String field, Direction direction);

  List<T> sortWithDirection(Map<String, Direction> fieldDirectionMap);

  T findOneByCriteria(String field, Object criteria);

  List<T> findAllByCriteria(String field, Object criteria);

  List<T> findAllByCriteria(Map<String, Object> fieldCriteriaMap);

  List<T> findByNotNull(String field);

  List<T> findByNull(String field);

  List<T> findLessThan(String field, Number number);

  List<T> findGreaterThan(String field, Number number);

  List<T> findAndSort(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<T> findContain(String field, String criteria);
}
