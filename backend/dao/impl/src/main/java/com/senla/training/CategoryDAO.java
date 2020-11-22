package com.senla.training;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO extends HibernateAbstractDAO<Category> implements ICategoryDAO {
}