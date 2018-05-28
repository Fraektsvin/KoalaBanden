/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.IEnquiry;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jonas
 */
public class createCaseController implements Initializable {

    @FXML
    private Label statusLabel;
    @FXML
    private JFXButton naestebtn;
    @FXML
    private TextField responsibleCaseworkerField;
    @FXML
    private JFXComboBox<String> enquiryIDList;
    @FXML
    private TextField dateField;
    
    private int caseID;
    @FXML
    private Label sagsStatusText;
    
    private int caseNumber;
    
 
    
    

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb)  {
        // TODO
        dateField.setText(new java.sql.Date(Calendar.getInstance().getTime().getTime()).toString());
        responsibleCaseworkerField.setText(GUIFacade.business.getCurrentUsername());
        try {
            // Loopet kører fra getCases().size() tallet, som er alle cases med en enquiry på. Loopet tager altså alle de enquiries, som ikke har en case.
                for (int j = GUIFacade.business.getCases().size(); j < GUIFacade.business.getEnquiries().size(); j++) {
                          enquiryIDList.getItems().add("Henvendelses ID: "  + Integer.toString(GUIFacade.business.getCaseworker().getEnquiries().get(j).getID()) + "   " +  "Borger CPR: " + Integer.toString(GUIFacade.business.getCaseworker().getEnquiries().get(j).getCitizenCPR()));             
                     }
                     
        
            
            
        } catch(SQLException e) {
        e.printStackTrace();
    }
    
       
    }    

    @FXML
    private void createCaseButtonAction(ActionEvent event) throws IOException {  
        try {
        GUIFacade.business.getCaseworker().createCase(GUIFacade.business.getCases().size() + 1, GUIFacade.business.getEnquiries().get(enquiryIDList.getSelectionModel().getSelectedIndex()).getID(), GUIFacade.business.getEnquiries().get(enquiryIDList.getSelectionModel().getSelectedIndex()).getCitizenCPR(), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), GUIFacade.business.getCurrentUsername(), GUIFacade.business.getCurrentUsername());
        Stage stage = (Stage) naestebtn.getScene().getWindow();
        stage.close();
        GUIFacade.instance.showCaseOpeningScene();
        
        } catch(IOException e) {
            e.printStackTrace();
        }
            
       

    
    }  
}
