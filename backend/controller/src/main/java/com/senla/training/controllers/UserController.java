package com.senla.training.controllers;

import com.senla.training.dto.user.UserDTO;
import com.senla.training.dto.user.UserWithRolesDTO;
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

  private final IUserService userService;

  @Autowired
  UserController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}")
  public UserWithRolesDTO getByIdUserWithRoles(@PathVariable("id") Integer id) {
    return userService.findByIdUserWithRolesDTO(id);
  }

  @GetMapping
  public List<UserWithRolesDTO> sortWithDirectionUsersWithRoles(
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
  public UserWithRolesDTO findOneByCriteriaUserWithRoles(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return userService.findOneByCriteriaUserWithRolesDTO(fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<UserWithRolesDTO> findAllByCriteriaUserWithRolesDTO(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return userService.findAllByCriteriaUserWithRolesDTO(fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<UserWithRolesDTO> findByNotNullUserWithRolesDTO(
      @RequestParam("field") List<String> fields) {
    return userService.findByNotNullUserWithRolesDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<UserWithRolesDTO> findByNullUserWithRolesDTO(
      @RequestParam("field") List<String> fields) {
    return userService.findByNullUserWithRolesDTO(fields);
  }

  @GetMapping("/finLessThan")
  public List<UserWithRolesDTO> findLessThanUserWithRolesDTO(
      @RequestParam Map<String, Number> fieldNumberMap) {
    return userService.findLessThanUserWithRolesDTO(fieldNumberMap);
  }

  @GetMapping("/findGreaterThan")
  public List<UserWithRolesDTO> findGreaterThanUserWithRolesDTO(
      @RequestParam Map<String, Number> fieldNumberMap) {
    return userService.findGreaterThanUserWithRolesDTO(fieldNumberMap);
  }

  @GetMapping("/findAndSort")
  public List<UserWithRolesDTO> findAndSortUserWithRolesDTO(
      @RequestParam Map<String, String> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return userService.findAndSortUserWithRolesDTO(fieldDirectionMap, fieldCriteriaMap);
  }

  @GetMapping("/findContain")
  public List<UserWithRolesDTO> findContainUserWithRolesDTO(
      @RequestParam Map<String, String> fieldStringMap) {
    return userService.findContainUserWithRolesDTO(fieldStringMap);
  }
}
