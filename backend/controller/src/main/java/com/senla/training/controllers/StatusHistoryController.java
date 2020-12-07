package com.senla.training.controllers;

import com.senla.training.dto.statusHistory.StatusHistoryDTO;
import com.senla.training.dto.statusHistory.StatusHistoryWithRentDTO;
import com.senla.training.service.api.IStatusHistoryService;
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
@RequestMapping("/statushistory")
public class StatusHistoryController {

  private final IStatusHistoryService statusHistoryService;

  @Autowired
  StatusHistoryController(IStatusHistoryService statusHistoryService) {
    this.statusHistoryService = statusHistoryService;
  }

  @GetMapping("/{id}")
  public StatusHistoryWithRentDTO getByIdUserWithRoles(@PathVariable("id") Integer id) {
    return statusHistoryService.findByIdStatusHistoryWithRentDTO(id);
  }

  @GetMapping
  public List<StatusHistoryWithRentDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return statusHistoryService.findAllAndSortWithDirectionStatusHistoryWithRentDTO(allParams);
  }

  @PutMapping
  public StatusHistoryDTO update(@RequestBody StatusHistoryDTO statusHistoryDTO) {
    return statusHistoryService.update(statusHistoryDTO);
  }

  @PostMapping
  public StatusHistoryDTO save(@RequestBody StatusHistoryDTO statusHistoryDTO) {
    return statusHistoryService.create(statusHistoryDTO);
  }

  @DeleteMapping
  public StatusHistoryDTO delete(@RequestBody StatusHistoryDTO statusHistoryDTO) {
    statusHistoryService.delete(statusHistoryDTO);
    return statusHistoryDTO;
  }

  @DeleteMapping("/{id}")
  public StatusHistoryDTO deleteById(@PathVariable("id") Integer id) {
    statusHistoryService.deleteById(id);
    return statusHistoryService.findByIdStatusHistoryWithRentDTO(id);
  }

  @GetMapping("/findOneByCriteria")
  public StatusHistoryWithRentDTO findOneByCriteriaUserWithRoles(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return statusHistoryService.findOneByCriteriaStatusHistoryWithRentDTO(fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<StatusHistoryWithRentDTO> findAllByCriteriaStatusHistoryWithRentDTO(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return statusHistoryService.findAllByCriteriaStatusHistoryWithRentDTO(fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<StatusHistoryWithRentDTO> findByNotNullStatusHistoryWithRentDTO(
      @RequestParam("field") List<String> fields) {
    return statusHistoryService.findByNotNullStatusHistoryWithRentDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<StatusHistoryWithRentDTO> findByNullStatusHistoryWithRentDTO(
      @RequestParam("field") List<String> fields) {
    return statusHistoryService.findByNullStatusHistoryWithRentDTO(fields);
  }

  @GetMapping("/finLessThan")
  public List<StatusHistoryWithRentDTO> findLessThanStatusHistoryWithRentDTO(
      @RequestParam Map<String, Number> fieldNumberMap) {
    return statusHistoryService.findLessThanStatusHistoryWithRentDTO(fieldNumberMap);
  }

  @GetMapping("/findGreaterThan")
  public List<StatusHistoryWithRentDTO> findGreaterThanStatusHistoryWithRentDTO(
      @RequestParam Map<String, Number> fieldNumberMap) {
    return statusHistoryService.findGreaterThanStatusHistoryWithRentDTO(fieldNumberMap);
  }

  @GetMapping("/findAndSort")
  public List<StatusHistoryWithRentDTO> findAndSortStatusHistoryWithRentDTO(
      @RequestParam Map<String, String> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return statusHistoryService.findAndSortStatusHistoryWithRentDTO(
        fieldDirectionMap, fieldCriteriaMap);
  }

  @GetMapping("/findContain")
  public List<StatusHistoryWithRentDTO> findContainStatusHistoryWithRentDTO(
      @RequestParam Map<String, String> fieldStringMap) {
    return statusHistoryService.findContainStatusHistoryWithRentDTO(fieldStringMap);
  }
}
