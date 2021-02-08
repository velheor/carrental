package com.velheor.carrental.models;

import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class ManufacturerCountry {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "name", nullable = false, length = 45)
  private String name;

  @OneToMany(mappedBy = "manufacturer_country_id")
  private List<Car> cars;

  public ManufacturerCountry() {
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ManufacturerCountry)) {
      return false;
    }
    ManufacturerCountry that = (ManufacturerCountry) o;
    return Objects.equals(getId(), that.getId()) &&
        Objects.equals(getName(), that.getName()) &&
        Objects.equals(getCars(), that.getCars());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getCars());
  }
}
