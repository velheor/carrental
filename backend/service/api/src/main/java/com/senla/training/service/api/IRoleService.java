package com.senla.training.service.api;

import com.senla.training.dto.RoleDTO;
import java.util.List;
import java.util.Map;

public interface IRoleService extends IGenericService<RoleDTO> {

  RoleDTO findByIdRoleWithUsersDTO(int id);

  List<RoleDTO> findAllAndSortWithDirectionRoleWithUsersDTO(
      Map<String, String> fieldDirectionMap);

  RoleDTO findOneByCriteriaRoleWithUsersDTO(Map<String, Object> fieldCriteriaMap);

  List<RoleDTO> findAllByCriteriaRoleWithUsersDTO(Map<String, Object> fieldCriteriaMap);

  List<RoleDTO> findByNotNullRoleWithUsersDTO(List<String> fields);

  List<RoleDTO> findByNullRoleWithUsersDTO(List<String> fields);

  List<RoleDTO> findAndSortRoleWithUsersDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

}
