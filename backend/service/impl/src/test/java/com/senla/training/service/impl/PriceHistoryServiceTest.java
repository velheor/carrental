package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.senla.training.dao.api.IPriceHistoryDAO;
import com.senla.training.dto.PriceHistoryDTO;
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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class PriceHistoryServiceTest {

  private final PriceHistory priceHistory;
  private final PriceHistoryDTO priceHistoryDTO;
  private final List<PriceHistory> priceHistoryList;
  private final List<PriceHistoryDTO> priceHistoryDTOList;
  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  @InjectMocks private PriceHistoryService priceHistoryService;
  @Mock private IPriceHistoryDAO priceHistoryDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  public PriceHistoryServiceTest() {
    MockitoAnnotations.initMocks(this);

    priceHistoryList = new ArrayList<>();
    this.priceHistory = Mockito.spy(PriceHistory.class);
    PriceHistory priceHistory = Mockito.spy(PriceHistory.class);

    priceHistoryList.add(this.priceHistory);
    priceHistoryList.add(priceHistory);

    priceHistoryDTOList = new ArrayList<>();
    this.priceHistoryDTO = Mockito.spy(PriceHistoryDTO.class);
    PriceHistoryDTO priceHistoryDTO = Mockito.spy(PriceHistoryDTO.class);

    priceHistoryDTOList.add(this.priceHistoryDTO);
    priceHistoryDTOList.add(priceHistoryDTO);

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
  }

  @Test
  void findByIdPriceHistoryWithCarModelBrandDTO() {
    given(priceHistoryDAO.findByIdPriceHistoryWithCarModelBrand(1)).willReturn(priceHistory);
    given(objectMapperUtils.map(priceHistory, PriceHistoryDTO.class)).willReturn(priceHistoryDTO);
    assertEquals(priceHistoryDTO, priceHistoryService.findByIdPriceHistoryWithCarModelBrandDTO(1));

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
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryDTO.class))
        .willReturn(priceHistoryDTOList);
    assertEquals(
        priceHistoryDTOList,
        priceHistoryService.findAllAndSortWithDirectionPriceHistoryWithCarModelBrandDTO(
            fieldDirectionStringMap));

    given(
            priceHistoryDAO.findAllAndSortWithDirectionPriceHistoryWithCarModelBrand(
                fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryDTO.class))
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
    given(objectMapperUtils.map(priceHistory, PriceHistoryDTO.class)).willReturn(priceHistoryDTO);
    assertEquals(
        priceHistoryDTO,
        priceHistoryService.findOneByCriteriaPriceHistoryWithCarModelBrandDTO(fieldCriterionMap));

    given(priceHistoryDAO.findOneByCriteriaPriceHistoryWithCarModelBrand(fieldCriterionMap))
        .willReturn(null);
    given(objectMapperUtils.map(priceHistory, PriceHistoryDTO.class)).willReturn(null);
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
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryDTO.class))
        .willReturn(priceHistoryDTOList);
    assertEquals(
        priceHistoryDTOList,
        priceHistoryService.findAllByCriteriaPriceHistoryWithCarModelBrandDTO(fieldCriterionMap));

    given(priceHistoryDAO.findAllByCriteriaPriceHistoryWithCarModelBrand(fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryDTO.class))
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
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryDTO.class))
        .willReturn(priceHistoryDTOList);
    assertEquals(
        priceHistoryDTOList,
        priceHistoryService.findByNotNullPriceHistoryWithCarModelBrandDTO(fields));

    given(priceHistoryDAO.findByNotNullPriceHistoryWithCarModelBrand(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryDTO.class))
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
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryDTO.class))
        .willReturn(priceHistoryDTOList);
    assertEquals(
        priceHistoryDTOList,
        priceHistoryService.findByNullPriceHistoryWithCarModelBrandDTO(fields));

    given(priceHistoryDAO.findByNullPriceHistoryWithCarModelBrand(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryDTO.class))
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
  void findAndSortPriceHistoryWithCarModelBrandDTO() {
    given(
            priceHistoryDAO.findAndSortPriceHistoryWithCarModelBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willReturn(priceHistoryList);
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryDTO.class))
        .willReturn(priceHistoryDTOList);
    assertEquals(
        priceHistoryDTOList,
        priceHistoryService.findAndSortPriceHistoryWithCarModelBrandDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(
            priceHistoryDAO.findAndSortPriceHistoryWithCarModelBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(priceHistoryList, PriceHistoryDTO.class))
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
    given(objectMapperUtils.map(priceHistoryDTO, PriceHistory.class)).willReturn(priceHistory);
    given(objectMapperUtils.map(priceHistory, PriceHistoryDTO.class)).willReturn(priceHistoryDTO);
    assertEquals(priceHistoryDTO, priceHistoryService.create(priceHistoryDTO));

    given(priceHistoryDAO.create(priceHistory)).willReturn(null);
    assertNull(priceHistoryService.create(priceHistoryDTO));

    given(priceHistoryDAO.create(priceHistory)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> priceHistoryService.create(priceHistoryDTO));
  }

  @Test
  void update() {
    given(priceHistoryDAO.update(priceHistory)).willReturn(priceHistory);
    given(objectMapperUtils.map(priceHistoryDTO, PriceHistory.class)).willReturn(priceHistory);
    given(objectMapperUtils.map(priceHistory, PriceHistoryDTO.class)).willReturn(priceHistoryDTO);
    assertEquals(priceHistoryDTO, priceHistoryService.update(priceHistoryDTO));

    given(priceHistoryDAO.update(priceHistory)).willReturn(null);
    assertNull(priceHistoryService.update(priceHistoryDTO));

    given(priceHistoryDAO.update(priceHistory)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> priceHistoryService.update(priceHistoryDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(priceHistoryDTO, PriceHistory.class)).willReturn(priceHistory);
    priceHistoryService.delete(priceHistoryDTO);
    verify(priceHistoryDAO, atLeastOnce()).delete(priceHistory);

    given(priceHistoryDAO.update(priceHistory)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> priceHistoryService.update(priceHistoryDTO));
  }

  @Test
  void deleteById() {
    int id = 1;
    priceHistoryService.deleteById(id);
    verify(priceHistoryDAO, atLeastOnce()).deleteById(id);
  }
}
