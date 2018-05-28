/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.AccessLevel;
import Acquaintance.ICase;
import Acquaintance.ICaseOpening;
import Acquaintance.ICitizen;
import Acquaintance.IEnquiry;
import Acquaintance.IUser;
import Business.Case;
import Business.Citizen;
import Business.Enquiry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import Business.User;
import java.util.HashMap;
import org.postgresql.util.PSQLException;

/**
 *
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
 */
public class Database {

    // Data field
    private String host = "jdbc:postgresql://dumbo.db.elephantsql.com:5432/ntkoapef";
    private String dbusername = "ntkoapef";
    private String dbpassword = "URBi5bIfDLXmwLn5Mfcs4b5NmS2jgRXg";
    private Connection db = DriverManager.getConnection(host, dbusername, dbpassword);
    private Statement st = db.createStatement();
    private HashMap<Integer, IUser> userMap;
    private HashMap<Integer, ICase> caseMap;
    private HashMap<Integer, IEnquiry> enquiryMap;
    private HashMap<Integer, ICitizen> citizenMap;

    // Constructors 
    /**
     *
     * @throws SQLException
     */
    public Database() throws SQLException {
    }

    // Methods
    /**
     * Method stores an User in the Database in the table 'users'
     *
     * @param cpr of an User
     * @param username of a User
     * @param password of User
     * @param email of User
     * @param accessLevel of a User
     * @throws SQLException
     */
    public void createUser(int cpr, String username, String password, String email, AccessLevel accessLevel) throws SQLException {
        try {
            st = db.createStatement();
            st.execute("INSERT into users(cpr, username, password, email, accessLevel) VALUES ('" + cpr + "','" + username + "','" + password + "','" + email + "','" + accessLevel.getCode() + "')");
            st.close();
        } catch (PSQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method deletes a User from the Database from table users, based on the
     * username
     *
     * @param userName
     * @throws SQLException
     */
    public void deleteUser(String userName) throws SQLException {
        try {
            // Removes the user from the database.
            st = db.createStatement();
            st.execute("DELETE from users WHERE username = '" + userName + "'");
            st.close();
            // Iterates through the hashMap containing users to find the user with the specified username. 
            for (int i = 0; i < userMap.size(); i++) {
                if (userMap.get(i).getUsername().equals(userName)) {
                    userMap.remove(i);
                    System.out.println(userName + " removed");
                }
            }
        } catch (PSQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method creates a case in the database in the table cases.
     *
     * @param id of a Case
     * @param enquiryid of an Enquiry
     * @param citizencpr of a Citizen
     * @param dateCreated of a Case
     * @param lastModified of a Case
     * @param lastModifiedBy of a Case
     * @param usersusername username of a User
     * @throws SQLException
     */
    public void createCase(int id, int enquiryid, int citizencpr, java.util.Date dateCreated, java.util.Date lastModified, String lastModifiedBy, String usersusername) throws SQLException {
        try {
            st = db.createStatement();
            st.execute("INSERT into cases(id, enquiryid, citizencpr, datecreated, lastmodified, lastmodifiedby, usersusername) VALUES ('" + id + "','" + enquiryid + "','" + citizencpr + "','" + dateCreated + "','" + lastModified + "','" + lastModifiedBy + "','" + usersusername + "')");
            st.close();
        } catch (PSQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method deletes a case from both the database table cases and from the
     * case hashmap, based on the CPR of a citizen.
     *
     * @param citizenCPR of a Citizen
     * @throws SQLException
     */
    public void deleteCase(int citizenCPR) throws SQLException {
        try {
            // Removes the user from the database.
            st = db.createStatement();
            st.execute("DELETE from cases WHERE id = '" + citizenCPR + "'");
            st.close();
            // Iterates through the hashMap containing cases to find the case with the specified CPR. 
            for (int i = 0; i < userMap.size(); i++) {
                if (Integer.toString(caseMap.get(i).getCitizencpr()).equals(citizenCPR)) {
                    caseMap.remove(i);
                    System.out.println(citizenCPR + " removed");
                } else {
                }
            }
        } catch (PSQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method checks if a user exists in the database table users, based on the
     * username.
     *
     * @param userName of a user
     * @returns true or false
     * @throws SQLException
     */
    public Boolean userExists(String userName) throws SQLException {
        try {
            st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT username FROM users WHERE username = '" + userName + "'");
            // If a user with the username exists.
            if (rs.next()) {
                return true;
            }
            rs.close();
            st.close();
        } catch (PSQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Method is used to call methods on a User at the GUI level BEFORE the user
     * is logged in.
     *
     * @param userName of a user
     * @param password of a user
     * @returns a user
     * @throws SQLException
     */
    public IUser getUser(String userName, String password) throws SQLException {
        IUser user = null;

        try {
            st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE username = '" + userName + "' AND password = '" + password + "'");
            if (rs.next()) {
                user = new User(rs);
                rs.close();
                st.close();
            }
        } catch (PSQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    /**
     * Method is used to call methods on a User at the GUI level AFTER the user
     * is logged in.
     *
     * @param userName of a User
     * @returns a user
     * @throws SQLException
     */
    public IUser getUser(String userName) throws SQLException {
        IUser user = null;
        try {
            st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE username = '" + userName + "'");

            rs.next();
            user = new User(rs);

            rs.close();
            st.close();
        } catch (PSQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

     
      /**
     * Method retrieves all current users in the database table users.
     *
     * @returns a HashMap with all users in the database.
     * @throws SQLException
     */
        public HashMap<Integer, IUser> getUsers() throws SQLException {
  
        // Creates the HashMap to make sure the HashMap is updated according to the database everytime getUsers() is called.     
        userMap = new HashMap();
        int userID = 0;
        try {
            st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                // BRYDER LAGDELING??
                userMap.put(userID, new User(rs));
                userID++;
            }
            rs.close();
            st.close();

        } catch (PSQLException ex) {
            ex.printStackTrace();
        }

        return userMap;
    }

        
        // This method is used to retrieve all current users in the database. Returns a HashMap with all users.
        public HashMap<Integer, ICase> getCases() throws SQLException {
    /**
     * Method retrieves all current cases in the database table cases.
     *
     * @returns a HashMap with all current cases in the database
     * @throws SQLException
     */
        // Creates the HashMap to make sure the HashMap is updated according to the database everytime getUsers() is called.     
        caseMap = new HashMap();
        int caseID = 0;
        try {
            st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cases");
            while (rs.next()) {
                // BRYDER LAGDELING??
                caseMap.put(caseID, new Case(rs));
                caseID++;
            }
            rs.close();
            st.close();

        } catch (PSQLException ex) {
            ex.printStackTrace();
        }

        return caseMap;
    }

    /**
     *
     * @return @throws SQLException
     */
   public void createCaseOpening(int id, Boolean guardianship, Boolean guardianshipwithdesprivedjudiciallegalcapacity, Boolean guardiancuratorship, Boolean guardian, String guardianinformation, Boolean layrepresentative, Boolean representative, Boolean representationcuratorship, Boolean authority, String authorityinformation) throws SQLException {
        try {
            st = db.createStatement();
            st.execute("INSERT into caseOpenings(id, guardianship, guardianshipwithdesprivedjudiciallegalcapacity, guardiancuratorship, guardian, guardianinformation, layrepresentative, representative, representationcuratorship, authority, authorityinformation) VALUES ('" + id + "','" + guardianship + "','" + guardianshipwithdesprivedjudiciallegalcapacity + "','" + guardiancuratorship + "','" + guardian + "','" + guardianinformation + "','" + layrepresentative + "','" + representative + "','" + representationcuratorship + "','" + authority + "','" + authorityinformation + "')");
            st.close();
        } catch (PSQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method sets and updates the password for a user.
     *
     * @param userName of a user
     * @param password of a user
     * @throws SQLException
     */
    public void setPassword(String userName, String password) throws SQLException {
        try {
            st = db.createStatement();
            st.execute("UPDATE users SET password = '" + password + "' WHERE username = '" + userName + "'");
            st.close();
        } catch (PSQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method sets and updates the email for a user.
     *
     * @param userName of a user
     * @param email of a user
     * @throws SQLException
     */
    public void setEmail(String userName, String email) throws SQLException {
        try {
            st = db.createStatement();
            st.execute("UPDATE users SET email = '" + email + "' WHERE username = '" + userName + "'");
            st.close();
        } catch (PSQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method creates an enquiry in the database table enquiries
     *
     * @param id of an Enquiry
     * @param source of an Enquiry
     * @param date of an Enquiry
     * @param description of an Enquiry
     * @param citizencpr of an Enquiry
     * @throws SQLException
     */
    public void createEnquiry(int id, String source, Date date, String description, int citizencpr) throws SQLException {
        try {
            st = db.createStatement();
            st.execute("INSERT into enquiries(id, source, date, description, citizencpr) VALUES ('" + id + "','" + source + "','" + date + "','" + description + "','" + citizencpr + "')");
            st.close();
        } catch (PSQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method creates a citizen in the database table citizens
     *
     * @param cpr
     * @param address
     * @param email
     * @param phoneNumber
     * @param firstname
     * @param lastname
     * @throws SQLException
     */
    public void createCitizen(int cpr, String address, String email, int phoneNumber, String firstname, String lastname) throws SQLException {
        try {
            st = db.createStatement();
            st.execute("INSERT into citizens(cpr, address, email, phonenumber, firstname, lastname) VALUES ('" + cpr + "','" + address + "','" + email + "','" + phoneNumber + "','" + firstname + "','" + lastname + "')");
            st.close();
        } catch (PSQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public HashMap<Integer, IEnquiry> getEnquiries() throws SQLException {
      // Creates the HashMap to make sure the HashMap is updated according to the database everytime getEnquiries() is called.     


    /**
     * Method retrieves all current enquiries from the database table enquiries
     *
     * @returns a HashMap with all current enquries
     * @throws SQLException
     */
        // Creates the HashMap to make sure the HashMap is updated according to the database everytime getEnquiries() is called.     
        enquiryMap = new HashMap();
        int enquiryID = 0;
        try {
            st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM enquiries");
            while (rs.next()) {
                // BRYDER LAGDELING??
                enquiryMap.put(enquiryID, new Enquiry(rs));
                enquiryID++;
            }
            rs.close();
            st.close();

        } catch (PSQLException ex) {
            ex.printStackTrace();
        }

        return enquiryMap;

    }

    
    public HashMap<Integer, ICitizen> getCitizens() throws SQLException {
      // Creates the HashMap to make sure the HashMap is updated according to the database everytime getEnquiries() is called.     

    /**
     * Method retrieves all current citizens from the database table citizens
     *
     * @returns a HashMap with all current enquiries
     * @throws SQLException
     */
        // Creates the HashMap to make sure the HashMap is updated according to the database everytime getEnquiries() is called.     
        citizenMap = new HashMap();
        int citizenID = 0;
        try {
            st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM citizens");
            while (rs.next()) {
                // BRYDER LAGDELING??
                citizenMap.put(citizenID, new Citizen(rs));
                citizenID++;
            }
            rs.close();
            st.close();

        } catch (PSQLException ex) {
            ex.printStackTrace();
        }
        
        return citizenMap;
    }

}
