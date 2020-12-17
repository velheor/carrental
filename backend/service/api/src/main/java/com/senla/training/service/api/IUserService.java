package com.senla.training.service.api;

import com.senla.training.dto.UserDTO;
import com.senla.training.dto.UserWithTokenDTO;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService extends IGenericService<UserDTO> {

  UserDTO findByIdUserWithRolesDTO(int id);

  List<UserDTO> findAllAndSortWithDirectionUserWithRolesDTO(
      Map<String, String> fieldDirectionMap);

  UserDTO findOneByCriteriaUserWithRolesDTO(Map<String, Object> fieldCriterionMap);

  List<UserDTO> findAllByCriteriaUserWithRolesDTO(Map<String, Object> fieldCriterionMap);

  List<UserDTO> findByNotNullUserWithRolesDTO(List<String> fields);

  List<UserDTO> findByNullUserWithRolesDTO(List<String> fields);

  List<UserDTO> findAndSortUserWithRolesDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  UserWithTokenDTO getUserWithTokenDTO(UserWithTokenDTO userWithTokenDTO);

  UserDTO findCurrentUser(UserDetails userDetails);

  UserDTO updateCurrentUser(UserDetails userDetails, UserDTO userDTO);

  UserDTO deleteCurrentUser(UserDetails userDetails);
}
