package com.velheor.carrental.dao.api;

import com.velheor.carrental.models.ManufacturerCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IManufacturerCountryDAO extends JpaRepository<ManufacturerCountry, Integer> {

}
