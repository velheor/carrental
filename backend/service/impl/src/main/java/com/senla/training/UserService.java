package com.senla.training;

import com.senla.training.user.UserDTO;
import com.senla.training.user.UserWithRolesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService extends GenericService<UserDTO, User> implements IUserService {

    private final IUserDAO userDAO;

    @Autowired
    UserService(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserWithRolesDTO findByIdUserWithRoleDTO(int id) {
        return ObjectMapperUtils.map(userDAO.findByIdUserWithRole(id), UserWithRolesDTO.class);
    }

    @Override
    public List<UserWithRolesDTO> findAllUserWithRoleDTO() {
        return ObjectMapperUtils.mapAll(userDAO.findAllUserWithRole(), UserWithRolesDTO.class);
    }

    @Override
    public List<UserWithRolesDTO> sortWithDirectionUserWithRoleDTO(String field, Direction direction) {
        return ObjectMapperUtils.mapAll(userDAO.sortWithDirectionUserWithRole(field, direction), UserWithRolesDTO.class);
    }

    @Override
    public List<UserWithRolesDTO> sortWithDirectionUserWithRoleDTO(Map<String, Direction> fieldDirectionMap) {
        return ObjectMapperUtils.mapAll(userDAO.sortWithDirectionUserWithRole(fieldDirectionMap), UserWithRolesDTO.class);
    }

    @Override
    public UserWithRolesDTO findOneByCriteriaUserWithRoleDTO(String field, Object criteria) {
        return ObjectMapperUtils.map(userDAO.findOneByCriteriaUserWithRole(field, criteria), UserWithRolesDTO.class);
    }

    @Override
    public List<UserWithRolesDTO> findAllByCriteriaUserWithRoleDTO(String field, Object criteria) {
        return ObjectMapperUtils.mapAll(userDAO.findAllByCriteriaUserWithRole(field, criteria), UserWithRolesDTO.class);
    }

    @Override
    public List<UserWithRolesDTO> findAllByCriteriaUserWithRoleDTO(Map<String, Object> fieldCriteriaMap) {
        return ObjectMapperUtils.mapAll(userDAO.findAllByCriteriaUserWithRole(fieldCriteriaMap), UserWithRolesDTO.class);
    }

    @Override
    public List<UserWithRolesDTO> findByNotNullUserWithRoleDTO(String field) {
        return ObjectMapperUtils.mapAll(userDAO.findByNotNullUserWithRole(field), UserWithRolesDTO.class);
    }

    @Override
    public List<UserWithRolesDTO> findByNullUserWithRoleDTO(String field) {
        return ObjectMapperUtils.mapAll(userDAO.findByNullUserWithRole(field), UserWithRolesDTO.class);
    }

    @Override
    public List<UserWithRolesDTO> findLessThanUserWithRoleDTO(String field, Number number) {
        return ObjectMapperUtils.mapAll(userDAO.findLessThanUserWithRole(field, number), UserWithRolesDTO.class);
    }

    @Override
    public List<UserWithRolesDTO> findGreaterThanUserWithRoleDTO(String field, Number number) {
        return ObjectMapperUtils.mapAll(userDAO.findGreaterThanUserWithRole(field, number), UserWithRolesDTO.class);
    }

    @Override
    public List<UserWithRolesDTO> findAndSortUserWithRoleDTO(Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
        return ObjectMapperUtils.mapAll(userDAO.findAndSortUserWithRole(fieldDirectionMap, fieldCriteriaMap), UserWithRolesDTO.class);
    }

    @Override
    public List<UserWithRolesDTO> findContainUserWithRoleDTO(String field, String criteria) {
        return ObjectMapperUtils.mapAll(userDAO.findContainUserWithRole(field, criteria), UserWithRolesDTO.class);
    }
}