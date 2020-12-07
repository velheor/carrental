package com.senla.training.controllers;

import com.senla.training.dto.category.CategoryDTO;
import com.senla.training.dto.category.CategoryWithCategoriesCarsModelBrandDTO;
import com.senla.training.service.api.ICategoryService;
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
  public CategoryWithCategoriesCarsModelBrandDTO getByIdCategoryWithCategoriesCarsModelBrand(
      @PathVariable("id") Integer id) {
    return categoryService.findByIdCategoryWithCategoriesCarsModelBrandDTO(id);
  }

  @GetMapping
  public List<CategoryWithCategoriesCarsModelBrandDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return categoryService.findAllAndSortWithDirectionCategoryWithCategoriesCarsModelBrandDTO(
        allParams);
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
    return categoryService.findByIdCategoryWithCategoriesCarsModelBrandDTO(id);
  }

  @GetMapping("/findOneByCriteria")
  public CategoryWithCategoriesCarsModelBrandDTO
      findOneByCriteriaCategoryWithCategoriesCarsModelBrand(
          @RequestParam Map<String, Object> fieldCriterionMap) {
    return categoryService.findOneByCriteriaCategoryWithCategoriesCarsModelBrandDTO(
        fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findAllByCriteriaCategoryWithCategoriesCarsModelBrandDTO(
          @RequestParam Map<String, Object> fieldCriterionMap) {
    return categoryService.findAllByCriteriaCategoryWithCategoriesCarsModelBrandDTO(
        fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findByNotNullCategoryWithCategoriesCarsModelBrandDTO(
          @RequestParam("field") List<String> fields) {
    return categoryService.findByNotNullCategoryWithCategoriesCarsModelBrandDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findByNullCategoryWithCategoriesCarsModelBrandDTO(
          @RequestParam("field") List<String> fields) {
    return categoryService.findByNullCategoryWithCategoriesCarsModelBrandDTO(fields);
  }

  @GetMapping("/finLessThan")
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findLessThanCategoryWithCategoriesCarsModelBrandDTO(
          @RequestParam Map<String, Number> fieldNumberMap) {
    return categoryService.findLessThanCategoryWithCategoriesCarsModelBrandDTO(fieldNumberMap);
  }

  @GetMapping("/findGreaterThan")
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findGreaterThanCategoryWithCategoriesCarsModelBrandDTO(
          @RequestParam Map<String, Number> fieldNumberMap) {
    return categoryService.findGreaterThanCategoryWithCategoriesCarsModelBrandDTO(fieldNumberMap);
  }

  @GetMapping("/findAndSort")
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findAndSortCategoryWithCategoriesCarsModelBrandDTO(
          @RequestParam Map<String, String> fieldDirectionMap,
          @RequestParam Map<String, Object> fieldCriteriaMap) {
    return categoryService.findAndSortCategoryWithCategoriesCarsModelBrandDTO(
        fieldDirectionMap, fieldCriteriaMap);
  }

  @GetMapping("/findContain")
  public List<CategoryWithCategoriesCarsModelBrandDTO>
      findContainCategoryWithCategoriesCarsModelBrandDTO(
          @RequestParam Map<String, String> fieldStringMap) {
    return categoryService.findContainCategoryWithCategoriesCarsModelBrandDTO(fieldStringMap);
  }
}
