package com.velheor.carrental.dao.impl;

import com.velheor.carrental.dao.api.IRoleDAO;
import com.velheor.carrental.models.Role;
import com.velheor.carrental.models.enums.Direction;
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
  public List<Role> findAndSortRoleWithUsers(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("roleWithUsers");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }
}
