package com.senla.training.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.senla.training.models.enums.EStatusHistory;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedEntityGraphs({
  @NamedEntityGraph(
      name = "statusHistoryWithRent",
      attributeNodes = {@NamedAttributeNode(value = "rent")})
})
@Entity
@Table(name = "status_history")
public class StatusHistory implements Serializable {

  @Id
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private Integer id;

  @Basic
  @Column(name = "name", nullable = false, length = 45)
  @Enumerated(value = EnumType.STRING)
  private EStatusHistory name;

  @Basic
  @Column(name = "status_date", nullable = false, length = 45)
  @Temporal(TemporalType.DATE)
  private Date statusDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @JsonBackReference
  private Rent rent;

  public StatusHistory() {}

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusHistory that = (StatusHistory) o;
    return id.equals(that.id)
        && Objects.equals(name, that.name)
        && Objects.equals(statusDate, that.statusDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, statusDate);
  }

  public Rent getRent() {
    return rent;
  }

  public void setRent(Rent rent) {
    this.rent = rent;
  }
}
