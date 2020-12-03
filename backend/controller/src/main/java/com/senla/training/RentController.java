package com.senla.training;

import com.senla.training.rent.RentWithUserStatusHistoryCarModelBrandDTO;
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
@RequestMapping("/rents")
public class RentController {

    private final IRentService rentService;

    @Autowired
    RentController(IRentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/{id}")
    public RentWithUserStatusHistoryCarModelBrandDTO getByIdWithRoleDTO(@PathVariable("id") Integer id) {
        return rentService.findByIdRentWithUserStatusHistoryCarDTO(id);
    }

    @GetMapping
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findAllRentWithUserStatusHistoryCarDTO() {
        return rentService.findAllRentWithUserStatusHistoryCarDTO();
    }

    @GetMapping("/sort")
    public List<RentWithUserStatusHistoryCarModelBrandDTO> sortWithDirectionRentWithUserStatusHistoryCarDTO(@RequestParam Map<String, Direction> allParams) {
        return rentService.sortWithDirectionRentWithUserStatusHistoryCarDTO(allParams);
    }

    @PutMapping
    public RentWithUserStatusHistoryCarModelBrandDTO updateRentWithUserStatusHistoryCarDTO(@RequestBody RentWithUserStatusHistoryCarModelBrandDTO RentWithUserStatusHistoryCarModelBrandDTO) {
        return rentService.updateRentWithUserStatusHistoryCarDTO(RentWithUserStatusHistoryCarModelBrandDTO);
    }

    @PostMapping
    public RentWithUserStatusHistoryCarModelBrandDTO saveRentWithUserStatusHistoryCarDTO(@RequestBody RentWithUserStatusHistoryCarModelBrandDTO RentWithUserStatusHistoryCarModelBrandDTO) {
        return rentService.createRentWithUserStatusHistoryCarDTO(RentWithUserStatusHistoryCarModelBrandDTO);
    }

    @DeleteMapping
    public RentWithUserStatusHistoryCarModelBrandDTO deleteRentWithUserStatusHistoryCarDTO(@RequestBody RentWithUserStatusHistoryCarModelBrandDTO RentWithUserStatusHistoryCarModelBrandDTO) {
        rentService.deleteRentWithUserStatusHistoryCarDTO(RentWithUserStatusHistoryCarModelBrandDTO);
        return RentWithUserStatusHistoryCarModelBrandDTO;
    }

    @GetMapping("/findOneByCriteria")
    public RentWithUserStatusHistoryCarModelBrandDTO findOneByCriteriaRentWithUserStatusHistoryCarDTO(@RequestParam String field, @RequestParam Object criteria) {
        return rentService.findOneByCriteriaRentWithUserStatusHistoryCarDTO(field, criteria);
    }

    @GetMapping("/findAllByCriteria")
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findAllByCriteriaRentWithUserStatusHistoryCarDTO(@RequestParam String field, @RequestParam Object criteria) {
        return rentService.findAllByCriteriaRentWithUserStatusHistoryCarDTO(field, criteria);
    }

    @GetMapping("/findAllByCriteriaMap")
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findAllByCriteriaRentWithUserStatusHistoryCarDTO(@RequestParam Map<String, Object> fieldCriteriaMap) {
        return rentService.findAllByCriteriaRentWithUserStatusHistoryCarDTO(fieldCriteriaMap);
    }

    @GetMapping("/findByNotNull")
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findByNotNullRentWithUserStatusHistoryCarDTO(@RequestParam String field) {
        return rentService.findByNotNullRentWithUserStatusHistoryCarDTO(field);
    }

    @GetMapping("/findByNull")
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findByNullRentWithUserStatusHistoryCarDTO(@RequestParam String field) {
        return rentService.findByNullRentWithUserStatusHistoryCarDTO(field);
    }

    @GetMapping("/finLessThan")
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findLessThanRentWithUserStatusHistoryCarDTO(@RequestParam String field, Number number) {
        return rentService.findLessThanRentWithUserStatusHistoryCarDTO(field, number);
    }

    @GetMapping("/findGreaterThan")
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findGreaterThanRentWithUserStatusHistoryCarDTO(@RequestParam String field, Number number) {
        return rentService.findGreaterThanRentWithUserStatusHistoryCarDTO(field, number);
    }

    @GetMapping("/findAndSort")
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findAndSortRentWithUserStatusHistoryCarDTO(@RequestParam Map<String, Direction> fieldDirectionMap, @RequestParam Map<String, Object> fieldCriteriaMap) {
        return rentService.findAndSortRentWithUserStatusHistoryCarDTO(fieldDirectionMap, fieldCriteriaMap);
    }

    @GetMapping("/findContain")
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findContainRentWithUserStatusHistoryCarDTO(String field, String criteria) {
        return rentService.findContainRentWithUserStatusHistoryCarDTO(field, criteria);
    }
}