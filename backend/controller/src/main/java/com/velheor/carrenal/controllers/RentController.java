package com.velheor.carrenal.controllers;

import com.velheor.carrental.dto.RentDTO;
import com.velheor.carrental.service.api.IRentService;
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
  public RentDTO getByIdUserWithRoles(@PathVariable("id") Integer id) {
    return rentService.findByIdRentWithUserStatusHistoryCarModelBrandDTO(id);
  }

  @GetMapping
  public List<RentDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return rentService.findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrandDTO(
        allParams);
  }

  @PutMapping
  public RentDTO update(@RequestBody RentDTO rentDTO) {
    return rentService.update((RentDTO) rentDTO);
  }

  @PostMapping
  public RentDTO save(@RequestBody RentDTO rentDTO) {
    return rentService.create((RentDTO) rentDTO);
  }

  @DeleteMapping
  public RentDTO delete(@RequestBody RentDTO rentDTO) {
    rentService.delete((RentDTO) rentDTO);
    return rentDTO;
  }

  @DeleteMapping("/{id}")
  public RentDTO deleteById(@PathVariable("id") Integer id) {
    rentService.deleteById(id);
    return rentService.findByIdRentWithUserStatusHistoryCarModelBrandDTO(id);
  }

  @GetMapping("/findOneByCriteria")
  public RentDTO findOneByCriteriaUserWithRoles(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return rentService.findOneByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
        fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<RentDTO> findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return rentService.findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
        fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<RentDTO> findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(
      @RequestParam("field") List<String> fields) {
    return rentService.findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<RentDTO> findByNullRentWithUserStatusHistoryCarModelBrandDTO(
      @RequestParam("field") List<String> fields) {
    return rentService.findByNullRentWithUserStatusHistoryCarModelBrandDTO(fields);
  }

  @GetMapping("/findAndSort")
  public List<RentDTO> findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
      @RequestParam Map<String, String> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return rentService.findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
        fieldDirectionMap, fieldCriteriaMap);
  }
}
