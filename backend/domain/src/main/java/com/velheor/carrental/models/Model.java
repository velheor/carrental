package com.velheor.carrental.models;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "models", schema = "carrental")
public class Model {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "name", nullable = false, length = 45)
  private String name;

  @OneToMany(mappedBy = "model")
  private List<Car> cars;

  @ManyToOne
  @JoinColumn(name = "brands_id", referencedColumnName = "id", nullable = false)
  private Brand brands;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Model model = (Model) o;
    return id.equals(model.id) && Objects.equals(name, model.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  public Collection<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> carsById) {
    this.cars = carsById;
  }

  public Brand getBrands() {
    return brands;
  }

  public void setBrands(Brand brandsByBrandsId) {
    this.brands = brandsByBrandsId;
  }
}
