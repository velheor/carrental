package com.velheor.carrental.service.impl;

import com.velheor.carrental.dao.api.RoleRepository;
import com.velheor.carrental.dto.RoleDTO;
import com.velheor.carrental.models.Role;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.service.api.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {

  private final RoleRepository roleRepository;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  RoleService(RoleRepository roleRepository, ObjectMapperUtils objectMapperUtils) {
    this.roleRepository = roleRepository;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public RoleDTO findById(Integer id) {
    return roleRepository
        .findById(id)
        .map(car -> objectMapperUtils.map(car, RoleDTO.class))
        .orElse(null);
  }

  @Override
  public RoleDTO create(RoleDTO entityDTO) {
    return objectMapperUtils.map(
        roleRepository.save(objectMapperUtils.map(entityDTO, Role.class)), RoleDTO.class);
  }

  @Override
  public RoleDTO update(RoleDTO entityDTO) {
    if (roleRepository.findById(entityDTO.getId()).isPresent()) {
      objectMapperUtils.map(
          roleRepository.save(objectMapperUtils.map(entityDTO, Role.class)), RoleDTO.class);
    }
    return null;
  }

  @Override
  public void delete(RoleDTO entityDTO) {
    roleRepository.delete(objectMapperUtils.map(entityDTO, Role.class));
  }

  @Override
  public void deleteById(int id) {
    roleRepository.deleteById(id);
  }
}
