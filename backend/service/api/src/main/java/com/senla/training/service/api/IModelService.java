package com.senla.training.service.api;

import com.senla.training.dto.ModelDTO;
import java.util.List;
import java.util.Map;

public interface IModelService extends IGenericService<ModelDTO> {

  ModelDTO findByIdModelWithBrandDTO(int id);

  List<ModelDTO> findAllAndSortWithDirectionModelWithBrandDTO(
      Map<String, String> fieldDirectionMap);

  ModelDTO findOneByCriteriaModelWithBrandDTO(Map<String, Object> fieldCriteriaMap);

  List<ModelDTO> findAllByCriteriaModelWithBrandDTO(Map<String, Object> fieldCriteriaMap);

  List<ModelDTO> findByNotNullModelWithBrandDTO(List<String> fields);

  List<ModelDTO> findByNullModelWithBrandDTO(List<String> fields);

  List<ModelDTO> findAndSortModelWithBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);
}
