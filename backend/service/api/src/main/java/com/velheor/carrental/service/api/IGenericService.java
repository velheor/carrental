package com.velheor.carrental.service.api;

public interface IGenericService<T> {

  T findById(Integer id);

  T create(T entityDTO);

  T update(T entityDTO);

  void delete(T entityDTO);

  void deleteById(int id);
}
