package com.velheor.carrental.dao.impl;

import com.velheor.carrental.dao.api.ICategoryDAO;
import com.velheor.carrental.models.Category;
import com.velheor.carrental.models.enums.Direction;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO extends EntityGraphAbstractDAO<Category> implements ICategoryDAO {

  @Override
  public Category findByIdCategoryWithCarsModelBrand(int id) {
    super.setEntityGraphName("categoryWithCarsModelBrand");
    return super.findById(id);
  }

  @Override
  public List<Category> findAllAndSortWithDirectionCategoryWithCarsModelBrand(
      Map<String, Direction> fieldDirectionMap) {
    super.setEntityGraphName("categoryWithCarsModelBrand");
    return super.findAllAndSortWithDirection(fieldDirectionMap);
  }

  @Override
  public Category findOneByCriteriaCategoryWithCarsModelBrand(
      Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("categoryWithCarsModelBrand");
    return super.findOneByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Category> findAllByCriteriaCategoryWithCarsModelBrand(
      Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("categoryWithCarsModelBrand");
    return super.findAllByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Category> findByNotNullCategoryWithCarsModelBrand(List<String> fields) {
    super.setEntityGraphName("categoryWithCarsModelBrand");
    return super.findByNotNull(fields);
  }

  @Override
  public List<Category> findByNullCategoryWithCarsModelBrand(List<String> fields) {
    super.setEntityGraphName("categoryWithCarsModelBrand");
    return super.findByNull(fields);
  }

  @Override
  public List<Category> findAndSortCategoryWithCarsModelBrand(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("categoryWithCarsModelBrand");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }
}
