package com.senla.training.dao.api;

import com.senla.training.models.User;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IUserDAO extends ICrudDAO<User> {
  User findByIdUserWithRoles(int id);

  List<User> findAllAndSortWithDirectionUserWithRoles(Map<String, Direction> fieldDirectionMap);

  User findOneByCriteriaUserWithRoles(Map<String, Object> fieldCriterionMap);

  List<User> findAllByCriteriaUserWithRoles(Map<String, Object> fieldCriterionMap);

  List<User> findByNotNullUserWithRoles(List<String> fields);

  List<User> findByNullUserWithRoles(List<String> fields);

  List<User> findAndSortUserWithRoles(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<User> findContainUserWithRoles(Map<String, String> fieldStringMap);

  User findByEmailUserWithRoles(String email);

  User findByEmailUserWithRents(String email);
}
