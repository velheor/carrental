package com.senla.training.dto.car;

import com.senla.training.dto.model.ModelWithBrandDTO;

public class CarWithModelBrandDTO extends CarDTO {
  private ModelWithBrandDTO model;

  public ModelWithBrandDTO getModel() {
    return model;
  }

  public void setModel(ModelWithBrandDTO model) {
    this.model = model;
  }
}
