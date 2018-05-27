/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.AccessLevel;
import Acquaintance.ICaseworker;
import Acquaintance.IData;
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
public class Caseworker extends User implements ICaseworker {

    // Data field
    private IData data;
    private int ID;

    // Constructor
    public Caseworker(String username, String password, String email, int SSN, AccessLevel accessLevel) {
        super(username, password, email, SSN, accessLevel);
    }

    // Methods
    @Override
    public void createCase(int id, int enquiryid, int citizencpr, java.util.Date dateCreated, java.util.Date lastModified, String lastModifiedBy, String usersusername) {
        try {
            BusinessFacade.data.createCase(id, enquiryid, citizencpr, dateCreated, lastModified, lastModifiedBy, usersusername);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCaseOpening() {

    }

    public void createCaseInformation() {

    }

    public String getCaseInformation() {
        String caseInformation = null;
        return caseInformation;
    }

    public void registerEnquiry(int id, String source, Date date, String description, int citizencpr) {
        try {
            BusinessFacade.data.createEnquiry(id, source, date, description, citizencpr);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public HashMap getEnquiries() throws SQLException {
        return BusinessFacade.data.getEnquiries();
    }

    public HashMap getCitizens() throws SQLException {
        return BusinessFacade.data.getCitizens();
    }

    public void createCitizen(int cpr, String address, String email, int phoneNumber, String firstname, String lastname) throws SQLException {
        BusinessFacade.data.createCitizen(cpr, address, email, phoneNumber, firstname, lastname);
    }

}
