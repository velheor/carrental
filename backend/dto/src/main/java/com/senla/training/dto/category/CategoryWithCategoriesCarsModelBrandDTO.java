package com.senla.training.dto.category;

import com.senla.training.dto.car.CarWithModelBrandDTO;
import java.util.List;

public class CategoryWithCategoriesCarsModelBrandDTO extends CategoryDTO {
  private List<CategoryDTO> categories;

  private List<CarWithModelBrandDTO> cars;

  public List<CategoryDTO> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryDTO> categories) {
    this.categories = categories;
  }

  public List<CarWithModelBrandDTO> getCars() {
    return cars;
  }

  public void setCars(List<CarWithModelBrandDTO> cars) {
    this.cars = cars;
  }
}
