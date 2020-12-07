package com.senla.training.service.api;

import com.senla.training.dto.statusHistory.StatusHistoryDTO;
import com.senla.training.dto.statusHistory.StatusHistoryWithRentDTO;
import java.util.List;
import java.util.Map;

public interface IStatusHistoryService extends IGenericService<StatusHistoryDTO> {
  StatusHistoryWithRentDTO findByIdStatusHistoryWithRentDTO(int id);

  List<StatusHistoryWithRentDTO> findAllAndSortWithDirectionStatusHistoryWithRentDTO(
      Map<String, String> fieldDirectionMap);

  StatusHistoryWithRentDTO findOneByCriteriaStatusHistoryWithRentDTO(
      Map<String, Object> fieldCriteriaMap);

  List<StatusHistoryWithRentDTO> findAllByCriteriaStatusHistoryWithRentDTO(
      Map<String, Object> fieldCriteriaMap);

  List<StatusHistoryWithRentDTO> findByNotNullStatusHistoryWithRentDTO(List<String> fields);

  List<StatusHistoryWithRentDTO> findByNullStatusHistoryWithRentDTO(List<String> fields);

  List<StatusHistoryWithRentDTO> findLessThanStatusHistoryWithRentDTO(
      Map<String, Number> fieldNumberMap);

  List<StatusHistoryWithRentDTO> findGreaterThanStatusHistoryWithRentDTO(
      Map<String, Number> fieldNumberMap);

  List<StatusHistoryWithRentDTO> findAndSortStatusHistoryWithRentDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<StatusHistoryWithRentDTO> findContainStatusHistoryWithRentDTO(
      Map<String, String> fieldStringMap);
}
