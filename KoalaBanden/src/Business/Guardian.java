package Business;

import java.util.ArrayList;

import Acquaintance.AccessLevel;
import Acquaintance.ICaseOpening;
import Acquaintance.IUser;
import Business.User;

public class Guardian extends User implements IUser {
    private String type;
    private String address;
    private String caseInformation; 
    
    private String username;
    private String password;
    private String email;
    private int SSN;
    private AccessLevel accessLevel;
    private String firstName;
    private String lastName;
    private String DOB;
    private String phonenumber;
    private String PostalCode;
    private String guardianDescription;

    public Guardian(String username, String password, String email, int SSN, AccessLevel accessLevel) {
        super(username, password, email, SSN, accessLevel);
        this.username = username;
        this.password = password;
        this.email = email;
        this.SSN = SSN;
        this.accessLevel = accessLevel;
        this.guardianDescription = username + password + email + SSN + accessLevel;

   }
}