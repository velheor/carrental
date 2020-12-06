package com.senla.training.dao.impl;

import com.senla.training.dao.api.IRentDAO;
import com.senla.training.models.Rent;
import org.springframework.stereotype.Repository;

@Repository
public class RentDAO extends EntityGraphAbstractDAO<Rent> implements IRentDAO {}
