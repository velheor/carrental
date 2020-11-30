package com.senla.training;

import com.senla.training.user.UserWithRolesDTO;

import java.util.Date;
import java.util.List;

public class RentDTO {
    private Integer id;

    private Date fromDate;

    private Date toDate;

    private Date checkinDate;

    private Date checkoutDate;

    private Double totalPrice;

    private UserWithRolesDTO user;

    private CarDTO car;

    private List<StatusHistoryDTO> statusHistoryList;

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

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public UserWithRolesDTO getUser() {
        return user;
    }

    public void setUser(UserWithRolesDTO user) {
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