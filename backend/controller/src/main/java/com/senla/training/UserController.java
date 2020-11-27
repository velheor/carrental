package com.senla.training;

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

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/sort")
    public List<UserDTO> sortWithDirection(@RequestParam Map<String, Direction> allParams) {
        return userService.sortWithDirection(allParams);
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

    @GetMapping("/findOneByCriteria")
    public UserDTO findOneByCriteria(@RequestParam String field, @RequestParam Object criteria) {
        return userService.findOneByCriteria(field, criteria);
    }

    @GetMapping("/findAllByCriteria")
    public List<UserDTO> findAllByCriteria(@RequestParam String field, @RequestParam Object criteria) {
        return userService.findAllByCriteria(field, criteria);
    }

    @GetMapping("/findAllByCriteriaMap")
    public List<UserDTO> findAllByCriteria(@RequestParam Map<String, Object> fieldCriteriaMap) {
        return userService.findAllByCriteria(fieldCriteriaMap);
    }

    @GetMapping("/findByNotNull")
    public List<UserDTO> findByNotNull(@RequestParam String field) {
        return userService.findByNotNull(field);
    }

    @GetMapping("/findByNull")
    public List<UserDTO> findByNull(@RequestParam String field) {
        return userService.findByNull(field);
    }

    @GetMapping("/finLessThan")
    public List<UserDTO> findLessThan(@RequestParam String field, Number number) {
        return userService.findLessThan(field, number);
    }

    @GetMapping("/findGreaterThan")
    public List<UserDTO> findGreaterThan(@RequestParam String field, Number number) {
        return userService.findGreaterThan(field, number);
    }

    @GetMapping("/findAndSort")
    public List<UserDTO> findAndSort(@RequestParam Map<String, Direction> fieldDirectionMap, @RequestParam Map<String, Object> fieldCriteriaMap) {
        return userService.findAndSort(fieldDirectionMap, fieldCriteriaMap);
    }

    @GetMapping("/findContain")
    public List<UserDTO> findContain(String field, String criteria) {
        return userService.findContain(field, criteria);
    }
}