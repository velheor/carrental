package com.velheor.carrental.models;

import com.velheor.carrental.models.enums.EStatusUser;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "carrental")
public class User {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "first_name", nullable = false, length = 45)
  private String firstName;

  @Basic
  @Column(name = "last_name", nullable = false, length = 45)
  private String lastName;

  @Basic
  @Column(name = "email", nullable = false, length = 45)
  private String email;

  @Basic
  @Column(name = "password", nullable = false, length = 255)
  private String password;

  @Basic
  @Column(name = "status", nullable = false, length = 20)
  private EStatusUser status;

  @ManyToMany
  @JoinTable(
      name = "users_roles",
      joinColumns = @JoinColumn(name = "users_id"),
      inverseJoinColumns = @JoinColumn(name = "roles_id"))
  private Set<Role> roles;

  @OneToMany(mappedBy = "user")
  private List<Rent> rentsById;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String secondName) {
    this.lastName = secondName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public EStatusUser getStatus() {
    return status;
  }

  public void setStatus(EStatusUser status) {
    this.status = status;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return id.equals(user.id)
        && Objects.equals(firstName, user.firstName)
        && Objects.equals(lastName, user.lastName)
        && Objects.equals(email, user.email)
        && Objects.equals(password, user.password)
        && Objects.equals(status, user.status)
        && Objects.equals(roles, user.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email, password, status);
  }

  public List<Rent> getRentsById() {
    return rentsById;
  }

  public void setRentsById(List<Rent> rentsById) {
    this.rentsById = rentsById;
  }
}
