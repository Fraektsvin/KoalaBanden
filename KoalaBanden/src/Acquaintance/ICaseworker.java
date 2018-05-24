/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Jonas
 */
public interface ICaseworker {

    public void createCase(int cpr, int id, Date dateCreated, Date lastModified, String lastModifiedBy);
    public void registerEnquiry(int id, String source, Date date, String description, int citizencpr);
    public void createCitizen(int cpr, String address, String email, int phoneNumber, String firstname, String lastname) throws SQLException;
    public HashMap getEnquiries() throws SQLException;
    public HashMap getCitizens() throws SQLException;
}
