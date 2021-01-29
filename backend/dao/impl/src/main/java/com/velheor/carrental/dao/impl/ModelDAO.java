package com.velheor.carrental.dao.impl;

import com.velheor.carrental.dao.api.IModelDAO;
import com.velheor.carrental.models.Model;
import com.velheor.carrental.models.enums.Direction;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ModelDAO extends EntityGraphAbstractDAO<Model> implements IModelDAO {

  @Override
  public Model findByIdModelWithBrand(int id) {
    super.setEntityGraphName("modelWithBrand");
    return super.findById(id);
  }

  @Override
  public List<Model> findAllAndSortWithDirectionModelWithBrand(
      Map<String, Direction> fieldDirectionMap) {
    super.setEntityGraphName("modelWithBrand");
    return super.findAllAndSortWithDirection(fieldDirectionMap);
  }

  @Override
  public Model findOneByCriteriaModelWithBrand(Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("modelWithBrand");
    return super.findOneByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Model> findAllByCriteriaModelWithBrand(Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("modelWithBrand");
    return super.findAllByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Model> findByNotNullModelWithBrand(List<String> fields) {
    super.setEntityGraphName("modelWithBrand");
    return super.findByNotNull(fields);
  }

  @Override
  public List<Model> findByNullModelWithBrand(List<String> fields) {
    super.setEntityGraphName("modelWithBrand");
    return super.findByNull(fields);
  }

  @Override
  public List<Model> findAndSortModelWithBrand(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("modelWithBrand");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }
}
