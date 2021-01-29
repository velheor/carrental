package com.velheor.carrental.dao.api;

import com.velheor.carrental.models.StatusHistory;
import com.velheor.carrental.models.enums.Direction;
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

  List<StatusHistory> findAndSortStatusHistoryWithRent(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);
}
