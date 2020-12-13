package com.senla.training.controllers;

import com.senla.training.dto.user.UserDTO;
import com.senla.training.dto.user.UserWithRolesDTO;
import com.senla.training.dto.user.UserWithTokenDTO;
import com.senla.training.security.jwt.JwtTokenProvider;
import com.senla.training.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
  private final AuthenticationManager authenticationManager;
  private IUserService userService;
  private JwtTokenProvider jwtTokenProvider;
  private PasswordEncoder passwordEncoder;

  @Autowired
  public AuthController(
          AuthenticationManager authenticationManager,
          IUserService userService,
          JwtTokenProvider jwtTokenProvider,
          PasswordEncoder passwordEncoder) {
    this.authenticationManager = authenticationManager;
    this.userService = userService;
    this.jwtTokenProvider = jwtTokenProvider;
    this.passwordEncoder = passwordEncoder;
  }

  @PostMapping("/signin")
  public UserWithTokenDTO login(@RequestBody UserWithTokenDTO userWithTokenDTO) {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userWithTokenDTO.getEmail(), userWithTokenDTO.getPassword()));
      UserWithRolesDTO user = userService.findByEmailUserWithRolesDTO(userWithTokenDTO.getEmail());
      userWithTokenDTO.setToken(jwtTokenProvider.createToken(user.getEmail(), user.getRoles()));
      return userWithTokenDTO;
  }

  @PostMapping("/signup")
  public UserDTO createAccount(@RequestBody UserDTO userDTO) {
    userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    return userService.create(userDTO);
  }
}
