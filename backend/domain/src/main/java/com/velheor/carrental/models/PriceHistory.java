package com.velheor.carrental.models;

import java.sql.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "price_history", schema = "carrental")
public class PriceHistory {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "price", nullable = false, precision = 0)
  private Double price;

  @Basic
  @Column(name = "price_date", nullable = false)
  private Date priceDate;

  @ManyToOne
  @JoinColumn(name = "cars_id", referencedColumnName = "id", nullable = false)
  private Car car;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Date getPriceDate() {
    return priceDate;
  }

  public void setPriceDate(Date priceDate) {
    this.priceDate = priceDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceHistory that = (PriceHistory) o;
    return id.equals(that.id)
        && Double.compare(that.price, price) == 0
        && Objects.equals(priceDate, that.priceDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, price, priceDate);
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car carsByCarsId) {
    this.car = carsByCarsId;
  }
}
