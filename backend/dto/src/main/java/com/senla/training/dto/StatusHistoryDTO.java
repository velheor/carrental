package com.senla.training.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.senla.training.models.enums.EStatusHistory;
import java.sql.Date;

public class StatusHistoryDTO {

  private Integer id;

  private EStatusHistory name;

  private Date statusDate;

  @JsonBackReference
  private RentDTO rent;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EStatusHistory getName() {
    return name;
  }

  public void setName(EStatusHistory name) {
    this.name = name;
  }

  public Date getStatusDate() {
    return statusDate;
  }

  public void setStatusDate(Date statusDate) {
    this.statusDate = statusDate;
  }

  public RentDTO getRent() {
    return rent;
  }

  public void setRent(RentDTO rent) {
    this.rent = rent;
  }
}
