package com.velheor.carrenal.controllers.rest;

import com.velheor.carrental.dto.CarDTO;
import com.velheor.carrental.service.api.ICarService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

  private final ICarService carService;

  @Autowired
  CarController(ICarService carService) {
    this.carService = carService;
  }

  @GetMapping("/{id}")
  public CarDTO findById(@PathVariable("id") Integer id) {
    return carService.findById(id);
  }

  @GetMapping
  public List<CarDTO> findAll(@RequestParam Map<String, String> allParams) {
    return null;
  }

  @PutMapping
  public CarDTO update(@RequestBody CarDTO carDTO) {
    return carService.update(carDTO);
  }

  @PostMapping
  public CarDTO save(@RequestBody CarDTO carDTO) {
    return carService.create(carDTO);
  }

  @DeleteMapping
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@RequestBody CarDTO carDTO) {
    carService.delete(carDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteById(@PathVariable("id") Integer id) {
    carService.deleteById(id);
  }
}
