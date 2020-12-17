package com.senla.training.controllers;

import com.senla.training.dto.ModelDTO;
import com.senla.training.service.api.IModelService;
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
@RequestMapping("/models")
public class ModelController {

  private final IModelService modelService;

  @Autowired
  ModelController(IModelService modelService) {
    this.modelService = modelService;
  }

  @GetMapping("/{id}")
  public ModelDTO getByIdModelWithBrand(@PathVariable("id") Integer id) {
    return modelService.findByIdModelWithBrandDTO(id);
  }

  @GetMapping
  public List<ModelDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return modelService.findAllAndSortWithDirectionModelWithBrandDTO(allParams);
  }

  @PutMapping
  public ModelDTO update(@RequestBody ModelDTO modelDTO) {
    return modelService.update(modelDTO);
  }

  @PostMapping
  public ModelDTO save(@RequestBody ModelDTO modelDTO) {
    return modelService.create(modelDTO);
  }

  @DeleteMapping
  public ModelDTO delete(@RequestBody ModelDTO modelDTO) {
    modelService.delete(modelDTO);
    return modelDTO;
  }

  @DeleteMapping("/{id}")
  public ModelDTO deleteById(@PathVariable("id") Integer id) {
    modelService.deleteById(id);
    return modelService.findByIdModelWithBrandDTO(id);
  }

  @GetMapping("/findOneByCriteria")
  public ModelDTO findOneByCriteriaModelWithBrand(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return modelService.findOneByCriteriaModelWithBrandDTO(fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<ModelDTO> findAllByCriteriaModelWithBrandDTO(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return modelService.findAllByCriteriaModelWithBrandDTO(fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<ModelDTO> findByNotNullModelWithBrandDTO(
      @RequestParam("field") List<String> fields) {
    return modelService.findByNotNullModelWithBrandDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<ModelDTO> findByNullModelWithBrandDTO(
      @RequestParam("field") List<String> fields) {
    return modelService.findByNullModelWithBrandDTO(fields);
  }

  @GetMapping("/findAndSort")
  public List<ModelDTO> findAndSortModelWithBrandDTO(
      @RequestParam Map<String, String> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return modelService.findAndSortModelWithBrandDTO(fieldDirectionMap, fieldCriteriaMap);
  }

}
