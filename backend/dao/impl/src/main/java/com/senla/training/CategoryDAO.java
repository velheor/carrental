package com.senla.training;

import com.senla.training.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO extends HibernateAbstractDAO<Category> implements ICategoryDAO {
}