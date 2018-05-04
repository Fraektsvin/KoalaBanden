/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;


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

    public Caseworker(String username, String password, String email, int CPR, int accessLevel) {
        super(username, password, email, CPR, accessLevel);
    }
    
   

    // Methods
    public void createCase(int citizenCPR) {
        business.createCase(citizenCPR);
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
