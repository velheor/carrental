package com.senla.training;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericService<DTO, Entity> implements IGenericService<DTO, Entity> {

    private final Class<DTO> typeDTO;

    private final Class<Entity> typeEntity;

    GenericService() {
        this.typeDTO = (Class<DTO>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        this.typeEntity = (Class<Entity>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Override
    public DTO convertEntityToDTO(Entity book) {
        return ObjectMapperUtils.map(book, getTypeDTO());
    }

    @Override
    public List<DTO> convertEntityToDTO(List<Entity> books) {
        return ObjectMapperUtils.mapAll(books, getTypeDTO());
    }

    @Override
    public Entity convertDTOtoEntity(DTO bookDTO) {
        return ObjectMapperUtils.map(bookDTO, getTypeEntity());
    }

    @Override
    public List<Entity> convertDTOtoEntity(List<DTO> bookDTOList) {
        return ObjectMapperUtils.mapAll(bookDTOList, getTypeEntity());
    }

    public Class<DTO> getTypeDTO() {
        return typeDTO;
    }

    public Class<Entity> getTypeEntity() {
        return typeEntity;
    }
}