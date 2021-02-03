package com.velheor.carrental.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedEntityGraph(
    name = "brandWithModels",
    attributeNodes = {@NamedAttributeNode("models")})
@Entity
@Table(name = "brands")
public class Brand implements Serializable {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "name", nullable = false, length = 45)
  private String name;

  @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
  private List<Model> models;

  public Brand() {}

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

  public List<Model> getModels() {
    return models;
  }

  public void setModels(List<Model> model) {
    this.models = model;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Brand)) {
      return false;
    }
    Brand brand = (Brand) o;
    return Objects.equals(getId(), brand.getId())
        && Objects.equals(getName(), brand.getName())
        && Objects.equals(getModels(), brand.getModels());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getModels());
  }
}
