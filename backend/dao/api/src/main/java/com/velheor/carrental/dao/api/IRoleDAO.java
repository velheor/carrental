package com.velheor.carrental.dao.api;

import com.velheor.carrental.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleDAO extends JpaRepository<Role, Integer> {}
