package com.senla.training;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@NamedEntityGraph(
        name = "carWithModelAndCategoryAndPriceHistoryAndRents",
        attributeNodes = {
                @NamedAttributeNode("model"),
                @NamedAttributeNode("category"),
                @NamedAttributeNode("priceHistories"),
                @NamedAttributeNode("rents")
        }
)
@NamedEntityGraph(
        name = "carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser",
        attributeNodes = {
                @NamedAttributeNode(value = "model", subgraph = "modelWithBrand"),
                @NamedAttributeNode("category"),
                @NamedAttributeNode("priceHistories"),
                @NamedAttributeNode(value = "rents", subgraph = "rentsWithUser")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "modelWithBrand",
                        attributeNodes = {
                                @NamedAttributeNode(value = "brand")
                        }
                ),
                @NamedSubgraph(
                        name = "rentsWithUser",
                        attributeNodes = {
                                @NamedAttributeNode(value = "user")
                        }
                )
        }
)
@Entity
@Table(name = "cars")
public class Car implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "models_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    private Model model;

    @Basic
    @Column(name = "car_type", nullable = false, length = 25)
    @Enumerated(value = EnumType.STRING)
    private ECarType carType;

    @Basic
    @Column(name = "fuel_type", nullable = false, length = 25)
    @Enumerated(value = EnumType.STRING)
    private EFuelType fuelType;

    @Basic
    @Column(name = "production_date", nullable = false)
    private Date productionDate;

    @Basic
    @Column(name = "transmission", nullable = false)
    private Boolean transmission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    private Category category;

    @OneToMany(mappedBy = "car")
    @JsonManagedReference
    private List<PriceHistory> priceHistories;

    @OneToMany(mappedBy = "car")
    @JsonBackReference
    private List<Rent> rents;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ECarType getCarType() {
        return carType;
    }

    public void setCarType(ECarType carType) {
        this.carType = carType;
    }

    public EFuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(EFuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Boolean getTransmission() {
        return transmission;
    }

    public void setTransmission(Boolean transmission) {
        this.transmission = transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id.equals(car.id) &&
                transmission == car.transmission &&
                Objects.equals(carType, car.carType) &&
                Objects.equals(fuelType, car.fuelType) &&
                Objects.equals(productionDate, car.productionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carType, fuelType, productionDate, transmission);
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<PriceHistory> getPriceHistories() {
        return priceHistories;
    }

    public void setPriceHistories(List<PriceHistory> priceHistories) {
        this.priceHistories = priceHistories;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }
}