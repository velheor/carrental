package com.senla.training.service.api;

import com.senla.training.dto.RentDTO;
import java.util.List;
import java.util.Map;

public interface IRentService extends IGenericService<RentDTO> {
  RentDTO findByIdRentWithUserStatusHistoryCarModelBrandDTO(
      int id);

  List<RentDTO>
      findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrandDTO(
          Map<String, String> fieldDirectionMap);

  RentDTO
      findOneByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
          Map<String, Object> fieldCriteriaMap);

  List<RentDTO>
      findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
          Map<String, Object> fieldCriteriaMap);

  List<RentDTO>
      findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(List<String> fields);

  List<RentDTO>
      findByNullRentWithUserStatusHistoryCarModelBrandDTO(List<String> fields);

  List<RentDTO>
      findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
          Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<RentDTO>
      findContainRentWithUserStatusHistoryCarModelBrandDTO(Map<String, String> fieldStringMap);
}
