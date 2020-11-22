package com.senla.training;

import org.springframework.stereotype.Repository;

@Repository
public class PriceHistoryDAO extends HibernateAbstractDAO<PriceHistory> implements IPriceHistory  {
}