/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.*;

import java.util.Collection;

import java.sql.SQLException;

import java.util.HashMap;

/**
 *
 * @author Antonio
 */
public class BusinessFacade implements IBusiness {

    private SystemManager manager; // instance of a systemmanager
    private ICaseworker worker; // instance of an ICaseworker
    public static IData data; // instance of an IData
    int caseID = 0;

    /**
     * Constructor instantiates manager as a SystemManager on object created.
     * @throws SQLException 
     */
    public BusinessFacade() throws SQLException {
        manager = new SystemManager();
    }

    /**
     * @see Data.DataFacade#userExists(java.lang.String) 
     * @param userName
     * @return 
     */
    public boolean userExists(String userName) {
        return data.userExists(userName);
    }

    /**
     * Method sets IData.
     * @param data 
     */
    @Override
    public void injectData(IData data) {
        this.data = data;
    }

    /**
     * Method return a caseworker object. 
     * @return 
     */
    @Override
    public ICaseworker getCaseworker() {
        return worker;
    }

    /**
     * Method creates a caseworker.
     * @param username
     * @param password
     * @param email
     * @param SSN
     * @param accesslevel 
     */
    @Override
    public void createCaseworker(String username, String password, String email, int SSN, AccessLevel accesslevel) {
        //manager.createCaseworker(username, password, email, SSN, accesslevel);
        this.worker = new Caseworker(username, password, email, SSN, accesslevel);
    }

    /**
     * 
     * @returns a collection of cases from the database.
     */
    @Override
    
    public HashMap<Integer, ICase> getCases() {
        return data.getCases();
    }

    /**
     * 
     * @returns a collection of enquiries from the database.
     */
    @Override
    public HashMap<Integer, IEnquiry> getEnquiries() {
        return data.getEnquiries();
    }

    /**
     * Method is used to get access to methods in the DataFacade from the BusinessFacade.
     * @returns IData.
     */
    @Override
    public IData getData() {
        return this.data;
    }

    /**
     * @see SystemManager#login(java.lang.String, java.lang.String) 
     * @param userName
     * @param password
     * @return 
     */
    @Override
    public IUser login(String userName, String password) {
        return manager.login(userName, password);
    }

    /**
     * @see SystemManager#createUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, Acquaintance.AccessLevel) 
     * @param username
     * @param password
     * @param email
     * @param SSN
     * @param accessLevel
     * @return 
     */
    @Override
    public boolean createUser(String username, String password, String email, String SSN, AccessLevel accessLevel) {
        return manager.createUser(username, password, email, SSN, accessLevel);
    }

    /**
     * @see SystemManager#getAccessLevels() 
     * @return 
     */
    @Override
    public Collection getAccessLevels() {
        return manager.getAccessLevels();
    }

    /**
     * 
     * @returns a collection of users from the database.
     */
    @Override
    public HashMap<Integer, IUser> getUsers() {
        return data.getUsers();
    }

    /**
     * @see SystemManager#deleteUser(java.lang.String) 
     * @param username 
     */
    @Override
    public void deleteUser(String username) {
        manager.deleteUser(username);
    }

    /**
     * @see SystemManager#getCurrentAccessLevel() 
     * @return 
     */
    @Override
    public AccessLevel getCurrentAccessLevel() {
        return manager.getCurrentAccessLevel();
    }

    /**
     * Method is used to get a user from the database with username and password.
     * @param userName
     * @param password
     * @return a IUser object. 
     */
    @Override
    public IUser getUser(String userName, String password) {
        return data.getUser(userName, password);
    }

    /**
     * Method is used to get a user from the database from a username.
     * @param userName
     * @return an IUser object.
     */
    @Override
    public IUser getUser(String userName) {
        return data.getUser(userName);
    }

    /**
     * @see SystemManager#getCurrentUsername() 
     * @return 
     */
    @Override
    public String getCurrentUsername() {
        return manager.getCurrentUsername();
    }

    /**
     * @see SystemManager#setUser(java.lang.String) 
     * @param Username 
     */
    @Override
    public void setUser(String Username) {
        manager.setUser(Username);
    }

}
