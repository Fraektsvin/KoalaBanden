/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
 */
// 
public class Case implements ICase {

    // Data Field
    private int id; // id of a case
    private int enquiryid; // id of the enquiry connected to a case
    private int citizencpr; // cpr of the citizen connected to a case
    private Date dateCreated; // date of when a case is created
    private Date lastModified; // date of when a case is last modified
    private String lastModifiedBy; // username of the caseworker who last modified a case
    private String usersusername; // username of the caseworker connected to a case

    // Constructors
    /**
     * Constructor creating a Case object
     *
     * @param id of the case
     * @param enquiryid id for the enquiry connected to the case
     * @param citizencpr cpr for the citizen connected to the case
     * @param dateCreated the date for creation of the case
     * @param lastModified the date for last modification
     * @param lastModifiedBy the username of the caseworker who last modified
     * the case
     * @param usersusername the username of the caseworker connected to the case
     */
    public Case(int id, int enquiryid, int citizencpr, Date dateCreated, Date lastModified, String lastModifiedBy, String usersusername) {
        this.id = id;
        this.enquiryid = enquiryid;
        this.citizencpr = citizencpr;
        this.dateCreated = dateCreated;
        this.lastModified = lastModified;
        this.lastModifiedBy = lastModifiedBy;
        this.usersusername = usersusername;
    }

    /**
     * Constructor creating a case by using the resultset of the database to set
     * the attributes of the case class
     *
     * @param rs
     * @throws SQLException
     */
    public Case(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.enquiryid = rs.getInt("enquiryid");
        this.citizencpr = rs.getInt("citizencpr");
        this.dateCreated = rs.getDate("dateCreated");
        this.lastModified = rs.getDate("lastModified");
        this.lastModifiedBy = rs.getString("lastModifiedBy");
        this.usersusername = rs.getString("usersusername");
    }

    // Methods
    /**
     *
     * @returns id of a case
     */
    public int getId() {
        return id;
    }

    /**
     * Method sets the id of a case
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @returns id of an enquiry
     */
    public int getEnquiryid() {
        return enquiryid;
    }

    /**
     * Method sets the id of an enquiry
     *
     * @param enquiryid
     */
    public void setEnquiryid(int enquiryid) {
        this.enquiryid = enquiryid;
    }

    /**
     *
     * @returns cpr of a citizen
     */
    public int getCitizencpr() {
        return citizencpr;
    }

    /**
     * Method sets the cpr of a citizen
     *
     * @param citizencpr
     */
    public void setCitizencpr(int citizencpr) {
        this.citizencpr = citizencpr;
    }

    /**
     *
     * @returns the date of when a case is created
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Method sets date of when a case is created
     *
     * @param dateCreated
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     *
     * @returns the date of when a case was last modified
     */
    public Date getLastModified() {
        return lastModified;
    }

    /**
     * Method sets the date of when a case is last modified
     *
     * @param lastModified
     */
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    /**
     *
     * @returns the username of the user who last modified a case
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * Method sets the username of the user who last modified a case
     *
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     *
     * @returns the username of the caseworker connected to a case
     */
    public String getUsersusername() {
        return usersusername;
    }

    /**
     * Method sets the username of the caseworker connected to a case
     *
     * @param usersusername
     */
    public void setUsersusername(String usersusername) {
        this.usersusername = usersusername;
    }

}
