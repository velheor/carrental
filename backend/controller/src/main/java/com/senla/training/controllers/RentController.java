package com.senla.training.controllers;

import com.senla.training.dto.rent.RentDTO;
import com.senla.training.dto.rent.RentWithUserStatusHistoryCarModelBrandDTO;
import com.senla.training.service.api.IRentService;
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
@RequestMapping("/rents")
public class RentController {

  private final IRentService rentService;

  @Autowired
  RentController(IRentService rentService) {
    this.rentService = rentService;
  }

  @GetMapping("/{id}")
  public RentWithUserStatusHistoryCarModelBrandDTO getByIdUserWithRoles(
      @PathVariable("id") Integer id) {
    return rentService.findByIdRentWithUserStatusHistoryCarModelBrandDTO(id);
  }

  @GetMapping
  public List<RentWithUserStatusHistoryCarModelBrandDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return rentService.findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrandDTO(
        allParams);
  }

  @PutMapping
  public RentDTO update(@RequestBody RentDTO rentDTO) {
    return rentService.update(rentDTO);
  }

  @PostMapping
  public RentDTO save(@RequestBody RentDTO rentDTO) {
    return rentService.create(rentDTO);
  }

  @DeleteMapping
  public RentDTO delete(@RequestBody RentDTO rentDTO) {
    rentService.delete(rentDTO);
    return rentDTO;
  }

  @DeleteMapping("/{id}")
  public RentDTO deleteById(@PathVariable("id") Integer id) {
    rentService.deleteById(id);
    return rentService.findByIdRentWithUserStatusHistoryCarModelBrandDTO(id);
  }

  @GetMapping("/findOneByCriteria")
  public RentWithUserStatusHistoryCarModelBrandDTO findOneByCriteriaUserWithRoles(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return rentService.findOneByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
        fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
          @RequestParam Map<String, Object> fieldCriterionMap) {
    return rentService.findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
        fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(
          @RequestParam("field") List<String> fields) {
    return rentService.findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findByNullRentWithUserStatusHistoryCarModelBrandDTO(
          @RequestParam("field") List<String> fields) {
    return rentService.findByNullRentWithUserStatusHistoryCarModelBrandDTO(fields);
  }

  @GetMapping("/finLessThan")
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findLessThanRentWithUserStatusHistoryCarModelBrandDTO(
          @RequestParam Map<String, Number> fieldNumberMap) {
    return rentService.findLessThanRentWithUserStatusHistoryCarModelBrandDTO(fieldNumberMap);
  }

  @GetMapping("/findGreaterThan")
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findGreaterThanRentWithUserStatusHistoryCarModelBrandDTO(
          @RequestParam Map<String, Number> fieldNumberMap) {
    return rentService.findGreaterThanRentWithUserStatusHistoryCarModelBrandDTO(fieldNumberMap);
  }

  @GetMapping("/findAndSort")
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
          @RequestParam Map<String, String> fieldDirectionMap,
          @RequestParam Map<String, Object> fieldCriteriaMap) {
    return rentService.findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
        fieldDirectionMap, fieldCriteriaMap);
  }

  @GetMapping("/findContain")
  public List<RentWithUserStatusHistoryCarModelBrandDTO>
      findContainRentWithUserStatusHistoryCarModelBrandDTO(
          @RequestParam Map<String, String> fieldStringMap) {
    return rentService.findContainRentWithUserStatusHistoryCarModelBrandDTO(fieldStringMap);
  }
}
