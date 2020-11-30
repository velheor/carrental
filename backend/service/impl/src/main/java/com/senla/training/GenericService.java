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
    public DTO convertEntityToDTO(Entity entity) {
        return ObjectMapperUtils.map(entity, getTypeDTO());
    }

    @Override
    public List<? extends DTO> convertEntityToDTO(List<Entity> entities) {
        return ObjectMapperUtils.mapAll(entities, getTypeDTO());
    }

    @Override
    public Entity convertDTOtoEntity(DTO dto) {
        return ObjectMapperUtils.map(dto, getTypeEntity());
    }

    @Override
    public List<Entity> convertDTOtoEntity(List<DTO> dtoList) {
        return ObjectMapperUtils.mapAll(dtoList, getTypeEntity());
    }

    public Class<DTO> getTypeDTO() {
        return typeDTO;
    }

    public Class<Entity> getTypeEntity() {
        return typeEntity;
    }
}