package com.senla.training.dto.model;

import com.senla.training.dto.brand.BrandDTO;

public class ModelWithBrandDTO extends ModelDTO {
  private BrandDTO brand;

  public ModelWithBrandDTO() {}

  public BrandDTO getBrand() {
    return brand;
  }

  public void setBrand(BrandDTO brand) {
    this.brand = brand;
  }
}
