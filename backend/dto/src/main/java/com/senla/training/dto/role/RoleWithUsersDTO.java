package com.senla.training.dto.role;

import com.senla.training.dto.user.UserDTO;
import java.util.List;

public class RoleWithUsersDTO extends RoleDTO {
  private List<UserDTO> users;

  public RoleWithUsersDTO() {}

  public RoleWithUsersDTO(Integer id, String name, List<UserDTO> users) {
    super(id, name);
    this.users = users;
  }

  public List<UserDTO> getUsers() {
    return users;
  }

  public void setUsers(List<UserDTO> users) {
    this.users = users;
  }
}
