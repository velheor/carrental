package com.senla.training.dao.api;

import com.senla.training.models.Rent;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IRentDAO extends ICrudDAO<Rent> {

  Rent findByIdRentWithUserStatusHistoryCarModelBrand(int id);

  List<Rent> findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrand(
      Map<String, Direction> fieldDirectionMap);

  Rent findOneByCriteriaRentWithUserStatusHistoryCarModelBrand(
      Map<String, Object> fieldCriteriaMap);

  List<Rent> findAllByCriteriaRentWithUserStatusHistoryCarModelBrand(
      Map<String, Object> fieldCriteriaMap);

  List<Rent> findByNotNullRentWithUserStatusHistoryCarModelBrand(List<String> fields);

  List<Rent> findByNullRentWithUserStatusHistoryCarModelBrand(List<String> fields);

  List<Rent> findAndSortRentWithUserStatusHistoryCarModelBrand(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);
}
