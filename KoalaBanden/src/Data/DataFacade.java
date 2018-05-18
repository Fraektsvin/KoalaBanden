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

import java.sql.SQLException;
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
    public void saveCase(ICase c) {
//        caseData.saveCase(c);
    }

    public Map<Integer, ICase> getCases() {
        return caseData.getCaseMap();
    }

    @Override
    public Map<String, IUser> getUsers() {
       // return userData.getUserMap();
       return null;
    }

    @Override
    public void deleteUser(String username) {
        // userData.deleteUser(username);
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
