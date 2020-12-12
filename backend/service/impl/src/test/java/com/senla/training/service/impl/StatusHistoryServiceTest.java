package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.senla.training.dao.api.IStatusHistoryDAO;
import com.senla.training.dto.statusHistory.StatusHistoryWithRentDTO;
import com.senla.training.models.StatusHistory;
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

class StatusHistoryServiceTest {

  @InjectMocks private StatusHistoryService statusHistoryService;
  @Mock private IStatusHistoryDAO statusHistoryDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  private final StatusHistory statusHistory;
  private final StatusHistoryWithRentDTO statusHistoryWithRentDTO;

  private final List<StatusHistory> statusHistoryList;
  private final List<StatusHistoryWithRentDTO> statusHistoryWithRentDTOList;

  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  private final Map<String, Number> fieldNumberMap;
  private final Map<String, String> fieldContainMap;

  public StatusHistoryServiceTest() {
    MockitoAnnotations.initMocks(this);

    statusHistory = new StatusHistory();
    statusHistoryWithRentDTO = new StatusHistoryWithRentDTO();

    statusHistoryList = new ArrayList<>();
    statusHistoryWithRentDTOList = new ArrayList<>();

    statusHistoryList.add(statusHistory);
    statusHistoryList.add(new StatusHistory());

    statusHistoryWithRentDTOList.add(statusHistoryWithRentDTO);
    statusHistoryWithRentDTOList.add(new StatusHistoryWithRentDTO());

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
    fieldNumberMap = new HashMap<>();
    fieldContainMap = new HashMap<>();
  }

