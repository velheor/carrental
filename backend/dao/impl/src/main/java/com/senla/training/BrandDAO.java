package com.senla.training;

import org.springframework.stereotype.Repository;

@Repository
public class BrandDAO extends HibernateAbstractDAO<Brand> implements IBrandDAO {
}