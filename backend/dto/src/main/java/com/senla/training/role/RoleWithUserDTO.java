package com.senla.training.role;

import com.senla.training.user.UserWithRolesDTO;

import java.util.List;

public class RoleWithUserDTO extends RoleDTO {
    private List<UserWithRolesDTO> users;

    public List<UserWithRolesDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithRolesDTO> users) {
        this.users = users;
    }
}