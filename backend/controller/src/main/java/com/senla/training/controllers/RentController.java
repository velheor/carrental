package com.senla.training.controllers;

import com.senla.training.dto.rent.RentWithUserStatusHistoryCarDTO;
import com.senla.training.models.enums.Direction;
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
  public RentWithUserStatusHistoryCarDTO getByIdWithRoleDTO(@PathVariable("id") Integer id) {
    return rentService.findByIdRentWithUserStatusHistoryCarDTO(id);
  }

  @GetMapping
  public List<RentWithUserStatusHistoryCarDTO> findAllRentWithUserStatusHistoryCarDTO() {
    return rentService.findAllRentWithUserStatusHistoryCarDTO();
  }

  @GetMapping("/sort")
  public List<RentWithUserStatusHistoryCarDTO> sortWithDirectionRentWithUserStatusHistoryCarDTO(
      @RequestParam Map<String, Direction> allParams) {
    return rentService.sortWithDirectionRentWithUserStatusHistoryCarDTO(allParams);
  }

  @PutMapping
  public RentWithUserStatusHistoryCarDTO updateRentWithUserStatusHistoryCarDTO(
      @RequestBody RentWithUserStatusHistoryCarDTO rentWithUserStatusHistoryCarDTO) {
    return rentService.updateRentWithUserStatusHistoryCarDTO(rentWithUserStatusHistoryCarDTO);
  }

  @PostMapping
  public RentWithUserStatusHistoryCarDTO saveRentWithUserStatusHistoryCarDTO(
      @RequestBody RentWithUserStatusHistoryCarDTO rentWithUserStatusHistoryCarDTO) {
    return rentService.createRentWithUserStatusHistoryCarDTO(rentWithUserStatusHistoryCarDTO);
  }

  @DeleteMapping
  public RentWithUserStatusHistoryCarDTO deleteRentWithUserStatusHistoryCarDTO(
      @RequestBody RentWithUserStatusHistoryCarDTO rentWithUserStatusHistoryCarDTO) {
    rentService.deleteRentWithUserStatusHistoryCarDTO(rentWithUserStatusHistoryCarDTO);
    return rentWithUserStatusHistoryCarDTO;
  }

  @GetMapping("/findOneByCriteria")
  public RentWithUserStatusHistoryCarDTO findOneByCriteriaRentWithUserStatusHistoryCarDTO(
      @RequestParam String field, @RequestParam Object criteria) {
    return rentService.findOneByCriteriaRentWithUserStatusHistoryCarDTO(field, criteria);
  }

  @GetMapping("/findAllByCriteria")
  public List<RentWithUserStatusHistoryCarDTO> findAllByCriteriaRentWithUserStatusHistoryCarDTO(
      @RequestParam String field, @RequestParam Object criteria) {
    return rentService.findAllByCriteriaRentWithUserStatusHistoryCarDTO(field, criteria);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<RentWithUserStatusHistoryCarDTO> findAllByCriteriaRentWithUserStatusHistoryCarDTO(
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return rentService.findAllByCriteriaRentWithUserStatusHistoryCarDTO(fieldCriteriaMap);
  }

  @GetMapping("/findByNotNull")
  public List<RentWithUserStatusHistoryCarDTO> findByNotNullRentWithUserStatusHistoryCarDTO(
      @RequestParam String field) {
    return rentService.findByNotNullRentWithUserStatusHistoryCarDTO(field);
  }

  @GetMapping("/findByNull")
  public List<RentWithUserStatusHistoryCarDTO> findByNullRentWithUserStatusHistoryCarDTO(
      @RequestParam String field) {
    return rentService.findByNullRentWithUserStatusHistoryCarDTO(field);
  }

  @GetMapping("/finLessThan")
  public List<RentWithUserStatusHistoryCarDTO> findLessThanRentWithUserStatusHistoryCarDTO(
      @RequestParam String field, Number number) {
    return rentService.findLessThanRentWithUserStatusHistoryCarDTO(field, number);
  }

  @GetMapping("/findGreaterThan")
  public List<RentWithUserStatusHistoryCarDTO> findGreaterThanRentWithUserStatusHistoryCarDTO(
      @RequestParam String field, Number number) {
    return rentService.findGreaterThanRentWithUserStatusHistoryCarDTO(field, number);
  }

  @GetMapping("/findAndSort")
  public List<RentWithUserStatusHistoryCarDTO> findAndSortRentWithUserStatusHistoryCarDTO(
      @RequestParam Map<String, Direction> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return rentService.findAndSortRentWithUserStatusHistoryCarDTO(
        fieldDirectionMap, fieldCriteriaMap);
  }

  @GetMapping("/findContain")
  public List<RentWithUserStatusHistoryCarDTO> findContainRentWithUserStatusHistoryCarDTO(
      String field, String criteria) {
    return rentService.findContainRentWithUserStatusHistoryCarDTO(field, criteria);
  }
}
