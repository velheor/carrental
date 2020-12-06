package com.senla.training.service.api;

import com.senla.training.dto.rent.RentDTO;
import com.senla.training.dto.rent.RentWithUserStatusHistoryCarModelBrandDTO;
import java.util.List;
import java.util.Map;

public interface IRentService extends IGenericService<RentDTO> {
  RentWithUserStatusHistoryCarModelBrandDTO findByIdRentWithUserStatusHistoryCarModelBrandDTO(
      int id);

  List<RentWithUserStatusHistoryCarModelBrandDTO>
      findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrandDTO(
          Map<String, String> fieldDirectionMap);

  RentWithUserStatusHistoryCarModelBrandDTO
      findOneByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
          Map<String, Object> fieldCriteriaMap);

  List<RentWithUserStatusHistoryCarModelBrandDTO>
      findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
          Map<String, Object> fieldCriteriaMap);

  List<RentWithUserStatusHistoryCarModelBrandDTO>
      findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(List<String> fields);

  List<RentWithUserStatusHistoryCarModelBrandDTO>
      findByNullRentWithUserStatusHistoryCarModelBrandDTO(List<String> fields);

  List<RentWithUserStatusHistoryCarModelBrandDTO>
      findLessThanRentWithUserStatusHistoryCarModelBrandDTO(Map<String, Number> fieldNumberMap);

  List<RentWithUserStatusHistoryCarModelBrandDTO>
      findGreaterThanRentWithUserStatusHistoryCarModelBrandDTO(Map<String, Number> fieldNumberMap);

  List<RentWithUserStatusHistoryCarModelBrandDTO>
      findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
          Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<RentWithUserStatusHistoryCarModelBrandDTO>
      findContainRentWithUserStatusHistoryCarModelBrandDTO(Map<String, String> fieldStringMap);
}
