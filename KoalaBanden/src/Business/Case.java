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
    private int citizenCPR;
    // Constructor
    public Case(int ID, int citizenCPR) {
        this.ID = ID;
        this.citizenCPR = citizenCPR;
    }
    
    // Methods
    
    public int getCPR() {
        return citizenCPR;
    }
    
    public void setSSN(int citizenCPR) {
        this.citizenCPR = citizenCPR;
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
