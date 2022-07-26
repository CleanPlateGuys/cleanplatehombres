package cleanplate.cleanplatehombres.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="org_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "listingList"})
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private String orgName;

    @Column
    private String orgDescription;

    @Column
    private String orgStAddress;

    @Column
    private String orgCity;

    @Column
    private String orgState;

    @Column
    private long orgZip;

    @Column
    private Boolean isDonor;

    @Column(length = 200)
    private String images;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private List<Listing> listingList;

    public Boolean isDonor() {
        return isDonor;
    }

    //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
//    private List<OrganizationImage> organizationImages;

    public Organization() {
    }
    public Organization(String orgName, String orgDescription, String orgStAddress, String orgCity, String orgState, long orgZip) {
        this.orgName = orgName;
        this.orgDescription = orgDescription;
        this.orgStAddress = orgStAddress;
        this.orgCity = orgCity;
        this.orgState = orgState;
        this.orgZip = orgZip;

    }
    public Organization(Integer id, String orgName, String orgDescription, String orgStAddress, String orgCity, String orgState, long orgZip, Boolean isDonor, String images, User user, List<Listing> listingList) {
        this.id = id;
        this.orgName = orgName;
        this.orgDescription = orgDescription;
        this.orgStAddress = orgStAddress;
        this.orgCity = orgCity;
        this.orgState = orgState;
        this.orgZip = orgZip;
        this.isDonor = isDonor;
        this.images = images;
        this.user = user;
        this.listingList = listingList;
    }

    public Organization(String orgName, String orgDescription, String orgStAddress, String orgCity, String orgState, long orgZip, Boolean isDonor, String images, User user, List<Listing> listingList) {
        this.orgName = orgName;
        this.orgDescription = orgDescription;
        this.orgStAddress = orgStAddress;
        this.orgCity = orgCity;
        this.orgState = orgState;
        this.orgZip = orgZip;
        this.isDonor = isDonor;
        this.images = images;
        this.user = user;
        this.listingList = listingList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public String getOrgStAddress() {
        return orgStAddress;
    }

    public void setOrgStAddress(String orgStAddress) {
        this.orgStAddress = orgStAddress;
    }

    public String getOrgCity() {
        return orgCity;
    }

    public void setOrgCity(String orgCity) {
        this.orgCity = orgCity;
    }

    public String getOrgState() {
        return orgState;
    }

    public void setOrgState(String orgState) {
        this.orgState = orgState;
    }

    public long getOrgZip() {
        return orgZip;
    }

    public void setOrgZip(long orgZip) {
        this.orgZip = orgZip;
    }

    public void setDonor(Boolean donor) {
        isDonor = donor;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Listing> getListingList() {
        return listingList;
    }

    public void setListingList(List<Listing> listingList) {
        this.listingList = listingList;
    }
}
