package com.velheor.carrental.dao.api;

import com.velheor.carrental.models.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPriceHistoryDAO extends JpaRepository<PriceHistory, Integer> {}
