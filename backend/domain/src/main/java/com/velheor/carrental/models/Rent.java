package com.velheor.carrental.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedEntityGraphs({
    @NamedEntityGraph(
        name = "rentWithUserStatusHistoryCarModelBrand",
        attributeNodes = {
            @NamedAttributeNode("user"),
            @NamedAttributeNode("statusHistoryList"),
            @NamedAttributeNode(value = "car", subgraph = "carWithModel")
        },
        subgraphs = {
            @NamedSubgraph(
                name = "carWithModel",
                attributeNodes = {
                    @NamedAttributeNode(value = "model", subgraph = "modelWithBrand"),
                }),
            @NamedSubgraph(
                name = "modelWithBrand",
                attributeNodes = {@NamedAttributeNode(value = "brand")}),
        })
})
@Entity
@Table(name = "rents")
public class Rent implements Serializable {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "from_date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fromDate;

  @Basic
  @Column(name = "to_date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date toDate;

  @Basic
  @Column(name = "total_price", nullable = false)
  private Double totalPrice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cars_id", referencedColumnName = "id", nullable = false)
  private Car car;

  @OneToMany(mappedBy = "rent")
  private List<StatusHistory> statusHistoryList;

  public Rent() {
  }

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

  public void setUser(User user) {
    this.user = user;
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
