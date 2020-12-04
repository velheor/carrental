package com.senla.training.dao.impl;

import com.senla.training.dao.api.IGenericDAO;
import com.senla.training.models.enums.Direction;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

public abstract class EntityGraphAbstractDAO<T extends Serializable>
    extends CriteriaApiAbstractDAO<T> implements IGenericDAO<T> {

  private String entityGraphName;

  public void setEntityGraphName(String entityGraphName) {
    this.entityGraphName = entityGraphName;
  }

  @Override
  public T findById(int id) {
    return findOneByCriteria("id", id);
  }

  @Override
  public List<T> findAll() {
    return createTypedQuery(super.findAllCriteriaQuery()).getResultList();
  }

  @Override
  public T create(T entity) {
    super.getEntityManager().persist(entity);
    return entity;
  }

  @Override
  public T update(T entity) {
    return super.getEntityManager().merge(entity);
  }

  @Override
  public void delete(T entity) {
    super.getEntityManager().remove(entity);
  }

  @Override
  public void deleteById(int id) {
    delete(findById(id));
  }

  @Override
  public List<T> sortWithDirection(String field, Direction direction) {
    return sortWithDirection(Map.of(field, direction));
  }

  @Override
  public List<T> sortWithDirection(Map<String, Direction> fieldDirectionMap) {
    return createTypedQuery(super.sortWithDirectionCriteriaQuery(fieldDirectionMap))
        .getResultList();
  }

  @Override
  public T findOneByCriteria(String field, Object criteria) {
    return createTypedQuery(super.findCriteriaQuery(Map.of(field, criteria))).getSingleResult();
  }

  @Override
  public List<T> findAllByCriteria(String field, Object criteria) {
    return createTypedQuery(super.findCriteriaQuery(Map.of(field, criteria))).getResultList();
  }

  @Override
  public List<T> findAllByCriteria(Map<String, Object> fieldCriteriaMap) {
    return createTypedQuery(super.findCriteriaQuery((fieldCriteriaMap))).getResultList();
  }

  @Override
  public List<T> findByNotNull(String field) {
    return createTypedQuery(super.findByNotNullCriteriaQuery(field)).getResultList();
  }

  @Override
  public List<T> findByNull(String field) {
    return createTypedQuery(super.findByNullCriteriaQuery(field)).getResultList();
  }

  @Override
  public List<T> findLessThan(String field, Number number) {
    return createTypedQuery(super.findLessThanCriteriaQuery(field, number)).getResultList();
  }

  @Override
  public List<T> findGreaterThan(String field, Number number) {
    return createTypedQuery(super.findGreaterThanCriteriaQuery(field, number)).getResultList();
  }

  @Override
  public List<T> findAndSort(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return createTypedQuery(super.findAndSortCriteriaQuery(fieldDirectionMap, fieldCriteriaMap))
        .getResultList();
  }

  @Override
  public List<T> findContain(String field, String criteria) {
    return createTypedQuery(super.findContainCriteriaQuery(field, criteria)).getResultList();
  }

  protected TypedQuery<T> createTypedQuery(CriteriaQuery<T> criteriaQuery) {
    EntityGraph entityGraph = super.getEntityManager().getEntityGraph(entityGraphName);
    TypedQuery<T> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
    typedQuery.setHint("javax.persistence.fetchgraph", entityGraph);
    return typedQuery;
  }
}
