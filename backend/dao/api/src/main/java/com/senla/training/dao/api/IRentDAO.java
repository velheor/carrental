package com.senla.training.dao.api;

import com.senla.training.models.Rent;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IRentDAO extends ICrudDAO<Rent> {
  Rent findByIdRentWithUserStatusHistoryCar(int id);

  List<Rent> findAllRentWithUserStatusHistoryCar();

  List<Rent> sortWithDirectionRentWithUserStatusHistoryCar(String field, Direction direction);

  List<Rent> sortWithDirectionRentWithUserStatusHistoryCar(
      Map<String, Direction> fieldDirectionMap);

  Rent findOneByCriteriaRentWithUserStatusHistoryCar(String field, Object criteria);

  List<Rent> findAllByCriteriaRentWithUserStatusHistoryCar(String field, Object criteria);

  List<Rent> findAllByCriteriaRentWithUserStatusHistoryCar(Map<String, Object> fieldCriteriaMap);

  List<Rent> findByNotNullRentWithUserStatusHistoryCar(String field);

  List<Rent> findByNullRentWithUserStatusHistoryCar(String field);

  List<Rent> findLessThanRentWithUserStatusHistoryCar(String field, Number number);

  List<Rent> findGreaterThanRentWithUserStatusHistoryCar(String field, Number number);

  List<Rent> findAndSortRentWithUserStatusHistoryCar(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<Rent> findContainRentWithUserStatusHistoryCar(String field, String criteria);
}
