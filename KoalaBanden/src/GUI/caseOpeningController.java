/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import Acquaintance.*;
import Business.Guardian;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import static javafx.scene.input.KeyCode.T;



public class caseOpeningController<T> extends ComboBox<T> implements Initializable {
private ArrayList<Guardian> guardianlist = new ArrayList<Guardian>();
   

    @FXML
    private CheckBox Borger;
    @FXML
    private CheckBox Pårørende;
    @FXML
    private CheckBox Læge;
    @FXML
    private CheckBox Hospital;
    @FXML
    private CheckBox andenForvaltning;
    @FXML
    private CheckBox igangværendeIndsats;
    @FXML
    private CheckBox andenKommune;
    @FXML
    private CheckBox andre;

    @FXML   
    private JFXComboBox text;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    @FXML
   public void addGuardian(ActionEvent event) throws IOException {
        text.getItems().addAll(guardianlist);
        
        
}}
    
           
    
             
     

  
