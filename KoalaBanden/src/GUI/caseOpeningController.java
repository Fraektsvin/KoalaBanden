/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Business.Guardian;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import Acquaintance.*;
import java.util.ArrayList;


public class caseOpeningController implements Initializable {
private ArrayList<Guardian> guardianlist = new ArrayList<Guardian>();
   

    @FXML   
    private JFXComboBox text;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    @FXML
   public void addGuardian(ActionEvent event) throws IOException {
        text.getItems().addAll(guardianlist);
        
}}
    
           
    
             
     

  
