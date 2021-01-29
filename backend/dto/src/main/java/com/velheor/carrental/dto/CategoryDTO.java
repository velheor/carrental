package com.velheor.carrental.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

public class CategoryDTO {

  private Integer id;

  private String name;

  private List<CarDTO> cars;

  @JsonBackReference private CategoryDTO category;

  @JsonManagedReference private List<CategoryDTO> categories;

  public CategoryDTO() {}

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

  public CategoryDTO getCategory() {
    return category;
  }

  public void setCategory(CategoryDTO category) {
    this.category = category;
  }

  public List<CategoryDTO> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryDTO> categories) {
    this.categories = categories;
  }
}
