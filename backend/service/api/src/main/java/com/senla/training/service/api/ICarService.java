package com.senla.training.service.api;

import com.senla.training.dto.car.CarWithCategoryDTO;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface ICarService {
  CarWithCategoryDTO createCarWithCategoryDTO(CarWithCategoryDTO carWithCategoryDTO);

  CarWithCategoryDTO updateCarWithCategoryDTO(CarWithCategoryDTO carWithCategoryDTO);

  void deleteCarWithCategoryDTO(CarWithCategoryDTO carWithCategoryDTO);

  void deleteById(int id);

  CarWithCategoryDTO findByIdCarWithCategoryDTO(int id);

  List<CarWithCategoryDTO> findAllCarWithCategoryDTO();

  List<CarWithCategoryDTO> sortWithDirectionCarWithCategoryDTO(String field, Direction direction);

  List<CarWithCategoryDTO> sortWithDirectionCarWithCategoryDTO(
      Map<String, Direction> fieldDirectionMap);

  CarWithCategoryDTO findOneByCriteriaCarWithCategoryDTO(String field, Object criteria);

  List<CarWithCategoryDTO> findAllByCriteriaCarWithCategoryDTO(String field, Object criteria);

  List<CarWithCategoryDTO> findAllByCriteriaCarWithCategoryDTO(
      Map<String, Object> fieldCriteriaMap);

  List<CarWithCategoryDTO> findByNotNullCarWithCategoryDTO(String field);

  List<CarWithCategoryDTO> findByNullCarWithCategoryDTO(String field);

  List<CarWithCategoryDTO> findLessThanCarWithCategoryDTO(String field, Number number);

  List<CarWithCategoryDTO> findGreaterThanCarWithCategoryDTO(String field, Number number);

  List<CarWithCategoryDTO> findAndSortCarWithCategoryDTO(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<CarWithCategoryDTO> findContainCarWithCategoryDTO(String field, String criteria);
}
