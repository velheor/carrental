package com.velheor.carrenal.controllers.rest;

import com.velheor.carrental.dto.BrandDTO;
import com.velheor.carrental.service.api.IBrandService;
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
@RequestMapping("/brands")
public class BrandController {

  private final IBrandService brandService;

  @Autowired
  BrandController(IBrandService brandService) {
    this.brandService = brandService;
  }

  @GetMapping("/{id}")
  public BrandDTO getByIdUserWithRoles(@PathVariable("id") Integer id) {
    return brandService.findById(id);
  }

  @GetMapping
  public List<BrandDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return null;
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
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@RequestBody BrandDTO brandDTO) {
    brandService.delete(brandDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteById(@PathVariable("id") Integer id) {
    brandService.deleteById(id);
  }
}
