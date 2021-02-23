package com.velheor.carrenal.controllers.rest;

import com.velheor.carrental.dto.ModelDTO;
import com.velheor.carrental.service.api.IModelService;
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
@RequestMapping("/models")
public class ModelController {

  private final IModelService modelService;

  @Autowired
  ModelController(IModelService modelService) {
    this.modelService = modelService;
  }

  @GetMapping("/{id}")
  public ModelDTO findById(@PathVariable("id") Integer id) {
    return modelService.findById(id);
  }

  @GetMapping
  public List<ModelDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return null;
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
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@RequestBody ModelDTO modelDTO) {
    modelService.delete(modelDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteById(@PathVariable("id") Integer id) {
    modelService.deleteById(id);
  }
}
