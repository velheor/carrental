package com.velheor.carrental.dao.api;

import com.velheor.carrental.models.ManufacturerCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerCountryRepository
    extends JpaRepository<ManufacturerCountry, Integer> {}
