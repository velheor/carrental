package com.velheor.carrental.service.api;

public interface IGenericService<T> {

  T create(T entity);

  T update(T entity);

  void delete(T entity);

  void deleteById(int id);
}
