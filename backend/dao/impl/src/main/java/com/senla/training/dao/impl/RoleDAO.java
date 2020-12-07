package com.senla.training.dao.impl;

import com.senla.training.dao.api.IRoleDAO;
import com.senla.training.models.Role;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAO extends EntityGraphAbstractDAO<Role> implements IRoleDAO {
  @Override
  public Role findByIdRoleWithUsers(int id) {
    super.setEntityGraphName("roleWithUsers");
    return super.findById(id);
  }

  @Override
  public List<Role> findAllAndSortWithDirectionRoleWithUsers(
      Map<String, Direction> fieldDirectionMap) {
    super.setEntityGraphName("roleWithUsers");
    return super.findAllAndSortWithDirection(fieldDirectionMap);
  }

  @Override
  public Role findOneByCriteriaRoleWithUsers(Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("roleWithUsers");
    return super.findOneByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Role> findAllByCriteriaRoleWithUsers(Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("roleWithUsers");
    return super.findAllByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Role> findByNotNullRoleWithUsers(List<String> fields) {
    super.setEntityGraphName("roleWithUsers");
    return super.findByNotNull(fields);
  }

  @Override
  public List<Role> findByNullRoleWithUsers(List<String> fields) {
    super.setEntityGraphName("roleWithUsers");
    return super.findByNull(fields);
  }

  @Override
  public List<Role> findLessThanRoleWithUsers(Map<String, Number> fieldNumberMap) {
    super.setEntityGraphName("roleWithUsers");
    return super.findLessThan(fieldNumberMap);
  }

  @Override
  public List<Role> findGreaterThanRoleWithUsers(Map<String, Number> fieldNumberMap) {
    super.setEntityGraphName("roleWithUsers");
    return super.findGreaterThan(fieldNumberMap);
  }

  @Override
  public List<Role> findAndSortRoleWithUsers(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("roleWithUsers");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }

  @Override
  public List<Role> findContainRoleWithUsers(Map<String, String> fieldStringMap) {
    super.setEntityGraphName("roleWithUsers");
    return super.findContain(fieldStringMap);
  }
}
