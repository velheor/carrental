package com.senla.training.brand;

import com.senla.training.model.ModelDTO;

import java.util.List;

public class BrandWithModelsDTO extends BrandDTO {
    private List<ModelDTO> models;

    public List<ModelDTO> getModels() {
        return models;
    }

    public void setModels(List<ModelDTO> models) {
        this.models = models;
    }
}