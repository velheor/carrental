package com.senla.training.dao.impl;

import com.senla.training.dao.api.IPriceHistoryDAO;
import com.senla.training.models.PriceHistory;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class PriceHistoryDAO extends EntityGraphAbstractDAO<PriceHistory>
    implements IPriceHistoryDAO {
  @Override
  public PriceHistory findByIdPriceHistoryWithCarModelBrand(int id) {
    super.setEntityGraphName("priceHistoryWithCarModelBrand");
    return super.findById(id);
  }

  @Override
  public List<PriceHistory> findAllAndSortWithDirectionPriceHistoryWithCarModelBrand(
      Map<String, Direction> fieldDirectionMap) {
    super.setEntityGraphName("priceHistoryWithCarModelBrand");
    return super.findAllAndSortWithDirection(fieldDirectionMap);
  }

  @Override
  public PriceHistory findOneByCriteriaPriceHistoryWithCarModelBrand(
      Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("priceHistoryWithCarModelBrand");
    return super.findOneByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<PriceHistory> findAllByCriteriaPriceHistoryWithCarModelBrand(
      Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("priceHistoryWithCarModelBrand");
    return super.findAllByCriteria(fieldCriteriaMap);
  }

  @Override
  public List<PriceHistory> findByNotNullPriceHistoryWithCarModelBrand(List<String> fields) {
    super.setEntityGraphName("priceHistoryWithCarModelBrand");
    return super.findByNotNull(fields);
  }

  @Override
  public List<PriceHistory> findByNullPriceHistoryWithCarModelBrand(List<String> fields) {
    super.setEntityGraphName("priceHistoryWithCarModelBrand");
    return super.findByNull(fields);
  }

  @Override
  public List<PriceHistory> findLessThanPriceHistoryWithCarModelBrand(
      Map<String, Number> fieldNumberMap) {
    super.setEntityGraphName("priceHistoryWithCarModelBrand");
    return super.findLessThan(fieldNumberMap);
  }

  @Override
  public List<PriceHistory> findGreaterThanPriceHistoryWithCarModelBrand(
      Map<String, Number> fieldNumberMap) {
    super.setEntityGraphName("priceHistoryWithCarModelBrand");
    return super.findGreaterThan(fieldNumberMap);
  }

  @Override
  public List<PriceHistory> findAndSortPriceHistoryWithCarModelBrand(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    super.setEntityGraphName("priceHistoryWithCarModelBrand");
    return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
  }

  @Override
  public List<PriceHistory> findContainPriceHistoryWithCarModelBrand(
      Map<String, String> fieldStringMap) {
    super.setEntityGraphName("priceHistoryWithCarModelBrand");
    return super.findContain(fieldStringMap);
  }
}
