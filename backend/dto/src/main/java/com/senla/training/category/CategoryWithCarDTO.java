package com.senla.training.category;

import com.senla.training.car.CarDTO;

import java.util.List;

public class CategoryWithCarDTO extends CategoryDTO {
    private List<CarDTO> cars;

    public List<CarDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarDTO> cars) {
        this.cars = cars;
    }
}