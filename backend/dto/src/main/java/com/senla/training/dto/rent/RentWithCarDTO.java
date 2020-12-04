package com.senla.training.dto.rent;

import com.senla.training.dto.car.CarWithCategoryDTO;

public class RentWithCarDTO extends RentDTO {
  private CarWithCategoryDTO car;

  public CarWithCategoryDTO getCar() {
    return car;
  }

  public void setCar(CarWithCategoryDTO car) {
    this.car = car;
  }
}
