package com.senla.training.service.api;

import com.senla.training.dto.model.ModelDTO;
import com.senla.training.dto.model.ModelWithBrandDTO;
import java.util.List;
import java.util.Map;

public interface IModelService extends IGenericService<ModelDTO> {
  ModelWithBrandDTO findByIdModelWithBrandDTO(int id);

  List<ModelWithBrandDTO> findAllAndSortWithDirectionModelWithBrandDTO(
      Map<String, String> fieldDirectionMap);

  ModelWithBrandDTO findOneByCriteriaModelWithBrandDTO(Map<String, Object> fieldCriteriaMap);

  List<ModelWithBrandDTO> findAllByCriteriaModelWithBrandDTO(Map<String, Object> fieldCriteriaMap);

  List<ModelWithBrandDTO> findByNotNullModelWithBrandDTO(List<String> fields);

  List<ModelWithBrandDTO> findByNullModelWithBrandDTO(List<String> fields);

  List<ModelWithBrandDTO> findLessThanModelWithBrandDTO(Map<String, Number> fieldNumberMap);

  List<ModelWithBrandDTO> findGreaterThanModelWithBrandDTO(Map<String, Number> fieldNumberMap);

  List<ModelWithBrandDTO> findAndSortModelWithBrandDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

  List<ModelWithBrandDTO> findContainModelWithBrandDTO(Map<String, String> fieldStringMap);
}