  @Test
  void findByIdStatusHistoryWithRentDTO() {
    given(statusHistoryDAO.findByIdStatusHistoryWithRent(1)).willReturn(statusHistory);
    given(objectMapperUtils.map(statusHistory, StatusHistoryWithRentDTO.class))
        .willReturn(statusHistoryWithRentDTO);
    assertEquals(
        statusHistoryWithRentDTO, statusHistoryService.findByIdStatusHistoryWithRentDTO(1));
    given(statusHistoryDAO.findByIdStatusHistoryWithRent(1)).willReturn(null);
    assertNull(statusHistoryService.findByIdStatusHistoryWithRentDTO(1));
    given(statusHistoryDAO.findByIdStatusHistoryWithRent(1)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> statusHistoryService.findByIdStatusHistoryWithRentDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionStatusHistoryWithRentDTO() {
    given(statusHistoryDAO.findAllAndSortWithDirectionStatusHistoryWithRent(fieldDirectionMap))
        .willReturn(statusHistoryList);
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(statusHistoryWithRentDTOList);
    assertEquals(
        statusHistoryWithRentDTOList,
        statusHistoryService.findAllAndSortWithDirectionStatusHistoryWithRentDTO(
            fieldDirectionStringMap));

    given(statusHistoryDAO.findAllAndSortWithDirectionStatusHistoryWithRent(fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        statusHistoryService.findAllAndSortWithDirectionStatusHistoryWithRentDTO(
            fieldDirectionStringMap));

    given(statusHistoryDAO.findAllAndSortWithDirectionStatusHistoryWithRent(fieldDirectionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            statusHistoryService.findAllAndSortWithDirectionStatusHistoryWithRentDTO(
                fieldDirectionStringMap));
  }

  @Test
  void findOneByCriteriaStatusHistoryWithRentDTO() {
    given(statusHistoryDAO.findOneByCriteriaStatusHistoryWithRent(fieldCriterionMap))
        .willReturn(statusHistory);
    given(objectMapperUtils.map(statusHistory, StatusHistoryWithRentDTO.class))
        .willReturn(statusHistoryWithRentDTO);
    assertEquals(
        statusHistoryWithRentDTO,
        statusHistoryService.findOneByCriteriaStatusHistoryWithRentDTO(fieldCriterionMap));

    given(statusHistoryDAO.findOneByCriteriaStatusHistoryWithRent(fieldCriterionMap))
        .willReturn(null);
    given(objectMapperUtils.map(statusHistory, StatusHistoryWithRentDTO.class)).willReturn(null);
    assertNull(statusHistoryService.findOneByCriteriaStatusHistoryWithRentDTO(fieldCriterionMap));

    given(statusHistoryDAO.findOneByCriteriaStatusHistoryWithRent(fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> statusHistoryService.findOneByCriteriaStatusHistoryWithRentDTO(fieldCriterionMap));
  }

  @Test
  void findAllByCriteriaStatusHistoryWithRentDTO() {
    given(statusHistoryDAO.findAllByCriteriaStatusHistoryWithRent(fieldCriterionMap))
        .willReturn(statusHistoryList);
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(statusHistoryWithRentDTOList);
    assertEquals(
        statusHistoryWithRentDTOList,
        statusHistoryService.findAllByCriteriaStatusHistoryWithRentDTO(fieldCriterionMap));

    given(statusHistoryDAO.findAllByCriteriaStatusHistoryWithRent(fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        statusHistoryService.findAllByCriteriaStatusHistoryWithRentDTO(fieldCriterionMap));

    given(statusHistoryDAO.findAllByCriteriaStatusHistoryWithRent(fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> statusHistoryService.findAllByCriteriaStatusHistoryWithRentDTO(fieldCriterionMap));
  }

  @Test
  void findByNotNullStatusHistoryWithRentDTO() {
    given(statusHistoryDAO.findByNotNullStatusHistoryWithRent(fields))
        .willReturn(statusHistoryList);
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(statusHistoryWithRentDTOList);
    assertEquals(
        statusHistoryWithRentDTOList,
        statusHistoryService.findByNotNullStatusHistoryWithRentDTO(fields));

    given(statusHistoryDAO.findByNotNullStatusHistoryWithRent(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(), statusHistoryService.findByNotNullStatusHistoryWithRentDTO(fields));

    given(statusHistoryDAO.findByNotNullStatusHistoryWithRent(fields)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> statusHistoryService.findByNotNullStatusHistoryWithRentDTO(fields));
  }

  @Test
  void findByNullStatusHistoryWithRentDTO() {
    given(statusHistoryDAO.findByNullStatusHistoryWithRent(fields)).willReturn(statusHistoryList);
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(statusHistoryWithRentDTOList);
    assertEquals(
        statusHistoryWithRentDTOList,
        statusHistoryService.findByNullStatusHistoryWithRentDTO(fields));

    given(statusHistoryDAO.findByNullStatusHistoryWithRent(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), statusHistoryService.findByNullStatusHistoryWithRentDTO(fields));

    given(statusHistoryDAO.findByNullStatusHistoryWithRent(fields)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> statusHistoryService.findByNullStatusHistoryWithRentDTO(fields));
  }

  @Test
  void findLessThanStatusHistoryWithRentDTO() {
    given(statusHistoryDAO.findLessThanStatusHistoryWithRent(fieldNumberMap))
        .willReturn(statusHistoryList);
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(statusHistoryWithRentDTOList);
    assertEquals(
        statusHistoryWithRentDTOList,
        statusHistoryService.findLessThanStatusHistoryWithRentDTO(fieldNumberMap));

    given(statusHistoryDAO.findLessThanStatusHistoryWithRent(fieldNumberMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        statusHistoryService.findLessThanStatusHistoryWithRentDTO(fieldNumberMap));

    given(statusHistoryDAO.findLessThanStatusHistoryWithRent(fieldNumberMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> statusHistoryService.findLessThanStatusHistoryWithRentDTO(fieldNumberMap));
  }

  @Test
  void findGreaterThanStatusHistoryWithRentDTO() {
    given(statusHistoryDAO.findGreaterThanStatusHistoryWithRent(fieldNumberMap))
        .willReturn(statusHistoryList);
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(statusHistoryWithRentDTOList);
    assertEquals(
        statusHistoryWithRentDTOList,
        statusHistoryService.findGreaterThanStatusHistoryWithRentDTO(fieldNumberMap));

    given(statusHistoryDAO.findGreaterThanStatusHistoryWithRent(fieldNumberMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        statusHistoryService.findGreaterThanStatusHistoryWithRentDTO(fieldNumberMap));

    given(statusHistoryDAO.findGreaterThanStatusHistoryWithRent(fieldNumberMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> statusHistoryService.findGreaterThanStatusHistoryWithRentDTO(fieldNumberMap));
  }

  @Test
  void findContainStatusHistoryWithRentDTO() {
    given(statusHistoryDAO.findContainStatusHistoryWithRent(fieldContainMap))
        .willReturn(statusHistoryList);
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(statusHistoryWithRentDTOList);
    assertEquals(
        statusHistoryWithRentDTOList,
        statusHistoryService.findContainStatusHistoryWithRentDTO(fieldContainMap));

    given(statusHistoryDAO.findContainStatusHistoryWithRent(fieldContainMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        statusHistoryService.findContainStatusHistoryWithRentDTO(fieldContainMap));

    given(statusHistoryDAO.findContainStatusHistoryWithRent(fieldContainMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> statusHistoryService.findContainStatusHistoryWithRentDTO(fieldContainMap));
  }

  @Test
  void findAndSortStatusHistoryWithRentDTO() {
    given(statusHistoryDAO.findAndSortStatusHistoryWithRent(fieldDirectionMap, fieldCriterionMap))
        .willReturn(statusHistoryList);
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(statusHistoryWithRentDTOList);
    assertEquals(
        statusHistoryWithRentDTOList,
        statusHistoryService.findAndSortStatusHistoryWithRentDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(statusHistoryDAO.findAndSortStatusHistoryWithRent(fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryWithRentDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        statusHistoryService.findAndSortStatusHistoryWithRentDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(statusHistoryDAO.findAndSortStatusHistoryWithRent(fieldDirectionMap, fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            statusHistoryService.findAndSortStatusHistoryWithRentDTO(
                fieldDirectionStringMap, fieldCriterionMap));
  }

  @Test
  void create() {
    given(statusHistoryDAO.create(statusHistory)).willReturn(statusHistory);
    given(objectMapperUtils.map(statusHistoryWithRentDTO, StatusHistory.class))
        .willReturn(statusHistory);
    assertEquals(statusHistoryWithRentDTO, statusHistoryService.create(statusHistoryWithRentDTO));

    given(statusHistoryDAO.create(statusHistory)).willReturn(null);
    assertNull(statusHistoryService.create(statusHistoryWithRentDTO));

    given(statusHistoryDAO.create(statusHistory)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> statusHistoryService.create(statusHistoryWithRentDTO));
  }

  @Test
  void update() {
    given(statusHistoryDAO.update(statusHistory)).willReturn(statusHistory);
    given(objectMapperUtils.map(statusHistoryWithRentDTO, StatusHistory.class))
        .willReturn(statusHistory);
    assertEquals(statusHistoryWithRentDTO, statusHistoryService.update(statusHistoryWithRentDTO));

    given(statusHistoryDAO.update(statusHistory)).willReturn(null);
    assertNull(statusHistoryService.update(statusHistoryWithRentDTO));

    given(statusHistoryDAO.update(statusHistory)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> statusHistoryService.update(statusHistoryWithRentDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(statusHistoryWithRentDTO, StatusHistory.class))
        .willReturn(statusHistory);
    statusHistoryService.delete(statusHistoryWithRentDTO);
    verify(statusHistoryDAO, atLeastOnce()).delete(statusHistory);

    given(statusHistoryDAO.update(statusHistory)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> statusHistoryService.update(statusHistoryWithRentDTO));
  }

  @Test
  void deleteById() {
    int id = 1;
    statusHistoryService.deleteById(id);
    verify(statusHistoryDAO, atLeastOnce()).deleteById(id);
  }
}
