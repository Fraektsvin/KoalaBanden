/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICase;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Jonas
 */
// TEST
public class Case implements Serializable, ICase {

    // Data Field
   
    private int id; 
    private int enquiryid;
    private int citizencpr; 
    private Date dateCreated;
    private Date lastModified;
    private String lastModifiedBy;
    private String usersusername;
    
    // Constructor
    public Case(int id, int enquiryid, int citizencpr, Date dateCreated, Date lastModified, String lastModifiedBy, String usersusername) {
        this.id = id;
        this.enquiryid = enquiryid;
        this.citizencpr = citizencpr;
        this.dateCreated = dateCreated;
        this.lastModified = lastModified;
        this.lastModifiedBy = lastModifiedBy;
        this.usersusername = usersusername;
    }
    
    public Case(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.enquiryid = rs.getInt("enquiryid");
        this.citizencpr = rs.getInt("citizencpr");
        this.dateCreated = rs.getDate("dateCreated");
        this.lastModified = rs.getDate("lastModified");
        this.lastModifiedBy = rs.getString("lastModifiedBy");
        this.usersusername = rs.getString("userusername");
    }

    // Methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnquiryid() {
        return enquiryid;
    }

    public void setEnquiryid(int enquiryid) {
        this.enquiryid = enquiryid;
    }

    public int getCitizencpr() {
        return citizencpr;
    }

    public void setCitizencpr(int citizencpr) {
        this.citizencpr = citizencpr;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getUsersusername() {
        return usersusername;
    }

    public void setUsersusername(String usersusername) {
        this.usersusername = usersusername;
    }

    
    

}
