package com.senla.training.dto.model;

public class ModelDTO {
  private Integer id;

  private String name;

  private String manufacturerCountry;

  public ModelDTO() {}

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

  public String getManufacturerCountry() {
    return manufacturerCountry;
  }

  public void setManufacturerCountry(String manufacturerCountry) {
    this.manufacturerCountry = manufacturerCountry;
  }
}
