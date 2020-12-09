package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import com.senla.training.dao.api.IRentDAO;
import com.senla.training.dto.rent.RentWithUserStatusHistoryCarModelBrandDTO;
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
  private final RentWithUserStatusHistoryCarModelBrandDTO rentWithUserStatusHistoryCarModelBrandDTO;

  private final List<Rent> rents;
  private final List<RentWithUserStatusHistoryCarModelBrandDTO>
      rentWithUserStatusHistoryCarModelBrandDTOList;

  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  private final Map<String, Number> fieldNumberMap;
  private final Map<String, String> fieldContainMap;

  public RentServiceTest() {
    MockitoAnnotations.initMocks(this);

    rent = new Rent();
    rentWithUserStatusHistoryCarModelBrandDTO = new RentWithUserStatusHistoryCarModelBrandDTO();

    rents = new ArrayList<>();
    rentWithUserStatusHistoryCarModelBrandDTOList = new ArrayList<>();

    rents.add(rent);
    rents.add(new Rent());

    rentWithUserStatusHistoryCarModelBrandDTOList.add(rentWithUserStatusHistoryCarModelBrandDTO);
    rentWithUserStatusHistoryCarModelBrandDTOList.add(
        new RentWithUserStatusHistoryCarModelBrandDTO());

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
    fieldNumberMap = new HashMap<>();
    fieldContainMap = new HashMap<>();
  }

  @Test
  void findByIdRentWithUserStatusHistoryCarModelBrandDTO() {
    given(rentDAO.findByIdRentWithUserStatusHistoryCarModelBrand(1)).willReturn(rent);
    given(objectMapperUtils.map(rent, RentWithUserStatusHistoryCarModelBrandDTO.class))
        .willReturn(rentWithUserStatusHistoryCarModelBrandDTO);
    assertEquals(
        rentWithUserStatusHistoryCarModelBrandDTO,
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
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
        .willReturn(rentWithUserStatusHistoryCarModelBrandDTOList);
    assertEquals(
        rentWithUserStatusHistoryCarModelBrandDTOList,
        rentService.findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrandDTO(
            fieldDirectionStringMap));

    given(
            rentDAO.findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrand(
                fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
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
    given(objectMapperUtils.map(rent, RentWithUserStatusHistoryCarModelBrandDTO.class))
        .willReturn(rentWithUserStatusHistoryCarModelBrandDTO);
    assertEquals(
        rentWithUserStatusHistoryCarModelBrandDTO,
        rentService.findOneByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(fieldCriterionMap));

    given(rentDAO.findOneByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriterionMap))
        .willReturn(null);
    given(objectMapperUtils.map(rent, RentWithUserStatusHistoryCarModelBrandDTO.class))
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
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
        .willReturn(rentWithUserStatusHistoryCarModelBrandDTOList);
    assertEquals(
        rentWithUserStatusHistoryCarModelBrandDTOList,
        rentService.findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(fieldCriterionMap));

    given(rentDAO.findAllByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
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
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
        .willReturn(rentWithUserStatusHistoryCarModelBrandDTOList);
    assertEquals(
        rentWithUserStatusHistoryCarModelBrandDTOList,
        rentService.findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(fields));

    given(rentDAO.findByNotNullRentWithUserStatusHistoryCarModelBrand(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
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
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
        .willReturn(rentWithUserStatusHistoryCarModelBrandDTOList);
    assertEquals(
        rentWithUserStatusHistoryCarModelBrandDTOList,
        rentService.findByNullRentWithUserStatusHistoryCarModelBrandDTO(fields));

    given(rentDAO.findByNullRentWithUserStatusHistoryCarModelBrand(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
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
  void findLessThanRentWithUserStatusHistoryCarModelBrandDTO() {
    given(rentDAO.findLessThanRentWithUserStatusHistoryCarModelBrand(fieldNumberMap))
        .willReturn(rents);
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
        .willReturn(rentWithUserStatusHistoryCarModelBrandDTOList);
    assertEquals(
        rentWithUserStatusHistoryCarModelBrandDTOList,
        rentService.findLessThanRentWithUserStatusHistoryCarModelBrandDTO(fieldNumberMap));

    given(rentDAO.findLessThanRentWithUserStatusHistoryCarModelBrand(fieldNumberMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        rentService.findLessThanRentWithUserStatusHistoryCarModelBrandDTO(fieldNumberMap));

    given(rentDAO.findLessThanRentWithUserStatusHistoryCarModelBrand(fieldNumberMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> rentService.findLessThanRentWithUserStatusHistoryCarModelBrandDTO(fieldNumberMap));
  }

  @Test
  void findGreaterThanRentWithUserStatusHistoryCarModelBrandDTO() {
    given(rentDAO.findGreaterThanRentWithUserStatusHistoryCarModelBrand(fieldNumberMap))
        .willReturn(rents);
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
        .willReturn(rentWithUserStatusHistoryCarModelBrandDTOList);
    assertEquals(
        rentWithUserStatusHistoryCarModelBrandDTOList,
        rentService.findGreaterThanRentWithUserStatusHistoryCarModelBrandDTO(fieldNumberMap));

    given(rentDAO.findGreaterThanRentWithUserStatusHistoryCarModelBrand(fieldNumberMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        rentService.findGreaterThanRentWithUserStatusHistoryCarModelBrandDTO(fieldNumberMap));

    given(rentDAO.findGreaterThanRentWithUserStatusHistoryCarModelBrand(fieldNumberMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> rentService.findGreaterThanRentWithUserStatusHistoryCarModelBrandDTO(fieldNumberMap));
  }

  @Test
  void findContainRentWithUserStatusHistoryCarModelBrandDTO() {
    given(rentDAO.findContainRentWithUserStatusHistoryCarModelBrand(fieldContainMap))
        .willReturn(rents);
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
        .willReturn(rentWithUserStatusHistoryCarModelBrandDTOList);
    assertEquals(
        rentWithUserStatusHistoryCarModelBrandDTOList,
        rentService.findContainRentWithUserStatusHistoryCarModelBrandDTO(fieldContainMap));

    given(rentDAO.findContainRentWithUserStatusHistoryCarModelBrand(fieldContainMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
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
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
        .willReturn(rentWithUserStatusHistoryCarModelBrandDTOList);
    assertEquals(
        rentWithUserStatusHistoryCarModelBrandDTOList,
        rentService.findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(
            rentDAO.findAndSortRentWithUserStatusHistoryCarModelBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(rents, RentWithUserStatusHistoryCarModelBrandDTO.class))
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
  void create() {}

  @Test
  void update() {}

  @Test
  void delete() {}

  @Test
  void deleteById() {}
}
