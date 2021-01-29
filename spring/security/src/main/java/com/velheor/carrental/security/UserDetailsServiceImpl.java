package com.velheor.carrental.security;

import com.velheor.carrental.dao.api.IUserDAO;
import com.velheor.carrental.models.User;
import com.velheor.carrental.security.jwt.SecurityUser;
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
    User userWithRoles = userDAO.findByEmailUserWithRoles(email);
    if (userWithRoles == null) {
      throw new UsernameNotFoundException("User doesn't exists");
    }
    return SecurityUser.fromUser(userWithRoles);
  }
}
