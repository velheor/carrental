package com.senla.training;

import java.util.List;

public class BrandDTO {
    private Integer id;

    private EBrand name;

    private List<ModelDTO> models;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EBrand getName() {
        return name;
    }

    public void setName(EBrand name) {
        this.name = name;
    }

    public List<ModelDTO> getModels() {
        return models;
    }

    public void setModels(List<ModelDTO> models) {
        this.models = models;
    }
}