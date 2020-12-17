package com.senla.training.controllers;

import com.senla.training.dto.StatusHistoryDTO;
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
  public StatusHistoryDTO getByIdUserWithRoles(@PathVariable("id") Integer id) {
    return statusHistoryService.findByIdStatusHistoryWithRentDTO(id);
  }

  @GetMapping
  public List<StatusHistoryDTO> sortWithDirectionUsersWithRoles(
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
  public StatusHistoryDTO findOneByCriteriaUserWithRoles(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return statusHistoryService.findOneByCriteriaStatusHistoryWithRentDTO(fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<StatusHistoryDTO> findAllByCriteriaStatusHistoryWithRentDTO(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return statusHistoryService.findAllByCriteriaStatusHistoryWithRentDTO(fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<StatusHistoryDTO> findByNotNullStatusHistoryWithRentDTO(
      @RequestParam("field") List<String> fields) {
    return statusHistoryService.findByNotNullStatusHistoryWithRentDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<StatusHistoryDTO> findByNullStatusHistoryWithRentDTO(
      @RequestParam("field") List<String> fields) {
    return statusHistoryService.findByNullStatusHistoryWithRentDTO(fields);
  }

  @GetMapping("/findAndSort")
  public List<StatusHistoryDTO> findAndSortStatusHistoryWithRentDTO(
      @RequestParam Map<String, String> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return statusHistoryService.findAndSortStatusHistoryWithRentDTO(
        fieldDirectionMap, fieldCriteriaMap);
  }
}
