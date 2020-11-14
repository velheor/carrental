package com.senla.training;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDAO<T extends Serializable> {
    T findById(int id);

    List<T> findAll();

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(int entityId);

    List<T> sortWithDirection(String field, Direction direction);

    List<T> sortWithDirection(Map<String, Direction> fieldDirectionMap);

    T findOneByCriteria(String field, Object criteria);

    List<T> findAllByCriteria(String field, Object criteria);

    List<T> findAllByCriteria(Map<String, Object> fieldCriteriaMap);

    List<T> findByNotNull(String field);

    List<T> findByNull(String field);

    List<T> findLessThan(String field, Number number);

    List<T> findGreaterThan(String field, Number number);

    List<T> findAndSort(Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

    List<T> findContain(String field, Object criteria);

    List<T> findBetweenNumbers(String field, Number firstNumber, Number secondNumber);
}