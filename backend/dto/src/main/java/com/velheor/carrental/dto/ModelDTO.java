package com.velheor.carrental.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

public class ModelDTO {

  private Integer id;

  private String name;

  @JsonManagedReference private List<CarDTO> cars;

  @JsonBackReference private BrandDTO brand;

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

  public List<CarDTO> getCars() {
    return cars;
  }

  public void setCars(List<CarDTO> cars) {
    this.cars = cars;
  }

  public BrandDTO getBrand() {
    return brand;
  }

  public void setBrand(BrandDTO brand) {
    this.brand = brand;
  }
}
