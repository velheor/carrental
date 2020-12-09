package com.senla.training.service.impl;

import com.senla.training.dao.api.IUserDAO;
import com.senla.training.dto.user.UserDTO;
import com.senla.training.dto.user.UserWithRolesDTO;
import com.senla.training.models.User;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IUserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

  private final IUserDAO userDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  public UserService(IUserDAO userDAO, ObjectMapperUtils objectMapperUtils) {
    this.userDAO = userDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public UserWithRolesDTO findByIdUserWithRolesDTO(int id) {
    return objectMapperUtils.map(userDAO.findByIdUserWithRoles(id), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findAllAndSortWithDirectionUserWithRolesDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        userDAO.findAllAndSortWithDirectionUserWithRoles(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        UserWithRolesDTO.class);
  }

  @Override
  public UserWithRolesDTO findOneByCriteriaUserWithRolesDTO(Map<String, Object> fieldCriterionMap) {
    return objectMapperUtils.map(
        userDAO.findOneByCriteriaUserWithRoles(fieldCriterionMap), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findAllByCriteriaUserWithRolesDTO(
      Map<String, Object> fieldCriterionMap) {
    return objectMapperUtils.mapAll(
        userDAO.findAllByCriteriaUserWithRoles(fieldCriterionMap), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findByNotNullUserWithRolesDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        userDAO.findByNotNullUserWithRoles(fields), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findByNullUserWithRolesDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        userDAO.findByNullUserWithRoles(fields), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findLessThanUserWithRolesDTO(Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        userDAO.findLessThanUserWithRoles(fieldNumberMap), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findGreaterThanUserWithRolesDTO(
      Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        userDAO.findGreaterThanUserWithRoles(fieldNumberMap), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findAndSortUserWithRolesDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        userDAO.findAndSortUserWithRoles(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findContainUserWithRolesDTO(Map<String, String> fieldStringMap) {
    return objectMapperUtils.mapAll(
        userDAO.findContainUserWithRoles(fieldStringMap), UserWithRolesDTO.class);
  }

  @Override
  public UserDTO create(UserDTO entityDTO) {
    if (this.checkForUniqueEmail(entityDTO.getEmail())) {
      return objectMapperUtils.map(
          userDAO.create(objectMapperUtils.map(entityDTO, User.class)), UserDTO.class);
    }
    return new UserDTO();
  }

  @Override
  public UserDTO update(UserDTO entityDTO) {
    return objectMapperUtils.map(
        userDAO.update(objectMapperUtils.map(entityDTO, User.class)), UserDTO.class);
  }

  @Override
  public void delete(UserDTO entityDTO) {
    userDAO.delete(objectMapperUtils.map(entityDTO, User.class));
  }

  @Override
  public void deleteById(int id) {
    userDAO.deleteById(id);
  }

  public Boolean checkForUniqueEmail(String email) {
    return userDAO.findByEmailUserWithRoles(email) != null;
  }
}
