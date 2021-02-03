package com.velheor.carrental.models;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedEntityGraphs({
  @NamedEntityGraph(
      name = "modelWithBrand",
      attributeNodes = {@NamedAttributeNode(value = "brand")}),
  @NamedEntityGraph(
      name = "modelWithCars",
      attributeNodes = {@NamedAttributeNode(value = "cars")}),
})
@Entity
@Table(name = "models")
public class Model implements Serializable {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "name", nullable = false, length = 45)
  private String name;

  @OneToMany(mappedBy = "model")
  private List<Car> cars;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "brands_id", referencedColumnName = "id", nullable = false)
  private Brand brand;

  public Model() {}

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

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Model)) {
      return false;
    }
    Model model = (Model) o;
    return Objects.equals(getId(), model.getId())
        && Objects.equals(getName(), model.getName())
        && Objects.equals(getCars(), model.getCars())
        && Objects.equals(getBrand(), model.getBrand());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getCars(), getBrand());
  }
}
