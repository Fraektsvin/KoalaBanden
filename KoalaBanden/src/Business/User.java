/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.AccessLevel;
import Acquaintance.IUser;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author finch
 */
public class User implements Serializable, IUser {
    
    // Date field
    
    private String username;
    private String password;
    private String email;
    private int SSN;
    private AccessLevel accessLevel;
    
    // Constructor
    
    public User(String username, String password, String email, int SSN, AccessLevel accessLevel){
        this.username = username;
        this.password = password;
        this.email = email;
        this.SSN = SSN;
        this.accessLevel = accessLevel;
    }

    public User(ResultSet rs) throws SQLException {
        this.SSN = rs.getInt(1);
        this.username = rs.getString(2);
        this.password = rs.getString(3);
        this.email = rs.getString(4);

        int accessLevel = rs.getInt(5);
        this.accessLevel = AccessLevel.fromInt(accessLevel);
    }

    // Methods

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
        BusinessFacade.data.createUser(this);
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
        BusinessFacade.data.createUser(this);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    @Override
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public int getCPR() {
        return this.SSN;
    }

    public int getSSN() {
        return SSN;
    }

    @Override
    public String getAccessLevelString() {
        return this.accessLevel.toString();
    }

    
    
}
