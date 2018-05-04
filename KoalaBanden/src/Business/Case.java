/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICase;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jonas
 */

// TEST
public class Case implements Serializable, ICase  {
    // Data Field
    private int ID = 1; 
    private Date dateCreated;
    private Date lastModified;
    private String lastModifiedBy;
    private int citizenSSN;
    // Constructor
    public Case(int ID, int citizenSSN) {
        this.ID = ID;
        this.citizenSSN = citizenSSN;
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
