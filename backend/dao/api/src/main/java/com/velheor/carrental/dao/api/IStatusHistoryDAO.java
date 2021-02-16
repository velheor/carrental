package com.velheor.carrental.dao.api;

import com.velheor.carrental.models.StatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusHistoryDAO extends JpaRepository<StatusHistory, Integer> {}
