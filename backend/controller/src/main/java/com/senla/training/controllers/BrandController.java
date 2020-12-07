package com.senla.training.controllers;

import com.senla.training.dto.brand.BrandDTO;
import com.senla.training.dto.brand.BrandWithModelsDTO;
import com.senla.training.service.api.IBrandService;
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
@RequestMapping("/brands")
public class BrandController {

  private final IBrandService brandService;

  @Autowired
  BrandController(IBrandService brandService) {
    this.brandService = brandService;
  }

  @GetMapping("/{id}")
  public BrandWithModelsDTO getByIdUserWithRoles(@PathVariable("id") Integer id) {
    return brandService.findByIdBrandWithModelsDTO(id);
  }

  @GetMapping
  public List<BrandWithModelsDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return brandService.findAllAndSortWithDirectionBrandWithModelsDTO(allParams);
  }

  @PutMapping
  public BrandDTO update(@RequestBody BrandDTO brandDTO) {
    return brandService.update(brandDTO);
  }

  @PostMapping
  public BrandDTO save(@RequestBody BrandDTO brandDTO) {
    return brandService.create(brandDTO);
  }

  @DeleteMapping
  public BrandDTO delete(@RequestBody BrandDTO brandDTO) {
    brandService.delete(brandDTO);
    return brandDTO;
  }

  @DeleteMapping("/{id}")
  public BrandDTO deleteById(@PathVariable("id") Integer id) {
    brandService.deleteById(id);
    return brandService.findByIdBrandWithModelsDTO(id);
  }

  @GetMapping("/findOneByCriteria")
  public BrandWithModelsDTO findOneByCriteriaUserWithRoles(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return brandService.findOneByCriteriaBrandWithModelsDTO(fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<BrandWithModelsDTO> findAllByCriteriaBrandWithModelsDTO(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return brandService.findAllByCriteriaBrandWithModelsDTO(fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<BrandWithModelsDTO> findByNotNullBrandWithModelsDTO(
      @RequestParam("field") List<String> fields) {
    return brandService.findByNotNullBrandWithModelsDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<BrandWithModelsDTO> findByNullBrandWithModelsDTO(
      @RequestParam("field") List<String> fields) {
    return brandService.findByNullBrandWithModelsDTO(fields);
  }

  @GetMapping("/finLessThan")
  public List<BrandWithModelsDTO> findLessThanBrandWithModelsDTO(
      @RequestParam Map<String, Number> fieldNumberMap) {
    return brandService.findLessThanBrandWithModelsDTO(fieldNumberMap);
  }

  @GetMapping("/findGreaterThan")
  public List<BrandWithModelsDTO> findGreaterThanBrandWithModelsDTO(
      @RequestParam Map<String, Number> fieldNumberMap) {
    return brandService.findGreaterThanBrandWithModelsDTO(fieldNumberMap);
  }

  @GetMapping("/findAndSort")
  public List<BrandWithModelsDTO> findAndSortBrandWithModelsDTO(
      @RequestParam Map<String, String> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return brandService.findAndSortBrandWithModelsDTO(fieldDirectionMap, fieldCriteriaMap);
  }

  @GetMapping("/findContain")
  public List<BrandWithModelsDTO> findContainBrandWithModelsDTO(
      @RequestParam Map<String, String> fieldStringMap) {
    return brandService.findContainBrandWithModelsDTO(fieldStringMap);
  }
}
