package com.senla.training.rent;

import com.senla.training.car.CarWithCategoryDTO;

public class RentWithCarDTO extends RentDTO {
    private CarWithCategoryDTO car;

    public CarWithCategoryDTO getCar() {
        return car;
    }

    public void setCar(CarWithCategoryDTO car) {
        this.car = car;
    }
}