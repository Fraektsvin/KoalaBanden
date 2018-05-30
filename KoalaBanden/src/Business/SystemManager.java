package Business;

import Acquaintance.AccessLevel;
import Acquaintance.IUser;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
 */

public class SystemManager {

    // Data field
    
    private ArrayList<User> Users = new ArrayList<>(); // arraylist of users
    private ArrayList<User> Case = new ArrayList<>(); // arraylist of cases ????
    private IUser currentUser = null;
    private ArrayList<String> accessLevels; // arraylist of accesslevels

    // TODO: Lav til enums
    private static final String SYSTEMADMINISTRATOR = "Systemadministrator";
    private static final String SAGSBEHANDLER = "Sagsbehandler";
    private static final String BORGER = "Borger";
    private static final String VÆRGE = "Værge";
    private static final String PARTSREPRÆSENTANT = "Partsrepræsentant";

    
    // Constructors
    
    /**
     * Constructor creating a system manager holding an arraylist of all types of accesslevels
     */
    public SystemManager() {
        accessLevels = new ArrayList();
        accessLevels.add(SYSTEMADMINISTRATOR);
        accessLevels.add(SAGSBEHANDLER);
        accessLevels.add(BORGER);
        accessLevels.add(VÆRGE);
        accessLevels.add(PARTSREPRÆSENTANT);
    }

    /**
     * Method used to create users with different accesslevel in the GUI
     * @param username
     * @param password
     * @param email
     * @param CPRString
     * @param accessLevel
     * @return 
     */
    public boolean createUser(String username, String password, String email, String CPRString, AccessLevel accessLevel) {
        // Checks if a user with the entered username exists
        if (!BusinessFacade.data.userExists(username)) {
            // Checks if the entered user cpr is exactly 10 characters
            if (CPRString.length() != 10) {
                return false;
            }
            
            // Iterates through the entered cpr and checks if all characters are digits.
            for (int i = 0; i < 10; i++) {
                boolean isDigit = Character.isDigit(CPRString.charAt(i));
                if (!isDigit) {
                    return false;
                }
            }
            
            int CPR = Integer.parseInt(CPRString);
            
            // A switch holding the different types of users creatable 
            switch (accessLevel) {
                case SYSTEMADMINISTRATOR:
                    BusinessFacade.data.createUser(new User(username, password, email, CPR, accessLevel));
                    return true;
                case SAGSBEHANDLER:
                    BusinessFacade.data.createUser(new Caseworker(username, password, email, CPR, accessLevel));
                    return true;
                case BORGER:
                    BusinessFacade.data.createUser(new User(username, password, email, CPR, accessLevel));
                    return true;
                case VÆRGE:
                    BusinessFacade.data.createUser(new User(username, password, email, CPR, accessLevel));
                    return true;
                case PARTSREPRÆSENTANT:
                    BusinessFacade.data.createUser(new User(username, password, email, CPR, accessLevel));
                    return true;
                default:
                    return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Method deletes a user, based on the username
     * @param username 
     */
    public void deleteUser(String username) {
        BusinessFacade.data.deleteUser(username);
    }

    /**
     * Method sets users in the user arraylist
     * @param Users 
     */
    public void setUsers(ArrayList<User> Users) {
        this.Users = Users;
    }

    /**
     * Method sets cases in the case arraylist
     * @param Case 
     */
    public void setCase(ArrayList<User> Case) {
        this.Case = Case;
    }

    /**
     * 
     * @return the arraylist of users
     */
    public ArrayList<User> getUsers() {
        return Users;
    }

    /**
     * 
     * @return the current user logged in as an IUser
     */
    public IUser getCurrentUser() {
        return currentUser;
    }

    /**
     * 
     * @return username of the current user logged in 
     */
    public String getCurrentUsername() {
        return currentUser.getUsername();
    }

    /**
     * Method sets the current logged in user for administrative purposes.
     * @param Username 
     */
    public void setUser(String Username) {
        currentUser = BusinessFacade.data.getUser(Username);
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

    /**
     * Method used to get the different access level strings
     * @param accessLevel
     * @return 
     */
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

    // Method used to return accesslevel of the current user logged in.
    public AccessLevel getCurrentAccessLevel() {
        return currentUser.getAccessLevel();
    }

}
