package com.senla.training.dao.impl;

import com.senla.training.models.enums.Direction;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class CriteriaApiAbstractDAO<T> {

  private final Class<T> type;

  @PersistenceContext private EntityManager entityManager;

  CriteriaApiAbstractDAO() {
    this.type =
        (Class<T>)
            ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }

  public Class<T> getType() {
    return this.type;
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }

  protected CriteriaQuery<T> findAllCriteriaQuery() {
    CriteriaQuery<T> q = entityManager.getCriteriaBuilder().createQuery(getType());
    return q.select(q.from(getType()));
  }

  protected CriteriaQuery<T> sortWithDirectionCriteriaQuery(
      Map<String, Direction> fieldDirectionMap) {
    List<Order> orders = new ArrayList<>();
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    q.select(c);
    fieldDirectionMap.forEach(
        (field, direction) -> {
          if (direction.equals(Direction.ASC)) {
            orders.add(cb.asc(c.get(field)));
          } else {
            orders.add(cb.desc(c.get(field)));
          }
        });
    return q.orderBy(orders);
  }

  protected CriteriaQuery<T> findCriteriaQuery(Map<String, Object> fieldCriteriaMap) {
    List<Predicate> predicates = new ArrayList<>();
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    for (Map.Entry<String, Object> entry : fieldCriteriaMap.entrySet()) {
      String field = entry.getKey();
      Object criteria = entry.getValue();
      predicates.add(cb.equal(c.get(field), criteria));
    }
    return q.select(c).where(predicates.toArray(new Predicate[] {}));
  }

  protected CriteriaQuery<T> findByNotNullCriteriaQuery(String field) {
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    return q.select(c).where(cb.isNotNull(c.get(field)));
  }

  protected CriteriaQuery<T> findByNullCriteriaQuery(String field) {
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    return q.select(c).where(cb.isNotNull(c.get(field)));
  }

  protected CriteriaQuery<T> findLessThanCriteriaQuery(String field, Number number) {
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    return q.select(c).where(cb.lt(c.get(field), number));
  }

  protected CriteriaQuery<T> findGreaterThanCriteriaQuery(String field, Number number) {
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    return q.select(c).where(cb.gt(c.get(field), number));
  }

  protected CriteriaQuery<T> findAndSortCriteriaQuery(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    List<Order> orders = new ArrayList<>();
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = findCriteriaQuery(fieldCriteriaMap);
    Root<T> c = q.from(getType());
    fieldDirectionMap.forEach(
        (field, direction) -> {
          if (direction.equals(Direction.ASC)) {
            orders.add(cb.asc(c.get(field)));
          } else {
            orders.add(cb.desc(c.get(field)));
          }
        });
    return q.orderBy(orders);
  }

  protected CriteriaQuery<T> findContainCriteriaQuery(String field, String criteria) {
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    return q.select(c).where(cb.like(c.get(field), criteria));
  }
}
