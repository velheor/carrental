package com.senla.training.dto.user;

public class UserWithTokenDTO {
  private String email;

  private String password;

  private String token;

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

  public UserWithTokenDTO() {}

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
