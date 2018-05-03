/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICaseOpening;
import Acquaintance.IUser;
import java.util.ArrayList;
import Business.Guardian;

/**
 * 
 * @author Jonas
 */
public abstract class CaseOpening implements ICaseOpening {
    private String  caseDescription; 
    private boolean isSoughtHelpClear;
    private boolean isInformedAboutRepresentationRights;
    private boolean isInformedAboutElectronicRegistration;
    private String  progressAgreement;
    private boolean isConsentRelevant;
    private String  citizenInvolvementSpecialCircumstances;
    private String  actingMunicipality; 
    private String  payingMunicipality;
    
   // private ArrayList<Guardian> guardianList;
    private ArrayList<Guardian> guardianlist = new ArrayList<>();

    public CaseOpening() {
        
    }
    
    private void addGuardian(Guardian guardian) {
        for (int i = 0; i < this.guardianlist.size(); i++) {
           guardianlist.get(i).getGuardianDescription();
           guardianlist.add(guardian);  
        }
    }
    
    
   
    private void addRepresentative() {
        
    }
    
    private void createEnquiry() {
        
    }
    
    private void addService() { 
        
    }
    
    private void addOffer() {
        
    }
    
    
    
    
    
    
    
}
