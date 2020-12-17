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
    return getSortedCriteriaQuery(fieldDirectionMap, orders, cb, q);
  }

  protected CriteriaQuery<T> findCriteriaQuery(Map<String, Object> fieldCriteriaMap) {
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    return q.select(c)
        .where(
            this.getPredicateFindByCriteria(cb, c, fieldCriteriaMap).toArray(new Predicate[] {}));
  }

  protected CriteriaQuery<T> findByNotNullCriteriaQuery(List<String> fields) {
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    return q.select(c).where(getPredicateByNotNull(cb, c, fields).toArray(new Predicate[] {}));
  }

  protected CriteriaQuery<T> findByNullCriteriaQuery(List<String> fields) {
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(getType());
    Root<T> c = q.from(getType());
    return q.select(c).where(this.getPredicateByNull(cb, c, fields).toArray(new Predicate[] {}));
  }

  protected CriteriaQuery<T> findAndSortCriteriaQuery(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    List<Order> orders = new ArrayList<>();
    CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<T> q = findCriteriaQuery(fieldCriteriaMap);
    return getSortedCriteriaQuery(fieldDirectionMap, orders, cb, q);
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

  private List<Predicate> getPredicateFindByCriteria(
      CriteriaBuilder cb, Root<T> c, Map<String, Object> fieldCriteriaMap) {
    List<Predicate> predicates = new ArrayList<>();
    for (Map.Entry<String, Object> entry : fieldCriteriaMap.entrySet()) {
      predicates.add(cb.equal(c.get(entry.getKey()), entry.getValue()));
    }
    return predicates;
  }

  private List<Predicate> getPredicateByNotNull(
      CriteriaBuilder cb, Root<T> c, List<String> fields) {
    List<Predicate> predicates = new ArrayList<>();
    fields.forEach(field -> predicates.add(cb.isNotNull(c.get(field))));
    return predicates;
  }

  private List<Predicate> getPredicateByNull(CriteriaBuilder cb, Root<T> c, List<String> fields) {
    List<Predicate> predicates = new ArrayList<>();
    fields.forEach(field -> predicates.add(cb.isNull(c.get(field))));
    return predicates;
  }

  private List<Predicate> getPredicateLT(
      CriteriaBuilder cb, Root<T> c, Map<String, Number> fieldNumberMap) {
    List<Predicate> predicates = new ArrayList<>();
    for (Map.Entry<String, Number> entry : fieldNumberMap.entrySet()) {
      predicates.add(cb.lt(c.get(entry.getKey()), entry.getValue()));
    }
    return predicates;
  }

  private List<Predicate> getPredicateGT(
      CriteriaBuilder cb, Root<T> c, Map<String, Number> fieldNumberMap) {
    List<Predicate> predicates = new ArrayList<>();
    for (Map.Entry<String, Number> entry : fieldNumberMap.entrySet()) {
      predicates.add(cb.gt(c.get(entry.getKey()), entry.getValue()));
    }
    return predicates;
  }

  private CriteriaQuery<T> getSortedCriteriaQuery(
      Map<String, Direction> fieldDirectionMap,
      List<Order> orders,
      CriteriaBuilder cb,
      CriteriaQuery<T> q) {
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
}
