package com.senla.training.controllers;

import com.senla.training.dto.car.CarDTO;
import com.senla.training.dto.car.CarWithModelCategoryPriceHistoryBrandDTO;
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
  public CarWithModelCategoryPriceHistoryBrandDTO getByIdUserWithRoles(
      @PathVariable("id") Integer id) {
    return carService.findByIdCarWithModelCategoryPriceHistoryBrandDTO(id);
  }

  @GetMapping
  public List<CarWithModelCategoryPriceHistoryBrandDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return carService.findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrandDTO(
        allParams);
  }

  @PutMapping
  public CarDTO update(@RequestBody CarDTO carDTO) {
    return carService.update(carDTO);
  }

  @PostMapping
  public CarDTO save(@RequestBody CarDTO carDTO) {
    return carService.create(carDTO);
  }

  @DeleteMapping
  public CarDTO delete(@RequestBody CarDTO carDTO) {
    carService.delete(carDTO);
    return carDTO;
  }

  @DeleteMapping("/{id}")
  public CarDTO deleteById(@PathVariable("id") Integer id) {
    carService.deleteById(id);
    return carService.findByIdCarWithModelCategoryPriceHistoryBrandDTO(id);
  }

  @GetMapping("/findOneByCriteria")
  public CarWithModelCategoryPriceHistoryBrandDTO findOneByCriteriaUserWithRoles(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return carService.findOneByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findAllByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(
          @RequestParam Map<String, Object> fieldCriterionMap) {
    return carService.findAllByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findByNotNullCarWithModelCategoryPriceHistoryBrandDTO(
          @RequestParam("field") List<String> fields) {
    return carService.findByNotNullCarWithModelCategoryPriceHistoryBrandDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findByNullCarWithModelCategoryPriceHistoryBrandDTO(
          @RequestParam("field") List<String> fields) {
    return carService.findByNullCarWithModelCategoryPriceHistoryBrandDTO(fields);
  }

  @GetMapping("/finLessThan")
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findLessThanCarWithModelCategoryPriceHistoryBrandDTO(
          @RequestParam Map<String, Number> fieldNumberMap) {
    return carService.findLessThanCarWithModelCategoryPriceHistoryBrandDTO(fieldNumberMap);
  }

  @GetMapping("/findGreaterThan")
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findGreaterThanCarWithModelCategoryPriceHistoryBrandDTO(
          @RequestParam Map<String, Number> fieldNumberMap) {
    return carService.findGreaterThanCarWithModelCategoryPriceHistoryBrandDTO(fieldNumberMap);
  }

  @GetMapping("/findAndSort")
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findAndSortCarWithModelCategoryPriceHistoryBrandDTO(
          @RequestParam Map<String, String> fieldDirectionMap,
          @RequestParam Map<String, Object> fieldCriteriaMap) {
    return carService.findAndSortCarWithModelCategoryPriceHistoryBrandDTO(
        fieldDirectionMap, fieldCriteriaMap);
  }

  @GetMapping("/findContain")
  public List<CarWithModelCategoryPriceHistoryBrandDTO>
      findContainCarWithModelCategoryPriceHistoryBrandDTO(
          @RequestParam Map<String, String> fieldStringMap) {
    return carService.findContainCarWithModelCategoryPriceHistoryBrandDTO(fieldStringMap);
  }
}
