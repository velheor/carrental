package com.senla.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService extends GenericService<UserDTO, User> {

    private final IUserDAO userDAO;

    @Autowired
    UserService(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDTO findById(int id) {
        return convertEntityToDTO(userDAO.findById(id));
    }

    @Override
    public List<UserDTO> findAll() {
        return convertEntityToDTO(userDAO.findAll());
    }

    @Override
    public UserDTO create(UserDTO entity) {
        return convertEntityToDTO(userDAO.create(convertDTOtoEntity(entity)));
    }

    @Override
    public UserDTO update(UserDTO entity) {
        return convertEntityToDTO(userDAO.update(convertDTOtoEntity(entity)));
    }

    @Override
    public void delete(UserDTO entity) {
        userDAO.delete(convertDTOtoEntity(entity));
    }

    @Override
    public void deleteById(int id) {
        userDAO.delete(convertDTOtoEntity(findById(id)));
    }

    @Override
    public List<UserDTO> sortWithDirection(String field, Direction direction) {
        return convertEntityToDTO(userDAO.sortWithDirection(field, direction));
    }

    @Override
    public List<UserDTO> sortWithDirection(Map<String, Direction> fieldDirectionMap) {
        return convertEntityToDTO(userDAO.sortWithDirection(fieldDirectionMap));
    }

    @Override
    public UserDTO findOneByCriteria(String field, Object criteria) {
        return convertEntityToDTO(userDAO.findOneByCriteria(field, criteria));
    }

    @Override
    public List<UserDTO> findAllByCriteria(String field, Object criteria) {
        return convertEntityToDTO(userDAO.findAllByCriteria(field, criteria));
    }

    @Override
    public List<UserDTO> findAllByCriteria(Map<String, Object> fieldCriteriaMap) {
        return convertEntityToDTO(userDAO.findAllByCriteria(fieldCriteriaMap));
    }

    @Override
    public List<UserDTO> findByNotNull(String field) {
        return convertEntityToDTO(userDAO.findByNotNull(field));
    }

    @Override
    public List<UserDTO> findByNull(String field) {
        return convertEntityToDTO(userDAO.findByNull(field));
    }

    @Override
    public List<UserDTO> findLessThan(String field, Number number) {
        return convertEntityToDTO(userDAO.findLessThan(field, number));
    }

    @Override
    public List<UserDTO> findGreaterThan(String field, Number number) {
        return convertEntityToDTO(userDAO.findGreaterThan(field, number));
    }

    @Override
    public List<UserDTO> findAndSort(Map<String, Direction> fieldDirectionMap, Map<String, Object> fieldCriteriaMap) {
        return convertEntityToDTO(userDAO.findAndSort(fieldDirectionMap, fieldCriteriaMap));
    }

    @Override
    public List<UserDTO> findContain(String field, String criteria) {
        return convertEntityToDTO(userDAO.findContain(field, criteria));
    }
}