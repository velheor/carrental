package com.senla.training.dto.user;

import com.senla.training.dto.role.RoleDTO;
import com.senla.training.models.enums.EStatusUser;
import java.util.Set;

public class UserWithRolesDTO extends UserDTO {
  private Set<RoleDTO> roles;

  public UserWithRolesDTO() {}

  public UserWithRolesDTO(
      Integer id,
      String firstName,
      String secondName,
      String email,
      String password,
      EStatusUser statusUser,
      Set<RoleDTO> roles) {
    super(id, firstName, secondName, email, password, statusUser);
    this.roles = roles;
  }

  public Set<RoleDTO> getRoles() {
    return roles;
  }

  public void setRoles(Set<RoleDTO> roles) {
    this.roles = roles;
  }
}
