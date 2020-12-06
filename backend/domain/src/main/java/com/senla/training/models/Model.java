package com.senla.training.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    name = "modelWithCarsAndBrandAndModels",
    attributeNodes = {
      @NamedAttributeNode(value = "cars"),
      @NamedAttributeNode(value = "brand", subgraph = "brandWithModels")
    },
    subgraphs = {
      @NamedSubgraph(
          name = "brandWithModels",
          attributeNodes = {@NamedAttributeNode(value = "models")})
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

  @Basic
  @Column(name = "manufacturer_country", nullable = false, length = 45)
  private String manufacturerCountry;

  @OneToMany(mappedBy = "model")
  @JsonBackReference
  private List<Car> cars;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "brands_id", referencedColumnName = "id", nullable = false)
  @JsonManagedReference
  private Brand brand;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Model model = (Model) o;
    return id.equals(model.id)
        && Objects.equals(name, model.name)
        && Objects.equals(manufacturerCountry, model.manufacturerCountry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, manufacturerCountry);
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
}