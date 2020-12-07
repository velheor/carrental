package com.senla.training.service.api;

import com.senla.training.dto.brand.BrandDTO;
import com.senla.training.dto.brand.BrandWithModelsDTO;
import java.util.List;
import java.util.Map;

public interface IBrandService extends IGenericService<BrandDTO> {
  BrandWithModelsDTO findByIdBrandWithModelsDTO(int id);

  List<BrandWithModelsDTO> findAllAndSortWithDirectionBrandWithModelsDTO(
      Map<String, String> fieldDirectionMap);

  BrandWithModelsDTO findOneByCriteriaBrandWithModelsDTO(Map<String, Object> fieldCriteriaMap);

  List<BrandWithModelsDTO> findAllByCriteriaBrandWithModelsDTO(
      Map<String, Object> fieldCriteriaMap);

  List<BrandWithModelsDTO> findByNotNullBrandWithModelsDTO(List<String> fields);

  List<BrandWithModelsDTO> findByNullBrandWithModelsDTO(List<String> fields);

  List<BrandWithModelsDTO> findLessThanBrandWithModelsDTO(Map<String, Number> fieldNumberMap);

  List<BrandWithModelsDTO> findGreaterThanBrandWithModelsDTO(Map<String, Number> fieldNumberMap);

  List<BrandWithModelsDTO> findAndSortBrandWithModelsDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<BrandWithModelsDTO> findContainBrandWithModelsDTO(Map<String, String> fieldStringMap);
}
