package com.velheor.carrental.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.velheor.carrental.dao.api.IUserDAO;
import com.velheor.carrental.dto.UserDTO;
import com.velheor.carrental.dto.UserWithTokenDTO;
import com.velheor.carrental.models.Role;
import com.velheor.carrental.models.User;
import com.velheor.carrental.models.enums.Direction;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.security.jwt.JwtTokenProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

class UserServiceTest {

  private final User user;

  private final UserDTO userDTO;

  private final UserWithTokenDTO userWithTokenDTO;

  private final UserDetails userDetails;

  private final List<User> users;
  private final List<UserDTO> usersDTO;
  private final Set<Role> roles;
  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;

  @InjectMocks private UserService userService;
  @Mock private IUserDAO userDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;
  @Mock private PasswordEncoder passwordEncoder;
  @Mock private JwtTokenProvider jwtTokenProvider;
  @Mock private AuthenticationManager authenticationManager;

  UserServiceTest() {
    MockitoAnnotations.initMocks(this);

    this.userWithTokenDTO = Mockito.spy(UserWithTokenDTO.class);
    this.userDetails = Mockito.spy(UserDetails.class);

    this.users = new ArrayList<>();
    this.user = Mockito.spy(User.class);
    User user = Mockito.spy(User.class);
    this.users.add(user);
    this.users.add(user);

    this.usersDTO = new ArrayList<>();
    this.userDTO = Mockito.spy(UserDTO.class);
    UserDTO userDTO = Mockito.spy(UserDTO.class);
    this.usersDTO.add(userDTO);
    this.usersDTO.add(userDTO);

    this.roles = new HashSet<>();
    Role role = Mockito.spy(Role.class);
    this.roles.add(role);

    this.fieldDirectionStringMap = new HashMap<>();
    this.fieldCriterionMap = new HashMap<>();
    this.fieldDirectionMap = new HashMap<>();
    this.fields = new ArrayList<>();
  }

