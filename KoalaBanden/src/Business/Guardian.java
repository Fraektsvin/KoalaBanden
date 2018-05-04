/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IGuardian;

/**
 *
 * @author Jonas
 */
public abstract class Guardian extends User implements IGuardian {
    private String type;
    private String address;
    private String caseInformation; 
    
    private String username;
    private String password;
    private String email;
    private int SSN;
    private int accessLevel;
    private String firstName;
    private String lastName;
    private String DOB;
    private String phonenumber;
    private String PostalCode;
    private String guardianDescription;
    
    
    public Guardian(String username, String password, String email, int SSN, String guardianDescription, int accessLevel, String type, String address, String caseInformation, String PostalCode, String firstName, String lastName, String phonenumber, String DOB) {
          super(username, password, email, SSN, accessLevel);
        
        
        this.type = type;
        this.address = address;
        this.caseInformation = caseInformation;
        this.email = email;
        this.SSN = SSN;
        this.accessLevel = accessLevel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.PostalCode = PostalCode;
        this.phonenumber = phonenumber;
        this.guardianDescription = firstName + " " + lastName;
        
        
        
    }


    public String getGuardianDescription() {
        return guardianDescription;
    }

    public void setGuardianDescription(String guardianDescription) {
        this.guardianDescription = guardianDescription;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCaseInformation() {
        return caseInformation;
    }

    public void setCaseInformation(String caseInformation) {
        this.caseInformation = caseInformation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
   // public int getSSN() {
     //   return  SSN;
    //}
    
    
    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
    
   private String getCaseinformation() {
      return caseInformation;
   }
   
   public void setGuardianData(String username, String password, String email, String guardianDescription, int SSN, int accessLevel, String type, String address, String caseInformation, String firstName, String lastName, String DOB, String phonenumber, String PostalCode) {
       
        this.type = type;
        this.address = address;
        this.caseInformation = caseInformation;
        this.email = email;
        this.SSN = SSN;
        this.accessLevel = accessLevel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.PostalCode = PostalCode;
        this.phonenumber = phonenumber;
        this.guardianDescription = guardianDescription;
      
       
   }
    
    
    
     
}
