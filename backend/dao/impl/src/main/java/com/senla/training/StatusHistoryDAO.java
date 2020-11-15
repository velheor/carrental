package com.senla.training;

import com.senla.training.domain.StatusHistory;
import org.springframework.stereotype.Repository;

@Repository
public class StatusHistoryDAO extends HibernateAbstractDAO<StatusHistory> implements IStatusHistoryDAO  {
}