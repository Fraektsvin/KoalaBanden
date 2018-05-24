/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICaseOpening;
import Acquaintance.IUser;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jonas
 */
public class CaseOpening implements ICaseOpening {

    private final Enquiry EN;
    private final Case C;
    private String guardianDescription;
    private String username;
    private String Address;
    private String Firstname;
    private String Lastname;
    private String Nationality;
    private int phoneNumber;
    private final String CitizenDescription;

    public CaseOpening(Enquiry EN, Case C, String guardianDescription, String username, String Address, String Firstname, String Lastname, String Nationality, int phoneNumber, Map<String, IUser> userMap) {
        this.EN = EN;
        this.C = C;
        this.guardianDescription = guardianDescription;
        this.username = username;
        this.Address = Address;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Nationality = Nationality;
        this.phoneNumber = phoneNumber;
        this.CitizenDescription = username + Address + Firstname + Lastname + Nationality + phoneNumber;
    }

    //  public CaseOpening(ResultSet rs) {
    //  }
    public String getCitizenDescription() {
        return CitizenDescription;
    }

    // private ArrayList<Guardian> guardianList;
//    public ArrayList<Guardian> guardianlist = new ArrayList<Guardian>();
//    public Guardian newGuardian = new Guardian("31313", "12113", "12313", 3, AccessLevel.SAGSBEHANDLER);
//    public ArrayList<Enquiry> EnquiryList = new ArrayList<Enquiry>();
//    public final HashMap<Integer, String> CPRS = new HashMap<>();
//    public ArrayList<Guardian> AddGuardian(Guardian guardian) {
//            guardianlist.add(guardian);
//        
//        return guardianlist;
//    }
//    public ArrayList<Guardian>GetGuardian() {
//        return guardianlist;
//    }
    public void saveCPR(Citizen citizen) {
        //  int CPR = citizen.;
        //  CPRS.put(CPR, CitizenDescription);
        //for(int i=0; i < CPRS.size(); i++) {
        //if(!CPRSget(getCitizenDescription().equals(Citizen)) {

    }

//    public HashMap getCPRSMAP() {
//        return CPRS;
//    }
//    @Override
//    public void createEnquiry() {
//        if (EN.getDescription() != null) {
//            EnquiryList.add(EN);
//        }
//    }
    private void addService() {

    }

    private void addOffer() {

    }

    @Override
    public void createEnquiry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap getCPRSMAP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
