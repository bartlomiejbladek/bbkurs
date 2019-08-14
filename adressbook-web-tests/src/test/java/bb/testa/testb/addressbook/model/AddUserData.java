package bb.testa.testb.addressbook.model;

public class AddUserData {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String mobile;
    private final String email;

    public AddUserData(String firstname, String lastname, String address, String mobile, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }
}