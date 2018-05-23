/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.ICase;
import Acquaintance.IData;
import Acquaintance.IUser;
import Business.User;
import java.sql.Date;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Antonio
 */
public class DataFacade implements IData {

    private Database database;
    private caseData caseData;
    

    public DataFacade() throws SQLException {
        database = new Database();
    }

    @Override
    public boolean userExists(String userName) {
        try {
           return database.userExists(userName);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void createUser(IUser user) {
        try {
         database.createUser(user.getCPR(), user.getUsername(), user.getPassword(), user.getEmail(), user.getAccessLevel());
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deleteUser(String userName) {
        try {
            database.deleteUser(userName);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
   public void createCase(int cpr, int id, Date dateCreated, Date lastModified, String lastModifiedBy ) throws SQLException {
       database.createCase(cpr, id, dateCreated, lastModified, lastModifiedBy);
   }

    public Map<Integer, ICase> getCases() {
        try {
            return database.getCases(); 
        } catch(SQLException e) {
            e.printStackTrace();
        }
     return null;  
    }

    @Override
    public HashMap getUsers() {
        try {
            return database.getUsers();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IUser getUser(String userName, String password) {
        try {
            return database.getUser(userName, password);
        } catch(SQLException e) {
        e.printStackTrace();
    }
        return null;
    }

    @Override
    public IUser getUser(String userName) {
         try {
            return database.getUser(userName);
        } catch(SQLException e) {
        e.printStackTrace();
    }
        return null;
    }
    
    @Override
    public void setPassword(String userName, String password) {
        try {
         database.setPassword(userName, password);  
        } catch(SQLException e) {
            e.printStackTrace();
        }
       
    }

    @Override
    public void setEmail(String userName, String email) {
        try {
         database.setEmail(userName, email);  
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    

}
