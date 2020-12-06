package com.senla.training.security;

import com.senla.training.dao.api.IUserDAO;
import com.senla.training.models.User;
import com.senla.training.security.jwt.SecurityUser;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

  private final IUserDAO userDAO;

  @Autowired
  public UserDetailsServiceImpl(IUserDAO userDAO) {
    this.userDAO = userDAO;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userDAO.findOneByCriteriaUserWithRoles(Map.of("email", email));
    if (user == null) {
      throw new UsernameNotFoundException("User doesn't exists");
    }
    return SecurityUser.fromUser(user);
  }
}
