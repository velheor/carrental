package com.senla.training;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

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