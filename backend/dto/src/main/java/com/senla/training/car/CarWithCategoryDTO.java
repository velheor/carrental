package com.senla.training.car;

import com.senla.training.category.CategoryDTO;

public class CarWithCategoryDTO extends CarDTO {
    private CategoryDTO category;

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}