package com.senla.training.dto;

import java.util.Date;

public class PriceHistoryDTO {
  private Integer id;

  private Double price;

  private Date priceDate;

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
}
