package com.senla.training.service.impl;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.senla.training.dao.api.ICarDAO;
import com.senla.training.dto.CarDTO;
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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class CarServiceTest {

  private final Car car;
  private final CarDTO carDTO;
  private final List<Car> cars;
  private final List<CarDTO> carDTOList;
  private final Map<String, String> fieldDirectionStringMap;
  private final Map<String, Object> fieldCriterionMap;
  private final Map<String, Direction> fieldDirectionMap;
  private final List<String> fields;
  @InjectMocks private CarService carService;
  @Mock private ICarDAO carDAO;
  @Mock private ObjectMapperUtils objectMapperUtils;

  public CarServiceTest() {
    MockitoAnnotations.initMocks(this);

    cars = new ArrayList<>();
    this.car = Mockito.spy(Car.class);
    Car car = Mockito.spy(Car.class);

    cars.add(this.car);
    cars.add(car);

    carDTOList = new ArrayList<>();
    this.carDTO = Mockito.spy(CarDTO.class);
    CarDTO carDTO = Mockito.spy(CarDTO.class);

    carDTOList.add(this.carDTO);
    carDTOList.add(carDTO);

    fieldDirectionStringMap = new HashMap<>();
    fieldCriterionMap = new HashMap<>();
    fieldDirectionMap = new HashMap<>();
    fields = new ArrayList<>();
  }

  @Test
  void findByIdCarWithModelCategoryPriceHistoryBrandDTO() {
    given(carDAO.findByIdCarWithModelCategoryPriceHistoryBrand(1)).willReturn(car);
    given(objectMapperUtils.map(car, CarDTO.class)).willReturn(carDTO);
    assertEquals(carDTO, carService.findByIdCarWithModelCategoryPriceHistoryBrandDTO(1));

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
    given(objectMapperUtils.mapAll(cars, CarDTO.class)).willReturn(carDTOList);
    assertEquals(
        carDTOList,
        carService.findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrandDTO(
            fieldDirectionStringMap));

    given(
            carDAO.findAllAndSortWithDirectionCarWithModelCategoryPriceHistoryBrand(
                fieldDirectionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(cars, CarDTO.class)).willReturn(new ArrayList<>());
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
    given(objectMapperUtils.map(car, CarDTO.class)).willReturn(carDTO);
    assertEquals(
        carDTO,
        carService.findOneByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(fieldCriterionMap));

    given(carDAO.findOneByCriteriaCarWithModelCategoryPriceHistoryBrand(fieldCriterionMap))
        .willReturn(null);
    given(objectMapperUtils.map(car, CarDTO.class)).willReturn(null);
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
    given(objectMapperUtils.mapAll(cars, CarDTO.class)).willReturn(carDTOList);
    assertEquals(
        carDTOList,
        carService.findAllByCriteriaCarWithModelCategoryPriceHistoryBrandDTO(fieldCriterionMap));

    given(carDAO.findAllByCriteriaCarWithModelCategoryPriceHistoryBrand(fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(cars, CarDTO.class)).willReturn(new ArrayList<>());
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
    given(objectMapperUtils.mapAll(cars, CarDTO.class)).willReturn(carDTOList);
    assertEquals(
        carDTOList, carService.findByNotNullCarWithModelCategoryPriceHistoryBrandDTO(fields));

    given(carDAO.findByNotNullCarWithModelCategoryPriceHistoryBrand(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(cars, CarDTO.class)).willReturn(new ArrayList<>());
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
    given(objectMapperUtils.mapAll(cars, CarDTO.class)).willReturn(carDTOList);
    assertEquals(carDTOList, carService.findByNullCarWithModelCategoryPriceHistoryBrandDTO(fields));

    given(carDAO.findByNullCarWithModelCategoryPriceHistoryBrand(fields))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(cars, CarDTO.class)).willReturn(new ArrayList<>());
    deepEquals(
        new ArrayList<>(), carService.findByNullCarWithModelCategoryPriceHistoryBrandDTO(fields));

    given(carDAO.findByNullCarWithModelCategoryPriceHistoryBrand(fields))
        .willThrow(Exception.class);
    assertThrows(
        Exception.class,
        () -> carService.findByNullCarWithModelCategoryPriceHistoryBrandDTO(fields));
  }

  @Test
  void findAndSortCarWithModelCategoryPriceHistoryBrandDTO() {
    given(
            carDAO.findAndSortCarWithModelCategoryPriceHistoryBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willReturn(cars);
    given(objectMapperUtils.mapAll(cars, CarDTO.class)).willReturn(carDTOList);
    assertEquals(
        carDTOList,
        carService.findAndSortCarWithModelCategoryPriceHistoryBrandDTO(
            fieldDirectionStringMap, fieldCriterionMap));

    given(
            carDAO.findAndSortCarWithModelCategoryPriceHistoryBrand(
                fieldDirectionMap, fieldCriterionMap))
        .willReturn(new ArrayList<>());
    given(objectMapperUtils.mapAll(cars, CarDTO.class)).willReturn(new ArrayList<>());
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
    given(objectMapperUtils.map(carDTO, Car.class)).willReturn(car);
    given(objectMapperUtils.map(car, CarDTO.class)).willReturn(carDTO);
    assertEquals(carDTO, carService.create(carDTO));

    given(carDAO.create(car)).willReturn(null);
    assertNull(carService.create(carDTO));

    given(carDAO.create(car)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> carService.create(carDTO));
  }

  @Test
  void update() {
    given(carDAO.update(car)).willReturn(car);
    given(objectMapperUtils.map(carDTO, Car.class)).willReturn(car);
    given(objectMapperUtils.map(car, CarDTO.class)).willReturn(carDTO);
    assertEquals(carDTO, carService.update(carDTO));

    given(carDAO.update(car)).willReturn(null);
    assertNull(carService.update(carDTO));

    given(carDAO.update(car)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> carService.update(carDTO));
  }

  @Test
  void delete() {
    given(objectMapperUtils.map(carDTO, Car.class)).willReturn(car);
    carService.delete(carDTO);
    verify(carDAO, atLeastOnce()).delete(car);

    given(carDAO.update(car)).willThrow(Exception.class);
    assertThrows(Exception.class, () -> carService.update(carDTO));
  }

  @Test
  void deleteById() {
    int id = 1;
    carService.deleteById(id);
    verify(carDAO, atLeastOnce()).deleteById(id);
  }
}
