package com.senla.training.dao.impl;

import com.senla.training.dao.api.ICategoryDAO;
import com.senla.training.models.Category;
import com.senla.training.models.Category;
import com.senla.training.models.enums.Direction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CategoryDAO extends EntityGraphAbstractDAO<Category> implements ICategoryDAO {
    @Override
    public Category findByIdCategoryWithCategoriesCarsModelBrand(int id) {
        super.setEntityGraphName("categoryWithCategoriesCarsModelBrand");
        return super.findById(id);
    }

    @Override
    public List<Category> findAllAndSortWithDirectionCategoryWithCategoriesCarsModelBrand(
            Map<String, Direction> fieldDirectionMap) {
        super.setEntityGraphName("categoryWithCategoriesCarsModelBrand");
        return super.findAllAndSortWithDirection(fieldDirectionMap);
    }

    @Override
    public Category findOneByCriteriaCategoryWithCategoriesCarsModelBrand(
            Map<String, Object> fieldCriteriaMap) {
        super.setEntityGraphName("categoryWithCategoriesCarsModelBrand");
        return super.findOneByCriteria(fieldCriteriaMap);
    }

    @Override
    public List<Category> findAllByCriteriaCategoryWithCategoriesCarsModelBrand(
            Map<String, Object> fieldCriteriaMap) {
        super.setEntityGraphName("categoryWithCategoriesCarsModelBrand");
        return super.findAllByCriteria(fieldCriteriaMap);
    }

    @Override
    public List<Category> findByNotNullCategoryWithCategoriesCarsModelBrand(List<String> fields) {
        super.setEntityGraphName("categoryWithCategoriesCarsModelBrand");
        return super.findByNotNull(fields);
    }

    @Override
    public List<Category> findByNullCategoryWithCategoriesCarsModelBrand(List<String> fields) {
        super.setEntityGraphName("categoryWithCategoriesCarsModelBrand");
        return super.findByNull(fields);
    }

    @Override
    public List<Category> findLessThanCategoryWithCategoriesCarsModelBrand(
            Map<String, Number> fieldNumberMap) {
        super.setEntityGraphName("categoryWithCategoriesCarsModelBrand");
        return super.findLessThan(fieldNumberMap);
    }

    @Override
    public List<Category> findGreaterThanCategoryWithCategoriesCarsModelBrand(
            Map<String, Number> fieldNumberMap) {
        super.setEntityGraphName("categoryWithCategoriesCarsModelBrand");
        return super.findGreaterThan(fieldNumberMap);
    }

    @Override
    public List<Category> findAndSortCategoryWithCategoriesCarsModelBrand(
            Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
        super.setEntityGraphName("categoryWithCategoriesCarsModelBrand");
        return super.findAndSort(fieldDirectionMap, fieldCriteriaMap);
    }

    @Override
    public List<Category> findContainCategoryWithCategoriesCarsModelBrand(
            Map<String, String> fieldStringMap) {
        super.setEntityGraphName("categoryWithCategoriesCarsModelBrand");
        return super.findContain(fieldStringMap);
    }
}
