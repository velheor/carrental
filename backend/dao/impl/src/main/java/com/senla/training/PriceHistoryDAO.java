package com.senla.training;

import com.senla.training.domain.PriceHistory;
import org.springframework.stereotype.Repository;

@Repository
public class PriceHistoryDAO extends HibernateAbstractDAO<PriceHistory> implements IPriceHistory  {
}