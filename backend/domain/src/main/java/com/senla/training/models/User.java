package com.senla.training.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.senla.training.models.enums.EStatusUser;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedEntityGraphs({
  @NamedEntityGraph(
      name = "userWithRoles",
      attributeNodes = {@NamedAttributeNode(value = "roles")})
})
@Entity
@Table(name = "users")
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "first_name", nullable = false, length = 45)
  private String firstName;

  @Basic
  @Column(name = "second_name", nullable = false, length = 45)
  private String secondName;

  @Basic
  @Column(name = "email", nullable = false, length = 45)
  private String email;

  @Basic
  @Column(name = "password", nullable = false, length = 45)
  private String password;

  @Basic
  @Enumerated(value = EnumType.STRING)
  @Column(name = "status", nullable = false, length = 45)
  private EStatusUser statusUser;

  @ManyToMany
  @JoinTable(
      name = "users_roles",
      joinColumns = @JoinColumn(name = "users_id"),
      inverseJoinColumns = @JoinColumn(name = "roles_id"))
  @JsonManagedReference
  private Set<Role> roles;

  @OneToMany(mappedBy = "user")
  @JsonBackReference
  private Set<Rent> rents;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public EStatusUser getStatusUser() {
    return statusUser;
  }

  public void setStatusUser(EStatusUser statusUser) {
    this.statusUser = statusUser;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return getId().equals(user.getId())
        && getFirstName().equals(user.getFirstName())
        && getSecondName().equals(user.getSecondName())
        && getEmail().equals(user.getEmail())
        && getStatusUser().equals(user.getStatusUser())
        && Objects.equals(getPassword(), user.getPassword())
        && Objects.equals(getRoles(), user.getRoles())
        && Objects.equals(getRents(), user.getRents());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getId(),
        getFirstName(),
        getSecondName(),
        getEmail(),
        getPassword(),
        getRoles(),
        getRents());
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public Set<Rent> getRents() {
    return rents;
  }

  public void setRents(Set<Rent> rents) {
    this.rents = rents;
  }
}
