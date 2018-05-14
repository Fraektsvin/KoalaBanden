/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IEnquiry;
import Acquaintance.IBusiness;
import Acquaintance.ICaseOpening;
import java.util.Date;

/**
 *
 * @author finch
 */

public class Enquiry implements IEnquiry{
    
    private Date date;
    private int CPR;
    private String description;
    private Boolean isCitizenAgreed;
    
    

    public Enquiry(Date date, int CPR, String description, Boolean isCitizenAgreed) {
        this.date = date;
        this.CPR = CPR;
        this.description = description;
        this.isCitizenAgreed = isCitizenAgreed;
        
    }
    public void setCPR(int CPR) {
        this.CPR = CPR;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public int getCPR() {
        return CPR;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsCitizenAgreed() {
        return isCitizenAgreed;
    }

    public void setIsCitizenAgreed(Boolean isCitizenAgreed) {
        this.isCitizenAgreed = isCitizenAgreed;
    }
}
    
    
   


