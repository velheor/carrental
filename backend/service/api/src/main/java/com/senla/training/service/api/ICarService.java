package com.senla.training.service.api;

import com.senla.training.dto.car.CarDTO;
import com.senla.training.dto.car.CarWithModelCategoryPriceHistoryBrandDTO;
import java.util.List;
import java.util.Map;

public interface ICarService extends IGenericService<CarDTO> {
  CarWithModelCategoryPriceHistoryBrandDTO findByIdCarWithModelCategoryPriceHistoryBrandDTO(int id);

  List<CarWithModelCategoryPriceHistoryBrandDTO>
      findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrandDTO(
          Map<String, String> fieldDirectionMap);

  CarWithModelCategoryPriceHistoryBrandDTO
      findOneByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(
          Map<String, Object> fieldCriteriaMap);

  List<CarWithModelCategoryPriceHistoryBrandDTO>
      findAllByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(
          Map<String, Object> fieldCriteriaMap);

  List<CarWithModelCategoryPriceHistoryBrandDTO>
      findByNotNullCarWithModelCategoryPriceHistoryBrandDTO(List<String> fields);

  List<CarWithModelCategoryPriceHistoryBrandDTO> findByNullCarWithModelCategoryPriceHistoryBrandDTO(
      List<String> fields);

  List<CarWithModelCategoryPriceHistoryBrandDTO>
      findLessThanCarWithModelCategoryPriceHistoryBrandDTO(Map<String, Number> fieldNumberMap);

  List<CarWithModelCategoryPriceHistoryBrandDTO>
      findGreaterThanCarWithModelCategoryPriceHistoryBrandDTO(Map<String, Number> fieldNumberMap);

  List<CarWithModelCategoryPriceHistoryBrandDTO>
      findAndSortCarWithModelCategoryPriceHistoryBrandDTO(
          Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<CarWithModelCategoryPriceHistoryBrandDTO>
      findContainCarWithModelCategoryPriceHistoryBrandDTO(Map<String, String> fieldStringMap);
}
