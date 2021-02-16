package com.velheor.carrental.dao.api;

import com.velheor.carrental.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryDAO extends JpaRepository<Category, Integer> {}
