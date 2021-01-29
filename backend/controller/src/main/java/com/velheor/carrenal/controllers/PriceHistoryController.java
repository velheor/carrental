package com.velheor.carrenal.controllers;

import com.velheor.carrental.dto.PriceHistoryDTO;
import com.velheor.carrental.service.api.IPriceHistoryService;
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
@RequestMapping("/pricehistory")
public class PriceHistoryController {
  private final IPriceHistoryService priceHistoryService;

  @Autowired
  PriceHistoryController(IPriceHistoryService priceHistoryService) {
    this.priceHistoryService = priceHistoryService;
  }

  @GetMapping("/{id}")
  public PriceHistoryDTO getByIdUserWithRoles(@PathVariable("id") Integer id) {
    return priceHistoryService.findByIdPriceHistoryWithCarModelBrandDTO(id);
  }

  @GetMapping
  public List<PriceHistoryDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return priceHistoryService.findAllAndSortWithDirectionPriceHistoryWithCarModelBrandDTO(
        allParams);
  }

  @PutMapping
  public PriceHistoryDTO update(@RequestBody PriceHistoryDTO priceHistoryDTO) {
    return priceHistoryService.update(priceHistoryDTO);
  }

  @PostMapping
  public PriceHistoryDTO save(@RequestBody PriceHistoryDTO priceHistoryDTO) {
    return priceHistoryService.create(priceHistoryDTO);
  }

  @DeleteMapping
  public PriceHistoryDTO delete(@RequestBody PriceHistoryDTO priceHistoryDTO) {
    priceHistoryService.delete(priceHistoryDTO);
    return priceHistoryDTO;
  }

  @DeleteMapping("/{id}")
  public PriceHistoryDTO deleteById(@PathVariable("id") Integer id) {
    priceHistoryService.deleteById(id);
    return priceHistoryService.findByIdPriceHistoryWithCarModelBrandDTO(id);
  }

  @GetMapping("/findOneByCriteria")
  public PriceHistoryDTO findOneByCriteriaUserWithRoles(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return priceHistoryService.findOneByCriteriaPriceHistoryWithCarModelBrandDTO(fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<PriceHistoryDTO> findAllByCriteriaPriceHistoryWithCarModelBrandDTO(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return priceHistoryService.findAllByCriteriaPriceHistoryWithCarModelBrandDTO(fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<PriceHistoryDTO> findByNotNullPriceHistoryWithCarModelBrandDTO(
      @RequestParam("field") List<String> fields) {
    return priceHistoryService.findByNotNullPriceHistoryWithCarModelBrandDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<PriceHistoryDTO> findByNullPriceHistoryWithCarModelBrandDTO(
      @RequestParam("field") List<String> fields) {
    return priceHistoryService.findByNullPriceHistoryWithCarModelBrandDTO(fields);
  }

  @GetMapping("/findAndSort")
  public List<PriceHistoryDTO> findAndSortPriceHistoryWithCarModelBrandDTO(
      @RequestParam Map<String, String> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return priceHistoryService.findAndSortPriceHistoryWithCarModelBrandDTO(
        fieldDirectionMap, fieldCriteriaMap);
  }
}
