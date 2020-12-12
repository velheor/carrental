package com.senla.training.service.impl;

import com.senla.training.dao.api.IRoleDAO;
import com.senla.training.dto.role.RoleDTO;
import com.senla.training.dto.role.RoleWithUsersDTO;
import com.senla.training.models.Role;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IRoleService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
  private final IRoleDAO roleDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  RoleService(IRoleDAO roleDAO, ObjectMapperUtils objectMapperUtils) {
    this.roleDAO = roleDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public RoleWithUsersDTO findByIdRoleWithUsersDTO(int id) {
    return objectMapperUtils.map(roleDAO.findByIdRoleWithUsers(id), RoleWithUsersDTO.class);
  }

  @Override
  public List<RoleWithUsersDTO> findAllAndSortWithDirectionRoleWithUsersDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        roleDAO.findAllAndSortWithDirectionRoleWithUsers(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        RoleWithUsersDTO.class);
  }

  @Override
  public RoleWithUsersDTO findOneByCriteriaRoleWithUsersDTO(Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        roleDAO.findOneByCriteriaRoleWithUsers(fieldCriteriaMap), RoleWithUsersDTO.class);
  }

  @Override
  public List<RoleWithUsersDTO> findAllByCriteriaRoleWithUsersDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        roleDAO.findAllByCriteriaRoleWithUsers(fieldCriteriaMap), RoleWithUsersDTO.class);
  }

  @Override
  public List<RoleWithUsersDTO> findByNotNullRoleWithUsersDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        roleDAO.findByNotNullRoleWithUsers(fields), RoleWithUsersDTO.class);
  }

  @Override
  public List<RoleWithUsersDTO> findByNullRoleWithUsersDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        roleDAO.findByNullRoleWithUsers(fields), RoleWithUsersDTO.class);
  }

  @Override
  public List<RoleWithUsersDTO> findLessThanRoleWithUsersDTO(Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        roleDAO.findLessThanRoleWithUsers(fieldNumberMap), RoleWithUsersDTO.class);
  }

  @Override
  public List<RoleWithUsersDTO> findGreaterThanRoleWithUsersDTO(
      Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        roleDAO.findGreaterThanRoleWithUsers(fieldNumberMap), RoleWithUsersDTO.class);
  }

  @Override
  public List<RoleWithUsersDTO> findAndSortRoleWithUsersDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        roleDAO.findAndSortRoleWithUsers(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        RoleWithUsersDTO.class);
  }

  @Override
  public List<RoleWithUsersDTO> findContainRoleWithUsersDTO(Map<String, String> fieldStringMap) {
    return objectMapperUtils.mapAll(
        roleDAO.findContainRoleWithUsers(fieldStringMap), RoleWithUsersDTO.class);
  }

  @Override
  public RoleDTO create(RoleDTO entityDTO) {
    roleDAO.create(objectMapperUtils.map(entityDTO, Role.class));
    return entityDTO;
  }

  @Override
  public RoleDTO update(RoleDTO entityDTO) {
    roleDAO.update(objectMapperUtils.map(entityDTO, Role.class));
    return entityDTO;
  }

  @Override
  public void delete(RoleDTO entityDTO) {
    roleDAO.delete(objectMapperUtils.map(entityDTO, Role.class));
  }

  @Override
  public void deleteById(int id) {
    roleDAO.deleteById(id);
  }
}
