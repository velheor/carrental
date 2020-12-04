package com.senla.training.dto.statusHistory;

import com.senla.training.models.enums.EStatusHistory;
import java.sql.Date;

public class StatusHistoryDTO {
  private Integer id;

  private EStatusHistory name;

  private Date statusDate;

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
}
