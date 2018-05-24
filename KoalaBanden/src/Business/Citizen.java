package Business;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author finch
 */
public class Citizen {

    // Data field
    private int cpr;
    private String address;
    private String email;
    private int phoneNumber;
    private String firstname;
    private String lastname;

    // Contructor
    public Citizen(int cpr, String address, String email, int phoneNumber, String firstname, String lastname) {
        this.cpr = cpr;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Citizen(ResultSet rs) throws SQLException {
        this.cpr = rs.getInt("cpr");
        this.address = rs.getString("address");
        this.email = rs.getString("email");
        this.phoneNumber = rs.getInt("phoneNumber");
        this.firstname = rs.getString("firstname");
        this.lastname = rs.getString("lastname");
    }

    
    // Methods
    
    public int getCpr() {
        return cpr;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

}
