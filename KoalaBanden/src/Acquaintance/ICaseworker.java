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
public interface ICaseworker {
     public void createCase(int id, int enquiryid, int citizencpr, java.util.Date dateCreated, java.util.Date lastModified, String lastModifiedBy, String usersusername);
    public void registerEnquiry(int id, String source, Date date, String description, int citizencpr);
    public void createCitizen(int cpr, String address, String email, int phoneNumber, String firstname, String lastname) throws SQLException;
    public HashMap<Integer, IEnquiry> getEnquiries() throws SQLException;
}
