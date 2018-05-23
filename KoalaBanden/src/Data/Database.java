/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.AccessLevel;
import Acquaintance.ICase;
import Acquaintance.IUser;
import Business.Case;
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
 */
public class Database {
    // Database info.
    private String host = "jdbc:postgresql://dumbo.db.elephantsql.com:5432/ntkoapef";
    private String dbusername = "ntkoapef";
    private String dbpassword = "URBi5bIfDLXmwLn5Mfcs4b5NmS2jgRXg";
    private Connection db = DriverManager.getConnection(host, dbusername, dbpassword);
    private HashMap<Integer, IUser> userMap;
    private HashMap<Integer, ICase> caseMap;
    
    public Database() throws SQLException {
     
    }
    
    public void createUser(int cpr, String username, String password, String email, AccessLevel accessLevel) throws SQLException {
          try {
             Class.forName("org.postgresql.Driver");
              Statement st = db.createStatement();
              st.execute("INSERT into users(cpr, username, password, email, accessLevel) VALUES ('" + cpr + "','" + username + "','" + password + "','" + email + "','" + accessLevel.getCode() + "')");
              st.close();
        } catch(PSQLException | ClassNotFoundException ex) {
           ex.printStackTrace();
        }
    }
    // Deletes a user based on the username.
    public void deleteUser(String userName) throws SQLException {
        try {
           // Removes the user from the database.
            Class.forName("org.postgresql.Driver");
            Statement st = db.createStatement();
            st.execute("DELETE from users WHERE username = '" + userName + "'");
            st.close();
             // Iterates through the hashMap containing users to find the user with the specified username. 
            for (int i = 0; i < userMap.size(); i++) {
                if(userMap.get(i).getUsername().equals(userName)) {
                    userMap.remove(i);
                    System.out.println(userName + " removed");
                }
            }
        } catch(PSQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    
     public void createCase(int cpr, int id, Date dateCreated, Date lastModified, String lastModifiedBy ) throws SQLException {
          try {
             Class.forName("org.postgresql.Driver");
              Statement st = db.createStatement();
              st.execute("INSERT into casesny(citizencpr, id, datecreated, lastmodified, lastmodifiedBy) VALUES ('" + cpr + "','" + id + "','" + dateCreated + "','" + lastModified + "','" + lastModifiedBy + "')");
              st.close();
        } catch(PSQLException | ClassNotFoundException ex) {
           ex.printStackTrace();
        }
    }
    // Deletes a case based on the CPR.
    public void deleteCase(int citizenCPR) throws SQLException {
        try {
           // Removes the user from the database.
            Class.forName("org.postgresql.Driver");
            Statement st = db.createStatement();
            st.execute("DELETE from cases WHERE citizenCPR = '" + citizenCPR + "'");
            st.close();
             // Iterates through the hashMap containing cases to find the case with the specified CPR. 
            for (int i = 0; i < userMap.size(); i++) {
                if(Integer.toString(caseMap.get(i).getSSN()).equals(citizenCPR)){
                    caseMap.remove(i);
                    System.out.println(citizenCPR + " removed");
                } else {
                }
            } 
        } catch(PSQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public Boolean userExists(String userName) throws SQLException {
        try {
             Class.forName("org.postgresql.Driver");
              Statement st = db.createStatement();
              ResultSet rs = st.executeQuery("SELECT username FROM users WHERE username = '" + userName + "'");
              // If a user with the username exists.
              if(rs.next()) {
                  return true;
              }
              rs.close();
              st.close();
        } catch(PSQLException | ClassNotFoundException ex) {
           ex.printStackTrace();
        }
        return false;
    }
    // This method is used to call methods on user in the GUI BEFORE the user logged in.
    public IUser getUser(String userName, String password) throws SQLException {
        IUser user = null;
        try {
            Class.forName("org.postgresql.Driver");
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE username = '" + userName + "' AND password = '" + password + "'");

            rs.next();
            user = new User(rs);

            rs.close();
            st.close();
        } catch(PSQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    // This method is used to call methods on user in the GUI AFTER a person logged in.
     public IUser getUser(String userName) throws SQLException {
        IUser user = null;
        try {
            Class.forName("org.postgresql.Driver");
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE username = '" + userName + "'");

            rs.next();
            user = new User(rs);

            rs.close();
            st.close();
        } catch(PSQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return user;
    }
     // This method is used to retrieve all current users in the database. Returns a HashMap with all users.
        public HashMap getUsers() throws SQLException {
        // Creates the HashMap to make sure the HashMap is updated according to the database everytime getUsers() is called.     
        userMap = new HashMap();
        int userID = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while(rs.next()) {
                userMap.put(userID, new User(rs));
                userID++;
            }   
            rs.close();
            st.close();
            
        } catch(PSQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return userMap;
    }
        
        // This method is used to retrieve all current users in the database. Returns a HashMap with all users.
        public HashMap getCases() throws SQLException {
        // Creates the HashMap to make sure the HashMap is updated according to the database everytime getUsers() is called.     
        caseMap = new HashMap();
        int caseID = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM casesny");
            while(rs.next()) {
                caseMap.put(caseID, new Case(rs));
                caseID++;
            }   
            rs.close();
            st.close();
            
        } catch(PSQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return caseMap;
    }
     
    // Takes userName to check the user we want to change password for. Takes password as the new password. 
    public void setPassword(String userName, String password) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            Statement st = db.createStatement();
            st.execute("UPDATE users SET password = '" + password + "' WHERE username = '" + userName + "'");
            st.close();
        } catch(PSQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void setEmail(String userName, String email) throws SQLException {
       try {
            Class.forName("org.postgresql.Driver");
            Statement st = db.createStatement();
            st.execute("UPDATE users SET email = '" + email + "' WHERE username = '" + userName + "'");
            st.close();
        } catch(PSQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }  
    }
        
    
    
    
  
}
