/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Antonio
 */
public class CaseInformation {
    private String citizenInformation; 
    private String caseworkerObservation; 
    private String informationFromOther; 
    private int functioning; 
    private ArrayList<Integer> treatedTopics = new ArrayList<Integer>(11);
    private String overallAssessment;
    
    public CaseInformation(String citizenInformation, String caseworkerObservation, String informationFromOther, int functioning, int treatedTopics, String overallAssesment ){
        this.citizenInformation = citizenInformation;
        this.caseworkerObservation = caseworkerObservation;
        this.informationFromOther = informationFromOther;
        
 
    }
}
