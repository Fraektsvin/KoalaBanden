/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;


import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author Jonas
 */
public interface IData {
    public boolean userExists(String userName);
    public void createUser(IUser user);
    public IUser getUser(String userName, String password);
    public IUser getUser(String userName);
    public void createCase(int cpr, int id, Date dateCreated, Date lastModified, String lastModifiedBy ) throws SQLException;
    public Map<Integer, ICase> getCases();
    public HashMap getUsers();
    public void deleteUser(String username);
    public void setPassword(String userName, String password);
    public void setEmail(String userName, String email);
    public void createEnquiry(int id, String source, Date date, String description, int citizencpr) throws SQLException;
    public void createCitizen(int cpr, String address, String email, int phoneNumber, String firstname, String lastname) throws SQLException;
    public HashMap getEnquiries() throws SQLException;
    public HashMap getCitizens() throws SQLException;
}
