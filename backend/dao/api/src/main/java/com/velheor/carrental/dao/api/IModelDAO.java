package com.velheor.carrental.dao.api;

import com.velheor.carrental.models.Model;
import com.velheor.carrental.models.enums.Direction;
import java.util.List;
import java.util.Map;

public interface IModelDAO extends IGenericDAO<Model> {

  Model findByIdModelWithBrand(int id);

  List<Model> findAllAndSortWithDirectionModelWithBrand(Map<String, Direction> fieldDirectionMap);

  Model findOneByCriteriaModelWithBrand(Map<String, Object> fieldCriteriaMap);

  List<Model> findAllByCriteriaModelWithBrand(Map<String, Object> fieldCriteriaMap);

  List<Model> findByNotNullModelWithBrand(List<String> fields);

  List<Model> findByNullModelWithBrand(List<String> fields);

  List<Model> findAndSortModelWithBrand(
      Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap);
}
