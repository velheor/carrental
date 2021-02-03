package com.velheor.carrental.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;

public class RentDTO {

  private Integer id;

  private Date fromDate;

  private Date toDate;

  private Double totalPrice;

  @JsonBackReference private UserDTO user;

  @JsonBackReference private CarDTO car;

  @JsonManagedReference private List<StatusHistoryDTO> statusHistoryList;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getFromDate() {
    return fromDate;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  public Date getToDate() {
    return toDate;
  }

  public void setToDate(Date toDate) {
    this.toDate = toDate;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public UserDTO getUser() {
    return user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
  }

  public CarDTO getCar() {
    return car;
  }

  public void setCar(CarDTO car) {
    this.car = car;
  }

  public List<StatusHistoryDTO> getStatusHistoryList() {
    return statusHistoryList;
  }

  public void setStatusHistoryList(List<StatusHistoryDTO> statusHistoryList) {
    this.statusHistoryList = statusHistoryList;
  }
}
