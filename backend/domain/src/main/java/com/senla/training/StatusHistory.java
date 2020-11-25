package com.senla.training;

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
import javax.persistence.NamedSubgraph;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@NamedEntityGraph(
        name = "statusHistoryWithRents",
        attributeNodes = {
                @NamedAttributeNode("rent"),
        })
@NamedEntityGraph(
        name = "statusHistoryWithRentsAndCar",
        attributeNodes = {
                @NamedAttributeNode(value = "rent", subgraph = "rentWithCar"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "rentWithCar",
                        attributeNodes = {
                                @NamedAttributeNode(value = "car")
                        }
                )
        }
)
@Entity
@Table(name = "status_history")
public class StatusHistory implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
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
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusHistory that = (StatusHistory) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(statusDate, that.statusDate);
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