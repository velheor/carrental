package com.velheor.carrental.dao.api;

import com.velheor.carrental.models.Car;
import com.velheor.carrental.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface ICarDAO extends IGenericDAO<Car> {

  Car findByIdCarWithModelCategoryPriceHistoryBrand(int id);

  List<Car> findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrand(
      Map<String, Direction> fieldDirectionMap);

  Car findOneByCriteriaCarWithModelCategoryPriceHistoryBrand(Map<String, Object> fieldCriteriaMap);

  List<Car> findAllByCriteriaCarWithModelCategoryPriceHistoryBrand(
      Map<String, Object> fieldCriteriaMap);

  List<Car> findByNotNullCarWithModelCategoryPriceHistoryBrand(List<String> fields);

  List<Car> findByNullCarWithModelCategoryPriceHistoryBrand(List<String> fields);

  List<Car> findAndSortCarWithModelCategoryPriceHistoryBrand(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);
}
