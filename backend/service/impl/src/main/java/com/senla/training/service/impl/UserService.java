package com.senla.training.service.impl;

import com.senla.training.constants.EmailValidator;
import com.senla.training.dao.api.IUserDAO;
import com.senla.training.dto.UserDTO;
import com.senla.training.dto.UserWithTokenDTO;
import com.senla.training.models.User;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.security.jwt.JwtTokenProvider;
import com.senla.training.service.api.IUserService;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements IUserService {

  private final IUserDAO userDAO;
  private final ObjectMapperUtils objectMapperUtils;
  private final JwtTokenProvider jwtTokenProvider;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  @Autowired
  public UserService(
      IUserDAO userDAO,
      ObjectMapperUtils objectMapperUtils,
      JwtTokenProvider jwtTokenProvider,
      PasswordEncoder passwordEncoder,
      AuthenticationManager authenticationManager) {
    this.userDAO = userDAO;
    this.objectMapperUtils = objectMapperUtils;
    this.jwtTokenProvider = jwtTokenProvider;
    this.passwordEncoder = passwordEncoder;
    this.authenticationManager = authenticationManager;
  }

  @Override
  public UserDTO findByIdUserWithRolesDTO(int id) {
    return objectMapperUtils.map(userDAO.findByIdUserWithRoles(id), UserDTO.class);
  }

  @Override
  public List<UserDTO> findAllAndSortWithDirectionUserWithRolesDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        userDAO.findAllAndSortWithDirectionUserWithRoles(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        UserDTO.class);
  }

  @Override
  public UserDTO findOneByCriteriaUserWithRolesDTO(Map<String, Object> fieldCriterionMap) {
    return objectMapperUtils.map(
        userDAO.findOneByCriteriaUserWithRoles(fieldCriterionMap), UserDTO.class);
  }

  @Override
  public List<UserDTO> findAllByCriteriaUserWithRolesDTO(Map<String, Object> fieldCriterionMap) {
    return objectMapperUtils.mapAll(
        userDAO.findAllByCriteriaUserWithRoles(fieldCriterionMap), UserDTO.class);
  }

  @Override
  public List<UserDTO> findByNotNullUserWithRolesDTO(List<String> fields) {
    return objectMapperUtils.mapAll(userDAO.findByNotNullUserWithRoles(fields), UserDTO.class);
  }

  @Override
  public List<UserDTO> findByNullUserWithRolesDTO(List<String> fields) {
    return objectMapperUtils.mapAll(userDAO.findByNullUserWithRoles(fields), UserDTO.class);
  }

  @Override
  public List<UserDTO> findAndSortUserWithRolesDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        userDAO.findAndSortUserWithRoles(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        UserDTO.class);
  }

  @Override
  public UserDTO create(UserDTO entityDTO) {
    if (this.isValidEmail(entityDTO.getEmail())) {
      return null;
    }
    entityDTO.setPassword(passwordEncoder.encode(entityDTO.getPassword()));
    return objectMapperUtils.map(
        userDAO.create(objectMapperUtils.map(entityDTO, User.class)), UserDTO.class);
  }

  @Override
  public UserDTO update(UserDTO entityDTO) {
    return objectMapperUtils.map(
        userDAO.update(objectMapperUtils.map(entityDTO, User.class)), UserDTO.class);
  }

  @Override
  public void delete(UserDTO entityDTO) {
    userDAO.delete(objectMapperUtils.map(entityDTO, User.class));
  }

  @Override
  public void deleteById(int id) {
    userDAO.deleteById(id);
  }

  @Override
  public UserWithTokenDTO getUserWithTokenDTO(UserWithTokenDTO userWithTokenDTO) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            userWithTokenDTO.getEmail(), userWithTokenDTO.getPassword()));
    User user = userDAO.findByEmailUserWithRoles(userWithTokenDTO.getEmail());
    userWithTokenDTO.setToken(jwtTokenProvider.createToken(user.getEmail(), user.getRoles()));
    return userWithTokenDTO;
  }

  @Override
  public UserDTO findCurrentUser(UserDetails userDetails) {
    return objectMapperUtils.map(
        userDAO.findByEmailUserWithRents(userDetails.getUsername()), UserDTO.class);
  }

  @Override
  public UserDTO updateCurrentUser(UserDetails userDetails, UserDTO userDTO) {
    if (!userDetails.getUsername().equals(userDTO.getEmail())) {
      return null;
    }
    return objectMapperUtils.map(
        userDAO.update(objectMapperUtils.map(userDTO, User.class)), UserDTO.class);
  }

  @Override
  public UserDTO deleteCurrentUser(UserDetails userDetails) {
    User user = userDAO.findByEmailUserWithRents(userDetails.getUsername());
    userDAO.delete(user);
    return objectMapperUtils.map(user, UserDTO.class);
  }

  protected Boolean isValidEmail(String email) {
    return !this.checkForExistEmail(email) && this.checkForRegexEmail(email);
  }

  protected Boolean checkForExistEmail(String email) {
    return userDAO.findByEmailUserWithRoles(email) != null;
  }

  protected Boolean checkForRegexEmail(String email) {
    return Pattern.compile(EmailValidator.emailRegex).matcher(email).matches();
  }
}
