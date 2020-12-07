package com.senla.training.dao.api;

import com.senla.training.models.StatusHistory;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IStatusHistoryDAO extends IGenericDAO<StatusHistory> {
  StatusHistory findByIdStatusHistoryWithRent(int id);

  List<StatusHistory> findAllAndSortWithDirectionStatusHistoryWithRent(
      Map<String, Direction> fieldDirectionMap);

  StatusHistory findOneByCriteriaStatusHistoryWithRent(Map<String, Object> fieldCriteriaMap);

  List<StatusHistory> findAllByCriteriaStatusHistoryWithRent(Map<String, Object> fieldCriteriaMap);

  List<StatusHistory> findByNotNullStatusHistoryWithRent(List<String> fields);

  List<StatusHistory> findByNullStatusHistoryWithRent(List<String> fields);

  List<StatusHistory> findLessThanStatusHistoryWithRent(Map<String, Number> fieldNumberMap);

  List<StatusHistory> findGreaterThanStatusHistoryWithRent(Map<String, Number> fieldNumberMap);

  List<StatusHistory> findAndSortStatusHistoryWithRent(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<StatusHistory> findContainStatusHistoryWithRent(Map<String, String> fieldStringMap);
}
