package com.senla.training.dao.impl;

import com.senla.training.dao.api.IModelDAO;
import com.senla.training.models.Model;
import com.senla.training.models.enums.Direction;
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
  public List<Model> findLessThanModelWithBrand(Map<String, Number> fieldNumberMap) {
    super.setEntityGraphName("modelWithBrand");
    return super.findLessThan(fieldNumberMap);
  }

  @Override
  public List<Model> findGreaterThanModelWithBrand(Map<String, Number> fieldNumberMap) {
    super.setEntityGraphName("modelWithBrand");
    return super.findGreaterThan(fieldNumberMap);
  }

  @Override
  public List<Model> findAndSortModelWithBrand(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("modelWithBrand");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }

  @Override
  public List<Model> findContainModelWithBrand(Map<String, String> fieldStringMap) {
    super.setEntityGraphName("modelWithBrand");
    return super.findContain(fieldStringMap);
  }
}
