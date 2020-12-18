package com.senla.training.service.api;

import com.senla.training.dto.PriceHistoryDTO;
import java.util.List;
import java.util.Map;

public interface IPriceHistoryService extends IGenericService<PriceHistoryDTO> {

  PriceHistoryDTO findByIdPriceHistoryWithCarModelBrandDTO(int id);

  List<PriceHistoryDTO> findAllAndSortWithDirectionPriceHistoryWithCarModelBrandDTO(
      Map<String, String> fieldDirectionMap);

  PriceHistoryDTO findOneByCriteriaPriceHistoryWithCarModelBrandDTO(
      Map<String, Object> fieldCriteriaMap);

  List<PriceHistoryDTO> findAllByCriteriaPriceHistoryWithCarModelBrandDTO(
      Map<String, Object> fieldCriteriaMap);

  List<PriceHistoryDTO> findByNotNullPriceHistoryWithCarModelBrandDTO(List<String> fields);

  List<PriceHistoryDTO> findByNullPriceHistoryWithCarModelBrandDTO(List<String> fields);

  List<PriceHistoryDTO> findAndSortPriceHistoryWithCarModelBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);
}
