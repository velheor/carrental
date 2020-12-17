package com.senla.training.service.api;

import com.senla.training.dto.BrandDTO;
import java.util.List;
import java.util.Map;

public interface IBrandService extends IGenericService<BrandDTO> {
  BrandDTO findByIdBrandWithModelsDTO(int id);

  List<BrandDTO> findAllAndSortWithDirectionBrandWithModelsDTO(
      Map<String, String> fieldDirectionMap);

  BrandDTO findOneByCriteriaBrandWithModelsDTO(Map<String, Object> fieldCriteriaMap);

  List<BrandDTO> findAllByCriteriaBrandWithModelsDTO(
      Map<String, Object> fieldCriteriaMap);

  List<BrandDTO> findByNotNullBrandWithModelsDTO(List<String> fields);

  List<BrandDTO> findByNullBrandWithModelsDTO(List<String> fields);

  List<BrandDTO> findAndSortBrandWithModelsDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<BrandDTO> findContainBrandWithModelsDTO(Map<String, String> fieldStringMap);
}
