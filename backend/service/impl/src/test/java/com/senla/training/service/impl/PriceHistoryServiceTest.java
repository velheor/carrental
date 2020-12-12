package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.senla.training.dao.api.IPriceHistoryDAO;
import com.senla.training.dto.pricehistory.PriceHistoryWithCarModelBrandDTO;
import com.senla.training.models.PriceHistory;
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

class PriceHistoryServiceTest {

  @InjectMocks private PriceHistoryService priceHistoryService;
  @Mock private IPriceHistoryDAO priceHistoryDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  private final PriceHistory priceHistory;
  private final PriceHistoryWithCarModelBrandDTO priceHistoryWithCarModelBrandDTO;

  private final List<PriceHistory> priceHistoryList;
  private final List<PriceHistoryWithCarModelBrandDTO> priceHistoryWithCarModelBrandDTOList;

  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  private final Map<String, Number> fieldNumberMap;
  private final Map<String, String> fieldContainMap;

  public PriceHistoryServiceTest() {
    MockitoAnnotations.initMocks(this);

    priceHistory = new PriceHistory();
    priceHistoryWithCarModelBrandDTO = new PriceHistoryWithCarModelBrandDTO();

    priceHistoryList = new ArrayList<>();
    priceHistoryWithCarModelBrandDTOList = new ArrayList<>();

    priceHistoryList.add(priceHistory);
    priceHistoryList.add(new PriceHistory());

    priceHistoryWithCarModelBrandDTOList.add(priceHistoryWithCarModelBrandDTO);
    priceHistoryWithCarModelBrandDTOList.add(new PriceHistoryWithCarModelBrandDTO());

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
    fieldNumberMap = new HashMap<>();
    fieldContainMap = new HashMap<>();
  }

