/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.IData;
import Acquaintance.IUser;
import java.sql.Date;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
 */
public class DataFacade implements IData {

    // Data Field
    private Database database;

    // Constructors
    /**
     * Constructor creating an instance of Database class
     *
     * @throws SQLException
     */
    public DataFacade() throws SQLException {
        database = new Database();
    }

    /**
     * @see Database#userExists(java.lang.String)
     * @param userName
     * @return
     */
    @Override
    public boolean userExists(String userName) {
        try {
            return database.userExists(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * @see Database#createUser(int, java.lang.String, java.lang.String,
     * java.lang.String, Acquaintance.AccessLevel)
     * @param user
     */
    @Override
    public void createUser(IUser user) {
        try {
            database.createUser(user.getCPR(), user.getUsername(), user.getPassword(), user.getEmail(), user.getAccessLevel());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see Database#deleteUser(java.lang.String)
     * @param userName
     */
    @Override
    public void deleteUser(String userName) {
        try {
            database.deleteUser(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see Database#createCase(int, int, int, java.util.Date, java.util.Date,
     * java.lang.String, java.lang.String)
     * @param id
     * @param enquiryid
     * @param citizencpr
     * @param dateCreated
     * @param lastModified
     * @param lastModifiedBy
     * @param usersusername
     * @throws SQLException
     */
    @Override
    public void createCase(int id, int enquiryid, int citizencpr, java.util.Date dateCreated, java.util.Date lastModified, String lastModifiedBy, String usersusername) throws SQLException {
        database.createCase(id, enquiryid, citizencpr, dateCreated, lastModified, lastModifiedBy, usersusername);
    }

    /**
     * @see Database#getCases()
     * @return
     */
    @Override
    public HashMap getCases() {
        try {
            return database.getCases();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @see Database#getUsers()
     * @return
     */
    @Override
    public HashMap getUsers() {
        try {
            return database.getUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @see Database#getUser(java.lang.String, java.lang.String)
     * @param userName
     * @param password
     * @return
     */
    @Override
    public IUser getUser(String userName, String password) {
        try {
            return database.getUser(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @see Database#getUser(java.lang.String)
     * @param userName
     * @return
     */
    @Override
    public IUser getUser(String userName) {
        try {
            return database.getUser(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @see Database#setPassword(java.lang.String, java.lang.String)
     * @param userName
     * @param password
     */
    @Override
    public void setPassword(String userName, String password) {
        try {
            database.setPassword(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * @see Database#setEmail(java.lang.String, java.lang.String)
     * @param userName
     * @param email
     */
    @Override
    public void setEmail(String userName, String email) {
        try {
            database.setEmail(userName, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see Database#getEnquiries()
     * @return
     */
    @Override
    public HashMap getEnquiries() {
        try {
            return database.getEnquiries();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @see Database#createCaseOpening(int, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String) 
     * @param id
     * @param guardianship
     * @param guardianshipwithdesprivedjudiciallegalcapacity
     * @param guardiancuratorship
     * @param guardian
     * @param guardianinformation
     * @param layrepresentative
     * @param representative
     * @param representationcuratorship
     * @param authority
     * @param authorityinformation
     * @throws SQLException 
     */
    public void createCaseOpening(int id, Boolean guardianship, Boolean guardianshipwithdesprivedjudiciallegalcapacity, Boolean guardiancuratorship, Boolean guardian, String guardianinformation, Boolean layrepresentative, Boolean representative, Boolean representationcuratorship, Boolean authority, String authorityinformation) throws SQLException {
        database.createCaseOpening(id, guardianship, guardianshipwithdesprivedjudiciallegalcapacity, guardiancuratorship, guardian, guardianinformation, layrepresentative, representative, representationcuratorship, authority, authorityinformation);
    }

    /**
     * @see Database#getCitizens() 
     * @return
     * @throws SQLException 
     */
    public HashMap getCitizens() throws SQLException {
        return database.getCitizens();
    }

    /**
     * @see Database#createEnquiry(int, java.lang.String, java.sql.Date, java.lang.String, int) 
     * @param id an id
     * @param source a source
     * @param date a date
     * @param description a description
     * @param citizencpr a
     * @throws SQLException 
     */
    public void createEnquiry(int id, String source, Date date, String description, int citizencpr) throws SQLException {
        database.createEnquiry(id, source, date, description, citizencpr);
    }

    /**
     * @see Database#createCitizen(int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String) 
     * @param cpr
     * @param address
     * @param email
     * @param phoneNumber
     * @param firstname
     * @param lastname
     * @throws SQLException 
     */
    public void createCitizen(int cpr, String address, String email, int phoneNumber, String firstname, String lastname) throws SQLException {
        database.createCitizen(cpr, address, email, phoneNumber, firstname, lastname);
    }

}
