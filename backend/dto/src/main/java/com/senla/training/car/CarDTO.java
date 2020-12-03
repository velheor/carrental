package com.senla.training.car;

import com.senla.training.ECarType;
import com.senla.training.EFuelType;
import com.senla.training.model.ModelWithBrandDTO;

import java.util.Date;

public class CarDTO {
    private Long id;

    private ECarType carType;

    private EFuelType fuelType;

    private Date productionDate;

    private Boolean transmission;

    private ModelWithBrandDTO model;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public ModelWithBrandDTO getModel() {
        return model;
    }

    public void setModel(ModelWithBrandDTO model) {
        this.model = model;
    }
}