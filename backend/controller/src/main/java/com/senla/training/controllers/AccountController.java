package com.senla.training.controllers;

import com.senla.training.dto.UserDTO;
import com.senla.training.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myaccount")
public class AccountController {

  private final IUserService userService;

  @Autowired
  public AccountController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public UserDTO read(@AuthenticationPrincipal UserDetails userDetails) {
    return userService.findCurrentUser(userDetails);
  }

  @PutMapping
  public UserDTO update(
      @AuthenticationPrincipal UserDetails userDetails, @RequestBody UserDTO userDTO) {
    return userService.updateCurrentUser(userDetails, userDTO);
  }

  @DeleteMapping
  public UserDTO delete(@AuthenticationPrincipal UserDetails userDetails) {
    return userService.deleteCurrentUser(userDetails);
  }
}
