package cleanplate.cleanplatehombres.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "organizationList"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Boolean isAdmin;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Organization> organizationList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Listing> listingList;

    public User() {}


    public User(User copy) {
        id = copy.id;
        isAdmin = copy.isAdmin;
        email = copy.email;
        username = copy.username;
        password = copy.password;

    }





    public Integer getUserId() {
        return id;
    }

    public void setUserId(Integer userId) {
        this.id = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }
}