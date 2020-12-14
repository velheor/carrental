package com.senla.training.service.impl;

import com.senla.training.constants.EmailValidator;
import com.senla.training.dao.api.IUserDAO;
import com.senla.training.dto.user.UserDTO;
import com.senla.training.dto.user.UserWithRolesDTO;
import com.senla.training.dto.user.UserWithTokenDTO;
import com.senla.training.models.User;
import com.senla.training.objectmapper.ObjectMapperUtils;
import com.senla.training.security.jwt.JwtTokenProvider;
import com.senla.training.service.api.IUserService;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
  public UserWithRolesDTO findByIdUserWithRolesDTO(int id) {
    return objectMapperUtils.map(userDAO.findByIdUserWithRoles(id), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findAllAndSortWithDirectionUserWithRolesDTO(
      Map<String, String> fieldDirectionMap) {
    return objectMapperUtils.mapAll(
        userDAO.findAllAndSortWithDirectionUserWithRoles(
            DirectionAdapter.converterMap(fieldDirectionMap)),
        UserWithRolesDTO.class);
  }

  @Override
  public UserWithRolesDTO findOneByCriteriaUserWithRolesDTO(Map<String, Object> fieldCriterionMap) {
    return objectMapperUtils.map(
        userDAO.findOneByCriteriaUserWithRoles(fieldCriterionMap), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findAllByCriteriaUserWithRolesDTO(
      Map<String, Object> fieldCriterionMap) {
    return objectMapperUtils.mapAll(
        userDAO.findAllByCriteriaUserWithRoles(fieldCriterionMap), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findByNotNullUserWithRolesDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        userDAO.findByNotNullUserWithRoles(fields), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findByNullUserWithRolesDTO(List<String> fields) {
    return objectMapperUtils.mapAll(
        userDAO.findByNullUserWithRoles(fields), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findLessThanUserWithRolesDTO(Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        userDAO.findLessThanUserWithRoles(fieldNumberMap), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findGreaterThanUserWithRolesDTO(
      Map<String, Number> fieldNumberMap) {
    return objectMapperUtils.mapAll(
        userDAO.findGreaterThanUserWithRoles(fieldNumberMap), UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findAndSortUserWithRolesDTO(
      Map<String, String> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
    return objectMapperUtils.mapAll(
        userDAO.findAndSortUserWithRoles(
            DirectionAdapter.converterMap(fieldDirectionMap), fieldCriteriaMap),
        UserWithRolesDTO.class);
  }

  @Override
  public List<UserWithRolesDTO> findContainUserWithRolesDTO(Map<String, String> fieldStringMap) {
    return objectMapperUtils.mapAll(
        userDAO.findContainUserWithRoles(fieldStringMap), UserWithRolesDTO.class);
  }

  @Override
  public UserDTO create(UserDTO entityDTO) {
    if (this.isValidEmail(entityDTO.getEmail())) {
      return null;
    }
    entityDTO.setPassword(passwordEncoder.encode(entityDTO.getPassword()));
    userDAO.create(objectMapperUtils.map(entityDTO, User.class));
    return entityDTO;
  }

  @Override
  public UserDTO update(UserDTO entityDTO) {
    userDAO.update(objectMapperUtils.map(entityDTO, User.class));
    return entityDTO;
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
    UserWithRolesDTO user = objectMapperUtils.map(userDAO.findByEmailUserWithRoles(userWithTokenDTO.getEmail()), UserWithRolesDTO.class);
    userWithTokenDTO.setToken(jwtTokenProvider.createToken(user.getEmail(), user.getRoles()));
    return userWithTokenDTO;
  }

  protected Boolean isValidEmail(String email){
    return !this.checkForExistEmail(email) && !checkForRegexEmail(email);
  }

  protected Boolean checkForExistEmail(String email) {
    return userDAO.findByEmailUserWithRoles(email) != null;
  }

  protected Boolean checkForRegexEmail(String email) {
    return Pattern.compile(EmailValidator.emailRegex).matcher(email).matches();
  }
}
