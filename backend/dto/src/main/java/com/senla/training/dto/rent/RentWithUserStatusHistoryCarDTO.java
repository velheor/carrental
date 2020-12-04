package com.senla.training.dto.rent;

import com.senla.training.dto.user.UserDTO;

public class RentWithUserStatusHistoryCarDTO extends RentWithCarDTO {
  private UserDTO user;

  public UserDTO getUser() {
    return user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
  }
}
