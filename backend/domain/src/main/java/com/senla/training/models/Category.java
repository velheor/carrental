package com.senla.training.models;

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
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedEntityGraphs({
  @NamedEntityGraph(
      name = "categoryWithCarsModelBrand",
      attributeNodes = {@NamedAttributeNode(value = "cars", subgraph = "carsWithModel")},
      subgraphs = {
        @NamedSubgraph(
            name = "carsWithModel",
            attributeNodes = {@NamedAttributeNode(value = "model", subgraph = "modelWithBrand")}),
        @NamedSubgraph(
            name = "modelWithBrand",
            attributeNodes = {@NamedAttributeNode(value = "brand")})
      }),
  @NamedEntityGraph(
      name = "categoryWithCategoriesCarsModelBrand",
      attributeNodes = {
        @NamedAttributeNode(value = "categories"),
        @NamedAttributeNode(value = "cars", subgraph = "carsWithModel")
      },
      subgraphs = {
        @NamedSubgraph(
            name = "carsWithModel",
            attributeNodes = {@NamedAttributeNode(value = "model", subgraph = "modelWithBrand")}),
        @NamedSubgraph(
            name = "modelWithBrand",
            attributeNodes = {@NamedAttributeNode(value = "brand")})
      })
})
@Entity
@Table(name = "categories")
public class Category implements Serializable {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "name", nullable = false, length = 45)
  private String name;

  @OneToMany(mappedBy = "category")
  private List<Car> cars;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "categories_id", referencedColumnName = "id", nullable = false)
  private Category category;

  @OneToMany(mappedBy = "category")
  private List<Category> categories;

  public Category() {}

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
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
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
