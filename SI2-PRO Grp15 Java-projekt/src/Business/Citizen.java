package Business;

import Acquaintance.ICitizen;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
 */
public class Citizen implements ICitizen {

    // Data field
    private int cpr; // cpr of a citizen
    private String address; // address of a citizen
    private String email; // email of a citizen
    private int phoneNumber; // phone number of a citizen
    private String firstname; // first name of a citizen
    private String lastname; // last anme of a citizen

    // Contructors
    /**
     * Constructor creating a citizen
     *
     * @param cpr
     * @param address
     * @param email
     * @param phoneNumber
     * @param firstname
     * @param lastname
     */
    public Citizen(int cpr, String address, String email, int phoneNumber, String firstname, String lastname) {
        this.cpr = cpr;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Constructor creating a citizen by using the resultset of the database to
     * set the attributes of the citizen class
     *
     * @param rs
     * @throws SQLException
     */
    public Citizen(ResultSet rs) throws SQLException {
        this.cpr = rs.getInt("cpr");
        this.address = rs.getString("address");
        this.email = rs.getString("email");
        this.phoneNumber = rs.getInt("phoneNumber");
        this.firstname = rs.getString("firstname");
        this.lastname = rs.getString("lastname");
    }

    // Methods
    /**
     *
     * @return cpr of the citizen
     */
    public int getCpr() {
        return cpr;
    }

    /**
     *
     * @return address of the citizen
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return email of the citizen
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return phone number of the citizen
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @return first name of the citizen
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @return last name of the citizen
     */
    public String getLastname() {
        return lastname;
    }

}