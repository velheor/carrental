package com.velheor.carrental.service.impl;

import com.velheor.carrental.constants.EmailValidator;
import com.velheor.carrental.dao.api.UserRepository;
import com.velheor.carrental.dto.UserDTO;
import com.velheor.carrental.dto.UserWithTokenDTO;
import com.velheor.carrental.models.User;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.security.jwt.JwtTokenProvider;
import com.velheor.carrental.service.api.IUserService;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

  private final UserRepository userRepository;
  private final ObjectMapperUtils objectMapperUtils;
  private final JwtTokenProvider jwtTokenProvider;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  @Autowired
  public UserService(
      UserRepository userRepository,
      ObjectMapperUtils objectMapperUtils,
      JwtTokenProvider jwtTokenProvider,
      PasswordEncoder passwordEncoder,
      AuthenticationManager authenticationManager) {
    this.userRepository = userRepository;
    this.objectMapperUtils = objectMapperUtils;
    this.jwtTokenProvider = jwtTokenProvider;
    this.passwordEncoder = passwordEncoder;
    this.authenticationManager = authenticationManager;
  }

  @Override
  public UserDTO findById(Integer id) {
    return userRepository
        .findById(id)
        .map(car -> objectMapperUtils.map(car, UserDTO.class))
        .orElse(null);
  }

  @Override
  public UserDTO create(UserDTO entityDTO) {
    return objectMapperUtils.map(
        userRepository.save(objectMapperUtils.map(entityDTO, User.class)), UserDTO.class);
  }

  @Override
  public UserDTO update(UserDTO entityDTO) {
    if (userRepository.findById(entityDTO.getId()).isPresent()) {
      objectMapperUtils.map(
          userRepository.save(objectMapperUtils.map(entityDTO, User.class)), UserDTO.class);
    }
    return null;
  }

  @Override
  public void delete(UserDTO entityDTO) {
    userRepository.delete(objectMapperUtils.map(entityDTO, User.class));
  }

  @Override
  public void deleteById(int id) {
    userRepository.deleteById(id);
  }

  @Override
  public UserWithTokenDTO getUserWithTokenDTO(UserWithTokenDTO userWithTokenDTO) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            userWithTokenDTO.getEmail(), userWithTokenDTO.getPassword()));
    User user = userRepository.findByEmail(userWithTokenDTO.getEmail());
    userWithTokenDTO.setToken(jwtTokenProvider.createToken(user.getEmail(), user.getRoles()));
    return userWithTokenDTO;
  }

  protected Boolean checkForRegexEmail(String email) {
    return Pattern.compile(EmailValidator.emailRegex).matcher(email).matches();
  }
}
