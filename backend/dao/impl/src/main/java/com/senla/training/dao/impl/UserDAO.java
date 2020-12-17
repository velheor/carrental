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
  public User findByIdUserWithRoles(int id) {
    super.setEntityGraphName("userWithRoles");
    return super.findById(id);
  }

  @Override
  public List<User> findAllAndSortWithDirectionUserWithRoles(
      Map<String, Direction> fieldDirectionMap) {
    super.setEntityGraphName("userWithRoles");
    return super.findAllAndSortWithDirection(fieldDirectionMap);
  }

  @Override
  public User findOneByCriteriaUserWithRoles(Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("userWithRoles");
    return super.findOneByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<User> findAllByCriteriaUserWithRoles(Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("userWithRoles");
    return super.findAllByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<User> findByNotNullUserWithRoles(List<String> fields) {
    super.setEntityGraphName("userWithRoles");
    return super.findByNotNull(fields);
  }

  @Override
  public List<User> findByNullUserWithRoles(List<String> fields) {
    super.setEntityGraphName("userWithRoles");
    return super.findByNull(fields);
  }

  @Override
  public List<User> findAndSortUserWithRoles(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("userWithRoles");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }

  @Override
  public List<User> findContainUserWithRoles(Map<String, String> fieldStringMap) {
    super.setEntityGraphName("userWithRoles");
    return super.findContain(fieldStringMap);
  }

  @Override
  public User findByEmailUserWithRoles(String email) {
    super.setEntityGraphName("userWithRoles");
    return this.findOneByCriteriaUserWithRoles(Map.of("email", email));
  }

  @Override
  public User findByEmailUserWithRents(String email) {
    super.setEntityGraphName("userWithRents");
    return this.findOneByCriteriaUserWithRoles(Map.of("email", email));
  }

}
