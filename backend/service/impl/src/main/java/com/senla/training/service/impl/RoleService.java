package com.senla.training.service.impl;

import com.senla.training.dao.api.IRoleDAO;
import com.senla.training.dto.RoleDTO;
import com.senla.training.models.Role;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.service.api.IRoleService;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService implements IRoleService {

  private final IRoleDAO roleDAO;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  RoleService(IRoleDAO roleDAO, ObjectMapperUtils objectMapperUtils) {
    this.roleDAO = roleDAO;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public RoleDTO findByIdRoleWithUsersDTO(int id) {
    return objectMapperUtils.map(roleDAO.findByIdRoleWithUsers(id), RoleDTO.class);
  }

  @Override
  public List<RoleDTO> findAllAndSortWithDirectionRoleWithUsersDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        roleDAO.findAllAndSortWithDirectionRoleWithUsers(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        RoleDTO.class);
  }

  @Override
  public RoleDTO findOneByCriteriaRoleWithUsersDTO(Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        roleDAO.findOneByCriteriaRoleWithUsers(fieldCriteriaMap), RoleDTO.class);
  }

  @Override
  public List<RoleDTO> findAllByCriteriaRoleWithUsersDTO(Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        roleDAO.findAllByCriteriaRoleWithUsers(fieldCriteriaMap), RoleDTO.class);
  }

  @Override
  public List<RoleDTO> findByNotNullRoleWithUsersDTO(List<String> fields) {
    return objectMapperUtils.mapAll(roleDAO.findByNotNullRoleWithUsers(fields), RoleDTO.class);
  }

  @Override
  public List<RoleDTO> findByNullRoleWithUsersDTO(List<String> fields) {
    return objectMapperUtils.mapAll(roleDAO.findByNullRoleWithUsers(fields), RoleDTO.class);
  }

  @Override
  public List<RoleDTO> findAndSortRoleWithUsersDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        roleDAO.findAndSortRoleWithUsers(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        RoleDTO.class);
  }

  @Override
  public RoleDTO create(RoleDTO entityDTO) {
    return objectMapperUtils.map(
        roleDAO.create(objectMapperUtils.map(entityDTO, Role.class)), RoleDTO.class);
  }

  @Override
  public RoleDTO update(RoleDTO entityDTO) {
    return objectMapperUtils.map(
        roleDAO.update(objectMapperUtils.map(entityDTO, Role.class)), RoleDTO.class);
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
