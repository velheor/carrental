package com.senla.training.controllers;

import com.senla.training.dto.BrandDTO;
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
  public BrandDTO getByIdUserWithRoles(@PathVariable("id") Integer id) {
    return brandService.findByIdBrandWithModelsDTO(id);
  }

  @GetMapping
  public List<BrandDTO> sortWithDirectionUsersWithRoles(
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
  public BrandDTO findOneByCriteriaUserWithRoles(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return brandService.findOneByCriteriaBrandWithModelsDTO(fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<BrandDTO> findAllByCriteriaBrandWithModelsDTO(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return brandService.findAllByCriteriaBrandWithModelsDTO(fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<BrandDTO> findByNotNullBrandWithModelsDTO(
      @RequestParam("field") List<String> fields) {
    return brandService.findByNotNullBrandWithModelsDTO(fields);
  }

  @GetMapping("/findAndSort")
  public List<BrandDTO> findAndSortBrandWithModelsDTO(
      @RequestParam Map<String, String> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return brandService.findAndSortBrandWithModelsDTO(fieldDirectionMap, fieldCriteriaMap);
  }

}
