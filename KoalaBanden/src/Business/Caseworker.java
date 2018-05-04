/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;


/**
 *
 * @author finch
 */
public class Caseworker extends User {

    private IBusiness business;
    
    // Data field
    private IData data; 
    private int ID; 
    private int caseID = 0;

    // Constructor

    public Caseworker(String username, String password, String email, int SSN, int accessLevel) {
        super(username, password, email, SSN, accessLevel);
    }
    
   

    // Methods
    public void createCase(int citizenSSN) {
        business.createCase(citizenSSN);
    }
    

  
      
    public void createCaseOpening() {

    }

    public void createCaseInformation() {

    }

    public String getCaseInformation() {
        String caseInformation = null;
        return caseInformation;
    }
}
