package com.senla.training.dao.impl;

import com.senla.training.dao.api.IBrandDAO;
import com.senla.training.models.Brand;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class BrandDAO extends EntityGraphAbstractDAO<Brand> implements IBrandDAO {
  @Override
  public Brand findByIdBrandWithModel(int id) {
    super.setEntityGraphName("brandWithModel");
    return super.findById(id);
  }

  @Override
  public List<Brand> findAllAndSortWithDirectionBrandWithModel(
      Map<String, Direction> fieldDirectionMap) {
    super.setEntityGraphName("brandWithModel");
    return super.findAllAndSortWithDirection(fieldDirectionMap);
  }

  @Override
  public Brand findOneByCriteriaBrandWithModel(Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("brandWithModel");
    return super.findOneByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Brand> findAllByCriteriaBrandWithModel(Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("brandWithModel");
    return super.findAllByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Brand> findByNotNullBrandWithModel(List<String> fields) {
    super.setEntityGraphName("brandWithModel");
    return super.findByNotNull(fields);
  }

  @Override
  public List<Brand> findByNullBrandWithModel(List<String> fields) {
    super.setEntityGraphName("brandWithModel");
    return super.findByNull(fields);
  }

  @Override
  public List<Brand> findLessThanBrandWithModel(Map<String, Number> fieldNumberMap) {
    super.setEntityGraphName("brandWithModel");
    return super.findLessThan(fieldNumberMap);
  }

  @Override
  public List<Brand> findGreaterThanBrandWithModel(Map<String, Number> fieldNumberMap) {
    super.setEntityGraphName("brandWithModel");
    return super.findGreaterThan(fieldNumberMap);
  }

  @Override
  public List<Brand> findAndSortBrandWithModel(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("brandWithModel");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }

  @Override
  public List<Brand> findContainBrandWithModel(Map<String, String> fieldStringMap) {
    super.setEntityGraphName("brandWithModel");
    return super.findContain(fieldStringMap);
  }
}
