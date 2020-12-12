package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.senla.training.dao.api.ICarDAO;
import com.senla.training.dto.car.CarWithModelCategoryPriceHistoryBrandDTO;
import com.senla.training.models.Car;
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

class CarServiceTest {
  @InjectMocks private CarService carService;
  @Mock private ICarDAO carDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  private final Car car;
  private final CarWithModelCategoryPriceHistoryBrandDTO carWithModelCategoryPriceHistoryBrandDTO;

  private final List<Car> cars;
  private final List<CarWithModelCategoryPriceHistoryBrandDTO>
      carWithModelCategoryPriceHistoryBrandDTOList;

  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  private final Map<String, Number> fieldNumberMap;
  private final Map<String, String> fieldContainMap;

  public CarServiceTest() {
    MockitoAnnotations.initMocks(this);

    car = new Car();
    carWithModelCategoryPriceHistoryBrandDTO = new CarWithModelCategoryPriceHistoryBrandDTO();

    cars = new ArrayList<>();
    carWithModelCategoryPriceHistoryBrandDTOList = new ArrayList<>();

    cars.add(car);
    cars.add(new Car());

    carWithModelCategoryPriceHistoryBrandDTOList.add(carWithModelCategoryPriceHistoryBrandDTO);
    carWithModelCategoryPriceHistoryBrandDTOList.add(
        new CarWithModelCategoryPriceHistoryBrandDTO());

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
    fieldNumberMap = new HashMap<>();
    fieldContainMap = new HashMap<>();
  }

