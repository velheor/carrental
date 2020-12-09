package com.senla.training.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;

@NamedEntityGraphs({
  @NamedEntityGraph(
      name = "priceHistoryWithCarModelBrand",
      attributeNodes = {
        @NamedAttributeNode(value = "car", subgraph = "carWithModel"),
      },
      subgraphs = {
        @NamedSubgraph(
            name = "carWithModel",
            attributeNodes = {
              @NamedAttributeNode(value = "model", subgraph = "modelWithBrand"),
            }),
        @NamedSubgraph(
            name = "modelWithBrand",
            attributeNodes = {@NamedAttributeNode(value = "brand")})
      })
})
@Entity
@Table(name = "price_history")
public class PriceHistory implements Serializable {
  @Id
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private Integer id;

  @Basic
  @Column(name = "price", nullable = false)
  private Double price;

  @Basic
  @Column(name = "price_date", nullable = false)
  private Date priceDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @JsonBackReference
  private Car car;

  public PriceHistory() {}

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
