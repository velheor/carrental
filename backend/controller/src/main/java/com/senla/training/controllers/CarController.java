package com.senla.training.controllers;

import com.senla.training.dto.car.CarWithCategoryDTO;
import com.senla.training.models.enums.Direction;
import com.senla.training.service.api.ICarService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

  private final ICarService carService;

  @Autowired
  CarController(ICarService carService) {
    this.carService = carService;
  }

  @GetMapping("/{id}")
  public CarWithCategoryDTO getByIdWithRoleDTO(@PathVariable("id") Integer id) {
    return carService.findByIdCarWithCategoryDTO(id);
  }

  @GetMapping
  public List<CarWithCategoryDTO> findAllCarWithCategoryDTO() {
    return carService.findAllCarWithCategoryDTO();
  }

  @GetMapping("/sort")
  public List<CarWithCategoryDTO> sortWithDirectionCarWithCategoryDTO(
      @RequestParam Map<String, Direction> allParams) {
    return carService.sortWithDirectionCarWithCategoryDTO(allParams);
  }

  @PutMapping
  public CarWithCategoryDTO updateCarWithCategoryDTO(
      @RequestBody CarWithCategoryDTO carWithCategoryDTO) {
    return carService.updateCarWithCategoryDTO(carWithCategoryDTO);
  }

  @PostMapping
  public CarWithCategoryDTO saveCarWithCategoryDTO(
      @RequestBody CarWithCategoryDTO carWithCategoryDTO) {
    return carService.createCarWithCategoryDTO(carWithCategoryDTO);
  }

  @DeleteMapping
  public CarWithCategoryDTO deleteCarWithCategoryDTO(
      @RequestBody CarWithCategoryDTO carWithCategoryDTO) {
    carService.deleteCarWithCategoryDTO(carWithCategoryDTO);
    return carWithCategoryDTO;
  }

  @GetMapping("/findOneByCriteria")
  public CarWithCategoryDTO findOneByCriteriaCarWithCategoryDTO(
      @RequestParam String field, @RequestParam Object criteria) {
    return carService.findOneByCriteriaCarWithCategoryDTO(field, criteria);
  }

  @GetMapping("/findAllByCriteria")
  public List<CarWithCategoryDTO> findAllByCriteriaCarWithCategoryDTO(
      @RequestParam String field, @RequestParam Object criteria) {
    return carService.findAllByCriteriaCarWithCategoryDTO(field, criteria);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<CarWithCategoryDTO> findAllByCriteriaCarWithCategoryDTO(
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return carService.findAllByCriteriaCarWithCategoryDTO(fieldCriteriaMap);
  }

  @GetMapping("/findByNotNull")
  public List<CarWithCategoryDTO> findByNotNullCarWithCategoryDTO(@RequestParam String field) {
    return carService.findByNotNullCarWithCategoryDTO(field);
  }

  @GetMapping("/findByNull")
  public List<CarWithCategoryDTO> findByNullCarWithCategoryDTO(@RequestParam String field) {
    return carService.findByNullCarWithCategoryDTO(field);
  }

  @GetMapping("/finLessThan")
  public List<CarWithCategoryDTO> findLessThanCarWithCategoryDTO(
      @RequestParam String field, Number number) {
    return carService.findLessThanCarWithCategoryDTO(field, number);
  }

  @GetMapping("/findGreaterThan")
  public List<CarWithCategoryDTO> findGreaterThanCarWithCategoryDTO(
      @RequestParam String field, Number number) {
    return carService.findGreaterThanCarWithCategoryDTO(field, number);
  }

  @GetMapping("/findAndSort")
  public List<CarWithCategoryDTO> findAndSortCarWithCategoryDTO(
      @RequestParam Map<String, Direction> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return carService.findAndSortCarWithCategoryDTO(fieldDirectionMap, fieldCriteriaMap);
  }

  @GetMapping("/findContain")
  public List<CarWithCategoryDTO> findContainCarWithCategoryDTO(String field, String criteria) {
    return carService.findContainCarWithCategoryDTO(field, criteria);
  }
}
