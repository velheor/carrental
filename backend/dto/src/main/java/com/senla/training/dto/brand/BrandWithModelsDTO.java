package com.senla.training.dto.brand;

import com.senla.training.dto.model.ModelDTO;
import java.util.List;

public class BrandWithModelsDTO extends BrandDTO {
  private List<ModelDTO> models;

  public List<ModelDTO> getModels() {
    return models;
  }

  public void setModels(List<ModelDTO> models) {
    this.models = models;
  }
}
