package com.senla.training.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class UserControllerTest {

  private static final Logger logger = Logger.getLogger(UserControllerTest.class);

  private final MockMvc mockMvc;

  UserControllerTest() {
    mockMvc = MockMvcBuilders.standaloneSetup(UserController.class).build();
  }

  @Test
  void getByIdUserWithRoles() {

  }

  @Test
  void sortWithDirectionUsersWithRoles() {
    try {
      mockMvc.perform(get("/users"))
          .andExpect(status().isOk());
    } catch (Exception e) {
      logger.error("Test /users");
    }

    try {
      mockMvc.perform(get("/users?id=DESC"))
          .andExpect(status().isOk());
    } catch (Exception e) {
      logger.error("Test /users?id=DESC");
    }

    try {
      mockMvc.perform(get("/users?id=abcd"))
          .andExpect(status().isBadRequest());
    } catch (Exception e) {
      logger.error("Test /users?id=abcd");
    }

  }

  @Test
  void update() {
  }

  @Test
  void save() {
  }

  @Test
  void delete() {
  }

  @Test
  void deleteById() {
  }

  @Test
  void findOneByCriteriaUserWithRoles() {
  }

  @Test
  void findAllByCriteriaUserWithRolesDTO() {
  }

  @Test
  void findByNotNullUserWithRolesDTO() {
  }

  @Test
  void findByNullUserWithRolesDTO() {
  }

  @Test
  void findAndSortUserWithRolesDTO() {
  }
}