import java.util.List;

public class UserDTO {
    private Integer id;

    private String name;

    private String password;

    private List<RoleDTO> roles;

    private List<RentDTO> rents;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public List<RentDTO> getRents() {
        return rents;
    }

    public void setRents(List<RentDTO> rents) {
        this.rents = rents;
    }
}