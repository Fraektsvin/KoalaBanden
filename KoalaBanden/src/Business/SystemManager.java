/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Antonio
 */
public class SystemManager {
    private ArrayList<User> Users = new ArrayList<>();
    private ArrayList<User> Case = new ArrayList<>();
    
    private User currentUser = null;
    private ArrayList<String> accessLevels;
    
    private final String SYSTEMADMINISTRATOR = "Systemadministrator";
    private final String SAGSBEHANDLER = "Sagsbehandler";
    private final String BORGER = "Borger";
    private final String VÆRGE = "Værge";
    private final String PARTSREPRÆSENTANT = "Partsrepæsentant";

    public SystemManager() {
        accessLevels = new ArrayList();
        accessLevels.add(SYSTEMADMINISTRATOR);
        accessLevels.add(SAGSBEHANDLER);
        accessLevels.add(BORGER);
        accessLevels.add(VÆRGE);
        accessLevels.add(PARTSREPRÆSENTANT);
    }
    
    public boolean createUser(String username, String password, String email, String CPRString, String accessLevelString) {
        
        if (!BusinessFacade.data.userExists(username)) {
            if (CPRString.length() != 10) {
                return false;
            }
            
            for (int i = 0; i < 10; i++) {
                boolean isDigit = Character.isDigit(CPRString.charAt(i));
                if (!isDigit) {
                    return false;
                }
            }
            
            int CPR = Integer.parseInt(CPRString);
            
            int accessLevel;
            
            switch (accessLevelString) {
                case SYSTEMADMINISTRATOR:
                    accessLevel = 1;
                    break;
                case SAGSBEHANDLER:
                    accessLevel = 2;
                    break;
                case BORGER:
                    accessLevel = 3;
                    break;
                case VÆRGE:
                    accessLevel = 4;
                    break;
                case PARTSREPRÆSENTANT:
                    accessLevel = 5;
                    break;
                default:
                    accessLevel = 0;
                    break;
            }
            
            switch (accessLevel) {
                case 1:
                    BusinessFacade.data.createUser(new User(username, password, email, CPR, accessLevel));
                    return true;
                case 2:
                    BusinessFacade.data.createUser(new Caseworker(username, password, email, CPR, accessLevel));
                    return true;
                case 3:
                    BusinessFacade.data.createUser(new Citizen(username, password, email, CPR, accessLevel));
                    return true;
                case 4:
                    BusinessFacade.data.createUser(new Guardian(username, password, email, CPR, accessLevel));
                    return true;
                case 5:
                    BusinessFacade.data.createUser(new Representative(username, password, email, CPR, accessLevel));
                    return true;
                default:
                    return false;
            }
        }
        else {
            return false;
        }
    } 
    
    public void deleteUser(String username) {
        BusinessFacade.data.deleteUser(username);
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
    
    public User getCurrentUser() {
        return currentUser;
    }
    
    public Case createCase(int ID, int citizenSSN) {
        Caseworker worker = (Caseworker)currentUser;
        return null;
   
    }

    public ArrayList<User> getCase() {
        return Case;
    }
    
    public int login(String userName, String password) {
        if (BusinessFacade.data.userExists(userName)) {
            User user = (User) BusinessFacade.data.getUser(userName, password);
            if (user != null) {
                currentUser = user;
                return user.getAccessLevel();
            }
        }
        return 0;
    }
    
    public void logOut() {
        currentUser = null;
    }

    public Collection getAccessLevels() {
        return this.accessLevels;
    }
   
}
