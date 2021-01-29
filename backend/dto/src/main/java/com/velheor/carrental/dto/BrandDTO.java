package com.velheor.carrental.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

public class BrandDTO {

  private Integer id;

  private String name;

  @JsonManagedReference private List<ModelDTO> models;

  public BrandDTO() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<ModelDTO> getModels() {
    return models;
  }

  public void setModels(List<ModelDTO> models) {
    this.models = models;
  }
}
