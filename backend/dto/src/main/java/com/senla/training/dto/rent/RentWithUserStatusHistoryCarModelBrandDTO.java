package com.senla.training.dto.rent;

import com.senla.training.dto.car.CarWithModelBrandDTO;
import com.senla.training.dto.statusHistory.StatusHistoryDTO;
import com.senla.training.dto.user.UserDTO;

public class RentWithUserStatusHistoryCarModelBrandDTO extends RentDTO {
  private UserDTO user;

  private StatusHistoryDTO statusHistory;

  private CarWithModelBrandDTO car;

  public RentWithUserStatusHistoryCarModelBrandDTO() {}

  public UserDTO getUser() {
    return user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
  }

  public StatusHistoryDTO getStatusHistory() {
    return statusHistory;
  }

  public void setStatusHistory(StatusHistoryDTO statusHistory) {
    this.statusHistory = statusHistory;
  }

  public CarWithModelBrandDTO getCar() {
    return car;
  }

  public void setCar(CarWithModelBrandDTO car) {
    this.car = car;
  }
}
