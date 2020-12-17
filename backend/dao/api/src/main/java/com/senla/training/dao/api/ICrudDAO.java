package com.senla.training.dao.api;

public interface ICrudDAO<T> {

  T create(T entity);

  T update(T entity);

  void delete(T entity);

  void deleteById(int id);
}
