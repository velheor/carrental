package com.senla.training.dto.category;

import com.senla.training.dto.car.CarWithModelBrandDTO;
import java.util.List;

public class CategoryWithCarsModelBrandDTO extends CategoryDTO {
  private List<CarWithModelBrandDTO> cars;

  public CategoryWithCarsModelBrandDTO() {}

  public List<CarWithModelBrandDTO> getCars() {
    return cars;
  }

  public void setCars(List<CarWithModelBrandDTO> cars) {
    this.cars = cars;
  }
}
