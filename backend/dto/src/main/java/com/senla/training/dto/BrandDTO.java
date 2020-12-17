package com.senla.training.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.senla.training.models.enums.EBrand;
import java.util.List;

public class BrandDTO {

  private Integer id;

  private EBrand name;

  @JsonManagedReference
  private List<ModelDTO> models;

  public BrandDTO() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EBrand getName() {
    return name;
  }

  public void setName(EBrand name) {
    this.name = name;
  }

  public List<ModelDTO> getModels() {
    return models;
  }

  public void setModels(List<ModelDTO> models) {
    this.models = models;
  }
}
