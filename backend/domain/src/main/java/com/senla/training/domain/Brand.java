package com.senla.training.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Brand {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @OneToMany(mappedBy = "brands")
    private List<Model> models;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return id == brand.id &&
                Objects.equals(name, brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> model) {
        this.models = model;
    }
}