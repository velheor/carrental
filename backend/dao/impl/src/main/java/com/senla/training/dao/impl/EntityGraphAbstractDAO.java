package com.senla.training.dao.impl;

import com.senla.training.dao.api.IGenericDAO;
import com.senla.training.models.enums.Direction;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityGraph;
import javax.persistence.NoResultException;
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
    return findOneByCriteria(Map.of("id", id));
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
    this.delete(this.findById(id));
  }

  @Override
  public List<T> findAllAndSortWithDirection(Map<String, Direction> fieldDirectionMap) {
    return createTypedQuery(super.sortWithDirectionCriteriaQuery(fieldDirectionMap))
        .getResultList();
  }

  @Override
  public T findOneByCriteria(Map<String, Object> fieldCriterionMap) {
    try {
      return createTypedQuery(super.findCriteriaQuery(fieldCriterionMap)).getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }

  @Override
  public List<T> findAllByCriteria(Map<String, Object> fieldCriterionMap) {
    return createTypedQuery(super.findCriteriaQuery(fieldCriterionMap)).getResultList();
  }

  @Override
  public List<T> findByNotNull(List<String> fields) {
    return createTypedQuery(super.findByNotNullCriteriaQuery(fields)).getResultList();
  }

  @Override
  public List<T> findByNull(List<String> fields) {
    return createTypedQuery(super.findByNullCriteriaQuery(fields)).getResultList();
  }

  @Override
  public List<T> findAndSort(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return createTypedQuery(super.findAndSortCriteriaQuery(fieldDirectionMap, fieldCriteriaMap))
        .getResultList();
  }

  private TypedQuery<T> createTypedQuery(CriteriaQuery<T> criteriaQuery) {
    EntityGraph entityGraph = super.getEntityManager().getEntityGraph(entityGraphName);
    TypedQuery<T> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
    typedQuery.setHint("javax.persistence.fetchgraph", entityGraph);
    return typedQuery;
  }
}
