/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Antonio
 */
public class SystemManager {
    private ArrayList<User> Users = new ArrayList<>();
    private ArrayList<User> Case = new ArrayList<>();
    
    private User currentUser = null;

    public SystemManager() {
    }
    
    public boolean createUser(String username, String password, String email, int SSN, int accessLevel) {
        if (!BusinessFacade.userExists(username)) {
            User user = new User(username, password, email, SSN, accessLevel);
            BusinessFacade.createUser(user);
            return true;
        } else {
            return false;
        }
    } 
    
    public void setUsers(ArrayList<User> Users) {
        this.Users = Users;
    }

    public void setCase(ArrayList<User> Case) {
        this.Case = Case;
    }

    public ArrayList<User> getUsers() {
        return Users;
    }

    public ArrayList<User> getCase() {
        return Case;
    }
    
    public int login(String userName, String password) {
        User user = BusinessFacade.getUser(userName, password);
        if (user != null) {
            currentUser = user;
            return user.getAccessLevel();
        }
        return 0; 
    }
    
    public void logOut() {
        currentUser = null;
    }

   
}
