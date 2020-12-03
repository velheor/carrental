package com.senla.training.category;

import java.util.List;

public class CategoryWithCategoriesDTO {
    private List<CategoryDTO> categories;

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}