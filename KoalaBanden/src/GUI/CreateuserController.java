/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author laurabrinkholmjustesen
 */
public class CreateuserController implements Initializable {

    @FXML
    private JFXComboBox<String> accessLevelComboBox;
    @FXML
    private JFXTextField usernameTextField;
    @FXML
    private JFXTextField passwordTextField;
    @FXML
    private JFXTextField CPRTextField1;
    @FXML
    private JFXTextField CPRTextField2;
    @FXML
    private JFXButton createUserButton;
    @FXML
    private Label statusLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> accessLevelList = FXCollections.observableArrayList("Systemadministrator", "Sagsbehandler", "Borger", "Værge", "Partsrepræsentant");
        accessLevelComboBox.setItems(accessLevelList);
    }    

    @FXML
    private void handleCreateUserButtonAction(ActionEvent event) {
        String username = this.usernameTextField.getText();
        String password = this.passwordTextField.getText();
        String CPR = this.CPRTextField1.getText() + this.CPRTextField2.getText();
        String accessLevel = this.accessLevelComboBox.getValue();
        
        
    }
    
}
