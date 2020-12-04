package com.senla.training.dao.impl;

import com.senla.training.dao.api.ICarDAO;
import com.senla.training.models.Car;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAO extends EntityGraphAbstractDAO<Car> implements ICarDAO {
  @Override
  public Car findByIdCarWithCategory(int id) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser");
    return super.findById(id);
  }

  @Override
  public List<Car> findAllCarWithCategory() {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser");
    return super.findAll();
  }

  @Override
  public List<Car> sortWithDirectionCarWithCategory(String field, Direction direction) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser");
    return super.sortWithDirection(field, direction);
  }

  @Override
  public List<Car> sortWithDirectionCarWithCategory(Map<String, Direction> fieldDirectionMap) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser");
    return super.sortWithDirection(fieldDirectionMap);
  }

  @Override
  public Car findOneByCriteriaCarWithCategory(String field, Object criteria) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser");
    return super.findOneByCriteria(field, criteria);
  }

  @Override
  public List<Car> findAllByCriteriaCarWithCategory(String field, Object criteria) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser");
    return super.findAllByCriteria(field, criteria);
  }

  @Override
  public List<Car> findAllByCriteriaCarWithCategory(Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser");
    return super.findAllByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Car> findByNotNullCarWithCategory(String field) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser");
    return super.findByNotNull(field);
  }

  @Override
  public List<Car> findByNullCarWithCategory(String field) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser");
    return super.findByNull(field);
  }

  @Override
  public List<Car> findLessThanCarWithCategory(String field, Number number) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser");
    return super.findLessThan(field, number);
  }

  @Override
  public List<Car> findGreaterThanCarWithCategory(String field, Number number) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser");
    return super.findGreaterThan(field, number);
  }

  @Override
  public List<Car> findAndSortCarWithCategory(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }

  @Override
  public List<Car> findContainCarWithCategory(String field, String criteria) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndRentsAndModelAndUser");
    return super.findContain(field, criteria);
  }
}
