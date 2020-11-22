package com.senla.training;

import org.springframework.stereotype.Repository;

@Repository
public class StatusHistoryDAO extends HibernateAbstractDAO<StatusHistory> implements IStatusHistoryDAO  {
}