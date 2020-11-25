package com.senla.training;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EntityGraphAbstractDAO<T extends Serializable> extends CriteriaApiAbstractDAO<T> implements IGenericDAO<T> {

    private String entityGraphName;

    @Override
    public T findById(int id) {
        EntityGraph entityGraph = super.getEntityManager().getEntityGraph(entityGraphName);
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);
        return getEntityManager().find(getType(), id, properties);
    }

    @Override
    public List<T> findAll() {
        EntityGraph entityGraph = super.getEntityManager().getEntityGraph(entityGraphName);
        CriteriaQuery<T> q = super.getEntityManager().getCriteriaBuilder().createQuery(getType());
        q.select(q.from(getType()));
        TypedQuery<T> typedQuery = super.getEntityManager().createQuery(q);
        typedQuery.setHint("javax.persistence.loadgraph", entityGraph);
        return typedQuery.getResultList();
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
        EntityGraph entityGraph = super.getEntityManager().getEntityGraph(entityGraphName);
        TypedQuery<T> typedQuery = super.getEntityManager().createQuery(sortByCriteriaQuery(fieldDirectionMap));
        typedQuery.setHint("javax.persistence.loadgraph", entityGraph);
        return typedQuery.getResultList();
    }


    @Override
    public T findOneByCriteria(String field, Object criteria) {
        return findTypedQuery(field, criteria).getSingleResult();
    }

    @Override
    public List<T> findAllByCriteria(String field, Object criteria) {
        return findTypedQuery(field, criteria).getResultList();
    }

    @Override
    public List<T> findAllByCriteria(Map<String, Object> fieldCriteriaMap) {
        return findTypedQuery(fieldCriteriaMap).getResultList();
    }


    protected TypedQuery<T> findTypedQuery(String field, Object criteria) {
        return findTypedQuery(Map.of(field, criteria));
    }

    protected TypedQuery<T> findTypedQuery(Map<String, Object> fieldCriteriaMap) {
        EntityGraph entityGraph = super.getEntityManager().getEntityGraph(entityGraphName);
        TypedQuery<T> typedQuery = super.getEntityManager().createQuery(findCriteriaQuery(fieldCriteriaMap));
        typedQuery.setHint("javax.persistence.loadgraph", entityGraph);
        return typedQuery;
    }

    @Override
    public List<T> findByNotNull(String field) {
        EntityGraph entityGraph = super.getEntityManager().getEntityGraph(entityGraphName);
        TypedQuery<T> typedQuery = super.getEntityManager().createQuery(findByNotNullCriteriaQuery(field));
        typedQuery.setHint("javax.persistence.loadgraph", entityGraph);
        return typedQuery.getResultList();
    }


    @Override
    public List<T> findByNull(String field) {
        return getListOfObjects(findByNullCriteriaQuery(field));
    }

    @Override
    public List<T> findLessThan(String field, Number number) {
        CriteriaBuilder cb = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(getType());
        Root<T> c = q.from(getType());
        return getListOfObjects(q.select(c).where(cb.lt(c.get(field), number)));
    }


    @Override
    public List<T> findGreaterThan(String field, Number number) {
        CriteriaBuilder cb = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(getType());
        Root<T> c = q.from(getType());
        return getListOfObjects(q.select(c).where(cb.gt(c.get(field), number)));
    }

    @Override
    public List<T> findAndSort(Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
        return getListOfObjects(findAndSortByCriteria(fieldDirectionMap, fieldCriteriaMap).distinct(true));
    }

    @Override
    public List<T> findContain(String field, String criteria) {
        CriteriaBuilder cb = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(getType());
        Root<T> c = q.from(getType());
        return getListOfObjects(q.select(c).where(cb.like(c.get(field), criteria)));
    }

    public String getEntityGraphName() {
        return entityGraphName;
    }

    public void setEntityGraphName(String entityGraphName) {
        this.entityGraphName = entityGraphName;
    }
}