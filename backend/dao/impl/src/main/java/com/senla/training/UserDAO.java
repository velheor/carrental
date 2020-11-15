package com.senla.training;

import com.senla.training.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends HibernateAbstractDAO<User> implements IUserDAO {
}