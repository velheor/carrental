package com.velheor.carrental.dao.api;

import com.velheor.carrental.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentDAO extends JpaRepository<Rent, Integer> {}
