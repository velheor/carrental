package com.velheor.carrental.service.api;

import com.velheor.carrental.dto.UserDTO;
import com.velheor.carrental.dto.UserWithTokenDTO;

public interface IUserService extends IGenericService<UserDTO> {
  UserWithTokenDTO getUserWithTokenDTO(UserWithTokenDTO userWithTokenDTO);
}
