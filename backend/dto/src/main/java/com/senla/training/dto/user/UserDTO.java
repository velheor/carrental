package com.senla.training.dto.user;

import com.senla.training.models.enums.EStatusUser;

public class UserDTO {
  private Integer id;

  private String firstName;

  private String secondName;

  private String email;

  private String password;

  private EStatusUser statusUser;

  public UserDTO() {}

  public UserDTO(
      Integer id,
      String firstName,
      String secondName,
      String email,
      String password,
      EStatusUser statusUser) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.email = email;
    this.password = password;
    this.statusUser = statusUser;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public EStatusUser getStatusUser() {
    return statusUser;
  }

  public void setStatusUser(EStatusUser statusUser) {
    this.statusUser = statusUser;
  }
}
