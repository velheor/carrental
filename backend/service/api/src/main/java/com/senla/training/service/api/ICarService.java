package com.senla.training.service.api;

import com.senla.training.dto.CarDTO;
import java.util.List;
import java.util.Map;

public interface ICarService extends IGenericService<com.senla.training.dto.CarDTO> {

  CarDTO findByIdCarWithModelCategoryPriceHistoryBrandDTO(int id);

  List<CarDTO>
  findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrandDTO(
      Map<String, String> fieldDirectionMap);

  CarDTO
  findOneByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(
      Map<String, Object> fieldCriteriaMap);

  List<CarDTO>
  findAllByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(
      Map<String, Object> fieldCriteriaMap);

  List<CarDTO>
  findByNotNullCarWithModelCategoryPriceHistoryBrandDTO(List<String> fields);

  List<CarDTO> findByNullCarWithModelCategoryPriceHistoryBrandDTO(
      List<String> fields);

  List<CarDTO>
  findAndSortCarWithModelCategoryPriceHistoryBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

}
