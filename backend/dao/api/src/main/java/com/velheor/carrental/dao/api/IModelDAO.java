package com.velheor.carrental.dao.api;

import com.velheor.carrental.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModelDAO extends JpaRepository<Model, Integer> {}
