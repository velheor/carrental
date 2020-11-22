package com.senla.training;

import org.springframework.stereotype.Repository;

@Repository
public class RentDAO extends HibernateAbstractDAO<Rent> implements IRentDAO  {
}