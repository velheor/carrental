package com.senla.training.dao.api;

import com.senla.training.models.Brand;
import com.senla.training.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IBrandDAO extends IGenericDAO<Brand> {

  Brand findByIdBrandWithModels(int id);

  List<Brand> findAllAndSortWithDirectionBrandWithModels(Map<String, Direction> fieldDirectionMap);

  Brand findOneByCriteriaBrandWithModels(Map<String, Object> fieldCriteriaMap);

  List<Brand> findAllByCriteriaBrandWithModels(Map<String, Object> fieldCriteriaMap);

  List<Brand> findByNotNullBrandWithModels(List<String> fields);

  List<Brand> findByNullBrandWithModels(List<String> fields);

  List<Brand> findAndSortBrandWithModels(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);

}
