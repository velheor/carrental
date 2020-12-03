package com.senla.training;

import com.senla.training.rent.RentWithUserStatusHistoryCarModelBrandDTO;

import java.util.List;
import java.util.Map;

public interface IRentService {
    RentWithUserStatusHistoryCarModelBrandDTO createRentWithUserStatusHistoryCarDTO(RentWithUserStatusHistoryCarModelBrandDTO RentWithUserStatusHistoryCarModelBrandDTO);

    RentWithUserStatusHistoryCarModelBrandDTO updateRentWithUserStatusHistoryCarDTO(RentWithUserStatusHistoryCarModelBrandDTO RentWithUserStatusHistoryCarModelBrandDTO);

    void deleteRentWithUserStatusHistoryCarDTO(RentWithUserStatusHistoryCarModelBrandDTO RentWithUserStatusHistoryCarModelBrandDTO);

    void deleteById(int id);

    RentWithUserStatusHistoryCarModelBrandDTO findByIdRentWithUserStatusHistoryCarDTO(int id);

    List<RentWithUserStatusHistoryCarModelBrandDTO> findAllRentWithUserStatusHistoryCarDTO();

    List<RentWithUserStatusHistoryCarModelBrandDTO> sortWithDirectionRentWithUserStatusHistoryCarDTO(String field, Direction direction);

    List<RentWithUserStatusHistoryCarModelBrandDTO> sortWithDirectionRentWithUserStatusHistoryCarDTO(Map<String, Direction> fieldDirectionMap);

    RentWithUserStatusHistoryCarModelBrandDTO findOneByCriteriaRentWithUserStatusHistoryCarDTO(String field, Object criteria);

    List<RentWithUserStatusHistoryCarModelBrandDTO> findAllByCriteriaRentWithUserStatusHistoryCarDTO(String field, Object criteria);

    List<RentWithUserStatusHistoryCarModelBrandDTO> findAllByCriteriaRentWithUserStatusHistoryCarDTO(Map<String, Object> fieldCriteriaMap);

    List<RentWithUserStatusHistoryCarModelBrandDTO> findByNotNullRentWithUserStatusHistoryCarDTO(String field);

    List<RentWithUserStatusHistoryCarModelBrandDTO> findByNullRentWithUserStatusHistoryCarDTO(String field);

    List<RentWithUserStatusHistoryCarModelBrandDTO> findLessThanRentWithUserStatusHistoryCarDTO(String field, Number number);

    List<RentWithUserStatusHistoryCarModelBrandDTO> findGreaterThanRentWithUserStatusHistoryCarDTO(String field, Number number);

    List<RentWithUserStatusHistoryCarModelBrandDTO> findAndSortRentWithUserStatusHistoryCarDTO(Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

    List<RentWithUserStatusHistoryCarModelBrandDTO> findContainRentWithUserStatusHistoryCarDTO(String field, String criteria);
}
