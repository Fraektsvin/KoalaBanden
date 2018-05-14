   
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