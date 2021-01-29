package com.velheor.carrental.dao.impl;

import com.velheor.carrental.dao.api.IBrandDAO;
import com.velheor.carrental.models.Brand;
import com.velheor.carrental.models.enums.Direction;
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
  public List<Brand> findAndSortBrandWithModels(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("brandWithModels");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }
}
