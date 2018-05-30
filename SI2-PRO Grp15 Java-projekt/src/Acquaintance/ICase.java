/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.Date;

/**
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
 */
public interface ICase {

  
    public int getId();
    public int getEnquiryid();
    public int getCitizencpr();
    public Date getDateCreated();
    public Date getLastModified();
    public String getLastModifiedBy();
    public String getUsersusername();
    

}
