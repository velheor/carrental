package com.velheor.carrenal.controllers.rest;

import com.velheor.carrental.dto.UserDTO;
import com.velheor.carrental.service.api.IUserService;
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
@RequestMapping("/users")
public class UserController {

  private IUserService userService;

  @Autowired
  public UserController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}")
  public UserDTO getById(@PathVariable("id") Integer id) {
    return userService.findById(id);
  }

  //TODO get all
  @GetMapping
  public List<UserDTO> getAll(
      @RequestParam Map<String, String> allParams) {
    return null;
  }

  @PutMapping
  public UserDTO update(@RequestBody UserDTO userDTO) {
    return userService.update(userDTO);
  }

  @PostMapping
  public UserDTO save(@RequestBody UserDTO userDTO) {
    return userService.create(userDTO);
  }

  @DeleteMapping
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@RequestBody UserDTO userDTO) {
    userService.delete(userDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteById(@PathVariable("id") Integer id) {
    userService.deleteById(id);
  }
}
