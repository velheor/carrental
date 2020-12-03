package com.senla.training.user;

import com.senla.training.rent.RentDTO;

import java.util.Set;

public class UserWithRolesAndRentsDTO extends UserWithRoleDTO {
    private Set<RentDTO> rents;

    public Set<RentDTO> getRents() {
        return rents;
    }

    public void setRents(Set<RentDTO> rents) {
        this.rents = rents;
    }
}