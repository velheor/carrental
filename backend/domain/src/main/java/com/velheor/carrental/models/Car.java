package com.velheor.carrental.models;

import com.velheor.carrental.models.enums.EFuelType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
        name = "carWithModelCategoryPriceHistoryCountryBrand",
        attributeNodes = {
            @NamedAttributeNode(value = "model", subgraph = "modelWithBrand"),
            @NamedAttributeNode("category"),
            @NamedAttributeNode("priceHistoryList"),
            @NamedAttributeNode("manufacturerCountry")
        },
        subgraphs = {
            @NamedSubgraph(
                name = "modelWithBrand",
                attributeNodes = {@NamedAttributeNode(value = "brand")})
        }),
    @NamedEntityGraph(
        name = "carWithRents",
        attributeNodes = {@NamedAttributeNode(value = "rents")})
})
@Entity
@Table(name = "cars")
public class Car implements Serializable {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "car_type", nullable = false, length = 25)
  private String carType;

  @Basic
  @Column(name = "fuel_type", nullable = false, length = 25)
  @Enumerated(value = EnumType.STRING)
  private EFuelType fuelType;

  @Basic
  @Column(name = "production_date", nullable = false)
  private Date productionDate;

  @Basic
  @Column(name = "transmission", nullable = false)
  private Boolean transmission;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "manufacturer_country_id", referencedColumnName = "id", nullable = false)
  private ManufacturerCountry manufacturerCountry;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "models_id", referencedColumnName = "id", nullable = false)
  private Model model;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "id",
      referencedColumnName = "id",
      nullable = false,
      insertable = false,
      updatable = false)
  private Category category;

  @OneToMany(mappedBy = "car")
  private List<PriceHistory> priceHistoryList;

  @OneToMany(mappedBy = "car")
  private List<Rent> rents;

  public Car() {
  }

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

  public ManufacturerCountry getManufacturerCountry() {
    return manufacturerCountry;
  }

  public void setManufacturerCountry(ManufacturerCountry manufacturerCountry) {
    this.manufacturerCountry = manufacturerCountry;
  }

  public Model getModel() {
    return model;
  }

  public void setModel(Model model) {
    this.model = model;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public List<PriceHistory> getPriceHistoryList() {
    return priceHistoryList;
  }

  public void setPriceHistoryList(
      List<PriceHistory> priceHistoryList) {
    this.priceHistoryList = priceHistoryList;
  }

  public List<Rent> getRents() {
    return rents;
  }

  public void setRents(List<Rent> rents) {
    this.rents = rents;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Car)) {
      return false;
    }
    Car car = (Car) o;
    return Objects.equals(getId(), car.getId()) &&
        Objects.equals(getCarType(), car.getCarType()) &&
        getFuelType() == car.getFuelType() &&
        Objects.equals(getProductionDate(), car.getProductionDate()) &&
        Objects.equals(getTransmission(), car.getTransmission()) &&
        Objects.equals(getManufacturerCountry(), car.getManufacturerCountry()) &&
        Objects.equals(getModel(), car.getModel()) &&
        Objects.equals(getCategory(), car.getCategory()) &&
        Objects.equals(getPriceHistoryList(), car.getPriceHistoryList()) &&
        Objects.equals(getRents(), car.getRents());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getId(), getCarType(), getFuelType(), getProductionDate(), getTransmission(),
            getManufacturerCountry(), getModel(), getCategory(), getPriceHistoryList(), getRents());
  }
}
