package com.velheor.carrenal.controllers;

import com.velheor.carrental.dto.UserDTO;
import com.velheor.carrental.dto.UserWithTokenDTO;
import com.velheor.carrental.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final IUserService userService;

  @Autowired
  public AuthController(IUserService userService) {
    this.userService = userService;
  }

  @PostMapping("/signin")
  public UserWithTokenDTO login(@RequestBody UserWithTokenDTO userWithTokenDTO) {
    return userService.getUserWithTokenDTO(userWithTokenDTO);
  }

  @PostMapping("/signup")
  public UserDTO createAccount(@RequestBody UserDTO userDTO) {
    return userService.create(userDTO);
  }
}
