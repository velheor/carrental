package com.velheor.carrental.models;

import com.velheor.carrental.models.enums.ERole;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.Table;

@NamedEntityGraphs({
  @NamedEntityGraph(
      name = "roleWithUsers",
      attributeNodes = {@NamedAttributeNode(value = "users")})
})
@Entity
@Table(name = "roles")
public class Role implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Basic
  @Column(name = "name", nullable = false, length = 45)
  @Enumerated(value = EnumType.STRING)
  private ERole name;

  @ManyToMany(mappedBy = "roles")
  private List<User> users;

  public Role() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ERole getName() {
    return name;
  }

  public void setName(ERole name) {
    this.name = name;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}
