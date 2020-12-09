package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import com.senla.training.dao.api.IRoleDAO;
import com.senla.training.dto.role.RoleWithUsersDTO;
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
  private final RoleWithUsersDTO roleWithUsersDTO;

  private final List<Role> roles;
  private final List<RoleWithUsersDTO> roleWithUsersDTOList;

  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  private final Map<String, Number> fieldNumberMap;
  private final Map<String, String> fieldContainMap;

  public RoleServiceTest() {
    MockitoAnnotations.initMocks(this);

    role = new Role();
    roleWithUsersDTO = new RoleWithUsersDTO();

    roles = new ArrayList<>();
    roleWithUsersDTOList = new ArrayList<>();

    roles.add(role);
    roles.add(new Role());

    roleWithUsersDTOList.add(roleWithUsersDTO);
    roleWithUsersDTOList.add(new RoleWithUsersDTO());

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
    fieldNumberMap = new HashMap<>();
    fieldContainMap = new HashMap<>();
  }

  @Test
  void findByIdRoleWithUsersDTO() {
    given(roleDAO.findByIdRoleWithUsers(1)).willReturn(role);
    given(objectMapperUtils.map(role, RoleWithUsersDTO.class)).willReturn(roleWithUsersDTO);
    assertEquals(roleWithUsersDTO, roleService.findByIdRoleWithUsersDTO(1));
    given(roleDAO.findByIdRoleWithUsers(1)).willReturn(null);
    assertNull(roleService.findByIdRoleWithUsersDTO(1));
    given(roleDAO.findByIdRoleWithUsers(1)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> roleService.findByIdRoleWithUsersDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionRoleWithUsersDTO() {
    given(roleDAO.findAllAndSortWithDirectionRoleWithUsers(fieldDirectionMap)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(roleWithUsersDTOList);
    assertEquals(
        roleWithUsersDTOList,
        roleService.findAllAndSortWithDirectionRoleWithUsersDTO(fieldDirectionStringMap));

    given(roleDAO.findAllAndSortWithDirectionRoleWithUsers(fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(new ArrayList<>());
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
    given(objectMapperUtils.map(role, RoleWithUsersDTO.class)).willReturn(roleWithUsersDTO);
    assertEquals(
        roleWithUsersDTO, roleService.findOneByCriteriaRoleWithUsersDTO(fieldCriterionMap));

    given(roleDAO.findOneByCriteriaRoleWithUsers(fieldCriterionMap)).willReturn(null);
    given(objectMapperUtils.map(role, RoleWithUsersDTO.class)).willReturn(null);
    assertNull(roleService.findOneByCriteriaRoleWithUsersDTO(fieldCriterionMap));

    given(roleDAO.findOneByCriteriaRoleWithUsers(fieldCriterionMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> roleService.findOneByCriteriaRoleWithUsersDTO(fieldCriterionMap));
  }

  @Test
  void findAllByCriteriaRoleWithUsersDTO() {
    given(roleDAO.findAllByCriteriaRoleWithUsers(fieldCriterionMap)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(roleWithUsersDTOList);
    assertEquals(
        roleWithUsersDTOList, roleService.findAllByCriteriaRoleWithUsersDTO(fieldCriterionMap));

    given(roleDAO.findAllByCriteriaRoleWithUsers(fieldCriterionMap)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), roleService.findAllByCriteriaRoleWithUsersDTO(fieldCriterionMap));

    given(roleDAO.findAllByCriteriaRoleWithUsers(fieldCriterionMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> roleService.findAllByCriteriaRoleWithUsersDTO(fieldCriterionMap));
  }

  @Test
  void findByNotNullRoleWithUsersDTO() {
    given(roleDAO.findByNotNullRoleWithUsers(fields)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(roleWithUsersDTOList);
    assertEquals(roleWithUsersDTOList, roleService.findByNotNullRoleWithUsersDTO(fields));

    given(roleDAO.findByNotNullRoleWithUsers(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), roleService.findByNotNullRoleWithUsersDTO(fields));

    given(roleDAO.findByNotNullRoleWithUsers(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> roleService.findByNotNullRoleWithUsersDTO(fields));
  }

  @Test
  void findByNullRoleWithUsersDTO() {
    given(roleDAO.findByNullRoleWithUsers(fields)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(roleWithUsersDTOList);
    assertEquals(roleWithUsersDTOList, roleService.findByNullRoleWithUsersDTO(fields));

    given(roleDAO.findByNullRoleWithUsers(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), roleService.findByNullRoleWithUsersDTO(fields));

    given(roleDAO.findByNullRoleWithUsers(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> roleService.findByNullRoleWithUsersDTO(fields));
  }

  @Test
  void findLessThanRoleWithUsersDTO() {
    given(roleDAO.findLessThanRoleWithUsers(fieldNumberMap)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(roleWithUsersDTOList);
    assertEquals(roleWithUsersDTOList, roleService.findLessThanRoleWithUsersDTO(fieldNumberMap));

    given(roleDAO.findLessThanRoleWithUsers(fieldNumberMap)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), roleService.findLessThanRoleWithUsersDTO(fieldNumberMap));

    given(roleDAO.findLessThanRoleWithUsers(fieldNumberMap)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> roleService.findLessThanRoleWithUsersDTO(fieldNumberMap));
  }

  @Test
  void findGreaterThanRoleWithUsersDTO() {
    given(roleDAO.findGreaterThanRoleWithUsers(fieldNumberMap)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(roleWithUsersDTOList);
    assertEquals(roleWithUsersDTOList, roleService.findGreaterThanRoleWithUsersDTO(fieldNumberMap));

    given(roleDAO.findGreaterThanRoleWithUsers(fieldNumberMap)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), roleService.findGreaterThanRoleWithUsersDTO(fieldNumberMap));

    given(roleDAO.findGreaterThanRoleWithUsers(fieldNumberMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> roleService.findGreaterThanRoleWithUsersDTO(fieldNumberMap));
  }

  @Test
  void findContainRoleWithUsersDTO() {
    given(roleDAO.findContainRoleWithUsers(fieldContainMap)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(roleWithUsersDTOList);
    assertEquals(roleWithUsersDTOList, roleService.findContainRoleWithUsersDTO(fieldContainMap));

    given(roleDAO.findContainRoleWithUsers(fieldContainMap)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), roleService.findContainRoleWithUsersDTO(fieldContainMap));

    given(roleDAO.findContainRoleWithUsers(fieldContainMap)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> roleService.findContainRoleWithUsersDTO(fieldContainMap));
  }

  @Test
  void findAndSortRoleWithUsersDTO() {
    given(roleDAO.findAndSortRoleWithUsers(fieldDirectionMap, fieldCriterionMap)).willReturn(roles);
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(roleWithUsersDTOList);
    assertEquals(
        roleWithUsersDTOList,
        roleService.findAndSortRoleWithUsersDTO(fieldDirectionStringMap, fieldCriterionMap));

    given(roleDAO.findAndSortRoleWithUsers(fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(roles, RoleWithUsersDTO.class)).willReturn(new ArrayList<>());
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
  void create() {}

  @Test
  void update() {}

  @Test
  void delete() {}

  @Test
  void deleteById() {}
}
