package com.velheor.carrenal.controllers.rest;

import com.velheor.carrental.dto.CategoryDTO;
import com.velheor.carrental.service.api.ICategoryService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
  public CategoryDTO findById(@PathVariable("id") Integer id) {
    return categoryService.findById(id);
  }

  @GetMapping
  public List<CategoryDTO> findAll(
      @RequestParam Map<String, String> allParams) {
    return null;
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
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@RequestBody CategoryDTO categoryDTO) {
    categoryService.delete(categoryDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteById(@PathVariable("id") Integer id) {
    categoryService.deleteById(id);
  }

}
