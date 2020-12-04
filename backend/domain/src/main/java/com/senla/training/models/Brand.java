package com.senla.training.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.senla.training.models.enums.EBrand;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
  @Enumerated(value = EnumType.STRING)
  private EBrand name;

  @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
  @JsonBackReference
  private List<Model> models;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EBrand getName() {
    return name;
  }

  public void setName(EBrand name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Brand brand = (Brand) o;
    return id.equals(brand.id) && Objects.equals(name, brand.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  public List<Model> getModels() {
    return models;
  }

  public void setModels(List<Model> model) {
    this.models = model;
  }
}
