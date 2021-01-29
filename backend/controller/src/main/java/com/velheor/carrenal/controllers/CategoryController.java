package com.velheor.carrenal.controllers;

import com.velheor.carrental.dto.CategoryDTO;
import com.velheor.carrental.service.api.ICategoryService;
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
@RequestMapping("/categories")
public class CategoryController {

  private final ICategoryService categoryService;

  @Autowired
  CategoryController(ICategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/{id}")
  public CategoryDTO getByIdCategoryWithCarsModelBrand(@PathVariable("id") Integer id) {
    return categoryService.findByIdCategoryWithCarsModelBrandDTO(id);
  }

  @GetMapping
  public List<CategoryDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return categoryService.findAllAndSortWithDirectionCategoryWithCarsModelBrandDTO(allParams);
  }

  @PutMapping
  public CategoryDTO update(@RequestBody CategoryDTO categoryDTO) {
    return categoryService.update(categoryDTO);
  }

  @PostMapping
  public CategoryDTO save(@RequestBody CategoryDTO categoryDTO) {
    return categoryService.create(categoryDTO);
  }

  @DeleteMapping
  public CategoryDTO delete(@RequestBody CategoryDTO categoryDTO) {
    categoryService.delete(categoryDTO);
    return categoryDTO;
  }

  @DeleteMapping("/{id}")
  public CategoryDTO deleteById(@PathVariable("id") Integer id) {
    categoryService.deleteById(id);
    return categoryService.findByIdCategoryWithCarsModelBrandDTO(id);
  }

  @GetMapping("/findOneByCriteria")
  public CategoryDTO findOneByCriteriaCategoryWithCarsModelBrand(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return categoryService.findOneByCriteriaCategoryWithCarsModelBrandDTO(fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<CategoryDTO> findAllByCriteriaCategoryWithCarsModelBrandDTO(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return categoryService.findAllByCriteriaCategoryWithCarsModelBrandDTO(fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<CategoryDTO> findByNotNullCategoryWithCarsModelBrandDTO(
      @RequestParam("field") List<String> fields) {
    return categoryService.findByNotNullCategoryWithCarsModelBrandDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<CategoryDTO> findByNullCategoryWithCarsModelBrandDTO(
      @RequestParam("field") List<String> fields) {
    return categoryService.findByNullCategoryWithCarsModelBrandDTO(fields);
  }

  @GetMapping("/findAndSort")
  public List<CategoryDTO> findAndSortCategoryWithCarsModelBrandDTO(
      @RequestParam Map<String, String> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return categoryService.findAndSortCategoryWithCarsModelBrandDTO(
        fieldDirectionMap, fieldCriteriaMap);
  }
}
