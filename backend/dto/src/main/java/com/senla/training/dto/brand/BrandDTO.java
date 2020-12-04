package com.senla.training.dto.brand;

import com.senla.training.models.enums.EBrand;

public class BrandDTO {
  private Long id;

  private EBrand name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EBrand getName() {
    return name;
  }

  public void setName(EBrand name) {
    this.name = name;
  }
}
