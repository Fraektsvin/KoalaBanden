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
public interface IEnquiry {

    public int getID();

    public String getSource();

    public Date getDate();

    public String getDescription();

    public int getCitizenCPR();
}
