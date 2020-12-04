package com.senla.training.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.Table;

@NamedEntityGraph(
    name = "priceHistoryWithCar",
    attributeNodes = {@NamedAttributeNode(value = "car")})
@NamedEntityGraph(
    name = "priceHistoryWithCarAndModel",
    attributeNodes = {
      @NamedAttributeNode(value = "car", subgraph = "carWithModelAndCategory"),
    },
    subgraphs = {
      @NamedSubgraph(
          name = "carWithModel",
          attributeNodes = {
            @NamedAttributeNode(value = "model", subgraph = "modelWithBrand"),
            @NamedAttributeNode(value = "category")
          }),
      @NamedSubgraph(
          name = "modelWithBrand",
          attributeNodes = {@NamedAttributeNode(value = "brand")})
    })
@Entity
@Table(name = "price_history")
public class PriceHistory implements Serializable {
  @EmbeddedId private Integer id;

  @Basic
  @Column(name = "price", nullable = false)
  private Double price;

  @Basic
  @Column(name = "price_date", nullable = false)
  private Date priceDate;

  @MapsId("id")
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id", referencedColumnName = "id")
  @JsonBackReference
  private Car car;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
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

  public void setCar(Car car) {
    this.car = car;
  }
}
