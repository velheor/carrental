package com.senla.training;

import com.senla.training.domain.Model;
import org.springframework.stereotype.Repository;

@Repository
public class ModelDAO extends HibernateAbstractDAO<Model> implements IModelDAO {
}