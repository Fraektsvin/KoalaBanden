/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.Date;

/**
 *
 * @author Antonio
 */
public interface IEnquiry {
    
   Date getDate();
   int getCPR();
   String getDescription();
   Boolean getIsCitizenAgreed();     
   void setCPR(int CPR);
   void setIsCitizenAgreed(Boolean isCitizenAgreed);
   void setDescription(String description);       
}
