/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 * Test
 * @author Antonio
 */
public class SystemAdministrator extends User {
    private int ID; 

    public SystemAdministrator(String username, String password, String email, int SSN, int accessLevel) {
        super(username, password, email, SSN, accessLevel);
    }

    public int getID() {
        return ID;
    }



    public void setID(int ID) {
        this.ID = ID;
    }
    private void addUSer() {
    
}
    private void deleteUSer() {
        
    }
    private void setUsername() {
        
    }
    private void serUSerpassword() {
        
    }
    private void accesLevel() {
        
    }
    private void setEmail() {
        
    }
    
}
