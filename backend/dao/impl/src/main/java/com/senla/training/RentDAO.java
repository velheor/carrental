package com.senla.training;

import com.senla.training.domain.Rent;
import org.springframework.stereotype.Repository;

@Repository
public class RentDAO extends HibernateAbstractDAO<Rent> implements IRentDAO  {
}