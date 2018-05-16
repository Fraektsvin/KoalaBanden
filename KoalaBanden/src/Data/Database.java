/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.IUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
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
    private String[] userData = new String[3];
    
    public Database() throws SQLException {
     
    }
    
    public void createUser(int cpr, String username, String password, String email, int accessLevel) throws SQLException {
          try {
             Class.forName("org.postgresql.Driver");
              Statement st = db.createStatement();
              st.execute("INSERT into users(cpr, username, password, email, accessLevel) VALUES ('" + cpr + "','" + username + "','" + password + "','" + email + "','" + accessLevel + "')");   
              st.close();
        } catch(PSQLException ex) {
           ex.printStackTrace();
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
    }
    }
    
    public Boolean userExists(String userName) throws SQLException {
        try {
             Class.forName("org.postgresql.Driver");
              Statement st = db.createStatement();
              ResultSet rs = st.executeQuery("SELECT username FROM users WHERE username = '" + userName + "'");
              // If a user with the username exists.
              if(rs.next() == true) {
                  return true;
              }
              rs.close();
              st.close();
        } catch(PSQLException ex) {
           ex.printStackTrace();
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
    }
        return false;
    }
    
    public String[] getUser(String userName, String password) throws SQLException {
        try {
             Class.forName("org.postgresql.Driver");
              Statement st = db.createStatement();
              ResultSet rs = st.executeQuery("SELECT * FROM users WHERE username = '" + userName + "' AND password = '" + password + "'");
              while(rs.next()) {
                  userData[0] = rs.getString(2); 
                  userData[1] = rs.getString(3);
                  userData[2] = rs.getString(5);
              }
              rs.close();
              st.close();
        } catch(PSQLException ex) {
           ex.printStackTrace();
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
    }
        return userData;
    }
    
        
    
    
    
  
}
