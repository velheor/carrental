package com.senla.training.controllers;

import com.senla.training.dto.RoleDTO;
import com.senla.training.service.api.IRoleService;
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
@RequestMapping("/roles")
public class RoleController {

  private final IRoleService roleService;

  @Autowired
  RoleController(IRoleService roleService) {
    this.roleService = roleService;
  }

  @GetMapping("/{id}")
  public RoleDTO getByIdUserWithRoles(@PathVariable("id") Integer id) {
    return roleService.findByIdRoleWithUsersDTO(id);
  }

  @GetMapping
  public List<RoleDTO> sortWithDirectionUsersWithRoles(
      @RequestParam Map<String, String> allParams) {
    return roleService.findAllAndSortWithDirectionRoleWithUsersDTO(allParams);
  }

  @PutMapping
  public RoleDTO update(@RequestBody RoleDTO roleDTO) {
    return roleService.update(roleDTO);
  }

  @PostMapping
  public RoleDTO save(@RequestBody RoleDTO roleDTO) {
    return roleService.create(roleDTO);
  }

  @DeleteMapping
  public RoleDTO delete(@RequestBody RoleDTO roleDTO) {
    roleService.delete(roleDTO);
    return roleDTO;
  }

  @DeleteMapping("/{id}")
  public RoleDTO deleteById(@PathVariable("id") Integer id) {
    roleService.deleteById(id);
    return roleService.findByIdRoleWithUsersDTO(id);
  }

  @GetMapping("/findOneByCriteria")
  public RoleDTO findOneByCriteriaUserWithRoles(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return roleService.findOneByCriteriaRoleWithUsersDTO(fieldCriterionMap);
  }

  @GetMapping("/findAllByCriteriaMap")
  public List<RoleDTO> findAllByCriteriaRoleWithUsersDTO(
      @RequestParam Map<String, Object> fieldCriterionMap) {
    return roleService.findAllByCriteriaRoleWithUsersDTO(fieldCriterionMap);
  }

  @GetMapping("/findByNotNull")
  public List<RoleDTO> findByNotNullRoleWithUsersDTO(
      @RequestParam("field") List<String> fields) {
    return roleService.findByNotNullRoleWithUsersDTO(fields);
  }

  @GetMapping("/findByNull")
  public List<RoleDTO> findByNullRoleWithUsersDTO(
      @RequestParam("field") List<String> fields) {
    return roleService.findByNullRoleWithUsersDTO(fields);
  }

  @GetMapping("/findAndSort")
  public List<RoleDTO> findAndSortRoleWithUsersDTO(
      @RequestParam Map<String, String> fieldDirectionMap,
      @RequestParam Map<String, Object> fieldCriteriaMap) {
    return roleService.findAndSortRoleWithUsersDTO(fieldDirectionMap, fieldCriteriaMap);
  }

  @GetMapping("/findContain")
  public List<RoleDTO> findContainRoleWithUsersDTO(
      @RequestParam Map<String, String> fieldStringMap) {
    return roleService.findContainRoleWithUsersDTO(fieldStringMap);
  }
}
