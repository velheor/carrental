package com.senla.training.service.api;

import com.senla.training.dto.StatusHistoryDTO;
import java.util.List;
import java.util.Map;

public interface IStatusHistoryService extends IGenericService<StatusHistoryDTO> {

  StatusHistoryDTO findByIdStatusHistoryWithRentDTO(int id);

  List<StatusHistoryDTO> findAllAndSortWithDirectionStatusHistoryWithRentDTO(
      Map<String, String> fieldDirectionMap);

  StatusHistoryDTO findOneByCriteriaStatusHistoryWithRentDTO(
      Map<String, Object> fieldCriteriaMap);

  List<StatusHistoryDTO> findAllByCriteriaStatusHistoryWithRentDTO(
      Map<String, Object> fieldCriteriaMap);

  List<StatusHistoryDTO> findByNotNullStatusHistoryWithRentDTO(List<String> fields);

  List<StatusHistoryDTO> findByNullStatusHistoryWithRentDTO(List<String> fields);

  List<StatusHistoryDTO> findAndSortStatusHistoryWithRentDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

}
