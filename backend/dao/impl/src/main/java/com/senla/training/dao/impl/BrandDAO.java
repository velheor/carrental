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
  public Brand findByIdBrandWithModels(int id) {
    super.setEntityGraphName("brandWithModels");
    return super.findById(id);
  }

  @Override
  public List<Brand> findAllAndSortWithDirectionBrandWithModels(
      Map<String, Direction> fieldDirectionMap) {
    super.setEntityGraphName("brandWithModels");
    return super.findAllAndSortWithDirection(fieldDirectionMap);
  }

  @Override
  public Brand findOneByCriteriaBrandWithModels(Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("brandWithModels");
    return super.findOneByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Brand> findAllByCriteriaBrandWithModels(Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("brandWithModels");
    return super.findAllByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Brand> findByNotNullBrandWithModels(List<String> fields) {
    super.setEntityGraphName("brandWithModels");
    return super.findByNotNull(fields);
  }

  @Override
  public List<Brand> findByNullBrandWithModels(List<String> fields) {
    super.setEntityGraphName("brandWithModels");
    return super.findByNull(fields);
  }

  @Override
  public List<Brand> findLessThanBrandWithModels(Map<String, Number> fieldNumberMap) {
    super.setEntityGraphName("brandWithModels");
    return super.findLessThan(fieldNumberMap);
  }

  @Override
  public List<Brand> findGreaterThanBrandWithModels(Map<String, Number> fieldNumberMap) {
    super.setEntityGraphName("brandWithModels");
    return super.findGreaterThan(fieldNumberMap);
  }

  @Override
  public List<Brand> findAndSortBrandWithModels(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("brandWithModels");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }

  @Override
  public List<Brand> findContainBrandWithModels(Map<String, String> fieldStringMap) {
    super.setEntityGraphName("brandWithModels");
    return super.findContain(fieldStringMap);
  }
}
