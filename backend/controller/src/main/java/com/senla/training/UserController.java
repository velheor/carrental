package com.senla.training;

import com.senla.training.user.UserWithRolesDTO;
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
    public UserWithRolesDTO getByIdWithRoleDTO(@PathVariable("id") Integer id) {
        return userService.findByIdUserWithRoleDTO(id);
    }

    @GetMapping
    public List<UserWithRolesDTO> findAllUserWithRoleDTO() {
        return userService.findAllUserWithRoleDTO();
    }

    @GetMapping("/sort")
    public List<UserWithRolesDTO> sortWithDirectionUserWithRoleDTO(@RequestParam Map<String, Direction> allParams) {
        return userService.sortWithDirectionUserWithRoleDTO(allParams);
    }

    @PutMapping
    public UserWithRolesDTO updateUserWithRoleDTO(@RequestBody UserWithRolesDTO userWithRolesDTO) {
        return userService.update(userWithRolesDTO);
    }

    @PostMapping
    public UserWithRolesDTO saveUserWithRoleDTO(@RequestBody UserWithRolesDTO userWithRolesDTO) {
        return userService.create(userWithRolesDTO);
    }

    @DeleteMapping
    public UserWithRolesDTO deleteUserWithRoleDTO(@RequestBody UserWithRolesDTO userWithRolesDTO) {
        userService.delete(userWithRolesDTO);
        return userWithRolesDTO;
    }

    @GetMapping("/findOneByCriteria")
    public UserWithRolesDTO findOneByCriteriaUserWithRoleDTO(@RequestParam String field, @RequestParam Object criteria) {
        return userService.findOneByCriteriaUserWithRoleDTO(field, criteria);
    }

    @GetMapping("/findAllByCriteria")
    public List<UserWithRolesDTO> findAllByCriteriaUserWithRoleDTO(@RequestParam String field, @RequestParam Object criteria) {
        return userService.findAllByCriteriaUserWithRoleDTO(field, criteria);
    }

    @GetMapping("/findAllByCriteriaMap")
    public List<UserWithRolesDTO> findAllByCriteriaUserWithRoleDTO(@RequestParam Map<String, Object> fieldCriteriaMap) {
        return userService.findAllByCriteriaUserWithRoleDTO(fieldCriteriaMap);
    }

    @GetMapping("/findByNotNull")
    public List<UserWithRolesDTO> findByNotNullUserWithRoleDTO(@RequestParam String field) {
        return userService.findByNotNullUserWithRoleDTO(field);
    }

    @GetMapping("/findByNull")
    public List<UserWithRolesDTO> findByNullUserWithRoleDTO(@RequestParam String field) {
        return userService.findByNullUserWithRoleDTO(field);
    }

    @GetMapping("/finLessThan")
    public List<UserWithRolesDTO> findLessThanUserWithRoleDTO(@RequestParam String field, Number number) {
        return userService.findLessThanUserWithRoleDTO(field, number);
    }

    @GetMapping("/findGreaterThan")
    public List<UserWithRolesDTO> findGreaterThanUserWithRoleDTO(@RequestParam String field, Number number) {
        return userService.findGreaterThanUserWithRoleDTO(field, number);
    }

    @GetMapping("/findAndSort")
    public List<UserWithRolesDTO> findAndSortUserWithRoleDTO(@RequestParam Map<String, Direction> fieldDirectionMap, @RequestParam Map<String, Object> fieldCriteriaMap) {
        return userService.findAndSortUserWithRoleDTO(fieldDirectionMap, fieldCriteriaMap);
    }

    @GetMapping("/findContain")
    public List<UserWithRolesDTO> findContainUserWithRoleDTO(String field, String criteria) {
        return userService.findContainUserWithRoleDTO(field, criteria);
    }
}