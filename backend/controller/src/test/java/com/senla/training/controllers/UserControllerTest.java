package com.senla.training.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class UserControllerTest {

  private static final Logger logger = Logger.getLogger(UserControllerTest.class);

  private final MockMvc mockMvc;

  private String userDTOJson;

  UserControllerTest() {
    userDTOJson =
        "{\"id\":1,\"firstName\":\"vlad\",\"secondName\":\"vlad\",\"email\":\"test@gmail.com\",\"password\":\"$2a$12$xx/TNW9/lGWqgK8GyAGSy.TKzSnLAi1ub.h0crYrL4qdFpBz75nda\",\"statusUser\":\"ACTIVE\",\"roles\":[{\"id\":1,\"name\":\"ADMIN\"}]}";
    mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
  }

  @Test
  void getByIdUserWithRoles() {
    try {
      mockMvc.perform(get("/users")).andExpect(status().isBadRequest());

      mockMvc.perform(get("/users").param("id", "1")).andExpect(status().isOk());
    } catch (Exception e) {
      logger.error("Test /users/1");
    }
  }

  @Test
  void sortWithDirectionUsersWithRoles() {
    try {
      mockMvc.perform(get("/users")).andExpect(status().isOk());
    } catch (Exception e) {
      logger.error("Test /users");
    }

    try {
      mockMvc.perform(get("/users?id=DESC")).andExpect(status().isOk());
    } catch (Exception e) {
      logger.error("Test /users?id=DESC");
    }

    try {
      mockMvc.perform(get("/users?id=abcd")).andExpect(status().isBadRequest());
    } catch (Exception e) {
      logger.error("Test /users?id=abcd");
    }
  }

  @Test
  void update() {
    try {
      mockMvc.perform(put("/users")).andExpect(status().isBadRequest());

      mockMvc
          .perform(put("/users").contentType(MediaType.APPLICATION_JSON_VALUE).content(userDTOJson))
          .andExpect(status().isOk());
    } catch (Exception e) {
      logger.error("Test update user");
    }
  }

  @Test
  void save() {
    try {
      mockMvc.perform(post("/users")).andExpect(status().isBadRequest());

      mockMvc
          .perform(
              post("/users").contentType(MediaType.APPLICATION_JSON_VALUE).content(userDTOJson))
          .andExpect(status().isOk());
    } catch (Exception e) {
      logger.error("Test save user");
    }
  }

  @Test
  void deleteTest() {
    try {
      mockMvc.perform(delete("/users")).andExpect(status().isBadRequest());

      mockMvc
          .perform(
              delete("/users").contentType(MediaType.APPLICATION_JSON_VALUE).content(userDTOJson))
          .andExpect(status().isOk());
    } catch (Exception e) {
      logger.error("Test delete user");
    }
  }

  @Test
  void findOneByCriteriaUserWithRoles() {
    try {
      mockMvc
          .perform(get("/users/findOneByCriteriaUserWithRoles"))
          .andExpect(status().isBadRequest());

      mockMvc.perform(get("/users").param("id", "1")).andExpect(status().isOk());
    } catch (Exception e) {
      logger.error("Test  findOneByCriteriaUserWithRoles /users/1");
    }
  }

  @Test
  void findAllByCriteriaUserWithRolesDTO() {
    try {
      mockMvc
          .perform(get("/users/findAllByCriteriaUserWithRolesDTO"))
          .andExpect(status().isBadRequest());

      mockMvc.perform(get("/users").param("id", "1")).andExpect(status().isOk());
    } catch (Exception e) {
      logger.error("Test  findAllByCriteriaUserWithRolesDTO /users/1");
    }
  }

  @Test
  void findByNotNullUserWithRolesDTO() {
    try {
      mockMvc
          .perform(get("/users/findByNotNullUserWithRolesDTO"))
          .andExpect(status().isBadRequest());

      mockMvc.perform(get("/users").param("id")).andExpect(status().isOk());
    } catch (Exception e) {
      logger.error("Test  findByNotNullUserWithRolesDTO /users/1");
    }
  }

  @Test
  void findByNullUserWithRolesDTO() {
    try {
      mockMvc.perform(get("/users/findByNullUserWithRolesDTO")).andExpect(status().isBadRequest());

      mockMvc.perform(get("/users").param("id")).andExpect(status().isOk());
    } catch (Exception e) {
      logger.error("Test  findByNullUserWithRolesDTO /users/1");
    }
  }

  @Test
  void findAndSortUserWithRolesDTO() {
    try {
      mockMvc.perform(get("/users/findAndSortUserWithRolesDTO")).andExpect(status().isBadRequest());

      mockMvc.perform(get("/users").param("id")).andExpect(status().isOk());
    } catch (Exception e) {
      logger.error("Test  findAndSortUserWithRolesDTO /users/1");
    }
  }
}
