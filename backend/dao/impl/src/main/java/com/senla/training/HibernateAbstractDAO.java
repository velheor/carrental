package com.senla.training;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class HibernateAbstractDAO<T extends Serializable> implements GenericDAO<T> {

    private final Class<T> type;

    @PersistenceContext
    private EntityManager entityManager;

    public HibernateAbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getType() {
        return this.type;
    }

    @Override
    public T findById(int id) {
        return entityManager.find(getType(), id);
    }

    @Override
    public  List<T> findAll() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(getType());
        Root<T> c = q.from(getType());
        return getListOfObjects(q.select(c));
    }

    @Override
    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteById(int entityId) {
        delete(findById(entityId));
    }

    @Override
    public List<T> sortWithDirection(String field, Direction direction) {
        return getListOfObjects(sortByCriteriaQuery(Map.of(field, direction)));
    }

    @Override
    public List<T> sortWithDirection(Map<String, Direction> fieldDirectionMap) {
        return getListOfObjects(sortByCriteriaQuery(fieldDirectionMap));
    }

    protected CriteriaQuery<T> sortByCriteriaQuery(Map<String, Direction> fieldDirectionMap) {
        List<Order> orders = new ArrayList<>();
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(getType());
        Root<T> c = q.from(getType());
        q.select(c);
        fieldDirectionMap.forEach((field, direction) -> {
            if (direction.equals(Direction.ASC)) {
                orders.add(cb.asc(c.get(field)));
            } else {
                orders.add(cb.desc(c.get(field)));
            }
        });
        return q.orderBy(orders);
    }

    @Override
    public T findOneByCriteria(String field, Object criteria) {
        return entityManager.createQuery(findCriteriaQuery(field, criteria)).getSingleResult();
    }

    @Override
    public List<T> findAllByCriteria(String field, Object criteria) {
        return entityManager.createQuery(findCriteriaQuery(field, criteria)).getResultList();
    }

    @Override
    public List<T> findAllByCriteria(Map<String, Object> fieldCriteriaMap) {
        return entityManager.createQuery(findCriteriaQuery(fieldCriteriaMap)).getResultList();
    }

    protected CriteriaQuery<T> findCriteriaQuery(String field, Object criteria) {
        return findCriteriaQuery(Map.of(field, criteria));
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
        return q.select(c).where(predicates.toArray(new Predicate[]{}));
    }

    @Override
    public List<T> findByNotNull(String field) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(getType());
        Root<T> c = q.from(getType());
        return getListOfObjects(q.select(c).where(cb.isNotNull(c.get(field))));
    }

    @Override
    public List<T> findByNull(String field) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(getType());
        Root<T> c = q.from(getType());
        return getListOfObjects(q.select(c).where(cb.isNull(c.get(field))));
    }

    @Override
    public List<T> findLessThan(String field, Number number) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(getType());
        Root<T> c = q.from(getType());
        return getListOfObjects(q.select(c).where(cb.lt(c.get(field), number)));
    }

    @Override
    public List<T> findGreaterThan(String field, Number number) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(getType());
        Root<T> c = q.from(getType());
        return getListOfObjects(q.select(c).where(cb.gt(c.get(field), number)));
    }

    @Override
    public List<T> findAndSort(Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
        return getListOfObjects(findAndSortByCriteria(fieldDirectionMap, fieldCriteriaMap).distinct(true));
    }

    protected CriteriaQuery<T> findAndSortByCriteria(Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
        List<Order> orders = new ArrayList<>();
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> q = findCriteriaQuery(fieldCriteriaMap);
        Root<T> c = q.from(getType());
        fieldDirectionMap.forEach((field, direction) -> {
            if (direction.equals(Direction.ASC)) {
                orders.add(cb.asc(c.get(field)));
            } else {
                orders.add(cb.desc(c.get(field)));
            }
        });
        return q.orderBy(orders);
    }

    @Override
    public List<T> findContain(String field, String criteria) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(getType());
        Root<T> c = q.from(getType());
        return getListOfObjects(q.select(c).where(cb.like(c.get(field), criteria)));
    }

    protected List<T> getListOfObjects(CriteriaQuery<T> criteriaQuery) {
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}