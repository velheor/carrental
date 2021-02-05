package com.velheor.carrental.service.api;

import com.velheor.carrental.dto.RentDTO;
import com.velheor.carrental.dto.UserDTO;
import com.velheor.carrental.models.Rent;
import com.velheor.carrental.models.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;

public interface IRentService extends IGenericService<RentDTO> {

  RentDTO findByIdRentWithUserStatusHistoryCarModelBrandDTO(int id);

  List<RentDTO> findAllAndSortWithDirectionRentWithUserStatusHistoryCarModelBrandDTO(
      Map<String, String> fieldDirectionMap);

  RentDTO findOneByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
      Map<String, Object> fieldCriteriaMap);

  List<RentDTO> findAllByCriteriaRentWithUserStatusHistoryCarModelBrandDTO(
      Map<String, Object> fieldCriteriaMap);

  List<RentDTO> findByNotNullRentWithUserStatusHistoryCarModelBrandDTO(List<String> fields);

  List<RentDTO> findByNullRentWithUserStatusHistoryCarModelBrandDTO(List<String> fields);

  List<RentDTO> findAndSortRentWithUserStatusHistoryCarModelBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);
  
  RentDTO checkIn(UserDetails userDetails, int id);
  
  RentDTO checkOut(UserDetails userDetails, int id);
}
