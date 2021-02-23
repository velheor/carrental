package com.velheor.carrenal.controllers.rest;

import com.velheor.carrental.dto.PriceHistoryDTO;
import com.velheor.carrental.service.api.IPriceHistoryService;
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
@RequestMapping("/pricehistory")
public class PriceHistoryController {
  private final IPriceHistoryService priceHistoryService;

  @Autowired
  PriceHistoryController(IPriceHistoryService priceHistoryService) {
    this.priceHistoryService = priceHistoryService;
  }

  @GetMapping("/{id}")
  public PriceHistoryDTO findById(@PathVariable("id") Integer id) {
    return priceHistoryService.findById(id);
  }

  @GetMapping
  public List<PriceHistoryDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return null;
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
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@RequestBody PriceHistoryDTO priceHistoryDTO) {
    priceHistoryService.delete(priceHistoryDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteById(@PathVariable("id") Integer id) {
    priceHistoryService.deleteById(id);
  }
}
