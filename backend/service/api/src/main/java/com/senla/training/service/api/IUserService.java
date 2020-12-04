package com.senla.training.service.api;

import com.senla.training.dto.user.UserWithRoleDTO;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IUserService {
  UserWithRoleDTO createUserWithRoleDTO(UserWithRoleDTO userWithRoleDTO);

  UserWithRoleDTO updateUserWithRoleDTO(UserWithRoleDTO userWithRoleDTO);

  void deleteUserWithRoleDTO(UserWithRoleDTO userWithRoleDTO);

  void deleteById(int id);

  UserWithRoleDTO findByIdUserWithRoleDTO(int id);

  List<UserWithRoleDTO> findAllUserWithRoleDTO();

  List<UserWithRoleDTO> sortWithDirectionUserWithRoleDTO(String field, Direction direction);

  List<UserWithRoleDTO> sortWithDirectionUserWithRoleDTO(Map<String, Direction> fieldDirectionMap);

  UserWithRoleDTO findOneByCriteriaUserWithRoleDTO(String field, Object criteria);

  List<UserWithRoleDTO> findAllByCriteriaUserWithRoleDTO(String field, Object criteria);

  List<UserWithRoleDTO> findAllByCriteriaUserWithRoleDTO(Map<String, Object> fieldCriteriaMap);

  List<UserWithRoleDTO> findByNotNullUserWithRoleDTO(String field);

  List<UserWithRoleDTO> findByNullUserWithRoleDTO(String field);

  List<UserWithRoleDTO> findLessThanUserWithRoleDTO(String field, Number number);

  List<UserWithRoleDTO> findGreaterThanUserWithRoleDTO(String field, Number number);

  List<UserWithRoleDTO> findAndSortUserWithRoleDTO(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<UserWithRoleDTO> findContainUserWithRoleDTO(String field, String criteria);
}
