package com.senla.training.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;

public class RoleDTO {

  private Integer id;

  private String name;

  @JsonIgnoreProperties("roles")
  private List<UserDTO> users;

  public RoleDTO() {
  }

  public RoleDTO(Integer id, String name, List<UserDTO> users) {
    this.id = id;
    this.name = name;
    this.users = users;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<UserDTO> getUsers() {
    return users;
  }

  public void setUsers(List<UserDTO> users) {
    this.users = users;
  }
}
