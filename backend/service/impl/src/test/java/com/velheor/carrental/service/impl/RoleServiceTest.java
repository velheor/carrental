package com.velheor.carrental.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.velheor.carrental.dao.api.IRoleDAO;
import com.velheor.carrental.dto.RoleDTO;
import com.velheor.carrental.models.Role;
import com.velheor.carrental.models.enums.Direction;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class RoleServiceTest {

  private final Role role;
  private final RoleDTO roleDTO;
  private final List<Role> roles;
  private final List<RoleDTO> roleDTOList;
  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  @InjectMocks private RoleService roleService;
  @Mock private IRoleDAO roleDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  public RoleServiceTest() {
    MockitoAnnotations.initMocks(this);

    roles = new ArrayList<>();
    this.role = Mockito.spy(Role.class);
    Role role = Mockito.spy(Role.class);

    roles.add(this.role);
    roles.add(role);

    roleDTOList = new ArrayList<>();
    this.roleDTO = Mockito.spy(RoleDTO.class);
    RoleDTO roleDTO = Mockito.spy(RoleDTO.class);

    roleDTOList.add(this.roleDTO);
    roleDTOList.add(roleDTO);

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
  }

  @Test
  void findByIdRoleWithUsersDTO() {
    given(roleDAO.findByIdRoleWithUsers(1)).willReturn(role);
    given(objectMapperUtils.map(role, RoleDTO.class)).willReturn(roleDTO);
    assertEquals(roleDTO, roleService.findByIdRoleWithUsersDTO(1));
    given(roleDAO.findByIdRoleWithUsers(1)).willReturn(null);
    assertNull(roleService.findByIdRoleWithUsersDTO(1));
    given(roleDAO.findByIdRoleWithUsers(1)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> roleService.findByIdRoleWithUsersDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionRoleWithUsersDTO() {
    given(roleDAO.findAllAndSortWithDirectionRoleWithUsers(fieldDirectionMap)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleDTO.class)).willReturn(roleDTOList);
    assertEquals(
        roleDTOList,
        roleService.findAllAndSortWithDirectionRoleWithUsersDTO(fieldDirectionStringMap));

    given(roleDAO.findAllAndSortWithDirectionRoleWithUsers(fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleDTO.class)).willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        roleService.findAllAndSortWithDirectionRoleWithUsersDTO(fieldDirectionStringMap));

    given(roleDAO.findAllAndSortWithDirectionRoleWithUsers(fieldDirectionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> roleService.findAllAndSortWithDirectionRoleWithUsersDTO(fieldDirectionStringMap));
  }

  @Test
  void findOneByCriteriaRoleWithUsersDTO() {
    given(roleDAO.findOneByCriteriaRoleWithUsers(fieldCriterionMap)).willReturn(role);
    given(objectMapperUtils.map(role, RoleDTO.class)).willReturn(roleDTO);
    assertEquals(roleDTO, roleService.findOneByCriteriaRoleWithUsersDTO(fieldCriterionMap));

    given(roleDAO.findOneByCriteriaRoleWithUsers(fieldCriterionMap)).willReturn(null);
    given(objectMapperUtils.map(role, RoleDTO.class)).willReturn(null);
    assertNull(roleService.findOneByCriteriaRoleWithUsersDTO(fieldCriterionMap));

    given(roleDAO.findOneByCriteriaRoleWithUsers(fieldCriterionMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> roleService.findOneByCriteriaRoleWithUsersDTO(fieldCriterionMap));
  }

  @Test
  void findAllByCriteriaRoleWithUsersDTO() {
    given(roleDAO.findAllByCriteriaRoleWithUsers(fieldCriterionMap)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleDTO.class)).willReturn(roleDTOList);
    assertEquals(roleDTOList, roleService.findAllByCriteriaRoleWithUsersDTO(fieldCriterionMap));

    given(roleDAO.findAllByCriteriaRoleWithUsers(fieldCriterionMap)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), roleService.findAllByCriteriaRoleWithUsersDTO(fieldCriterionMap));

    given(roleDAO.findAllByCriteriaRoleWithUsers(fieldCriterionMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> roleService.findAllByCriteriaRoleWithUsersDTO(fieldCriterionMap));
  }

  @Test
  void findByNotNullRoleWithUsersDTO() {
    given(roleDAO.findByNotNullRoleWithUsers(fields)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleDTO.class)).willReturn(roleDTOList);
    assertEquals(roleDTOList, roleService.findByNotNullRoleWithUsersDTO(fields));

    given(roleDAO.findByNotNullRoleWithUsers(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), roleService.findByNotNullRoleWithUsersDTO(fields));

    given(roleDAO.findByNotNullRoleWithUsers(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> roleService.findByNotNullRoleWithUsersDTO(fields));
  }

  @Test
  void findByNullRoleWithUsersDTO() {
    given(roleDAO.findByNullRoleWithUsers(fields)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleDTO.class)).willReturn(roleDTOList);
    assertEquals(roleDTOList, roleService.findByNullRoleWithUsersDTO(fields));

    given(roleDAO.findByNullRoleWithUsers(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), roleService.findByNullRoleWithUsersDTO(fields));

    given(roleDAO.findByNullRoleWithUsers(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> roleService.findByNullRoleWithUsersDTO(fields));
  }

  @Test
  void findAndSortRoleWithUsersDTO() {
    given(roleDAO.findAndSortRoleWithUsers(fieldDirectionMap, fieldCriterionMap)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleDTO.class)).willReturn(roleDTOList);
    assertEquals(
        roleDTOList,
        roleService.findAndSortRoleWithUsersDTO(fieldDirectionStringMap, fieldCriterionMap));

    given(roleDAO.findAndSortRoleWithUsers(fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleDTO.class)).willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        roleService.findAndSortRoleWithUsersDTO(fieldDirectionStringMap, fieldCriterionMap));

    given(roleDAO.findAndSortRoleWithUsers(fieldDirectionMap, fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> roleService.findAndSortRoleWithUsersDTO(fieldDirectionStringMap, fieldCriterionMap));
  }

  @Test
  void create() {
    given(roleDAO.create(role)).willReturn(role);
    given(objectMapperUtils.map(roleDTO, Role.class)).willReturn(role);
    given(objectMapperUtils.map(role, RoleDTO.class)).willReturn(roleDTO);
    assertEquals(roleDTO, roleService.create(roleDTO));

    given(roleDAO.create(role)).willReturn(null);
    assertNull(roleService.create(roleDTO));

    given(roleDAO.create(role)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> roleService.create(roleDTO));
  }

  @Test
  void update() {
    given(roleDAO.update(role)).willReturn(role);
    given(objectMapperUtils.map(roleDTO, Role.class)).willReturn(role);
    given(objectMapperUtils.map(role, RoleDTO.class)).willReturn(roleDTO);
    assertEquals(roleDTO, roleService.update(roleDTO));

    given(roleDAO.update(role)).willReturn(null);
    assertNull(roleService.update(roleDTO));

    given(roleDAO.update(role)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> roleService.update(roleDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(roleDTO, Role.class)).willReturn(role);
    roleService.delete(roleDTO);
    verify(roleDAO, atLeastOnce()).delete(role);

    given(roleDAO.update(role)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> roleService.update(roleDTO));
  }

  @Test
  void deleteById() {
    int id = 1;
    roleService.deleteById(id);
    verify(roleDAO, atLeastOnce()).deleteById(id);
  }
}
