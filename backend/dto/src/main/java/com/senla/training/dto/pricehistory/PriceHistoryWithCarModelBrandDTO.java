package com.senla.training.dto.pricehistory;

import com.senla.training.dto.car.CarWithModelBrandDTO;

public class PriceHistoryWithCarModelBrandDTO extends PriceHistoryDTO {
  private CarWithModelBrandDTO car;

  public PriceHistoryWithCarModelBrandDTO() {}

  public CarWithModelBrandDTO getCar() {
    return car;
  }

  public void setCar(CarWithModelBrandDTO car) {
    this.car = car;
  }
}
