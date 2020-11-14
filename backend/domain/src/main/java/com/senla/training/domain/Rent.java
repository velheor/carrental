package com.senla.training.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rents")
public class Rent implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "from_date", nullable = false)
    private Date fromDate;

    @Basic
    @Column(name = "to_date", nullable = false)
    private Date toDate;

    @Basic
    @Column(name = "checkin_date", nullable = false)
    private Date checkinDate;

    @Basic
    @Column(name = "checkout_date", nullable = false)
    private Date checkoutDate;

    @Basic
    @Column(name = "total_price", nullable = false, precision = 0)
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "cars_id", referencedColumnName = "id", nullable = false)
    private Car car;

    @OneToMany(mappedBy = "rent")
    private List<StatusHistory> statusHistoryList;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return id == rent.id &&
                Double.compare(rent.totalPrice, totalPrice) == 0 &&
                Objects.equals(fromDate, rent.fromDate) &&
                Objects.equals(toDate, rent.toDate) &&
                Objects.equals(checkinDate, rent.checkinDate) &&
                Objects.equals(checkoutDate, rent.checkoutDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromDate, toDate, checkinDate, checkoutDate, totalPrice);
    }

    public User getUsersByUsersId() {
        return user;
    }

    public void setUsersByUsersId(User usersByUsersId) {
        this.user = usersByUsersId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<StatusHistory> getStatusHistoryList() {
        return statusHistoryList;
    }

    public void setStatusHistoryList(List<StatusHistory> statusHistoryList) {
        this.statusHistoryList = statusHistoryList;
    }
}