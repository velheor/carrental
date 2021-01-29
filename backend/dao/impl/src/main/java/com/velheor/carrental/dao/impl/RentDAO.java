package com.velheor.carrental.dao.impl;

import com.velheor.carrental.dao.api.IRentDAO;
import com.velheor.carrental.models.Rent;
import com.velheor.carrental.models.enums.Direction;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class RentDAO extends EntityGraphAbstractDAO<Rent> implements IRentDAO {

  @Override
  public Rent findByIdRentWithUserStatusHistoryCarModelBrand(int id) {
    super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
    return super.findById(id);
  }

  @Override
  public List<Rent> findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrand(
      Map<String, Direction> fieldDirectionMap) {
    super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
    return super.findAllAndSortWithDirection(fieldDirectionMap);
  }

  @Override
  public Rent findOneByCriteriaRentWithUserStatusHistoryCarModelBrand(
      Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
    return super.findOneByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Rent> findAllByCriteriaRentWithUserStatusHistoryCarModelBrand(
      Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
    return super.findAllByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Rent> findByNotNullRentWithUserStatusHistoryCarModelBrand(List<String> fields) {
    super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
    return super.findByNotNull(fields);
  }

  @Override
  public List<Rent> findByNullRentWithUserStatusHistoryCarModelBrand(List<String> fields) {
    super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
    return super.findByNull(fields);
  }

  @Override
  public List<Rent> findAndSortRentWithUserStatusHistoryCarModelBrand(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }
}
