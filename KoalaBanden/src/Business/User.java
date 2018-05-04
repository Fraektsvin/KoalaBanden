/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IUser;
import java.io.Serializable;

/**
 *
 * @author finch
 */
public class User implements Serializable, IUser {
    
    // Date field
    
    private String username;
    private String password;
    private String email;
    private int CPR;
    private int accessLevel;
    
    // Constructor
    
    public User(String username, String password, String email, int CPR, int accessLevel){
        this.username = username;
        this.password = password;
        this.email = email;
        this.CPR = CPR;
        this.accessLevel = accessLevel;
    }
    
    // Methods

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    @Override
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    
    
}
