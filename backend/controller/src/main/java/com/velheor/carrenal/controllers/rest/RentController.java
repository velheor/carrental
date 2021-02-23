package com.velheor.carrenal.controllers.rest;

import com.velheor.carrental.dto.RentDTO;
import com.velheor.carrental.service.api.IRentService;
import com.velheor.carrental.service.api.IRoleService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
@RequestMapping("/rents")
public class RentController {

  private final IRentService rentService;

  @Autowired
  RentController(IRentService rentService) {
    this.rentService = rentService;
  }

  @GetMapping("/{id}")
  public RentDTO findById(@PathVariable("id") Integer id) {
    return rentService.findById(id);
  }

  //TODO GET AlL
  @GetMapping
  public List<RentDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return null;
  }

  @PutMapping
  public RentDTO update(@RequestBody RentDTO rentDTO) {
    return rentService.update(rentDTO);
  }

  @PostMapping
  public RentDTO save(@RequestBody RentDTO rentDTO) {
    return rentService.create(rentDTO);
  }

  @DeleteMapping
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@RequestBody RentDTO rentDTO) {
    rentService.delete(rentDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteById(@PathVariable("id") Integer id) {
    rentService.deleteById(id);
  }
}
