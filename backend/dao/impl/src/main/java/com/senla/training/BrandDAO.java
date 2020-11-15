package com.senla.training;

import com.senla.training.domain.Brand;
import org.springframework.stereotype.Repository;

@Repository
public class BrandDAO extends HibernateAbstractDAO<Brand> implements IBrandDAO {
}