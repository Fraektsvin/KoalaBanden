/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICaseworker;
import Acquaintance.IData;

/**
 *
 * @author finch
 */
public class Caseworker extends User implements ICaseworker {

    // Data field
    private IData data;
    private int ID;

    // Constructor
    public Caseworker(String username, String password, String email, int SSN, int accessLevel) {
        super(username, password, email, SSN, accessLevel);
    }

    // Methods
    public void createCase(int citizenSSN) {
        BusinessFacade.data.saveCase(new Case(citizenSSN));
        System.out.println("ghfghfg");
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
