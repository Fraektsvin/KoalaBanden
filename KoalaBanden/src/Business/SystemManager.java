/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.AccessLevel;
import Acquaintance.IUser;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Antonio
 */
public class SystemManager {
    private ArrayList<User> Users = new ArrayList<>();
    private ArrayList<User> Case = new ArrayList<>();
    
    private IUser currentUser = null;
    private ArrayList<String> accessLevels;

    // TODO: Lav til enums
    private static final String SYSTEMADMINISTRATOR = "Systemadministrator";
    private static final String SAGSBEHANDLER = "Sagsbehandler";
    private static final String BORGER = "Borger";
    private static final String VÆRGE = "Værge";
    private static final String PARTSREPRÆSENTANT = "Partsrepræsentant";

    public SystemManager() {
        accessLevels = new ArrayList();
        accessLevels.add(SYSTEMADMINISTRATOR);
        accessLevels.add(SAGSBEHANDLER);
        accessLevels.add(BORGER);
        accessLevels.add(VÆRGE);
        accessLevels.add(PARTSREPRÆSENTANT);
    }
    
    public boolean createUser(String username, String password, String email, String CPRString, AccessLevel accessLevel) {
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
            
            switch (accessLevel) {
                case SYSTEMADMINISTRATOR:
                    BusinessFacade.data.createUser(new User(username, password, email, CPR, accessLevel));
                    return true;
                case SAGSBEHANDLER:
                    BusinessFacade.data.createUser(new Caseworker(username, password, email, CPR, accessLevel));
                    return true;
                case BORGER:
                    BusinessFacade.data.createUser(new Citizen(username, password, email, CPR, accessLevel));
                    return true;
                case VÆRGE:
                    BusinessFacade.data.createUser(new Guardian(username, password, email, CPR, accessLevel));
                    return true;
                case PARTSREPRÆSENTANT:
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
    
    public IUser getCurrentUser() {
        return currentUser;
    }
    
    public String getCurrentUsername() {
        return currentUser.getUsername();
    }
    
    public Case createCase(int ID, int citizenSSN) {
        Caseworker worker = (Caseworker)currentUser;
        return null;
   
    }
    // Sets the current logged in user for administrative purposes.
    public void setUser(String Username) {
        currentUser = BusinessFacade.data.getUser(Username);
    }

    public ArrayList<User> getCase() {
        return Case;
    }
    
    public IUser login(String userName, String password) {
        if (BusinessFacade.data.userExists(userName)) {
            this.currentUser = BusinessFacade.data.getUser(userName, password);
            return this.currentUser;
        }
        return null;
    }
    
    public void logOut() {
        currentUser = null;
    }

    public Collection getAccessLevels() {
        return this.accessLevels;
    }
    
    public static String getAccessLevelString(int accessLevel) {
        String accessLevelString = "";
        switch (accessLevel) {
                case 1:
                    accessLevelString = SYSTEMADMINISTRATOR;
                    break;
                case 2:
                    accessLevelString = SAGSBEHANDLER;
                    break;
                case 3:
                    accessLevelString = BORGER;
                    break;
                case 4:
                    accessLevelString = VÆRGE;
                    break;
                case 5:
                    accessLevelString = PARTSREPRÆSENTANT;
                    break;
                default:
                    accessLevelString = "Fejl";
                    break;
            }
        return accessLevelString;
    }
   
    public AccessLevel getCurrentAccessLevel() {
        return currentUser.getAccessLevel();
    }
}
