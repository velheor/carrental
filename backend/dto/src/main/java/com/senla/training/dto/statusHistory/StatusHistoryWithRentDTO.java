package com.senla.training.dto.statusHistory;

import com.senla.training.dto.rent.RentDTO;

public class StatusHistoryWithRentDTO extends StatusHistoryDTO {
  private RentDTO rent;

  public RentDTO getRent() {
    return rent;
  }

  public void setRent(RentDTO rent) {
    this.rent = rent;
  }
}
