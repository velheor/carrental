package com.senla.training;

import java.util.List;

public interface IGenericService<DTO, Entity> extends IGenericDAO<DTO> {
    DTO convertEntityToDTO(Entity book);

    List<DTO> convertEntityToDTO(List<Entity> books);

    Entity convertDTOtoEntity(DTO bookDTO);

    List<Entity> convertDTOtoEntity(List<DTO> bookDTOList);
}