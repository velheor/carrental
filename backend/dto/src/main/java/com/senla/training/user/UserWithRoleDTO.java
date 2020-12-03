package com.senla.training.user;

import com.senla.training.role.RoleDTO;

import java.util.Set;

public class UserWithRoleDTO extends UserDTO {
    private Set<RoleDTO> roles;

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }
}