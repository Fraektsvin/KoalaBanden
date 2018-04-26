/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author finch
 */
public class Citizen extends User {
    
    // Contructor
    
    public Citizen(String username, String password, String email, int SSN, int accessLevel) {
        super(username, password, email, SSN, accessLevel);
    }
    
    // Methods
    
    public String getCaseInformation(){
        String caseInformation = null;
        return caseInformation;
    }

    
}