  @Test
  void findByIdCarWithModelCategoryPriceHistoryBrandDTO() {
    given(carDAO.findByIdCarWithModelCategoryPriceHistoryBrand(1)).willReturn(car);
    given(objectMapperUtils.map(car, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(carWithModelCategoryPriceHistoryBrandDTO);
    assertEquals(
        carWithModelCategoryPriceHistoryBrandDTO,
        carService.findByIdCarWithModelCategoryPriceHistoryBrandDTO(1));

    given(carDAO.findByIdCarWithModelCategoryPriceHistoryBrand(1)).willReturn(null);
    assertNull(carService.findByIdCarWithModelCategoryPriceHistoryBrandDTO(1));

    given(carDAO.findByIdCarWithModelCategoryPriceHistoryBrand(1)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> carService.findByIdCarWithModelCategoryPriceHistoryBrandDTO(1));
  }

  @Test
  void findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrandDTO() {
    given(
            carDAO.findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrand(
                fieldDirectionMap))
        .willReturn(cars);
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(carWithModelCategoryPriceHistoryBrandDTOList);
    assertEquals(
        carWithModelCategoryPriceHistoryBrandDTOList,
        carService.findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrandDTO(
            fieldDirectionStringMap));

    given(
            carDAO.findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrand(
                fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        carService.findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrandDTO(
            fieldDirectionStringMap));

    given(
            carDAO.findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrand(
                fieldDirectionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            carService.findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrandDTO(
                fieldDirectionStringMap));
  }

  @Test
  void findOneByCriteriaCarWithModelCategoryPriceHistoryBrandDTO() {
    given(carDAO.findOneByCriteriaCarWithModelCategoryPriceHistoryBrand(fieldCriterionMap))
        .willReturn(car);
    given(objectMapperUtils.map(car, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(carWithModelCategoryPriceHistoryBrandDTO);
    assertEquals(
        carWithModelCategoryPriceHistoryBrandDTO,
        carService.findOneByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(fieldCriterionMap));

    given(carDAO.findOneByCriteriaCarWithModelCategoryPriceHistoryBrand(fieldCriterionMap))
        .willReturn(null);
    given(objectMapperUtils.map(car, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(null);
    assertNull(
        carService.findOneByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(fieldCriterionMap));

    given(carDAO.findOneByCriteriaCarWithModelCategoryPriceHistoryBrand(fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            carService.findOneByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(
                fieldCriterionMap));
  }

  @Test
  void findAllByCriteriaCarWithModelCategoryPriceHistoryBrandDTO() {
    given(carDAO.findAllByCriteriaCarWithModelCategoryPriceHistoryBrand(fieldCriterionMap))
        .willReturn(cars);
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(carWithModelCategoryPriceHistoryBrandDTOList);
    assertEquals(
        carWithModelCategoryPriceHistoryBrandDTOList,
        carService.findAllByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(fieldCriterionMap));

    given(carDAO.findAllByCriteriaCarWithModelCategoryPriceHistoryBrand(fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        carService.findAllByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(fieldCriterionMap));

    given(carDAO.findAllByCriteriaCarWithModelCategoryPriceHistoryBrand(fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            carService.findAllByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(
                fieldCriterionMap));
  }

  @Test
  void findByNotNullCarWithModelCategoryPriceHistoryBrandDTO() {
    given(carDAO.findByNotNullCarWithModelCategoryPriceHistoryBrand(fields)).willReturn(cars);
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(carWithModelCategoryPriceHistoryBrandDTOList);
    assertEquals(
        carWithModelCategoryPriceHistoryBrandDTOList,
        carService.findByNotNullCarWithModelCategoryPriceHistoryBrandDTO(fields));

    given(carDAO.findByNotNullCarWithModelCategoryPriceHistoryBrand(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        carService.findByNotNullCarWithModelCategoryPriceHistoryBrandDTO(fields));

    given(carDAO.findByNotNullCarWithModelCategoryPriceHistoryBrand(fields))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> carService.findByNotNullCarWithModelCategoryPriceHistoryBrandDTO(fields));
  }

  @Test
  void findByNullCarWithModelCategoryPriceHistoryBrandDTO() {
    given(carDAO.findByNullCarWithModelCategoryPriceHistoryBrand(fields)).willReturn(cars);
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(carWithModelCategoryPriceHistoryBrandDTOList);
    assertEquals(
        carWithModelCategoryPriceHistoryBrandDTOList,
        carService.findByNullCarWithModelCategoryPriceHistoryBrandDTO(fields));

    given(carDAO.findByNullCarWithModelCategoryPriceHistoryBrand(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(), carService.findByNullCarWithModelCategoryPriceHistoryBrandDTO(fields));

    given(carDAO.findByNullCarWithModelCategoryPriceHistoryBrand(fields))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> carService.findByNullCarWithModelCategoryPriceHistoryBrandDTO(fields));
  }

  @Test
  void findLessThanCarWithModelCategoryPriceHistoryBrandDTO() {
    given(carDAO.findLessThanCarWithModelCategoryPriceHistoryBrand(fieldNumberMap))
        .willReturn(cars);
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(carWithModelCategoryPriceHistoryBrandDTOList);
    assertEquals(
        carWithModelCategoryPriceHistoryBrandDTOList,
        carService.findLessThanCarWithModelCategoryPriceHistoryBrandDTO(fieldNumberMap));

    given(carDAO.findLessThanCarWithModelCategoryPriceHistoryBrand(fieldNumberMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        carService.findLessThanCarWithModelCategoryPriceHistoryBrandDTO(fieldNumberMap));

    given(carDAO.findLessThanCarWithModelCategoryPriceHistoryBrand(fieldNumberMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> carService.findLessThanCarWithModelCategoryPriceHistoryBrandDTO(fieldNumberMap));
  }

  @Test
  void findGreaterThanCarWithModelCategoryPriceHistoryBrandDTO() {
    given(carDAO.findGreaterThanCarWithModelCategoryPriceHistoryBrand(fieldNumberMap))
        .willReturn(cars);
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(carWithModelCategoryPriceHistoryBrandDTOList);
    assertEquals(
        carWithModelCategoryPriceHistoryBrandDTOList,
        carService.findGreaterThanCarWithModelCategoryPriceHistoryBrandDTO(fieldNumberMap));

    given(carDAO.findGreaterThanCarWithModelCategoryPriceHistoryBrand(fieldNumberMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        carService.findGreaterThanCarWithModelCategoryPriceHistoryBrandDTO(fieldNumberMap));

    given(carDAO.findGreaterThanCarWithModelCategoryPriceHistoryBrand(fieldNumberMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> carService.findGreaterThanCarWithModelCategoryPriceHistoryBrandDTO(fieldNumberMap));
  }

  @Test
  void findContainCarWithModelCategoryPriceHistoryBrandDTO() {
    given(carDAO.findContainCarWithModelCategoryPriceHistoryBrand(fieldContainMap))
        .willReturn(cars);
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(carWithModelCategoryPriceHistoryBrandDTOList);
    assertEquals(
        carWithModelCategoryPriceHistoryBrandDTOList,
        carService.findContainCarWithModelCategoryPriceHistoryBrandDTO(fieldContainMap));

    given(carDAO.findContainCarWithModelCategoryPriceHistoryBrand(fieldContainMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        carService.findContainCarWithModelCategoryPriceHistoryBrandDTO(fieldContainMap));

    given(carDAO.findContainCarWithModelCategoryPriceHistoryBrand(fieldContainMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> carService.findContainCarWithModelCategoryPriceHistoryBrandDTO(fieldContainMap));
  }

  @Test
  void findAndSortCarWithModelCategoryPriceHistoryBrandDTO() {
    given(
            carDAO.findAndSortCarWithModelCategoryPriceHistoryBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willReturn(cars);
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(carWithModelCategoryPriceHistoryBrandDTOList);
    assertEquals(
        carWithModelCategoryPriceHistoryBrandDTOList,
        carService.findAndSortCarWithModelCategoryPriceHistoryBrandDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(
            carDAO.findAndSortCarWithModelCategoryPriceHistoryBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(cars, CarWithModelCategoryPriceHistoryBrandDTO.class))
        .willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(),
        carService.findAndSortCarWithModelCategoryPriceHistoryBrandDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(
            carDAO.findAndSortCarWithModelCategoryPriceHistoryBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () ->
            carService.findAndSortCarWithModelCategoryPriceHistoryBrandDTO(
                fieldDirectionStringMap, fieldCriterionMap));
  }

  @Test
  void create() {
    given(carDAO.create(car)).willReturn(car);
    given(objectMapperUtils.map(carWithModelCategoryPriceHistoryBrandDTO, Car.class))
        .willReturn(car);
    assertEquals(
        carWithModelCategoryPriceHistoryBrandDTO,
        carService.create(carWithModelCategoryPriceHistoryBrandDTO));

    given(carDAO.create(car)).willReturn(null);
    assertNull(carService.create(carWithModelCategoryPriceHistoryBrandDTO));

    given(carDAO.create(car)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> carService.create(carWithModelCategoryPriceHistoryBrandDTO));
  }

  @Test
  void update() {
    given(carDAO.update(car)).willReturn(car);
    given(objectMapperUtils.map(carWithModelCategoryPriceHistoryBrandDTO, Car.class))
        .willReturn(car);
    assertEquals(
        carWithModelCategoryPriceHistoryBrandDTO,
        carService.update(carWithModelCategoryPriceHistoryBrandDTO));

    given(carDAO.update(car)).willReturn(null);
    assertNull(carService.update(carWithModelCategoryPriceHistoryBrandDTO));

    given(carDAO.update(car)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> carService.update(carWithModelCategoryPriceHistoryBrandDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(carWithModelCategoryPriceHistoryBrandDTO, Car.class))
        .willReturn(car);
    carService.delete(carWithModelCategoryPriceHistoryBrandDTO);
    verify(carDAO, atLeastOnce()).delete(car);

    given(carDAO.update(car)).willThrow(Exception.class);
    assertThrows(
        Exception.class, () -> carService.update(carWithModelCategoryPriceHistoryBrandDTO));
  }

  @Test
  void deleteById() {
    int id = 1;
    carService.deleteById(id);
    verify(carDAO, atLeastOnce()).deleteById(id);
  }
}
