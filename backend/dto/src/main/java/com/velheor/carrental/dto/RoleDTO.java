package com.velheor.carrental.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.velheor.carrental.models.enums.ERole;
import java.util.List;

public class RoleDTO {

  private Integer id;

  private ERole name;

  @JsonIgnoreProperties("roles")
  private List<UserDTO> users;

  public RoleDTO() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ERole getName() {
    return name;
  }

  public void setName(ERole name) {
    this.name = name;
  }

  public List<UserDTO> getUsers() {
    return users;
  }

  public void setUsers(List<UserDTO> users) {
    this.users = users;
  }
}
