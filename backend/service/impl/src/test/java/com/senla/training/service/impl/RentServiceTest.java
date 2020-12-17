package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.senla.training.dao.api.IRentDAO;
import com.senla.training.dto.RentDTO;
import com.senla.training.models.Rent;
import com.senla.training.models.enums.Direction;
import com.senla.training.objectmapper.ObjectMapperUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RentServiceTest {
  @InjectMocks private RentService rentService;
  @Mock private IRentDAO rentDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  private final Rent rent;
  private final RentDTO rentDTO;

  private final List<Rent> rents;
  private final List<RentDTO>
      rentDTOList;

  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  private final Map<String, String> fieldContainMap;

  public RentServiceTest() {
    MockitoAnnotations.initMocks(this);

    rent = new Rent();
    rentDTO = new RentDTO();

    rents = new ArrayList<>();
    rentDTOList = new ArrayList<>();

    rents.add(rent);
    rents.add(new Rent());

    rentDTOList.add(rentDTO);
    rentDTOList.add(
        new RentDTO());

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
    fieldContainMap = new HashMap<>();
  }

  @Test
  void findByIdRentWithUserStatusHistoryCarModelBrandDTO() {
    given(rentDAO.findByIdRentWithUserStatusHistoryCarModelBrand(1)).willReturn(rent);
    given(objectMapperUtils.map(rent, RentDTO.class))
        .willReturn(rentDTO);
    assertEquals(
        rentDTO,
        rentService.findByIdRentWithUserStatusHistoryCarModelBrandDTO(1));
    given(rentDAO.findByIdRentWithUserStatusHistoryCarModelBrand(1)).willReturn(null);
    assertNull(rentService.findByIdRentWithUserStatusHistoryCarModelBrandDTO(1));
    given(rentDAO.findByIdRentWithUserStatusHistoryCarModelBrand(1)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> rentService.findByIdRentWithUserStatusHistoryCarModelBrandDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrandDTO() {
    given(
            rentDAO.findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrand(
                fieldDirectionMap))
        .willReturn(rents);
    given(objectMapperUtils.mapAll(rents, RentDTO.class))
        .willReturn(rentDTOList);
    assertEquals(
        rentDTOList,
        rentService.findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrandDTO(
            fieldDirectionStringMap));

    given(
            rentDAO.findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrand(
                fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        rentService.findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrandDTO(
            fieldDirectionStringMap));

    given(
            rentDAO.findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrand(
                fieldDirectionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            rentService.findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrandDTO(
                fieldDirectionStringMap));
  }

  @Test
  void findOneByCriteriaRentWithUserStatusHistoryCarModelBrandDTO() {
    given(rentDAO.findOneByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriterionMap))
        .willReturn(rent);
    given(objectMapperUtils.map(rent, RentDTO.class))
        .willReturn(rentDTO);
    assertEquals(
        rentDTO,
        rentService.findOneByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(fieldCriterionMap));

    given(rentDAO.findOneByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriterionMap))
        .willReturn(null);
    given(objectMapperUtils.map(rent, RentDTO.class))
        .willReturn(null);
    assertNull(
        rentService.findOneByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(fieldCriterionMap));

    given(rentDAO.findOneByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            rentService.findOneByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
                fieldCriterionMap));
  }

  @Test
  void findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO() {
    given(rentDAO.findAllByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriterionMap))
        .willReturn(rents);
    given(objectMapperUtils.mapAll(rents, RentDTO.class))
        .willReturn(rentDTOList);
    assertEquals(
        rentDTOList,
        rentService.findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(fieldCriterionMap));

    given(rentDAO.findAllByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        rentService.findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(fieldCriterionMap));

    given(rentDAO.findAllByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            rentService.findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
                fieldCriterionMap));
  }

  @Test
  void findByNotNullRentWithUserStatusHistoryCarModelBrandDTO() {
    given(rentDAO.findByNotNullRentWithUserStatusHistoryCarModelBrand(fields)).willReturn(rents);
    given(objectMapperUtils.mapAll(rents, RentDTO.class))
        .willReturn(rentDTOList);
    assertEquals(
        rentDTOList,
        rentService.findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(fields));

    given(rentDAO.findByNotNullRentWithUserStatusHistoryCarModelBrand(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        rentService.findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(fields));

    given(rentDAO.findByNotNullRentWithUserStatusHistoryCarModelBrand(fields))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> rentService.findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(fields));
  }

  @Test
  void findByNullRentWithUserStatusHistoryCarModelBrandDTO() {
    given(rentDAO.findByNullRentWithUserStatusHistoryCarModelBrand(fields)).willReturn(rents);
    given(objectMapperUtils.mapAll(rents, RentDTO.class))
        .willReturn(rentDTOList);
    assertEquals(
        rentDTOList,
        rentService.findByNullRentWithUserStatusHistoryCarModelBrandDTO(fields));

    given(rentDAO.findByNullRentWithUserStatusHistoryCarModelBrand(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(), rentService.findByNullRentWithUserStatusHistoryCarModelBrandDTO(fields));

    given(rentDAO.findByNullRentWithUserStatusHistoryCarModelBrand(fields))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> rentService.findByNullRentWithUserStatusHistoryCarModelBrandDTO(fields));
  }

  @Test
  void findContainRentWithUserStatusHistoryCarModelBrandDTO() {
    given(rentDAO.findContainRentWithUserStatusHistoryCarModelBrand(fieldContainMap))
        .willReturn(rents);
    given(objectMapperUtils.mapAll(rents, RentDTO.class))
        .willReturn(rentDTOList);
    assertEquals(
        rentDTOList,
        rentService.findContainRentWithUserStatusHistoryCarModelBrandDTO(fieldContainMap));

    given(rentDAO.findContainRentWithUserStatusHistoryCarModelBrand(fieldContainMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        rentService.findContainRentWithUserStatusHistoryCarModelBrandDTO(fieldContainMap));

    given(rentDAO.findContainRentWithUserStatusHistoryCarModelBrand(fieldContainMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> rentService.findContainRentWithUserStatusHistoryCarModelBrandDTO(fieldContainMap));
  }

  @Test
  void findAndSortRentWithUserStatusHistoryCarModelBrandDTO() {
    given(
            rentDAO.findAndSortRentWithUserStatusHistoryCarModelBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willReturn(rents);
    given(objectMapperUtils.mapAll(rents, RentDTO.class))
        .willReturn(rentDTOList);
    assertEquals(
        rentDTOList,
        rentService.findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(
            rentDAO.findAndSortRentWithUserStatusHistoryCarModelBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        rentService.findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(
            rentDAO.findAndSortRentWithUserStatusHistoryCarModelBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            rentService.findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
                fieldDirectionStringMap, fieldCriterionMap));
  }

  @Test
  void create() {
    given(rentDAO.create(rent)).willReturn(rent);
    given(objectMapperUtils.map(rentDTO, Rent.class))
        .willReturn(rent);
    assertEquals(
        rentDTO,
        rentService.create(rentDTO));

    given(rentDAO.create(rent)).willReturn(null);
    assertNull(rentService.create(rentDTO));

    given(rentDAO.create(rent)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> rentService.create(rentDTO));
  }

  @Test
  void update() {
    given(rentDAO.update(rent)).willReturn(rent);
    given(objectMapperUtils.map(rentDTO, Rent.class))
        .willReturn(rent);
    assertEquals(
        rentDTO,
        rentService.update(rentDTO));

    given(rentDAO.update(rent)).willReturn(null);
    assertNull(rentService.update(rentDTO));

    given(rentDAO.update(rent)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> rentService.update(rentDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(rentDTO, Rent.class))
        .willReturn(rent);
    rentService.delete(rentDTO);
    verify(rentDAO, atLeastOnce()).delete(rent);

    given(rentDAO.update(rent)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> rentService.update(rentDTO));
  }

  @Test
  void deleteById() {
    int id = 1;
    rentService.deleteById(id);
    verify(rentDAO, atLeastOnce()).deleteById(id);
  }
}
