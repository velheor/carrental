package com.senla.training.service.api;

import com.senla.training.dto.user.UserDTO;
import com.senla.training.dto.user.UserWithRolesDTO;
import java.util.List;
import java.util.Map;

public interface IUserService extends IGenericService<UserDTO> {
  UserWithRolesDTO findByIdUserWithRolesDTO(int id);

  List<UserWithRolesDTO> findAllAndSortWithDirectionUserWithRolesDTO(
      Map<String, String> fieldDirectionMap);

  UserWithRolesDTO findOneByCriteriaUserWithRolesDTO(Map<String, Object> fieldCriterionMap);

  List<UserWithRolesDTO> findAllByCriteriaUserWithRolesDTO(Map<String, Object> fieldCriterionMap);

  List<UserWithRolesDTO> findByNotNullUserWithRolesDTO(List<String> fields);

  List<UserWithRolesDTO> findByNullUserWithRolesDTO(List<String> fields);

  List<UserWithRolesDTO> findLessThanUserWithRolesDTO(Map<String, Number> fieldNumberMap);

  List<UserWithRolesDTO> findGreaterThanUserWithRolesDTO(Map<String, Number> fieldNumberMap);

  List<UserWithRolesDTO> findAndSortUserWithRolesDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<UserWithRolesDTO> findContainUserWithRolesDTO(Map<String, String> fieldStringMap);

  Boolean checkForExistEmail(String email);
}
