package com.senla.training;

import com.senla.training.rent.RentWithUserStatusHistoryCarModelBrandDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RentService implements IRentService {

    private final IRentDAO rentDAO;

    private final ObjectMapperUtils objectMapperUtils;

    @Autowired
    RentService(IRentDAO rentDAO, ObjectMapperUtils objectMapperUtils) {
        this.rentDAO = rentDAO;
        this.objectMapperUtils = objectMapperUtils;
    }

    @Override
    public RentWithUserStatusHistoryCarModelBrandDTO findByIdRentWithUserStatusHistoryCarDTO(int id) {
        return objectMapperUtils.map(rentDAO.findByIdRentWithUserStatusHistoryCar(id), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findAllRentWithUserStatusHistoryCarDTO() {
        return objectMapperUtils.mapAll(rentDAO.findAllRentWithUserStatusHistoryCar(), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public RentWithUserStatusHistoryCarModelBrandDTO createRentWithUserStatusHistoryCarDTO(RentWithUserStatusHistoryCarModelBrandDTO RentWithUserStatusHistoryCarModelBrandDTO) {
        return objectMapperUtils.map(rentDAO.create(objectMapperUtils.map(RentWithUserStatusHistoryCarModelBrandDTO, Rent.class)), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public RentWithUserStatusHistoryCarModelBrandDTO updateRentWithUserStatusHistoryCarDTO(RentWithUserStatusHistoryCarModelBrandDTO RentWithUserStatusHistoryCarModelBrandDTO) {
        return objectMapperUtils.map(rentDAO.update(objectMapperUtils.map(RentWithUserStatusHistoryCarModelBrandDTO, Rent.class)), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public void deleteRentWithUserStatusHistoryCarDTO(RentWithUserStatusHistoryCarModelBrandDTO RentWithUserStatusHistoryCarModelBrandDTO) {
        rentDAO.delete(objectMapperUtils.map(RentWithUserStatusHistoryCarModelBrandDTO, Rent.class));
    }

    @Override
    public void deleteById(int id) {
        rentDAO.deleteById(id);
    }

    @Override
    public List<RentWithUserStatusHistoryCarModelBrandDTO> sortWithDirectionRentWithUserStatusHistoryCarDTO(String field, Direction direction) {
        return objectMapperUtils.mapAll(rentDAO.sortWithDirectionRentWithUserStatusHistoryCar(field, direction), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public List<RentWithUserStatusHistoryCarModelBrandDTO> sortWithDirectionRentWithUserStatusHistoryCarDTO(Map<String, Direction> fieldDirectionMap) {
        return objectMapperUtils.mapAll(rentDAO.sortWithDirectionRentWithUserStatusHistoryCar(fieldDirectionMap), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public RentWithUserStatusHistoryCarModelBrandDTO findOneByCriteriaRentWithUserStatusHistoryCarDTO(String field, Object criteria) {
        return objectMapperUtils.map(rentDAO.findOneByCriteriaRentWithUserStatusHistoryCar(field, criteria), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findAllByCriteriaRentWithUserStatusHistoryCarDTO(String field, Object criteria) {
        return objectMapperUtils.mapAll(rentDAO.findAllByCriteriaRentWithUserStatusHistoryCar(field, criteria), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findAllByCriteriaRentWithUserStatusHistoryCarDTO(Map<String, Object> fieldCriteriaMap) {
        return objectMapperUtils.mapAll(rentDAO.findAllByCriteriaRentWithUserStatusHistoryCar(fieldCriteriaMap), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findByNotNullRentWithUserStatusHistoryCarDTO(String field) {
        return objectMapperUtils.mapAll(rentDAO.findByNotNullRentWithUserStatusHistoryCar(field), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findByNullRentWithUserStatusHistoryCarDTO(String field) {
        return objectMapperUtils.mapAll(rentDAO.findByNullRentWithUserStatusHistoryCar(field), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findLessThanRentWithUserStatusHistoryCarDTO(String field, Number number) {
        return objectMapperUtils.mapAll(rentDAO.findLessThanRentWithUserStatusHistoryCar(field, number), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findGreaterThanRentWithUserStatusHistoryCarDTO(String field, Number number) {
        return objectMapperUtils.mapAll(rentDAO.findGreaterThanRentWithUserStatusHistoryCar(field, number), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findAndSortRentWithUserStatusHistoryCarDTO(Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
        return objectMapperUtils.mapAll(rentDAO.findAndSortRentWithUserStatusHistoryCar(fieldDirectionMap, fieldCriteriaMap), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }

    @Override
    public List<RentWithUserStatusHistoryCarModelBrandDTO> findContainRentWithUserStatusHistoryCarDTO(String field, String criteria) {
        return objectMapperUtils.mapAll(rentDAO.findContainRentWithUserStatusHistoryCar(field, criteria), RentWithUserStatusHistoryCarModelBrandDTO.class);
    }
}