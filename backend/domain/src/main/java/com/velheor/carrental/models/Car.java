package com.velheor.carrental.models;

import com.velheor.carrental.models.enums.EFuelType;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cars", schema = "carrental")
public class Car {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "car_type", nullable = false, length = 25)
  private String carType;

  @Basic
  @Column(name = "fuel_type", nullable = false, length = 25)
  private EFuelType fuelType;

  @Basic
  @Column(name = "production_date", nullable = false)
  private Date productionDate;

  @Basic
  @Column(name = "transmission", nullable = false)
  private Boolean transmission;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "models_id", referencedColumnName = "id", nullable = false)
  private Model model;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
  private Category category;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "manufacturer_country_id", referencedColumnName = "id", nullable = false)
  private ManufacturerCountry manufacturerCountry;

  @OneToMany(mappedBy = "car")
  private List<PriceHistory> priceHistories;

  @OneToMany(mappedBy = "car")
  private List<Rent> rents;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }

  public EFuelType getFuelType() {
    return fuelType;
  }

  public void setFuelType(EFuelType fuelType) {
    this.fuelType = fuelType;
  }

  public Date getProductionDate() {
    return productionDate;
  }

  public void setProductionDate(Date productionDate) {
    this.productionDate = productionDate;
  }

  public Boolean getTransmission() {
    return transmission;
  }

  public void setTransmission(Boolean transmission) {
    this.transmission = transmission;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return id.equals(car.id)
        && transmission == car.transmission
        && Objects.equals(carType, car.carType)
        && Objects.equals(fuelType, car.fuelType)
        && Objects.equals(productionDate, car.productionDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, carType, fuelType, productionDate, transmission);
  }

  public Model getModel() {
    return model;
  }

  public void setModel(Model modelsByModelId) {
    this.model = modelsByModelId;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category categoriesByCategroriesId) {
    this.category = categoriesByCategroriesId;
  }

  public ManufacturerCountry getManufacturerCountry() {
    return manufacturerCountry;
  }

  public void setManufacturerCountry(
      ManufacturerCountry manufacturerCountryByManufacturerCountryId) {
    this.manufacturerCountry = manufacturerCountryByManufacturerCountryId;
  }

  public List<PriceHistory> getPriceHistories() {
    return priceHistories;
  }

  public void setPriceHistories(List<PriceHistory> priceHistoriesById) {
    this.priceHistories = priceHistoriesById;
  }

  public Collection<Rent> getRents() {
    return rents;
  }

  public void setRents(List<Rent> rentsById) {
    this.rents = rentsById;
  }
}
