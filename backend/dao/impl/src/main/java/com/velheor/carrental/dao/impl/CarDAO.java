package com.velheor.carrental.dao.impl;

import com.velheor.carrental.dao.api.ICarDAO;
import com.velheor.carrental.models.Car;
import com.velheor.carrental.models.enums.Direction;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAO extends EntityGraphAbstractDAO<Car> implements ICarDAO {

  @Override
  public Car findByIdCarWithModelCategoryPriceHistoryBrand(int id) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndBrand");
    return super.findById(id);
  }

  @Override
  public Car findByIdCarWithRents(int id) {
    super.setEntityGraphName("carWithRents");
    return super.findById(id);
  }

  @Override
  public List<Car> findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrand(
      Map<String, Direction> fieldDirectionMap) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndBrand");
    return super.findAllAndSortWithDirection(fieldDirectionMap);
  }

  @Override
  public Car findOneByCriteriaCarWithModelCategoryPriceHistoryBrand(
      Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndBrand");
    return super.findOneByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Car> findAllByCriteriaCarWithModelCategoryPriceHistoryBrand(
      Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndBrand");
    return super.findAllByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<Car> findByNotNullCarWithModelCategoryPriceHistoryBrand(List<String> fields) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndBrand");
    return super.findByNotNull(fields);
  }

  @Override
  public List<Car> findByNullCarWithModelCategoryPriceHistoryBrand(List<String> fields) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndBrand");
    return super.findByNull(fields);
  }

  @Override
  public List<Car> findAndSortCarWithModelCategoryPriceHistoryBrand(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("carWithModelAndCategoryAndPriceHistoryAndBrand");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }
}
