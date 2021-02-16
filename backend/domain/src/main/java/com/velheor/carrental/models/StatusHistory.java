package com.velheor.carrental.models;

import com.velheor.carrental.models.enums.EStatusHistory;
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
@Table(name = "status_history", schema = "carrental")
public class StatusHistory {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "name", nullable = false, length = 45)
  private EStatusHistory name;

  @Basic
  @Column(name = "status_date", nullable = false)
  private Date statusDate;

  @ManyToOne
  @JoinColumn(name = "rents_id", referencedColumnName = "id", nullable = false)
  private Rent rent;

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

  public void setRent(Rent rentsByRentsId) {
    this.rent = rentsByRentsId;
  }
}
