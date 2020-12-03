package com.senla.training;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RentDAO extends EntityGraphAbstractDAO<Rent> implements IRentDAO {
    @Override
    public Rent findByIdRentWithUserStatusHistoryCar(int id) {
        super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
        return super.findById(id);
    }

    @Override
    public List<Rent> findAllRentWithUserStatusHistoryCar() {
        super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
        return super.findAll();
    }

    @Override
    public List<Rent> sortWithDirectionRentWithUserStatusHistoryCar(String field, Direction direction) {
        super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
        return super.sortWithDirection(field, direction);
    }

    @Override
    public List<Rent> sortWithDirectionRentWithUserStatusHistoryCar(Map<String, Direction> fieldDirectionMap) {
        super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
        return super.sortWithDirection(fieldDirectionMap);
    }

    @Override
    public Rent findOneByCriteriaRentWithUserStatusHistoryCar(String field, Object criteria) {
        super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
        return super.findOneByCriteria(field, criteria);
    }

    @Override
    public List<Rent> findAllByCriteriaRentWithUserStatusHistoryCar(String field, Object criteria) {
        super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
        return super.findAllByCriteria(field, criteria);
    }

    @Override
    public List<Rent> findAllByCriteriaRentWithUserStatusHistoryCar(Map<String, Object> fieldCriteriaMap) {
        super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
        return super.findAllByCriteria(fieldCriteriaMap);
    }

    @Override
    public List<Rent> findByNotNullRentWithUserStatusHistoryCar(String field) {
        super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
        return super.findByNotNull(field);
    }

    @Override
    public List<Rent> findByNullRentWithUserStatusHistoryCar(String field) {
        super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
        return super.findByNull(field);
    }

    @Override
    public List<Rent> findLessThanRentWithUserStatusHistoryCar(String field, Number number) {
        super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
        return super.findLessThan(field, number);
    }

    @Override
    public List<Rent> findGreaterThanRentWithUserStatusHistoryCar(String field, Number number) {
        super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
        return super.findGreaterThan(field, number);
    }

    @Override
    public List<Rent> findAndSortRentWithUserStatusHistoryCar(Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
        super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
        return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
    }

    @Override
    public List<Rent> findContainRentWithUserStatusHistoryCar(String field, String criteria) {
        super.setEntityGraphName("rentWithUserStatusHistoryCarModelBrand");
        return super.findContain(field, criteria);
    }
}