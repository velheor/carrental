package com.senla.training.service.api;

import com.senla.training.dto.rent.RentWithUserStatusHistoryCarDTO;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IRentService {
  RentWithUserStatusHistoryCarDTO createRentWithUserStatusHistoryCarDTO(
      RentWithUserStatusHistoryCarDTO rentWithUserStatusHistoryCarDTO);

  RentWithUserStatusHistoryCarDTO updateRentWithUserStatusHistoryCarDTO(
      RentWithUserStatusHistoryCarDTO rentWithUserStatusHistoryCarDTO);

  void deleteRentWithUserStatusHistoryCarDTO(
      RentWithUserStatusHistoryCarDTO rentWithUserStatusHistoryCarDTO);

  void deleteById(int id);

  RentWithUserStatusHistoryCarDTO findByIdRentWithUserStatusHistoryCarDTO(int id);

  List<RentWithUserStatusHistoryCarDTO> findAllRentWithUserStatusHistoryCarDTO();

  List<RentWithUserStatusHistoryCarDTO> sortWithDirectionRentWithUserStatusHistoryCarDTO(
      String field, Direction direction);

  List<RentWithUserStatusHistoryCarDTO> sortWithDirectionRentWithUserStatusHistoryCarDTO(
      Map<String, Direction> fieldDirectionMap);

  RentWithUserStatusHistoryCarDTO findOneByCriteriaRentWithUserStatusHistoryCarDTO(
      String field, Object criteria);

  List<RentWithUserStatusHistoryCarDTO> findAllByCriteriaRentWithUserStatusHistoryCarDTO(
      String field, Object criteria);

  List<RentWithUserStatusHistoryCarDTO> findAllByCriteriaRentWithUserStatusHistoryCarDTO(
      Map<String, Object> fieldCriteriaMap);

  List<RentWithUserStatusHistoryCarDTO> findByNotNullRentWithUserStatusHistoryCarDTO(String field);

  List<RentWithUserStatusHistoryCarDTO> findByNullRentWithUserStatusHistoryCarDTO(String field);

  List<RentWithUserStatusHistoryCarDTO> findLessThanRentWithUserStatusHistoryCarDTO(
      String field, Number number);

  List<RentWithUserStatusHistoryCarDTO> findGreaterThanRentWithUserStatusHistoryCarDTO(
      String field, Number number);

  List<RentWithUserStatusHistoryCarDTO> findAndSortRentWithUserStatusHistoryCarDTO(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<RentWithUserStatusHistoryCarDTO> findContainRentWithUserStatusHistoryCarDTO(
      String field, String criteria);
}
