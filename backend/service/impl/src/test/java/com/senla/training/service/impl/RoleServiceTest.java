package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.senla.training.dao.api.IRoleDAO;
import com.senla.training.dto.RoleDTO;
import com.senla.training.models.Role;
import com.senla.training.models.enums.Direction;
import com.senla.training.objectmapper.ObjectMapperUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RoleServiceTest {
  @InjectMocks private RoleService roleService;
  @Mock private IRoleDAO roleDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  private final Role role;
  private final RoleDTO roleDTO;

  private final List<Role> roles;
  private final List<RoleDTO> roleDTOList;

  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  private final Map<String, String> fieldContainMap;

  public RoleServiceTest() {
    MockitoAnnotations.initMocks(this);

    role = new Role();
    roleDTO = new RoleDTO();

    roles = new ArrayList<>();
    roleDTOList = new ArrayList<>();

    roles.add(role);
    roles.add(new Role());

    roleDTOList.add(roleDTO);
    roleDTOList.add(new RoleDTO());

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
    fieldContainMap = new HashMap<>();
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
    assertEquals(
        roleDTO, roleService.findOneByCriteriaRoleWithUsersDTO(fieldCriterionMap));

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
    assertEquals(
        roleDTOList, roleService.findAllByCriteriaRoleWithUsersDTO(fieldCriterionMap));

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
  void findContainRoleWithUsersDTO() {
    given(roleDAO.findContainRoleWithUsers(fieldContainMap)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleDTO.class)).willReturn(roleDTOList);
    assertEquals(roleDTOList, roleService.findContainRoleWithUsersDTO(fieldContainMap));

    given(roleDAO.findContainRoleWithUsers(fieldContainMap)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), roleService.findContainRoleWithUsersDTO(fieldContainMap));

    given(roleDAO.findContainRoleWithUsers(fieldContainMap)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> roleService.findContainRoleWithUsersDTO(fieldContainMap));
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
