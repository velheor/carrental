package com.senla.training.dao.api;

import com.senla.training.models.PriceHistory;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IPriceHistoryDAO extends IGenericDAO<PriceHistory> {
  PriceHistory findByIdPriceHistoryWithCarModelBrand(int id);

  List<PriceHistory> findAllAndSortWithDirectionPriceHistoryWithCarModelBrand(
      Map<String, Direction> fieldDirectionMap);

  PriceHistory findOneByCriteriaPriceHistoryWithCarModelBrand(Map<String, Object> fieldCriteriaMap);

  List<PriceHistory> findAllByCriteriaPriceHistoryWithCarModelBrand(
      Map<String, Object> fieldCriteriaMap);

  List<PriceHistory> findByNotNullPriceHistoryWithCarModelBrand(List<String> fields);

  List<PriceHistory> findByNullPriceHistoryWithCarModelBrand(List<String> fields);

  List<PriceHistory> findLessThanPriceHistoryWithCarModelBrand(Map<String, Number> fieldNumberMap);

  List<PriceHistory> findGreaterThanPriceHistoryWithCarModelBrand(
      Map<String, Number> fieldNumberMap);

  List<PriceHistory> findAndSortPriceHistoryWithCarModelBrand(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<PriceHistory> findContainPriceHistoryWithCarModelBrand(Map<String, String> fieldStringMap);
}
