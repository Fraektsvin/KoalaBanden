/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author finch
 */
public class Case {
    
    // Data field
    
    private int ID;
    private Date dateCreated;
    private String lastModifiedBy;
    private Date lastModified;
    private int citizenSSN;

    // Constructor
    
    public Case (int ID, int citizenSSN){
        this.ID = ID;
        this.citizenSSN = citizenSSN;
        this.dateCreated = new Date();
    }
    
    // Methods
    
    public int getSSN(){
        return this.citizenSSN;
    }
    
}
