package com.senla.training;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends HibernateAbstractDAO<User> implements IUserDAO {
}