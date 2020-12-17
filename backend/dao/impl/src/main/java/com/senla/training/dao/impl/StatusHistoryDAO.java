package com.senla.training.dao.impl;

import com.senla.training.dao.api.IStatusHistoryDAO;
import com.senla.training.models.StatusHistory;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class StatusHistoryDAO extends EntityGraphAbstractDAO<StatusHistory>
    implements IStatusHistoryDAO {
  @Override
  public StatusHistory findByIdStatusHistoryWithRent(int id) {
    super.setEntityGraphName("statusHistoryWithRent");
    return super.findById(id);
  }

  @Override
  public List<StatusHistory> findAllAndSortWithDirectionStatusHistoryWithRent(
      Map<String, Direction> fieldDirectionMap) {
    super.setEntityGraphName("statusHistoryWithRent");
    return super.findAllAndSortWithDirection(fieldDirectionMap);
  }

  @Override
  public StatusHistory findOneByCriteriaStatusHistoryWithRent(
      Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("statusHistoryWithRent");
    return super.findOneByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<StatusHistory> findAllByCriteriaStatusHistoryWithRent(
      Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("statusHistoryWithRent");
    return super.findAllByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<StatusHistory> findByNotNullStatusHistoryWithRent(List<String> fields) {
    super.setEntityGraphName("statusHistoryWithRent");
    return super.findByNotNull(fields);
  }

  @Override
  public List<StatusHistory> findByNullStatusHistoryWithRent(List<String> fields) {
    super.setEntityGraphName("statusHistoryWithRent");
    return super.findByNull(fields);
  }

  @Override
  public List<StatusHistory> findAndSortStatusHistoryWithRent(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("statusHistoryWithRent");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }

  @Override
  public List<StatusHistory> findContainStatusHistoryWithRent(Map<String, String> fieldStringMap) {
    super.setEntityGraphName("statusHistoryWithRent");
    return super.findContain(fieldStringMap);
  }
}
