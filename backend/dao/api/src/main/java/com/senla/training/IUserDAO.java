package com.senla.training;

import java.util.List;
import java.util.Map;

interface IUserDAO extends ICrudDAO<User> {
    User findByIdUserWithRole(int id);

    List<User> findAllUserWithRole();

    List<User> sortWithDirectionUserWithRole(String field, Direction direction);

    List<User> sortWithDirectionUserWithRole(Map<String, Direction> fieldDirectionMap);

    User findOneByCriteriaUserWithRole(String field, Object criteria);

    List<User> findAllByCriteriaUserWithRole(String field, Object criteria);

    List<User> findAllByCriteriaUserWithRole(Map<String, Object> fieldCriteriaMap);

    List<User> findByNotNullUserWithRole(String field);

    List<User> findByNullUserWithRole(String field);

    List<User> findLessThanUserWithRole(String field, Number number);

    List<User> findGreaterThanUserWithRole(String field, Number number);

    List<User> findAndSortUserWithRole(Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

    List<User> findContainUserWithRole(String field, String criteria);
}