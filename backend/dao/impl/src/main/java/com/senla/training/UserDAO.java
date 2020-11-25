package com.senla.training;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDAO extends EntityGraphAbstractDAO<User> implements IUserDAO {
    @Override
    public User findById(int id) {
        super.setEntityGraphName("userWithRolesAndRentsAndCar");
        return super.findById(id);
    }

    @Override
    public List<User> findAll() {
        super.setEntityGraphName("userWithRolesAndRentsAndCar");
        return super.findAll();
    }

    @Override
    public User create(User entity) {
        return super.create(entity);
    }

    @Override
    public User update(User entity) {
        return super.update(entity);
    }

    @Override
    public void delete(User entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(int id) {
        deleteById(id);
    }

    @Override
    public List<User> sortWithDirection(String field, Direction direction) {
        super.setEntityGraphName("userWithRolesAndRentsAndCar");
        return super.sortWithDirection(field, direction);
    }

    @Override
    public List<User> sortWithDirection(Map<String, Direction> fieldDirectionMap) {
        super.setEntityGraphName("userWithRolesAndRentsAndCar");
        return super.sortWithDirection(fieldDirectionMap);
    }

    @Override
    public User findOneByCriteria(String field, Object criteria) {
        super.setEntityGraphName("userWithRolesAndRentsAndCar");
        return super.findOneByCriteria(field, criteria);
    }

    @Override
    public List<User> findAllByCriteria(String field, Object criteria) {
        super.setEntityGraphName("userWithRolesAndRentsAndCar");
        return super.findAllByCriteria(field, criteria);
    }

    @Override
    public List<User> findAllByCriteria(Map<String, Object> fieldCriteriaMap) {
        super.setEntityGraphName("userWithRolesAndRentsAndCar");
        return super.findAllByCriteria(fieldCriteriaMap);
    }

    @Override
    public List<User> findByNotNull(String field) {
        super.setEntityGraphName("userWithRolesAndRentsAndCar");
        return super.findByNotNull(field);
    }

    @Override
    public List<User> findByNull(String field) {
        super.setEntityGraphName("userWithRolesAndRentsAndCar");
        return super.findByNull(field);
    }

    @Override
    public List<User> findLessThan(String field, Number number) {
        super.setEntityGraphName("userWithRolesAndRentsAndCar");
        return super.findLessThan(field, number);
    }

    @Override
    public List<User> findGreaterThan(String field, Number number) {
        super.setEntityGraphName("userWithRolesAndRentsAndCar");
        return super.findGreaterThan(field, number);
    }

    @Override
    public List<User> findAndSort(Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
        super.setEntityGraphName("userWithRolesAndRentsAndCar");
        return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
    }

    @Override
    public List<User> findContain(String field, String criteria) {
        super.setEntityGraphName("userWithRolesAndRentsAndCar");
        return super.findContain(field, criteria);
    }
}