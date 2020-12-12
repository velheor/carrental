package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.senla.training.dao.api.IUserDAO;
import com.senla.training.dto.role.RoleDTO;
import com.senla.training.dto.user.UserWithRolesDTO;
import com.senla.training.models.Role;
import com.senla.training.models.User;
import com.senla.training.models.enums.Direction;
import com.senla.training.models.enums.ERole;
import com.senla.training.models.enums.EStatusUser;
import com.senla.training.objectmapper.ObjectMapperUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserServiceTest {

  private final User user;
  private final UserWithRolesDTO userWithRolesDTO;

  @InjectMocks private UserService userService;
  @Mock private IUserDAO userDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  private final List<User> users;
  private final List<UserWithRolesDTO> usersDTO;

  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  private final Map<String, Number> fieldNumberMap;
  private final Map<String, String> fieldContainMap;

  UserServiceTest() {
    MockitoAnnotations.initMocks(this);
    Role role = new Role();
    role.setName(ERole.ADMIN);

    usersDTO = new ArrayList<>();
    users = new ArrayList<>();

    user =
        new User(
            1, "Ivan", "Ivanov", "dj@gmail.com", "137", EStatusUser.ACTIVE, Set.of(role), null);
    users.add(user);

    users.add(
        new User(
            2, "Ivan", "Neivanov", "auf@gmail.com", "111", EStatusUser.ACTIVE, Set.of(role), null));

    RoleDTO roleDTO = new RoleDTO(1, ERole.ADMIN.name());
    userWithRolesDTO =
        new UserWithRolesDTO(
            1, "Ivan", "Ivanov", "dj@gmail.com", "137", EStatusUser.ACTIVE, Set.of(roleDTO));
    usersDTO.add(userWithRolesDTO);
    usersDTO.add(
        new UserWithRolesDTO(
            2, "Ivan", "Neivanov", "auf@gmail.com", "111", EStatusUser.ACTIVE, Set.of(roleDTO)));

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
    fieldNumberMap = new HashMap<>();
    fieldContainMap = new HashMap<>();
  }

  @Test
  void findByIdUserWithRolesDTO() {
    given(userDAO.findByIdUserWithRoles(1)).willReturn(user);
    given(objectMapperUtils.map(user, UserWithRolesDTO.class)).willReturn(userWithRolesDTO);
    assertEquals(userWithRolesDTO, userService.findByIdUserWithRolesDTO(1));
    given(userDAO.findByIdUserWithRoles(1)).willReturn(null);
    assertNull(userService.findByIdUserWithRolesDTO(1));
    given(userDAO.findByIdUserWithRoles(1)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.findByIdUserWithRolesDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionUserWithRolesDTO() {
    given(userDAO.findAllAndSortWithDirectionUserWithRoles(fieldDirectionMap)).willReturn(users);
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(usersDTO);
    assertEquals(
        usersDTO, userService.findAllAndSortWithDirectionUserWithRolesDTO(fieldDirectionStringMap));

    given(userDAO.findAllAndSortWithDirectionUserWithRoles(fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        userService.findAllAndSortWithDirectionUserWithRolesDTO(fieldDirectionStringMap));

    given(userDAO.findAllAndSortWithDirectionUserWithRoles(fieldDirectionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> userService.findAllAndSortWithDirectionUserWithRolesDTO(fieldDirectionStringMap));
  }

  @Test
  void findOneByCriteriaUserWithRolesDTO() {
    given(userDAO.findOneByCriteriaUserWithRoles(fieldCriterionMap)).willReturn(user);
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(usersDTO);
    deepEquals(usersDTO, userService.findOneByCriteriaUserWithRolesDTO(fieldCriterionMap));

    given(userDAO.findOneByCriteriaUserWithRoles(fieldCriterionMap)).willReturn(null);
    given(objectMapperUtils.map(user, UserWithRolesDTO.class)).willReturn(null);
    assertNull(userService.findOneByCriteriaUserWithRolesDTO(fieldCriterionMap));

    given(userDAO.findOneByCriteriaUserWithRoles(fieldCriterionMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> userService.findOneByCriteriaUserWithRolesDTO(fieldCriterionMap));
  }

  @Test
  void findAllByCriteriaUserWithRolesDTO() {
    given(userDAO.findAllByCriteriaUserWithRoles(fieldCriterionMap)).willReturn(users);
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(usersDTO);
    deepEquals(usersDTO, userService.findAllByCriteriaUserWithRolesDTO(fieldCriterionMap));

    given(userDAO.findAllByCriteriaUserWithRoles(fieldCriterionMap)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), userService.findAllByCriteriaUserWithRolesDTO(fieldCriterionMap));

    given(userDAO.findAllByCriteriaUserWithRoles(fieldCriterionMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> userService.findAllByCriteriaUserWithRolesDTO(fieldCriterionMap));
  }

  @Test
  void findByNotNullUserWithRolesDTO() {
    given(userDAO.findByNotNullUserWithRoles(fields)).willReturn(users);
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(usersDTO);
    deepEquals(usersDTO, userService.findByNotNullUserWithRolesDTO(fields));

    given(userDAO.findByNotNullUserWithRoles(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), userService.findByNotNullUserWithRolesDTO(fields));

    given(userDAO.findByNotNullUserWithRoles(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.findByNotNullUserWithRolesDTO(fields));
  }

  @Test
  void findByNullUserWithRolesDTO() {
    given(userDAO.findByNullUserWithRoles(fields)).willReturn(users);
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(usersDTO);
    deepEquals(usersDTO, userService.findByNullUserWithRolesDTO(fields));

    given(userDAO.findByNullUserWithRoles(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), userService.findByNullUserWithRolesDTO(fields));

    given(userDAO.findByNullUserWithRoles(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.findByNullUserWithRolesDTO(fields));
  }

  @Test
  void findLessThanUserWithRolesDTO() {
    given(userDAO.findLessThanUserWithRoles(fieldNumberMap)).willReturn(users);
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(usersDTO);
    deepEquals(usersDTO, userService.findLessThanUserWithRolesDTO(fieldNumberMap));

    given(userDAO.findLessThanUserWithRoles(fieldNumberMap)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), userService.findLessThanUserWithRolesDTO(fieldNumberMap));

    given(userDAO.findLessThanUserWithRoles(fieldNumberMap)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.findLessThanUserWithRolesDTO(fieldNumberMap));
  }

  @Test
  void findGreaterThanUserWithRolesDTO() {
    given(userDAO.findGreaterThanUserWithRoles(fieldNumberMap)).willReturn(users);
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(usersDTO);
    deepEquals(usersDTO, userService.findGreaterThanUserWithRolesDTO(fieldNumberMap));

    given(userDAO.findGreaterThanUserWithRoles(fieldNumberMap)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), userService.findGreaterThanUserWithRolesDTO(fieldNumberMap));

    given(userDAO.findGreaterThanUserWithRoles(fieldNumberMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> userService.findGreaterThanUserWithRolesDTO(fieldNumberMap));
  }

  @Test
  void findContainUserWithRolesDTO() {
    given(userDAO.findContainUserWithRoles(fieldContainMap)).willReturn(users);
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(usersDTO);
    deepEquals(usersDTO, userService.findContainUserWithRolesDTO(fieldContainMap));

    given(userDAO.findContainUserWithRoles(fieldContainMap)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), userService.findContainUserWithRolesDTO(fieldContainMap));

    given(userDAO.findContainUserWithRoles(fieldContainMap)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.findContainUserWithRolesDTO(fieldContainMap));
  }

  @Test
  void findAndSortUserWithRolesDTO() {

    given(userDAO.findAndSortUserWithRoles(fieldDirectionMap, fieldCriterionMap)).willReturn(users);
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(usersDTO);
    deepEquals(
        usersDTO,
        userService.findAndSortUserWithRolesDTO(fieldDirectionStringMap, fieldCriterionMap));

    given(userDAO.findAndSortUserWithRoles(fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(users, UserWithRolesDTO.class)).willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        userService.findAndSortUserWithRolesDTO(fieldDirectionStringMap, fieldCriterionMap));

    given(userDAO.findAndSortUserWithRoles(fieldDirectionMap, fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> userService.findAndSortUserWithRolesDTO(fieldDirectionStringMap, fieldCriterionMap));
  }

  @Test
  void create() {
    given(userDAO.create(user)).willReturn(user);
    given(userDAO.findByEmailUserWithRoles(user.getEmail())).willReturn(null);
    given(objectMapperUtils.map(userWithRolesDTO, User.class)).willReturn(user);
    deepEquals(user, userService.create(userWithRolesDTO));

    given(userDAO.create(user)).willReturn(null);
    assertNull(userService.create(userWithRolesDTO));

    given(userDAO.create(user)).willThrow(Exception.class);
    given(userDAO.findByEmailUserWithRoles(user.getEmail())).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.create(userWithRolesDTO));
  }

  @Test
  void update() {
    given(userDAO.update(user)).willReturn(user);
    given(objectMapperUtils.map(userWithRolesDTO, User.class)).willReturn(user);
    assertEquals(userWithRolesDTO, userService.update(userWithRolesDTO));

    given(userDAO.update(user)).willReturn(null);
    assertNull(userService.update(userWithRolesDTO));

    given(userDAO.update(user)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.update(userWithRolesDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(userWithRolesDTO, User.class)).willReturn(user);
    userService.delete(userWithRolesDTO);
    verify(userDAO, atLeastOnce()).delete(user);

    given(userDAO.update(user)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.update(userWithRolesDTO));
  }

  @Test
  void deleteById() {
    int id = 1;
    given(userDAO.findByIdUserWithRoles(id)).willReturn(user);
    userService.deleteById(id);
    verify(userDAO, atLeastOnce()).deleteById(id);
  }

  @Test
  void checkForExistEmail() {
    String email = "test@gmail.com";
    given(userDAO.findByEmailUserWithRoles(email)).willReturn(user);
    userService.checkForExistEmail(email);
    verify(userDAO, atLeastOnce()).findByEmailUserWithRoles(email);

    given(userDAO.findByEmailUserWithRoles(email)).willReturn(null);
    assertFalse(userService.checkForExistEmail(email));

    given(userDAO.findByEmailUserWithRoles(email)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.checkForExistEmail(email));
  }
}
