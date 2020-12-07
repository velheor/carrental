package com.senla.training.service.api;

import com.senla.training.dto.role.RoleDTO;
import com.senla.training.dto.role.RoleWithUsersDTO;
import java.util.List;
import java.util.Map;

public interface IRoleService extends IGenericService<RoleDTO> {
  RoleWithUsersDTO findByIdRoleWithUsersDTO(int id);

  List<RoleWithUsersDTO> findAllAndSortWithDirectionRoleWithUsersDTO(
      Map<String, String> fieldDirectionMap);

  RoleWithUsersDTO findOneByCriteriaRoleWithUsersDTO(Map<String, Object> fieldCriteriaMap);

  List<RoleWithUsersDTO> findAllByCriteriaRoleWithUsersDTO(Map<String, Object> fieldCriteriaMap);

  List<RoleWithUsersDTO> findByNotNullRoleWithUsersDTO(List<String> fields);

  List<RoleWithUsersDTO> findByNullRoleWithUsersDTO(List<String> fields);

  List<RoleWithUsersDTO> findLessThanRoleWithUsersDTO(Map<String, Number> fieldNumberMap);

  List<RoleWithUsersDTO> findGreaterThanRoleWithUsersDTO(Map<String, Number> fieldNumberMap);

  List<RoleWithUsersDTO> findAndSortRoleWithUsersDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<RoleWithUsersDTO> findContainRoleWithUsersDTO(Map<String, String> fieldStringMap);
}
