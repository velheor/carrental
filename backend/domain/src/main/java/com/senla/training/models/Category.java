package com.senla.training.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedEntityGraph(
    name = "categoryWithCarsAndCategoryAndCategoriesAndModels",
    attributeNodes = {
      @NamedAttributeNode(value = "cars", subgraph = "carWithModel"),
      @NamedAttributeNode(value = "category", subgraph = "categoryWithCar"),
      @NamedAttributeNode(value = "categories", subgraph = "categoriesWithCategoryAndCar")
    },
    subgraphs = {
      @NamedSubgraph(
          name = "categoriesWithCategoryAndCar",
          attributeNodes = {
            @NamedAttributeNode(value = "category", subgraph = "categoryWithCar"),
            @NamedAttributeNode(value = "cars", subgraph = "carWithModel")
          }),
      @NamedSubgraph(
          name = "categoryWithCar",
          attributeNodes = {@NamedAttributeNode(value = "cars", subgraph = "carWithModel")}),
      @NamedSubgraph(
          name = "carWithModel",
          attributeNodes = {@NamedAttributeNode(value = "model", subgraph = "modelWithBrand")}),
      @NamedSubgraph(
          name = "modelWithBrand",
          attributeNodes = {@NamedAttributeNode(value = "brand")})
    })
@Entity
@Table(name = "categories")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "category"})
public class Category implements Serializable {
  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "name", nullable = false, length = 45)
  private String name;

  @OneToMany(mappedBy = "category")
  @JsonBackReference
  private List<Car> cars;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "categories_id", referencedColumnName = "id", nullable = false)
  @JsonManagedReference
  private Category category;

  @OneToMany(mappedBy = "category")
  @JsonBackReference
  private List<Category> categories;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Category that = (Category) o;
    return id.equals(that.id) && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }
}
