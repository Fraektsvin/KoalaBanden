package Business;

import Acquaintance.AccessLevel;
import Acquaintance.IUser;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
 */
public class User implements IUser {

    // Date field
    private String username; // userame of a user
    private String password; // password of a user
    private String email; // email of a user
    private int CPR; // cpr of the user
    private AccessLevel accessLevel; // accesslevel of the user, 1 is for system administrator, 2 is for caseworker, 3 is for citizen, guardian and representative

    // Constructor
    /**
     * Constructor creating a user
     *
     * @param username of a user
     * @param password of a user
     * @param email of a user
     * @param CPR of a user
     * @param accessLevel of a user
     */
    public User(String username, String password, String email, int CPR, AccessLevel accessLevel) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.CPR = CPR;
        this.accessLevel = accessLevel;
    }

    /**
     * Constructor creating a user by using the resultset of the database to set
     * the attributes of the user class
     *
     * @param rs
     * @throws SQLException
     */
    public User(ResultSet rs) throws SQLException {
        this.CPR = rs.getInt("CPR");
        this.username = rs.getString("Username");
        this.password = rs.getString("Password");
        this.email = rs.getString("Email");
        int accessLevel = rs.getInt("AccessLevel");
        this.accessLevel = AccessLevel.fromInt(accessLevel);
    }

    /**
     *
     * @returns password of the user
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Method sets password of the user, based on the username
     *
     * @param userName
     * @param password
     */
    @Override
    public void setPassword(String userName, String password) {
        this.password = password;
        BusinessFacade.data.setPassword(userName, password);
    }

    /**
     * Method sets email of the user, based on the username
     *
     * @param userName
     * @param email
     */
    @Override
    public void setEmail(String userName, String email) {
        this.email = email;
        BusinessFacade.data.setEmail(userName, email);

    }

    /**
     *
     * @returns email of a user
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     *
     * @returns username of a user
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     *
     * @returns accesslevel of a user
     */
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    /**
     *
     * @returns cpr of a user
     */
    @Override
    public int getCPR() {
        return this.CPR;
    }

    /**
     *
     * @returns the accesslevel of a user as a string
     */
    @Override
    public String getAccessLevelString() {
        return this.accessLevel.toString();
    }
}
