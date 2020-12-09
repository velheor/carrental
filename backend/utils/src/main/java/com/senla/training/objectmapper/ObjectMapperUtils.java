package com.senla.training.objectmapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperUtils {
  private final ModelMapper modelMapper;

  @Autowired
  public ObjectMapperUtils(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
    if (entityList == null || outCLass == null) {
      return new ArrayList<>();
    }
    return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
  }

  public <D, T> D map(final T entity, Class<D> outClass) {
    if (entity == null || outClass == null) {
      return null;
    }
    return modelMapper.map(entity, outClass);
  }
}
