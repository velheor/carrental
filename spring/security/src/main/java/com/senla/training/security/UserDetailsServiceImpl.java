package com.senla.training.security;

import com.senla.training.dto.user.UserWithRolesDTO;
import com.senla.training.security.jwt.SecurityUser;
import com.senla.training.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

  private final IUserService userService;

  @Autowired
  public UserDetailsServiceImpl(IUserService userService) {
    this.userService = userService;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserWithRolesDTO user = userService.findByEmailUserWithRolesDTO(email);
    if (user == null) {
      throw new UsernameNotFoundException("User doesn't exists");
    }
    return SecurityUser.fromUser(user);
  }
}
