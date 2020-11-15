package com.senla.training;

import com.senla.training.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAO extends HibernateAbstractDAO<Car> implements ICarDAO {
}