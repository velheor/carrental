package com.senla.training;

import java.util.List;

public interface IGenericService<DTO, Entity> {
    DTO convertEntityToDTO(Entity entity);

    List<? extends DTO> convertEntityToDTO(List<Entity> books);

    Entity convertDTOtoEntity(DTO bookDTO);

    List<Entity> convertDTOtoEntity(List<DTO> bookDTOList);
}