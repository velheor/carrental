package com.senla.training.models.enums;

import com.senla.training.models.Permission;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ERole {
  ADMIN(Set.of(Permission.ADMINS_READ, Permission.ADMINS_WRITE)),
  USER(Set.of(Permission.ADMINS_READ));

  private final Set<Permission> permissions;

  ERole(Set<Permission> permissions) {
    this.permissions = permissions;
  }

  public Set<Permission> getPermissions() {
    return permissions;
  }

  public Set<SimpleGrantedAuthority> getAuthorities() {
    return getPermissions().stream()
        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
        .collect(Collectors.toSet());
  }
}
