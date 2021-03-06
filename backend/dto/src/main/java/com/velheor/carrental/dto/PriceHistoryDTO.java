package com.velheor.carrental.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;

public class PriceHistoryDTO {

  private Integer id;

  private Double price;

  private Date priceDate;

  @JsonBackReference private CarDTO car;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Date getPriceDate() {
    return priceDate;
  }

  public void setPriceDate(Date priceDate) {
    this.priceDate = priceDate;
  }

  public CarDTO getCar() {
    return car;
  }

  public void setCar(CarDTO car) {
    this.car = car;
  }
}
