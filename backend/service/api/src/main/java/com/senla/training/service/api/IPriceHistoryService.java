package com.senla.training.service.api;

import com.senla.training.dao.api.IPriceHistoryDAO;
import com.senla.training.dto.pricehistory.PriceHistoryDTO;
import com.senla.training.dto.pricehistory.PriceHistoryWithCarModelBrandDTO;
import com.senla.training.models.Car;
import com.senla.training.models.enums.Direction;

import java.util.List;
import java.util.Map;

public interface IPriceHistoryService extends IGenericService<PriceHistoryDTO> {
    PriceHistoryWithCarModelBrandDTO findByIdPriceHistoryWithCarModelBrandDTO(int id);

    List<PriceHistoryWithCarModelBrandDTO> findAllAndSortWithDirectionPriceHistoryWithCarModelBrandDTO(
            Map<String, String> fieldDirectionMap);

    PriceHistoryWithCarModelBrandDTO findOneByCriteriaPriceHistoryWithCarModelBrandDTO(Map<String, Object> fieldCriteriaMap);

    List<PriceHistoryWithCarModelBrandDTO> findAllByCriteriaPriceHistoryWithCarModelBrandDTO(
            Map<String, Object> fieldCriteriaMap);

    List<PriceHistoryWithCarModelBrandDTO> findByNotNullPriceHistoryWithCarModelBrandDTO(List<String> fields);

    List<PriceHistoryWithCarModelBrandDTO> findByNullPriceHistoryWithCarModelBrandDTO(List<String> fields);

    List<PriceHistoryWithCarModelBrandDTO> findLessThanPriceHistoryWithCarModelBrandDTO(Map<String, Number> fieldNumberMap);

    List<PriceHistoryWithCarModelBrandDTO> findGreaterThanPriceHistoryWithCarModelBrandDTO(
            Map<String, Number> fieldNumberMap);

    List<PriceHistoryWithCarModelBrandDTO> findAndSortPriceHistoryWithCarModelBrandDTO(
            Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

    List<PriceHistoryWithCarModelBrandDTO> findContainPriceHistoryWithCarModelBrandDTO(Map<String, String> fieldStringMap);
}
