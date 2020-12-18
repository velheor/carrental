package com.senla.training.controllers;

import com.senla.training.dto.UserDTO;
import com.senla.training.service.api.IUserService;
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
@RequestMapping("/users")
public class UserController {

  private IUserService userService;

  UserController(){}

  @Autowired
  UserController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}")
  public UserDTO getByIdUserWithRoles(@PathVariable("id") Integer id) {
    return userService.findByIdUserWithRolesDTO(id);
  }

  @GetMapping
  public List<UserDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return userService.findAllAndSortWithDirectionUserWithRolesDTO(allParams);
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
  public UserDTO delete(@RequestBody UserDTO userDTO) {
    userService.delete(userDTO);
    return userDTO;
  }

  @DeleteMapping("/{id}")
  public UserDTO deleteById(@PathVariable("id") Integer id) {
    userService.deleteById(id);
    return userService.findByIdUserWithRolesDTO(id);
  }

  @GetMapping("/findOneByCriteria")
  public UserDTO findOneByCriteriaUserWithRoles(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return userService.findOneByCriteriaUserWithRolesDTO(fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<UserDTO> findAllByCriteriaUserWithRolesDTO(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return userService.findAllByCriteriaUserWithRolesDTO(fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<UserDTO> findByNotNullUserWithRolesDTO(@RequestParam("field") List<String> fields) {
    return userService.findByNotNullUserWithRolesDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<UserDTO> findByNullUserWithRolesDTO(@RequestParam("field") List<String> fields) {
    return userService.findByNullUserWithRolesDTO(fields);
  }

  @GetMapping("/findAndSort")
  public List<UserDTO> findAndSortUserWithRolesDTO(
      @RequestParam Map<String, String> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return userService.findAndSortUserWithRolesDTO(fieldDirectionMap, fieldCriteriaMap);
  }
}
