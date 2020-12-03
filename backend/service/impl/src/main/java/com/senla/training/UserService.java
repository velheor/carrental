package com.senla.training;

import com.senla.training.user.UserDTO;
import com.senla.training.user.UserWithRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService {

    private final IUserDAO userDAO;

    private final ObjectMapperUtils objectMapperUtils;

    @Autowired
    UserService(IUserDAO userDAO, ObjectMapperUtils objectMapperUtils) {
        this.userDAO = userDAO;
        this.objectMapperUtils = objectMapperUtils;
    }

    @Override
    public UserWithRoleDTO findByIdUserWithRoleDTO(int id) {
        return objectMapperUtils.map(userDAO.findByIdUserWithRole(id), UserWithRoleDTO.class);
    }

    @Override
    public List<UserWithRoleDTO> findAllUserWithRoleDTO() {
        return objectMapperUtils.mapAll(userDAO.findAllUserWithRole(), UserWithRoleDTO.class);
    }

    @Override
    public UserWithRoleDTO createUserWithRoleDTO(UserWithRoleDTO userWithRoleDTO) {
        return objectMapperUtils.map(userDAO.create(objectMapperUtils.map(userWithRoleDTO, User.class)), UserWithRoleDTO.class);
    }

    @Override
    public UserWithRoleDTO updateUserWithRoleDTO(UserWithRoleDTO userWithRoleDTO) {
        return objectMapperUtils.map(userDAO.update(objectMapperUtils.map(userWithRoleDTO, User.class)), UserWithRoleDTO.class);
    }

    @Override
    public void deleteUserWithRoleDTO(UserWithRoleDTO userWithRoleDTO) {
        userDAO.delete(objectMapperUtils.map(userWithRoleDTO, User.class));
    }

    @Override
    public void deleteById(int id) {
        userDAO.deleteById(id);
    }

    @Override
    public List<UserWithRoleDTO> sortWithDirectionUserWithRoleDTO(String field, Direction direction) {
        return objectMapperUtils.mapAll(userDAO.sortWithDirectionUserWithRole(field, direction), UserWithRoleDTO.class);
    }

    @Override
    public List<UserWithRoleDTO> sortWithDirectionUserWithRoleDTO(Map<String, Direction> fieldDirectionMap) {
        return objectMapperUtils.mapAll(userDAO.sortWithDirectionUserWithRole(fieldDirectionMap), UserWithRoleDTO.class);
    }

    @Override
    public UserWithRoleDTO findOneByCriteriaUserWithRoleDTO(String field, Object criteria) {
        return objectMapperUtils.map(userDAO.findOneByCriteriaUserWithRole(field, criteria), UserWithRoleDTO.class);
    }

    @Override
    public List<UserWithRoleDTO> findAllByCriteriaUserWithRoleDTO(String field, Object criteria) {
        return objectMapperUtils.mapAll(userDAO.findAllByCriteriaUserWithRole(field, criteria), UserWithRoleDTO.class);
    }

    @Override
    public List<UserWithRoleDTO> findAllByCriteriaUserWithRoleDTO(Map<String, Object> fieldCriteriaMap) {
        return objectMapperUtils.mapAll(userDAO.findAllByCriteriaUserWithRole(fieldCriteriaMap), UserWithRoleDTO.class);
    }

    @Override
    public List<UserWithRoleDTO> findByNotNullUserWithRoleDTO(String field) {
        return objectMapperUtils.mapAll(userDAO.findByNotNullUserWithRole(field), UserWithRoleDTO.class);
    }

    @Override
    public List<UserWithRoleDTO> findByNullUserWithRoleDTO(String field) {
        return objectMapperUtils.mapAll(userDAO.findByNullUserWithRole(field), UserWithRoleDTO.class);
    }

    @Override
    public List<UserWithRoleDTO> findLessThanUserWithRoleDTO(String field, Number number) {
        return objectMapperUtils.mapAll(userDAO.findLessThanUserWithRole(field, number), UserWithRoleDTO.class);
    }

    @Override
    public List<UserWithRoleDTO> findGreaterThanUserWithRoleDTO(String field, Number number) {
        return objectMapperUtils.mapAll(userDAO.findGreaterThanUserWithRole(field, number), UserWithRoleDTO.class);
    }

    @Override
    public List<UserWithRoleDTO> findAndSortUserWithRoleDTO(Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
        return objectMapperUtils.mapAll(userDAO.findAndSortUserWithRole(fieldDirectionMap, fieldCriteriaMap), UserWithRoleDTO.class);
    }

    @Override
    public List<UserWithRoleDTO> findContainUserWithRoleDTO(String field, String criteria) {
        return objectMapperUtils.mapAll(userDAO.findContainUserWithRole(field, criteria), UserWithRoleDTO.class);
    }
}