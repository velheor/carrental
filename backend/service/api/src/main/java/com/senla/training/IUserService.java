package com.senla.training;

import com.senla.training.user.UserWithRolesDTO;

import java.util.List;
import java.util.Map;

public interface IUserService {
    UserWithRolesDTO findByIdUserWithRoleDTO(int id);

    List<UserWithRolesDTO> findAllUserWithRoleDTO();

    List<UserWithRolesDTO> sortWithDirectionUserWithRoleDTO(String field, Direction direction);

    List<UserWithRolesDTO> sortWithDirectionUserWithRoleDTO(Map<String, Direction> fieldDirectionMap);

    UserWithRolesDTO findOneByCriteriaUserWithRoleDTO(String field, Object criteria);

    List<UserWithRolesDTO> findAllByCriteriaUserWithRoleDTO(String field, Object criteria);

    List<UserWithRolesDTO> findAllByCriteriaUserWithRoleDTO(Map<String, Object> fieldCriteriaMap);

    List<UserWithRolesDTO> findByNotNullUserWithRoleDTO(String field);

    List<UserWithRolesDTO> findByNullUserWithRoleDTO(String field);

    List<UserWithRolesDTO> findLessThanUserWithRoleDTO(String field, Number number);

    List<UserWithRolesDTO> findGreaterThanUserWithRoleDTO(String field, Number number);

    List<UserWithRolesDTO> findAndSortUserWithRoleDTO(Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

    List<UserWithRolesDTO> findContainUserWithRoleDTO(String field, String criteria);
}