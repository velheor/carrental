package com.senla.training.model;

import com.senla.training.brand.BrandDTO;

public class ModelWithBrandDTO extends ModelDTO {

    private BrandDTO brand;

    public BrandDTO getBrand() {
        return brand;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }
}