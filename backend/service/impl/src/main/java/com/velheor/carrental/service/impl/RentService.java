package com.velheor.carrental.service.impl;

import com.velheor.carrental.dao.api.IRentDAO;
import com.velheor.carrental.dao.api.IUserDAO;
import com.velheor.carrental.dto.RentDTO;
import com.velheor.carrental.models.Rent;
import com.velheor.carrental.models.StatusHistory;
import com.velheor.carrental.models.User;
import com.velheor.carrental.models.enums.EStatusHistory;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.service.api.ICarService;
import com.velheor.carrental.service.api.IRentService;
import com.velheor.carrental.service.api.IUserService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RentService implements IRentService {

  private final IRentDAO rentDAO;

  private final ICarService carService;

  private final IUserDAO userDAO;

  private final IUserService userService;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  RentService(
      IRentDAO rentDAO,
      ICarService carService,
      IUserDAO userDAO,
      IUserService userService,
      ObjectMapperUtils objectMapperUtils) {
    this.rentDAO = rentDAO;
    this.carService = carService;
    this.userDAO = userDAO;
    this.userService = userService;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public RentDTO findByIdRentWithUserStatusHistoryCarModelBrandDTO(int id) {
    return objectMapperUtils.map(
        rentDAO.findByIdRentWithUserStatusHistoryCarModelBrand(id), RentDTO.class);
  }

  @Override
  public List<RentDTO> findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrandDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        RentDTO.class);
  }

  @Override
  public RentDTO findOneByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.map(
        rentDAO.findOneByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriteriaMap),
        RentDTO.class);
  }

  @Override
  public List<RentDTO> findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
      Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findAllByCriteriaRentWithUserStatusHistoryCarModelBrand(fieldCriteriaMap),
        RentDTO.class);
  }

  @Override
  public List<RentDTO> findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        rentDAO.findByNotNullRentWithUserStatusHistoryCarModelBrand(fields), RentDTO.class);
  }

  @Override
  public List<RentDTO> findByNullRentWithUserStatusHistoryCarModelBrandDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        rentDAO.findByNullRentWithUserStatusHistoryCarModelBrand(fields), RentDTO.class);
  }

  @Override
  public List<RentDTO> findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        rentDAO.findAndSortRentWithUserStatusHistoryCarModelBrand(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        RentDTO.class);
  }

  @Override
  public RentDTO checkIn(UserDetails userDetails, int id) {
    User user = this.userDAO
        .findByIdUserWithRents(userService.findCurrentUser(userDetails).getId());
    for (Rent rent : user.getRents()) {
      if (rent.getId().equals(id)) {
        rentDAO.findByIdRentWithUserStatusHistoryCarModelBrand(id).getStatusHistoryList()
            .add(new StatusHistory(id,
                EStatusHistory.START, new Date()));
      }
    }
    return this.findByIdRentWithUserStatusHistoryCarModelBrandDTO(id);
  }

  @Override
  public RentDTO checkOut(UserDetails userDetails, int id) {
    for (Rent rent : this.userDAO
        .findByIdUserWithRents(userService.findCurrentUser(userDetails).getId()).getRents()) {
      if (rent.getId().equals(id)) {
        rentDAO.findByIdRentWithUserStatusHistoryCarModelBrand(id).getStatusHistoryList()
            .add(new StatusHistory(id,
                EStatusHistory.END, new Date()));
      }
    }
    return this.findByIdRentWithUserStatusHistoryCarModelBrandDTO(id);
  }

  @Override
  public RentDTO create(RentDTO entityDTO) {
    if (carService.isAvailableCarOnDate(entityDTO.getCar().getId(), entityDTO.getFromDate(),
        entityDTO.getToDate())) {
      return objectMapperUtils.map(
          rentDAO.create(objectMapperUtils.map(entityDTO, Rent.class)), RentDTO.class);
    }
    return null;
  }

  @Override
  public RentDTO update(RentDTO entityDTO) {
    return objectMapperUtils.map(
        rentDAO.update(objectMapperUtils.map(entityDTO, Rent.class)), RentDTO.class);
  }

  @Override
  public void delete(RentDTO entityDTO) {
    rentDAO.delete(objectMapperUtils.map(entityDTO, Rent.class));
  }

  @Override
  public void deleteById(int id) {
    rentDAO.deleteById(id);
  }
}
