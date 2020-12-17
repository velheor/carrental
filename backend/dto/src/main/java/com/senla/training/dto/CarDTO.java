package com.senla.training.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.senla.training.models.Rent;
import com.senla.training.models.enums.ECarType;
import com.senla.training.models.enums.EFuelType;
import java.util.Date;
import java.util.List;

public class CarDTO {

  private Integer id;

  private ECarType carType;

  private EFuelType fuelType;

  private Date productionDate;

  private Boolean transmission;

  @JsonBackReference
  private ModelDTO model;

  @JsonBackReference
  private CategoryDTO category;

  @JsonManagedReference
  private List<PriceHistoryDTO> priceHistoryList;

  @JsonManagedReference
  private List<Rent> rents;

  public CarDTO() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ECarType getCarType() {
    return carType;
  }

  public void setCarType(ECarType carType) {
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

  public ModelDTO getModel() {
    return model;
  }

  public void setModel(ModelDTO model) {
    this.model = model;
  }

  public CategoryDTO getCategory() {
    return category;
  }

  public void setCategory(CategoryDTO category) {
    this.category = category;
  }

  public List<PriceHistoryDTO> getPriceHistoryList() {
    return priceHistoryList;
  }

  public void setPriceHistoryList(
      List<PriceHistoryDTO> priceHistoryList) {
    this.priceHistoryList = priceHistoryList;
  }

  public List<Rent> getRents() {
    return rents;
  }

  public void setRents(List<Rent> rents) {
    this.rents = rents;
  }
}
