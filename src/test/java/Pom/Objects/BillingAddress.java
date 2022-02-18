package Pom.Objects;

public class BillingAddress {


    private String firstName;
    private String lastName;
    private String addressLineone;
    private String city;
    private String postalcode;
    private String email;
    private String country;
    private String state;

    public BillingAddress(String first1Name, String lastName,
                          String addressLineone, String city,
                          String postalcode, String email,
                          String country, String state) {
        this.firstName = first1Name;
        this.lastName = lastName;
        this.addressLineone = addressLineone;
        this.city = city;
        this.postalcode = postalcode;
        this.email = email;
        this.country = country;
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }





    public BillingAddress() {
    }


    public String getFirstName() {
        return firstName;
    }

    public BillingAddress setFirstName(String firstName) {//using builder  pattern for setting address so return class
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddressLineone() {
        return addressLineone;
    }

    public BillingAddress setAddressLineone(String addressLineone) {
        this.addressLineone = addressLineone;
        return this;
    }

    public String getCity() {
        return city;
    }

    public BillingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public BillingAddress setPostalcode(String postalcode) {
        this.postalcode = postalcode;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BillingAddress setEmail(String email) {
        this.email = email;
        return this;
    }


}
