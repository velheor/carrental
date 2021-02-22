package com.velheor.carrental.security.jwt;

import com.velheor.carrental.models.Role;
import com.velheor.carrental.models.User;
import com.velheor.carrental.models.enums.EStatusUser;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails {
  private final String username;
  private final String password;
  private final List<SimpleGrantedAuthority> authorities;
  private final boolean isActive;

  public SecurityUser(
      String username,
      String password,
      List<SimpleGrantedAuthority> authorities,
      boolean isActive) {
    this.username = username;
    this.password = password;
    this.authorities = authorities;
    this.isActive = isActive;
  }

  public static UserDetails fromUser(User user) {
    return new org.springframework.security.core.userdetails.User(
        user.getEmail(),
        user.getPassword(),
        user.getStatus().equals(EStatusUser.ACTIVE),
        user.getStatus().equals(EStatusUser.ACTIVE),
        user.getStatus().equals(EStatusUser.ACTIVE),
        user.getStatus().equals(EStatusUser.ACTIVE),
        mapToGrantedAuthorities(user.getRoles()));
  }

  private static List<GrantedAuthority> mapToGrantedAuthorities(Set<Role> userRoles) {
    return userRoles.stream()
        .map(role -> new SimpleGrantedAuthority(role.getName()))
        .collect(Collectors.toList());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return isActive;
  }

  @Override
  public boolean isAccountNonLocked() {
    return isActive;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return isActive;
  }

  @Override
  public boolean isEnabled() {
    return isActive;
  }
}
