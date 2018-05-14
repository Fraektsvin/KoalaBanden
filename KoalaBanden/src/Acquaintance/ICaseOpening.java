/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import Business.Enquiry;
import Business.Guardian;
import java.util.ArrayList;
import java.util.HashMap;

public interface ICaseOpening {

    public ArrayList<Guardian> AddGuardian(Guardian guardian);
    public void createEnquiry();

}
