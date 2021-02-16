package com.velheor.carrental.dao.api;

import com.velheor.carrental.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarDAO extends JpaRepository<Car, Integer> {}