  @Test
  void findByIdPriceHistoryWithCarModelBrandDTO() {
    given(priceHistoryDAO.findByIdPriceHistoryWithCarModelBrand(1)).willReturn(priceHistory);
    given(objectMapperUtils.map(priceHistory, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(priceHistoryWithCarModelBrandDTO);
    assertEquals(
        priceHistoryWithCarModelBrandDTO,
        priceHistoryService.findByIdPriceHistoryWithCarModelBrandDTO(1));

    given(priceHistoryDAO.findByIdPriceHistoryWithCarModelBrand(1)).willReturn(null);
    assertNull(priceHistoryService.findByIdPriceHistoryWithCarModelBrandDTO(1));

    given(priceHistoryDAO.findByIdPriceHistoryWithCarModelBrand(1)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> priceHistoryService.findByIdPriceHistoryWithCarModelBrandDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionPriceHistoryWithCarModelBrandDTO() {
    given(
            priceHistoryDAO.findAllAndSortWithDirectionPriceHistoryWithCarModelBrand(
                fieldDirectionMap))
        .willReturn(priceHistoryList);
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(priceHistoryWithCarModelBrandDTOList);
    assertEquals(
        priceHistoryWithCarModelBrandDTOList,
        priceHistoryService.findAllAndSortWithDirectionPriceHistoryWithCarModelBrandDTO(
            fieldDirectionStringMap));

    given(
            priceHistoryDAO.findAllAndSortWithDirectionPriceHistoryWithCarModelBrand(
                fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        priceHistoryService.findAllAndSortWithDirectionPriceHistoryWithCarModelBrandDTO(
            fieldDirectionStringMap));

    given(
            priceHistoryDAO.findAllAndSortWithDirectionPriceHistoryWithCarModelBrand(
                fieldDirectionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            priceHistoryService.findAllAndSortWithDirectionPriceHistoryWithCarModelBrandDTO(
                fieldDirectionStringMap));
  }

  @Test
  void findOneByCriteriaPriceHistoryWithCarModelBrandDTO() {
    given(priceHistoryDAO.findOneByCriteriaPriceHistoryWithCarModelBrand(fieldCriterionMap))
        .willReturn(priceHistory);
    given(objectMapperUtils.map(priceHistory, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(priceHistoryWithCarModelBrandDTO);
    assertEquals(
        priceHistoryWithCarModelBrandDTO,
        priceHistoryService.findOneByCriteriaPriceHistoryWithCarModelBrandDTO(fieldCriterionMap));

    given(priceHistoryDAO.findOneByCriteriaPriceHistoryWithCarModelBrand(fieldCriterionMap))
        .willReturn(null);
    given(objectMapperUtils.map(priceHistory, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(null);
    assertNull(
        priceHistoryService.findOneByCriteriaPriceHistoryWithCarModelBrandDTO(fieldCriterionMap));

    given(priceHistoryDAO.findOneByCriteriaPriceHistoryWithCarModelBrand(fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            priceHistoryService.findOneByCriteriaPriceHistoryWithCarModelBrandDTO(
                fieldCriterionMap));
  }

  @Test
  void findAllByCriteriaPriceHistoryWithCarModelBrandDTO() {
    given(priceHistoryDAO.findAllByCriteriaPriceHistoryWithCarModelBrand(fieldCriterionMap))
        .willReturn(priceHistoryList);
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(priceHistoryWithCarModelBrandDTOList);
    assertEquals(
        priceHistoryWithCarModelBrandDTOList,
        priceHistoryService.findAllByCriteriaPriceHistoryWithCarModelBrandDTO(fieldCriterionMap));

    given(priceHistoryDAO.findAllByCriteriaPriceHistoryWithCarModelBrand(fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        priceHistoryService.findAllByCriteriaPriceHistoryWithCarModelBrandDTO(fieldCriterionMap));

    given(priceHistoryDAO.findAllByCriteriaPriceHistoryWithCarModelBrand(fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            priceHistoryService.findAllByCriteriaPriceHistoryWithCarModelBrandDTO(
                fieldCriterionMap));
  }

  @Test
  void findByNotNullPriceHistoryWithCarModelBrandDTO() {
    given(priceHistoryDAO.findByNotNullPriceHistoryWithCarModelBrand(fields))
        .willReturn(priceHistoryList);
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(priceHistoryWithCarModelBrandDTOList);
    assertEquals(
        priceHistoryWithCarModelBrandDTOList,
        priceHistoryService.findByNotNullPriceHistoryWithCarModelBrandDTO(fields));

    given(priceHistoryDAO.findByNotNullPriceHistoryWithCarModelBrand(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        priceHistoryService.findByNotNullPriceHistoryWithCarModelBrandDTO(fields));

    given(priceHistoryDAO.findByNotNullPriceHistoryWithCarModelBrand(fields))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> priceHistoryService.findByNotNullPriceHistoryWithCarModelBrandDTO(fields));
  }

  @Test
  void findByNullPriceHistoryWithCarModelBrandDTO() {
    given(priceHistoryDAO.findByNullPriceHistoryWithCarModelBrand(fields))
        .willReturn(priceHistoryList);
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(priceHistoryWithCarModelBrandDTOList);
    assertEquals(
        priceHistoryWithCarModelBrandDTOList,
        priceHistoryService.findByNullPriceHistoryWithCarModelBrandDTO(fields));

    given(priceHistoryDAO.findByNullPriceHistoryWithCarModelBrand(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(), priceHistoryService.findByNullPriceHistoryWithCarModelBrandDTO(fields));

    given(priceHistoryDAO.findByNullPriceHistoryWithCarModelBrand(fields))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> priceHistoryService.findByNullPriceHistoryWithCarModelBrandDTO(fields));
  }

  @Test
  void findLessThanPriceHistoryWithCarModelBrandDTO() {
    given(priceHistoryDAO.findLessThanPriceHistoryWithCarModelBrand(fieldNumberMap))
        .willReturn(priceHistoryList);
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(priceHistoryWithCarModelBrandDTOList);
    assertEquals(
        priceHistoryWithCarModelBrandDTOList,
        priceHistoryService.findLessThanPriceHistoryWithCarModelBrandDTO(fieldNumberMap));

    given(priceHistoryDAO.findLessThanPriceHistoryWithCarModelBrand(fieldNumberMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        priceHistoryService.findLessThanPriceHistoryWithCarModelBrandDTO(fieldNumberMap));

    given(priceHistoryDAO.findLessThanPriceHistoryWithCarModelBrand(fieldNumberMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> priceHistoryService.findLessThanPriceHistoryWithCarModelBrandDTO(fieldNumberMap));
  }

  @Test
  void findGreaterThanPriceHistoryWithCarModelBrandDTO() {
    given(priceHistoryDAO.findGreaterThanPriceHistoryWithCarModelBrand(fieldNumberMap))
        .willReturn(priceHistoryList);
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(priceHistoryWithCarModelBrandDTOList);
    assertEquals(
        priceHistoryWithCarModelBrandDTOList,
        priceHistoryService.findGreaterThanPriceHistoryWithCarModelBrandDTO(fieldNumberMap));

    given(priceHistoryDAO.findGreaterThanPriceHistoryWithCarModelBrand(fieldNumberMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        priceHistoryService.findGreaterThanPriceHistoryWithCarModelBrandDTO(fieldNumberMap));

    given(priceHistoryDAO.findGreaterThanPriceHistoryWithCarModelBrand(fieldNumberMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> priceHistoryService.findGreaterThanPriceHistoryWithCarModelBrandDTO(fieldNumberMap));
  }

  @Test
  void findContainPriceHistoryWithCarModelBrandDTO() {
    given(priceHistoryDAO.findContainPriceHistoryWithCarModelBrand(fieldContainMap))
        .willReturn(priceHistoryList);
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(priceHistoryWithCarModelBrandDTOList);
    assertEquals(
        priceHistoryWithCarModelBrandDTOList,
        priceHistoryService.findContainPriceHistoryWithCarModelBrandDTO(fieldContainMap));

    given(priceHistoryDAO.findContainPriceHistoryWithCarModelBrand(fieldContainMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        priceHistoryService.findContainPriceHistoryWithCarModelBrandDTO(fieldContainMap));

    given(priceHistoryDAO.findContainPriceHistoryWithCarModelBrand(fieldContainMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> priceHistoryService.findContainPriceHistoryWithCarModelBrandDTO(fieldContainMap));
  }

  @Test
  void findAndSortPriceHistoryWithCarModelBrandDTO() {
    given(
            priceHistoryDAO.findAndSortPriceHistoryWithCarModelBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willReturn(priceHistoryList);
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(priceHistoryWithCarModelBrandDTOList);
    assertEquals(
        priceHistoryWithCarModelBrandDTOList,
        priceHistoryService.findAndSortPriceHistoryWithCarModelBrandDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(
            priceHistoryDAO.findAndSortPriceHistoryWithCarModelBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryWithCarModelBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        priceHistoryService.findAndSortPriceHistoryWithCarModelBrandDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(
            priceHistoryDAO.findAndSortPriceHistoryWithCarModelBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            priceHistoryService.findAndSortPriceHistoryWithCarModelBrandDTO(
                fieldDirectionStringMap, fieldCriterionMap));
  }

  @Test
  void create() {
    given(priceHistoryDAO.create(priceHistory)).willReturn(priceHistory);
    given(objectMapperUtils.map(priceHistoryWithCarModelBrandDTO, PriceHistory.class))
        .willReturn(priceHistory);
    assertEquals(
        priceHistoryWithCarModelBrandDTO,
        priceHistoryService.create(priceHistoryWithCarModelBrandDTO));

    given(priceHistoryDAO.create(priceHistory)).willReturn(null);
    assertNull(priceHistoryService.create(priceHistoryWithCarModelBrandDTO));

    given(priceHistoryDAO.create(priceHistory)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> priceHistoryService.create(priceHistoryWithCarModelBrandDTO));
  }

  @Test
  void update() {
    given(priceHistoryDAO.update(priceHistory)).willReturn(priceHistory);
    given(objectMapperUtils.map(priceHistoryWithCarModelBrandDTO, PriceHistory.class))
        .willReturn(priceHistory);
    assertEquals(
        priceHistoryWithCarModelBrandDTO,
        priceHistoryService.update(priceHistoryWithCarModelBrandDTO));

    given(priceHistoryDAO.update(priceHistory)).willReturn(null);
    assertNull(priceHistoryService.update(priceHistoryWithCarModelBrandDTO));

    given(priceHistoryDAO.update(priceHistory)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> priceHistoryService.update(priceHistoryWithCarModelBrandDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(priceHistoryWithCarModelBrandDTO, PriceHistory.class))
        .willReturn(priceHistory);
    priceHistoryService.delete(priceHistoryWithCarModelBrandDTO);
    verify(priceHistoryDAO, atLeastOnce()).delete(priceHistory);

    given(priceHistoryDAO.update(priceHistory)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> priceHistoryService.update(priceHistoryWithCarModelBrandDTO));
  }

  @Test
  void deleteById() {
    int id = 1;
    priceHistoryService.deleteById(id);
    verify(priceHistoryDAO, atLeastOnce()).deleteById(id);
  }
}
