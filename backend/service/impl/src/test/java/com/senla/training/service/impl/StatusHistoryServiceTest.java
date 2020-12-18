package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.senla.training.dao.api.IStatusHistoryDAO;
import com.senla.training.dto.StatusHistoryDTO;
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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class StatusHistoryServiceTest {

  private final StatusHistory statusHistory;
  private final StatusHistoryDTO statusHistoryDTO;
  private final List<StatusHistory> statusHistoryList;
  private final List<StatusHistoryDTO> statusHistoryDTOList;
  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  @InjectMocks
  private StatusHistoryService statusHistoryService;
  @Mock
  private IStatusHistoryDAO statusHistoryDAO;
  @Mock
  private ObjectMapperUtils objectMapperUtils;

  public StatusHistoryServiceTest() {
    MockitoAnnotations.initMocks(this);

    this.statusHistoryList = new ArrayList<>();
    this.statusHistory = Mockito.spy(StatusHistory.class);
    StatusHistory statusHistory = Mockito.spy(StatusHistory.class);
    this.statusHistoryList.add(this.statusHistory);
    this.statusHistoryList.add(statusHistory);

    this.statusHistoryDTOList = new ArrayList<>();
    this.statusHistoryDTO = Mockito.spy(StatusHistoryDTO.class);
    StatusHistoryDTO statusHistoryDTO = Mockito.spy(StatusHistoryDTO.class);
    this.statusHistoryDTOList.add(this.statusHistoryDTO);
    this.statusHistoryDTOList.add(statusHistoryDTO);

    this.fieldDirectionStringMap = new HashMap<>();
    this.fieldCriterionMap = new HashMap<>();
    this.fieldDirectionMap = new HashMap<>();
    this.fields = new ArrayList<>();
  }

  @Test
  void findByIdStatusHistoryWithRentDTO() {
    given(statusHistoryDAO.findByIdStatusHistoryWithRent(1)).willReturn(statusHistory);
    given(objectMapperUtils.map(statusHistory, StatusHistoryDTO.class))
        .willReturn(statusHistoryDTO);
    assertEquals(statusHistoryDTO, statusHistoryService.findByIdStatusHistoryWithRentDTO(1));
    given(statusHistoryDAO.findByIdStatusHistoryWithRent(1)).willReturn(null);
    assertNull(statusHistoryService.findByIdStatusHistoryWithRentDTO(1));
    given(statusHistoryDAO.findByIdStatusHistoryWithRent(1)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> statusHistoryService.findByIdStatusHistoryWithRentDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionStatusHistoryWithRentDTO() {
    given(statusHistoryDAO.findAllAndSortWithDirectionStatusHistoryWithRent(fieldDirectionMap))
        .willReturn(statusHistoryList);
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryDTO.class))
        .willReturn(statusHistoryDTOList);
    assertEquals(
        statusHistoryDTOList,
        statusHistoryService.findAllAndSortWithDirectionStatusHistoryWithRentDTO(
            fieldDirectionStringMap));

    given(statusHistoryDAO.findAllAndSortWithDirectionStatusHistoryWithRent(fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryDTO.class))
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
    given(objectMapperUtils.map(statusHistory, StatusHistoryDTO.class))
        .willReturn(statusHistoryDTO);
    assertEquals(
        statusHistoryDTO,
        statusHistoryService.findOneByCriteriaStatusHistoryWithRentDTO(fieldCriterionMap));

    given(statusHistoryDAO.findOneByCriteriaStatusHistoryWithRent(fieldCriterionMap))
        .willReturn(null);
    given(objectMapperUtils.map(statusHistory, StatusHistoryDTO.class)).willReturn(null);
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
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryDTO.class))
        .willReturn(statusHistoryDTOList);
    assertEquals(
        statusHistoryDTOList,
        statusHistoryService.findAllByCriteriaStatusHistoryWithRentDTO(fieldCriterionMap));

    given(statusHistoryDAO.findAllByCriteriaStatusHistoryWithRent(fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryDTO.class))
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
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryDTO.class))
        .willReturn(statusHistoryDTOList);
    assertEquals(
        statusHistoryDTOList, statusHistoryService.findByNotNullStatusHistoryWithRentDTO(fields));

    given(statusHistoryDAO.findByNotNullStatusHistoryWithRent(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryDTO.class))
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
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryDTO.class))
        .willReturn(statusHistoryDTOList);
    assertEquals(
        statusHistoryDTOList, statusHistoryService.findByNullStatusHistoryWithRentDTO(fields));

    given(statusHistoryDAO.findByNullStatusHistoryWithRent(fields)).willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(new ArrayList<>(), statusHistoryService.findByNullStatusHistoryWithRentDTO(fields));

    given(statusHistoryDAO.findByNullStatusHistoryWithRent(fields)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> statusHistoryService.findByNullStatusHistoryWithRentDTO(fields));
  }

  @Test
  void findAndSortStatusHistoryWithRentDTO() {
    given(statusHistoryDAO.findAndSortStatusHistoryWithRent(fieldDirectionMap, fieldCriterionMap))
        .willReturn(statusHistoryList);
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryDTO.class))
        .willReturn(statusHistoryDTOList);
    assertEquals(
        statusHistoryDTOList,
        statusHistoryService.findAndSortStatusHistoryWithRentDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(statusHistoryDAO.findAndSortStatusHistoryWithRent(fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(statusHistoryList, StatusHistoryDTO.class))
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
    given(objectMapperUtils.map(statusHistoryDTO, StatusHistory.class)).willReturn(statusHistory);
    given(objectMapperUtils.map(statusHistory, StatusHistoryDTO.class))
        .willReturn(statusHistoryDTO);
    assertEquals(statusHistoryDTO, statusHistoryService.create(statusHistoryDTO));

    given(statusHistoryDAO.create(statusHistory)).willReturn(null);
    assertNull(statusHistoryService.create(statusHistoryDTO));

    given(statusHistoryDAO.create(statusHistory)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> statusHistoryService.create(statusHistoryDTO));
  }

  @Test
  void update() {
    given(statusHistoryDAO.update(statusHistory)).willReturn(statusHistory);
    given(objectMapperUtils.map(statusHistoryDTO, StatusHistory.class)).willReturn(statusHistory);
    given(objectMapperUtils.map(statusHistory, StatusHistoryDTO.class))
        .willReturn(statusHistoryDTO);
    assertEquals(statusHistoryDTO, statusHistoryService.update(statusHistoryDTO));

    given(statusHistoryDAO.update(statusHistory)).willReturn(null);
    assertNull(statusHistoryService.update(statusHistoryDTO));

    given(statusHistoryDAO.update(statusHistory)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> statusHistoryService.update(statusHistoryDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(statusHistoryDTO, StatusHistory.class)).willReturn(statusHistory);
    statusHistoryService.delete(statusHistoryDTO);
    verify(statusHistoryDAO, atLeastOnce()).delete(statusHistory);

    given(statusHistoryDAO.update(statusHistory)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> statusHistoryService.update(statusHistoryDTO));
  }

  @Test
  void deleteById() {
    int id = 1;
    statusHistoryService.deleteById(id);
    verify(statusHistoryDAO, atLeastOnce()).deleteById(id);
  }
}
