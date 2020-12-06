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

  protected CriteriaQuery<T> findByNotNullCriteriaQuery(List<String> fields) {
    List<Predicate> predicates = new ArrayList<>();
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    fields.forEach(field -> predicates.add(cb.isNotNull(c.get(field))));
    return q.select(c).where(predicates.toArray(new Predicate[] {}));
  }

  protected CriteriaQuery<T> findByNullCriteriaQuery(List<String> fields) {
    List<Predicate> predicates = new ArrayList<>();
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    fields.forEach(field -> predicates.add(cb.isNull(c.get(field))));
    return q.select(c).where(predicates.toArray(new Predicate[] {}));
  }

  protected CriteriaQuery<T> findLessThanCriteriaQuery(Map<String, Number> fieldNumberMap) {
    List<Predicate> predicates = new ArrayList<>();
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    for (Map.Entry<String, Number> entry : fieldNumberMap.entrySet()) {
      String field = entry.getKey();
      Number number = entry.getValue();
      predicates.add(cb.lt(c.get(field), number));
    }
    return q.select(c).where(predicates.toArray(new Predicate[] {}));
  }

  protected CriteriaQuery<T> findGreaterThanCriteriaQuery(Map<String, Number> fieldNumberMap) {
    List<Predicate> predicates = new ArrayList<>();
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    for (Map.Entry<String, Number> entry : fieldNumberMap.entrySet()) {
      String field = entry.getKey();
      Number number = entry.getValue();
      predicates.add(cb.gt(c.get(field), number));
    }
    return q.select(c).where(predicates.toArray(new Predicate[] {}));
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

  protected CriteriaQuery<T> findContainCriteriaQuery(Map<String, String> fieldStringMap) {
    List<Predicate> predicates = new ArrayList<>();
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    for (Map.Entry<String, String> entry : fieldStringMap.entrySet()) {
      String field = entry.getKey();
      String contain = entry.getValue();
      predicates.add(cb.like(c.get(field), contain));
    }
    return q.select(c).where(predicates.toArray(new Predicate[] {}));
  }
}
