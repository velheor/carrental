package com.senla.training;

import com.senla.training.user.UserDTO;
import com.senla.training.user.UserWithRoleDTO;
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
    public UserWithRoleDTO getByIdWithRoleDTO(@PathVariable("id") Integer id) {
        return userService.findByIdUserWithRoleDTO(id);
    }

    @GetMapping
    public List<UserWithRoleDTO> findAllUserWithRoleDTO() {
        return userService.findAllUserWithRoleDTO();
    }

    @GetMapping("/sort")
    public List<UserWithRoleDTO> sortWithDirectionUserWithRoleDTO(@RequestParam Map<String, Direction> allParams) {
        return userService.sortWithDirectionUserWithRoleDTO(allParams);
    }

    @PutMapping
    public UserWithRoleDTO updateUserWithRoleDTO(@RequestBody UserWithRoleDTO userWithRoleDTO) {
        return userService.updateUserWithRoleDTO(userWithRoleDTO);
    }

    @PostMapping
    public UserWithRoleDTO saveUserWithRoleDTO(@RequestBody UserWithRoleDTO userWithRoleDTO) {
        return userService.createUserWithRoleDTO(userWithRoleDTO);
    }

    @DeleteMapping
    public UserWithRoleDTO deleteUserWithRoleDTO(@RequestBody UserWithRoleDTO userWithRoleDTO) {
        userService.deleteUserWithRoleDTO(userWithRoleDTO);
        return userWithRoleDTO;
    }

    @GetMapping("/findOneByCriteria")
    public UserWithRoleDTO findOneByCriteriaUserWithRoleDTO(@RequestParam String field, @RequestParam Object criteria) {
        return userService.findOneByCriteriaUserWithRoleDTO(field, criteria);
    }

    @GetMapping("/findAllByCriteria")
    public List<UserWithRoleDTO> findAllByCriteriaUserWithRoleDTO(@RequestParam String field, @RequestParam Object criteria) {
        return userService.findAllByCriteriaUserWithRoleDTO(field, criteria);
    }

    @GetMapping("/findAllByCriteriaMap")
    public List<UserWithRoleDTO> findAllByCriteriaUserWithRoleDTO(@RequestParam Map<String, Object> fieldCriteriaMap) {
        return userService.findAllByCriteriaUserWithRoleDTO(fieldCriteriaMap);
    }

    @GetMapping("/findByNotNull")
    public List<UserWithRoleDTO> findByNotNullUserWithRoleDTO(@RequestParam String field) {
        return userService.findByNotNullUserWithRoleDTO(field);
    }

    @GetMapping("/findByNull")
    public List<UserWithRoleDTO> findByNullUserWithRoleDTO(@RequestParam String field) {
        return userService.findByNullUserWithRoleDTO(field);
    }

    @GetMapping("/finLessThan")
    public List<UserWithRoleDTO> findLessThanUserWithRoleDTO(@RequestParam String field, Number number) {
        return userService.findLessThanUserWithRoleDTO(field, number);
    }

    @GetMapping("/findGreaterThan")
    public List<UserWithRoleDTO> findGreaterThanUserWithRoleDTO(@RequestParam String field, Number number) {
        return userService.findGreaterThanUserWithRoleDTO(field, number);
    }

    @GetMapping("/findAndSort")
    public List<UserWithRoleDTO> findAndSortUserWithRoleDTO(@RequestParam Map<String, Direction> fieldDirectionMap, @RequestParam Map<String, Object> fieldCriteriaMap) {
        return userService.findAndSortUserWithRoleDTO(fieldDirectionMap, fieldCriteriaMap);
    }

    @GetMapping("/findContain")
    public List<UserWithRoleDTO> findContainUserWithRoleDTO(String field, String criteria) {
        return userService.findContainUserWithRoleDTO(field, criteria);
    }
}