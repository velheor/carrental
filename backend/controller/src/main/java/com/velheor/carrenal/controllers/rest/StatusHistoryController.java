package com.velheor.carrenal.controllers.rest;

import com.velheor.carrental.dto.StatusHistoryDTO;
import com.velheor.carrental.service.api.IStatusHistoryService;
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
@RequestMapping("/statushistory")
public class StatusHistoryController {

  private final IStatusHistoryService statusHistoryService;

  @Autowired
  StatusHistoryController(IStatusHistoryService statusHistoryService) {
    this.statusHistoryService = statusHistoryService;
  }

  @GetMapping("/{id}")
  public StatusHistoryDTO findById(@PathVariable("id") Integer id) {
    return statusHistoryService.findById(id);
  }

  //TODO get all
  @GetMapping
  public List<StatusHistoryDTO> getAll(
      @RequestParam Map<String, String> allParams) {
    return null;
  }

  @PutMapping
  public StatusHistoryDTO update(@RequestBody StatusHistoryDTO statusHistoryDTO) {
    return statusHistoryService.update(statusHistoryDTO);
  }

  @PostMapping
  public StatusHistoryDTO save(@RequestBody StatusHistoryDTO statusHistoryDTO) {
    return statusHistoryService.create(statusHistoryDTO);
  }

  @DeleteMapping
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@RequestBody StatusHistoryDTO statusHistoryDTO) {
    statusHistoryService.delete(statusHistoryDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteById(@PathVariable("id") Integer id) {
    statusHistoryService.deleteById(id);
  }
}
