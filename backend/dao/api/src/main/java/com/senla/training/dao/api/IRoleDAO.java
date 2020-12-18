package com.senla.training.dao.api;

import com.senla.training.models.Role;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IRoleDAO extends ICrudDAO<Role> {

  Role findByIdRoleWithUsers(int id);

  List<Role> findAllAndSortWithDirectionRoleWithUsers(Map<String, Direction> fieldDirectionMap);

  Role findOneByCriteriaRoleWithUsers(Map<String, Object> fieldCriteriaMap);

  List<Role> findAllByCriteriaRoleWithUsers(Map<String, Object> fieldCriteriaMap);

  List<Role> findByNotNullRoleWithUsers(List<String> fields);

  List<Role> findByNullRoleWithUsers(List<String> fields);

  List<Role> findAndSortRoleWithUsers(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);
}
