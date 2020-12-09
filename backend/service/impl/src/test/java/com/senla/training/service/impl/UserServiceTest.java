package com.senla.training.service.impl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.senla.training.dao.api.IUserDAO;
import com.senla.training.dto.role.RoleDTO;
import com.senla.training.dto.user.UserWithRolesDTO;
import com.senla.training.models.Role;
import com.senla.training.models.User;
import com.senla.training.models.enums.ERole;
import com.senla.training.models.enums.EStatusUser;
import com.senla.training.objectmapper.ObjectMapperUtils;
import java.util.ArrayList;
import java.util.List;
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

  private List<User> users = new ArrayList<>();
  private List<UserWithRolesDTO> usersDTO = new ArrayList<>();

  UserServiceTest() {
    MockitoAnnotations.initMocks(this);

    Role role = new Role();
    role.setName(ERole.ADMIN);

    user =
        new User(
            1, "Ivan", "Ivanov", "dj@gmail.com", "137", EStatusUser.ACTIVE, Set.of(role), null);
    users.add(user);

    users.add(
        new User(
            2, "Navi", "Vonavi", "auf@gmail.com", "111", EStatusUser.ACTIVE, Set.of(role), null));

    RoleDTO roleDTO = new RoleDTO(1, ERole.ADMIN.name());
    userWithRolesDTO =
        new UserWithRolesDTO(
            1, "Ivan", "Ivanov", "dj@gmail.com", "137", EStatusUser.ACTIVE, Set.of(roleDTO));
    usersDTO.add(userWithRolesDTO);
    usersDTO.add(
        new UserWithRolesDTO(
            2, "Navi", "Vonavi", "auf@gmail.com", "111", EStatusUser.ACTIVE, Set.of(roleDTO)));
  }

  @Test
  void findByIdUserWithRolesDTO() {}

  @Test
  void findAllAndSortWithDirectionUserWithRolesDTO() {}

  @Test
  void findOneByCriteriaUserWithRolesDTO() {}

  @Test
  void findAllByCriteriaUserWithRolesDTO() {}

  @Test
  void findByNotNullUserWithRolesDTO() {}

  @Test
  void findByNullUserWithRolesDTO() {}

  @Test
  void findLessThanUserWithRolesDTO() {}

  @Test
  void findGreaterThanUserWithRolesDTO() {}

  @Test
  void findAndSortUserWithRolesDTO() {}

  @Test
  void findContainUserWithRolesDTO() {}

  @Test
  void create() {}

  @Test
  void update() {}

  @Test
  void delete() {
    given(objectMapperUtils.map(userWithRolesDTO, User.class)).willReturn(user);
    userService.delete(userWithRolesDTO);
    verify(userDAO, atLeastOnce()).delete(user);
  }

  @Test
  void deleteById() {}
}
