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
    private Date dateCreated;
    private Date lastModified;
    private String lastModifiedBy;
    private int citizenSSN;
    private int ID;

    // Constructor
    public Case(int citizenSSN) {
        this.citizenSSN = citizenSSN;
    }
    
    public Case(ResultSet rs) throws SQLException {
        this.citizenSSN = rs.getInt("citizencpr");
        this.dateCreated = rs.getDate("datecreated");
        this.lastModified = rs.getDate("lastmodified");
        this.lastModifiedBy = rs.getString("lastmodifiedby");
        this.ID = rs.getInt("ID");
    }

    // Methods
    public int getSSN() {
        return citizenSSN;
    }

    public void setSSN(int citizenSSN) {
        this.citizenSSN = citizenSSN;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

}
