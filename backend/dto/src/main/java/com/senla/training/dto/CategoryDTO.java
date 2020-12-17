package com.senla.training.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

public class CategoryDTO {

  private Integer id;

  private String name;

  private List<CarDTO> cars;

  @JsonBackReference
  private CategoryDTO category;

  @JsonManagedReference
  private List<CategoryDTO> categories;

  public CategoryDTO() {
  }
}
