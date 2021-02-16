package com.velheor.carrental.models;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rents", schema = "carrental")
public class Rent {

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
  @Column(name = "total_price", nullable = false, precision = 0)
  private Double totalPrice;

  @ManyToOne
  @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "cars_id", referencedColumnName = "id", nullable = false)
  private Car car;

  @OneToMany(mappedBy = "rent")
  private List<StatusHistory> statusHistories;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rent rent = (Rent) o;
    return id.equals(rent.id)
        && Double.compare(rent.totalPrice, totalPrice) == 0
        && Objects.equals(fromDate, rent.fromDate)
        && Objects.equals(toDate, rent.toDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fromDate, toDate, totalPrice);
  }

  public User getUser() {
    return user;
  }

  public void setUser(User usersByUserId) {
    this.user = usersByUserId;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car carsByCarsId) {
    this.car = carsByCarsId;
  }

  public Collection<StatusHistory> getStatusHistories() {
    return statusHistories;
  }

  public void setStatusHistories(List<StatusHistory> statusHistoriesById) {
    this.statusHistories = statusHistoriesById;
  }
}
