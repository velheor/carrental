package com.senla.training.rent;

import com.senla.training.user.UserDTO;

public class RentWithUserStatusHistoryCarModelBrandDTO extends RentWithCarDTO {
    private UserDTO user;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}