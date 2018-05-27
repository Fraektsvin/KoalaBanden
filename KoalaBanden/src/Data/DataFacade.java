/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.ICase;
import Acquaintance.IData;
import Acquaintance.IUser;
import java.sql.Date;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
 */
public class DataFacade implements IData {

    private Database database;
//    private caseData caseData;  // bruges ikke

    public DataFacade() throws SQLException {
        database = new Database();
    }

    @Override
    public boolean userExists(String userName) {
        try {
            return database.userExists(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void createUser(IUser user) {
        try {
            database.createUser(user.getCPR(), user.getUsername(), user.getPassword(), user.getEmail(), user.getAccessLevel());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String userName) {
        try {
            database.deleteUser(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCase(int id, int enquiryid, int citizencpr, java.util.Date dateCreated, java.util.Date lastModified, String lastModifiedBy, String usersusername) throws SQLException {
        database.createCase(id, enquiryid, citizencpr, dateCreated, lastModified, lastModifiedBy, usersusername);
    }

    public Map<Integer, ICase> getCases() {
        try {
            return database.getCases();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HashMap getUsers() {
        try {
            return database.getUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IUser getUser(String userName, String password) {
        try {
            return database.getUser(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IUser getUser(String userName) {
        try {
            return database.getUser(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setPassword(String userName, String password) {
        try {
            database.setPassword(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void setEmail(String userName, String email) {
        try {
            database.setEmail(userName, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HashMap getEnquiries() throws SQLException {
        return database.getEnquiries();
    }

    public HashMap getCitizens() throws SQLException {
        return database.getCitizens();
    }

    public void createEnquiry(int id, String source, Date date, String description, int citizencpr) throws SQLException {
        database.createEnquiry(id, source, date, description, citizencpr);
    }

    public void createCitizen(int cpr, String address, String email, int phoneNumber, String firstname, String lastname) throws SQLException {
        database.createCitizen(cpr, address, email, phoneNumber, firstname, lastname);
    }

}
