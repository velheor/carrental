package com.senla.training.dao.impl;

import com.senla.training.dao.api.IUserDAO;
import com.senla.training.models.User;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends EntityGraphAbstractDAO<User> implements IUserDAO {
  @Override
  public User findByIdUserWithRole(int id) {
    super.setEntityGraphName("userWithRole");
    return super.findById(id);
  }

  @Override
  public List<User> findAllUserWithRole() {
    super.setEntityGraphName("userWithRolesAndRentsAndCarAndCategoryAndModelAndBrand");
    return super.findAll();
  }

  @Override
  public List<User> sortWithDirectionUserWithRole(String field, Direction direction) {
    super.setEntityGraphName("userWithRole");
    return super.sortWithDirection(field, direction);
  }

  @Override
  public List<User> sortWithDirectionUserWithRole(Map<String, Direction> fieldDirectionMap) {
    super.setEntityGraphName("userWithRole");
    return super.sortWithDirection(fieldDirectionMap);
  }

  @Override
  public User findOneByCriteriaUserWithRole(String field, Object criteria) {
    super.setEntityGraphName("userWithRole");
    return super.findOneByCriteria(field, criteria);
  }

  @Override
  public List<User> findAllByCriteriaUserWithRole(String field, Object criteria) {
    super.setEntityGraphName("userWithRole");
    return super.findAllByCriteria(field, criteria);
  }

  @Override
  public List<User> findAllByCriteriaUserWithRole(Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("userWithRole");
    return super.findAllByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<User> findByNotNullUserWithRole(String field) {
    super.setEntityGraphName("userWithRole");
    return super.findByNotNull(field);
  }

  @Override
  public List<User> findByNullUserWithRole(String field) {
    super.setEntityGraphName("userWithRole");
    return super.findByNull(field);
  }

  @Override
  public List<User> findLessThanUserWithRole(String field, Number number) {
    super.setEntityGraphName("userWithRole");
    return super.findLessThan(field, number);
  }

  @Override
  public List<User> findGreaterThanUserWithRole(String field, Number number) {
    super.setEntityGraphName("userWithRole");
    return super.findGreaterThan(field, number);
  }

  @Override
  public List<User> findAndSortUserWithRole(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("userWithRole");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }

  @Override
  public List<User> findContainUserWithRole(String field, String criteria) {
    super.setEntityGraphName("userWithRole");
    return super.findContain(field, criteria);
  }
}
