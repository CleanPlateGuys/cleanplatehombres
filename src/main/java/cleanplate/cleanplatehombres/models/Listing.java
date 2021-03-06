package cleanplate.cleanplatehombres.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//table creation
@Entity
@Table(name = "listing")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private String foodName;

    @Column
    private String foodAmt;

    @Column
    private String donationDescription;

    @Column
    private boolean isDonation;

    @Column
    private Date expDate;

    @Column
    private boolean isFulfilled;

    @ManyToOne
    @JoinColumn(name = "user_info_id")
    private User user;


    public Listing(Integer id, String foodName, String foodAmt, String donationDescription, boolean isDonation,
                   Date expDate, boolean isFulfilled, User user) {
        this.id = id;
        this.foodName = foodName;
        this.foodAmt = foodAmt;
        this.donationDescription = donationDescription;
        this.isDonation = isDonation;
        this.expDate = expDate;
        this.isFulfilled = isFulfilled;
        this.user = user;

    }



    @ManyToOne
    @JoinColumn(name="org_info", nullable = false)
    private Organization organization;

    public Listing(Organization organization) {
        this.organization = organization;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="listing_categories",
            joinColumns={@JoinColumn(name="listingID")},
            inverseJoinColumns={@JoinColumn(name="categoryID")}
    )
    private List<Category> categories;

    public Listing() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodAmt() {
        return foodAmt;
    }

    public void setFoodAmt(String foodAmt) {
        this.foodAmt = foodAmt;
    }

    public String getDonationDescription() {
        return donationDescription;
    }

    public void setDonationDescription(String donationDescription) {
        this.donationDescription = donationDescription;
    }

    public boolean isDonation() {
        return isDonation;
    }

    public void setDonation(boolean donation) {
        isDonation = donation;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public boolean isFulfilled() {
        return isFulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        isFulfilled = fulfilled;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}









