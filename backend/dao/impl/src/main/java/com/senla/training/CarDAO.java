package com.senla.training;

import org.springframework.stereotype.Repository;

@Repository
public class CarDAO extends HibernateAbstractDAO<Car> implements ICarDAO {
}