package com.velheor.carrenal.controllers;

import com.velheor.carrental.dto.CarDTO;
import com.velheor.carrental.service.api.ICarService;
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
  public CarDTO getByIdUserWithRoles(@PathVariable("id") Integer id) {
    return carService.findByIdCarWithModelCategoryPriceHistoryBrandDTO(id);
  }

  @GetMapping
  public List<CarDTO> sortWithDirectionUsersWithRoles(@RequestParam Map<String, String> allParams) {
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
  public CarDTO findOneByCriteriaUserWithRoles(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return carService.findOneByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<CarDTO> findAllByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return carService.findAllByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<CarDTO> findByNotNullCarWithModelCategoryPriceHistoryBrandDTO(
      @RequestParam("field") List<String> fields) {
    return carService.findByNotNullCarWithModelCategoryPriceHistoryBrandDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<CarDTO> findByNullCarWithModelCategoryPriceHistoryBrandDTO(
      @RequestParam("field") List<String> fields) {
    return carService.findByNullCarWithModelCategoryPriceHistoryBrandDTO(fields);
  }

  @GetMapping("/findAndSort")
  public List<CarDTO> findAndSortCarWithModelCategoryPriceHistoryBrandDTO(
      @RequestParam Map<String, String> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return carService.findAndSortCarWithModelCategoryPriceHistoryBrandDTO(
        fieldDirectionMap, fieldCriteriaMap);
  }
}
