package com.senla.training.dao.api;

import com.senla.training.models.Car;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface ICarDAO extends IGenericDAO<Car> {
  Car findByIdCarWithCategory(int id);

  List<Car> findAllCarWithCategory();

  List<Car> sortWithDirectionCarWithCategory(String field, Direction direction);

  List<Car> sortWithDirectionCarWithCategory(Map<String, Direction> fieldDirectionMap);

  Car findOneByCriteriaCarWithCategory(String field, Object criteria);

  List<Car> findAllByCriteriaCarWithCategory(String field, Object criteria);

  List<Car> findAllByCriteriaCarWithCategory(Map<String, Object> fieldCriteriaMap);

  List<Car> findByNotNullCarWithCategory(String field);

  List<Car> findByNullCarWithCategory(String field);

  List<Car> findLessThanCarWithCategory(String field, Number number);

  List<Car> findGreaterThanCarWithCategory(String field, Number number);

  List<Car> findAndSortCarWithCategory(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<Car> findContainCarWithCategory(String field, String criteria);
}
