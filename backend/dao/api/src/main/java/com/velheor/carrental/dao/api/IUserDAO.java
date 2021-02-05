package com.velheor.carrental.dao.api;

import com.velheor.carrental.models.User;
import com.velheor.carrental.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IUserDAO extends ICrudDAO<User> {

  User findByIdUserWithRoles(int id);

  User findByIdUserWithRents(int id);

  List<User> findAllAndSortWithDirectionUserWithRoles(Map<String, Direction> fieldDirectionMap);

  User findOneByCriteriaUserWithRoles(Map<String, Object> fieldCriterionMap);

  List<User> findAllByCriteriaUserWithRoles(Map<String, Object> fieldCriterionMap);

  List<User> findByNotNullUserWithRoles(List<String> fields);

  List<User> findByNullUserWithRoles(List<String> fields);

  List<User> findAndSortUserWithRoles(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  User findByEmailUserWithRoles(String email);

  User findByEmailUserWithRents(String email);
  
}