  @Test
  void findByIdUserWithRolesDTO() {
    given(userDAO.findByIdUserWithRoles(1)).willReturn(user);
    given(objectMapperUtils.map(user, UserDTO.class)).willReturn(userDTO);
    assertEquals(userDTO, userService.findByIdUserWithRolesDTO(1));
    given(userDAO.findByIdUserWithRoles(1)).willReturn(null);
    assertNull(userService.findByIdUserWithRolesDTO(1));
    given(userDAO.findByIdUserWithRoles(1)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.findByIdUserWithRolesDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionUserWithRolesDTO() {
    given(userDAO.findAllAndSortWithDirectionUserWithRoles(fieldDirectionMap)).willReturn(users);
    given(objectMapperUtils.mapAll(users, UserDTO.class)).willReturn(usersDTO);
    assertEquals(
        usersDTO, userService.findAllAndSortWithDirectionUserWithRolesDTO(fieldDirectionStringMap));

    given(userDAO.findAllAndSortWithDirectionUserWithRoles(fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(users, UserDTO.class)).willReturn(new ArrayList<>());
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
    given(objectMapperUtils.mapAll(users, UserDTO.class)).willReturn(usersDTO);
    deepEquals(usersDTO, userService.findOneByCriteriaUserWithRolesDTO(fieldCriterionMap));

    given(userDAO.findOneByCriteriaUserWithRoles(fieldCriterionMap)).willReturn(null);
    given(objectMapperUtils.map(user, UserDTO.class)).willReturn(null);
    assertNull(userService.findOneByCriteriaUserWithRolesDTO(fieldCriterionMap));

    given(userDAO.findOneByCriteriaUserWithRoles(fieldCriterionMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> userService.findOneByCriteriaUserWithRolesDTO(fieldCriterionMap));
  }

  @Test
  void findAllByCriteriaUserWithRolesDTO() {
    given(userDAO.findAllByCriteriaUserWithRoles(fieldCriterionMap)).willReturn(users);
    given(objectMapperUtils.mapAll(users, UserDTO.class)).willReturn(usersDTO);
    deepEquals(usersDTO, userService.findAllByCriteriaUserWithRolesDTO(fieldCriterionMap));

    given(userDAO.findAllByCriteriaUserWithRoles(fieldCriterionMap)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(users, UserDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), userService.findAllByCriteriaUserWithRolesDTO(fieldCriterionMap));

    given(userDAO.findAllByCriteriaUserWithRoles(fieldCriterionMap)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> userService.findAllByCriteriaUserWithRolesDTO(fieldCriterionMap));
  }

  @Test
  void findByNotNullUserWithRolesDTO() {
    given(userDAO.findByNotNullUserWithRoles(fields)).willReturn(users);
    given(objectMapperUtils.mapAll(users, UserDTO.class)).willReturn(usersDTO);
    deepEquals(usersDTO, userService.findByNotNullUserWithRolesDTO(fields));

    given(userDAO.findByNotNullUserWithRoles(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(users, UserDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), userService.findByNotNullUserWithRolesDTO(fields));

    given(userDAO.findByNotNullUserWithRoles(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.findByNotNullUserWithRolesDTO(fields));
  }

  @Test
  void findByNullUserWithRolesDTO() {
    given(userDAO.findByNullUserWithRoles(fields)).willReturn(users);
    given(objectMapperUtils.mapAll(users, UserDTO.class)).willReturn(usersDTO);
    deepEquals(usersDTO, userService.findByNullUserWithRolesDTO(fields));

    given(userDAO.findByNullUserWithRoles(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(users, UserDTO.class)).willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), userService.findByNullUserWithRolesDTO(fields));

    given(userDAO.findByNullUserWithRoles(fields)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.findByNullUserWithRolesDTO(fields));
  }

  @Test
  void findAndSortUserWithRolesDTO() {

    given(userDAO.findAndSortUserWithRoles(fieldDirectionMap, fieldCriterionMap)).willReturn(users);
    given(objectMapperUtils.mapAll(users, UserDTO.class)).willReturn(usersDTO);
    deepEquals(
        usersDTO,
        userService.findAndSortUserWithRolesDTO(fieldDirectionStringMap, fieldCriterionMap));

    given(userDAO.findAndSortUserWithRoles(fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(users, UserDTO.class)).willReturn(new ArrayList<>());
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
    given(userDAO.findByEmailUserWithRoles(user.getEmail())).willReturn(user);
    given(user.getPassword()).willReturn("password");
    given(passwordEncoder.encode(user.getPassword())).willReturn("encodePassword");
    given(objectMapperUtils.map(user, UserDTO.class)).willReturn(userDTO);
    deepEquals(userDTO, userService.create(userDTO));

    given(userDAO.create(user)).willReturn(null);
    given(objectMapperUtils.map(user, UserDTO.class)).willReturn(null);
    assertNull(userService.create(userDTO));

    given(userDAO.create(user)).willThrow(Exception.class);
    given(userDAO.findByEmailUserWithRoles(user.getEmail())).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.create(userDTO));
  }

  @Test
  void update() {
    given(userDAO.update(user)).willReturn(user);
    given(objectMapperUtils.map(userDTO, User.class)).willReturn(user);
    given(objectMapperUtils.map(user, UserDTO.class)).willReturn(userDTO);
    assertEquals(userDTO, userService.update(userDTO));

    given(objectMapperUtils.map(userDTO, User.class)).willReturn(null);
    given(userDAO.update(user)).willReturn(null);
    assertNull(userService.update(userDTO));

    given(objectMapperUtils.map(userDTO, User.class)).willReturn(user);
    given(userDAO.update(user)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.update(userDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(userDTO, User.class)).willReturn(user);
    userService.delete(userDTO);
    verify(userDAO, atLeastOnce()).delete(user);
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
    assertTrue(userService.checkForExistEmail(email));

    given(userDAO.findByEmailUserWithRoles(email)).willReturn(null);
    assertFalse(userService.checkForExistEmail(email));

    given(userDAO.findByEmailUserWithRoles(email)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.checkForExistEmail(email));
  }

  @Test
  public void getUserWithTokenDTO() {
    String email = "test@gmail.com";
    String token = "jwt";
    given(userWithTokenDTO.getEmail()).willReturn(email);
    given(userDAO.findByEmailUserWithRoles(email)).willReturn(user);
    given(user.getEmail()).willReturn(email);
    given(user.getRoles()).willReturn(roles);
    given(jwtTokenProvider.createToken(email, roles)).willReturn(token);
    assertEquals(userWithTokenDTO, userService.getUserWithTokenDTO(userWithTokenDTO));

    userService.getUserWithTokenDTO(userWithTokenDTO);
    verify(userWithTokenDTO, atLeastOnce()).setToken(token);

    given(userDAO.findByEmailUserWithRoles(email)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.getUserWithTokenDTO(userWithTokenDTO));
  }

  @Test
  public void findCurrentUser() {
    String email = "test@gmail.com";
    given(userDetails.getUsername()).willReturn(email);
    given(userDAO.findByEmailUserWithRents(email)).willReturn(user);
    given(objectMapperUtils.map(user, UserDTO.class)).willReturn(userDTO);
    assertEquals(userDTO, userService.findCurrentUser(userDetails));

    given(userDetails.getUsername()).willReturn(email);
    given(userDAO.findByEmailUserWithRents(email)).willReturn(null);
    given(objectMapperUtils.map(user, UserDTO.class)).willReturn(null);
    assertNull(userService.findCurrentUser(userDetails));

    given(userDetails.getUsername()).willReturn(email);
    given(userDAO.findByEmailUserWithRents(email)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.findCurrentUser(userDetails));
  }

  @Test
  public void updateCurrentUser() {
    String email = "test@gmail.com";

    given(userDetails.getUsername()).willReturn(email);
    given(userDTO.getEmail()).willReturn(email);
    given(objectMapperUtils.map(userDTO, User.class)).willReturn(user);
    given(userDAO.update(user)).willReturn(user);
    given(objectMapperUtils.map(user, UserDTO.class)).willReturn(userDTO);
    assertEquals(userDTO, userService.updateCurrentUser(userDetails, userDTO));

    given(userDAO.update(user)).willReturn(null);
    given(objectMapperUtils.map(userDAO.update(user), UserDTO.class)).willReturn(null);
    assertNull(userService.updateCurrentUser(userDetails, userDTO));

    given(userDAO.update(user)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.updateCurrentUser(userDetails, userDTO));
  }

  @Test
  public void deleteCurrentUser() {
    given(userDetails.getUsername()).willReturn("user");
    given(userDAO.findByEmailUserWithRents(userDetails.getUsername())).willReturn(user);
    userService.deleteCurrentUser(userDetails);
    verify(userDAO, atLeastOnce()).delete(user);
    given(objectMapperUtils.map(user, UserDTO.class)).willReturn(userDTO);
    assertEquals(userDTO, userService.deleteCurrentUser(userDetails));

    given(userDAO.findByEmailUserWithRents(userDetails.getUsername())).willReturn(null);
    given(
            objectMapperUtils.map(
                (userDAO.findByEmailUserWithRents(userDetails.getUsername())), UserDTO.class))
        .willReturn(null);
    assertNull(userService.deleteCurrentUser(userDetails));

    given(userDAO.findByEmailUserWithRents(userDetails.getUsername())).willThrow(Exception.class);
    assertThrows(Exception.class, () -> userService.deleteCurrentUser(userDetails));
  }
}
