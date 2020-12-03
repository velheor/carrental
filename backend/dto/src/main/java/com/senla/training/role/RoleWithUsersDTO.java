package com.senla.training.role;

import com.senla.training.user.UserDTO;

import java.util.List;

public class RoleWithUsersDTO extends RoleDTO {
    private List<UserDTO> users;

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}