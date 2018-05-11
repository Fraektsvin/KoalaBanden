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
import javafx.stage.Stage;

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
    @FXML
    private JFXTextField emailTextField;

    private final String SYSTEM_ADMINISTRATOR = "Systemadministrator";
    private final String SAGSBEHANDLER = "Sagsbehandler";
    private final String BORGER = "Borger";
    private final String VÆRGE = "Værge";
    private final String PARTSREPRÆSENTANT = "Partsrepræsentant";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> accessLevelList = FXCollections.observableArrayList(SYSTEM_ADMINISTRATOR, SAGSBEHANDLER, BORGER, VÆRGE, PARTSREPRÆSENTANT);
        accessLevelComboBox.setItems(accessLevelList);
    }    

    @FXML
    private void handleCreateUserButtonAction(ActionEvent event) {
        // Read values
        String username = this.usernameTextField.getText();
        String password = this.passwordTextField.getText();
        String email = this.emailTextField.getText();
        String CPRString = this.CPRTextField1.getText() + this.CPRTextField2.getText();
        String accessLevelString = this.accessLevelComboBox.getValue();
        
        boolean hasErrorOccurred = false;
        
        int CPR = 0;
        try {
            CPR = Integer.parseInt(CPRString);
        }
        catch (NumberFormatException ex) {
            hasErrorOccurred = true;
            this.statusLabel.setText("Status: Forkert CPR.");
        }
        
        int accessLevel;
        
        switch(accessLevelString) {
            case SYSTEM_ADMINISTRATOR:
                accessLevel = 1;
                break;
            case SAGSBEHANDLER:
                accessLevel = 2;
                break;
            case BORGER:
                accessLevel = 3;
                break;
            case VÆRGE:
                accessLevel = 4;
                break;
            case PARTSREPRÆSENTANT:
                accessLevel = 5;
                break;
            default:
                accessLevel = 0;
                hasErrorOccurred = true;
                break;
        }
        
        if (!hasErrorOccurred) {
            GUIFacade.createUser(username, password, email, CPR, accessLevel);
        }
        else {
            this.statusLabel.setText("Status: Der er sket en fejl. Prøv igen.");
        }
        
        Stage stage = (Stage) createUserButton.getScene().getWindow();
        stage.close();
    }
    
}
