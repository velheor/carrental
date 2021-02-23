package com.velheor.carrenal.controllers.rest;

import com.velheor.carrental.dto.RoleDTO;
import com.velheor.carrental.service.api.IRoleService;
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
@RequestMapping("/roles")
public class RoleController {

  private final IRoleService roleService;

  @Autowired
  RoleController(IRoleService roleService) {
    this.roleService = roleService;
  }

  @GetMapping("/{id}")
  public RoleDTO findById(@PathVariable("id") Integer id) {
    return roleService.findById(id);
  }

  //TODO GET AlL
  @GetMapping
  public List<RoleDTO> findAll(
      @RequestParam Map<String, String> allParams) {
    return null;
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
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@RequestBody RoleDTO roleDTO) {
    roleService.delete(roleDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteById(@PathVariable("id") Integer id) {
    roleService.deleteById(id);
  }
}
