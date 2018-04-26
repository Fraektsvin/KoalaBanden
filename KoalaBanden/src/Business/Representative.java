/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Jonas
 */
public class Representative extends User {
    private String type; 
    private String address; 
    private String caseInformation;
    
    public Representative(String username, String password, String email, int SSN, int accessLevel) {
        super(username, password, email, SSN, accessLevel);
    }
    
    private String getCaseinformation() {
      return caseInformation;
   }
    
}
