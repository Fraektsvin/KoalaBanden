/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.AccessLevel;
import Acquaintance.ICaseworker;
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

    // Constructors
    /**
     * Constructor creating a caseworker
     *
     * @param username
     * @param password
     * @param email
     * @param CPR
     * @param accessLevel
     */
    public Caseworker(String username, String password, String email, int CPR, AccessLevel accessLevel) {
        super(username, password, email, CPR, accessLevel);
    }

    // Methods
    /**
     * Method registers an enquiry based on information from a citizen by email,
     * phone call etc. the enquiry is created through the createEnquiry() method
     * from the datafacade in the database
     *
     * @param id
     * @param source
     * @param date
     * @param description
     * @param citizencpr
     */
    @Override
    public void registerEnquiry(int id, String source, Date date, String description, int citizencpr) {
        try {
            BusinessFacade.data.createEnquiry(id, source, date, description, citizencpr);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @returns a HashMap of enquiries created in the database class in the data
     * package.
     * @throws SQLException
     */
    @Override
    public HashMap getEnquiries() throws SQLException {
        return BusinessFacade.data.getEnquiries();
    }

    
    /**
     * Method creates a case through the createCase() method in the datafacade
     * in the database
     *
     * @see Data.DataFacade#createCase(int, int, int, java.util.Date,
     * java.util.Date, java.lang.String, java.lang.String)
     * @param id
     * @param enquiryid
     * @param citizencpr
     * @param dateCreated
     * @param lastModified
     * @param lastModifiedBy
     * @param usersusername
     */
    @Override
    public void createCase(int id, int enquiryid, int citizencpr, java.util.Date dateCreated, java.util.Date lastModified, String lastModifiedBy, String usersusername) {
        try {
            BusinessFacade.data.createCase(id, enquiryid, citizencpr, dateCreated, lastModified, lastModifiedBy, usersusername);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method creates a citizen through the createCitizen() method in the
     * datafacade.
     *
     * @see Data.DataFacade#createCitizen(int, java.lang.String,
     * java.lang.String, int, java.lang.String, java.lang.String)
     * @param cpr
     * @param address
     * @param email
     * @param phoneNumber
     * @param firstname
     * @param lastname
     * @throws SQLException
     */
    public void createCitizen(int cpr, String address, String email, int phoneNumber, String firstname, String lastname) throws SQLException {
        BusinessFacade.data.createCitizen(cpr, address, email, phoneNumber, firstname, lastname);
    }

    /**
     * Method creates a caseopening through the createCaseOpening() method in
     * the datafacade.
     *
     * @see Data.DataFacade#createCaseOpening(int, java.lang.Boolean,
     * java.lang.Boolean, java.lang.Boolean, java.lang.Boolean,
     * java.lang.String, java.lang.Boolean, java.lang.Boolean,
     * java.lang.Boolean, java.lang.Boolean, java.lang.String)
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
        BusinessFacade.data.createCaseOpening(id, guardianship, guardianshipwithdesprivedjudiciallegalcapacity, guardiancuratorship, guardian, guardianinformation, layrepresentative, representative, representationcuratorship, authority, authorityinformation);
    }

}
