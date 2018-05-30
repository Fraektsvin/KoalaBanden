/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.AccessLevel;
import Business.LoggerStart;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private TextField passwordTextField;
    @FXML
    private TextField CPRTextField1;
    @FXML
    private TextField CPRTextField2;
    @FXML
    private JFXButton createUserButton;
    @FXML
    private Label statusLabel;
    @FXML
    private TextField emailTextField;

    private final static Logger logger = Logger.getLogger(LoggerStart.class.getName());
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> accessLevelList = FXCollections.observableArrayList(GUIFacade.getAccessLevels());
        accessLevelComboBox.setItems(accessLevelList);
    }  
    /**
     * Method creates a user on button clicked and checks that all fields are filled out. 
     * @param event 
     */
    @FXML
    public void handleCreateUserButtonAction(ActionEvent event) {
        // Read values
        String username = this.usernameTextField.getText();
        String password = this.passwordTextField.getText();
        String email = this.emailTextField.getText();
        String CPR = this.CPRTextField1.getText() + this.CPRTextField2.getText();
        String accessLevel = this.accessLevelComboBox.getValue();
        
        boolean isUserCreated = false;
        
        if (!"".equals(username) && !"".equals(password) && !"".equals(email) && !"".equals(CPR) && !"".equals(accessLevel)) {
            // TODO: Parse access level from cobo box
            isUserCreated = GUIFacade.createUser(username, password, email, CPR, AccessLevel.valueOf(accessLevel.toUpperCase()));
        }
        else {
            statusLabel.setText("Status: Alle felter skal være udfyldt.");
            
            return;
        }
        
        if (isUserCreated){
            Stage stage = (Stage) createUserButton.getScene().getWindow();
            statusLabel.setText("Status: " + username + " er oprettet.");
            logger.info(username + " er oprettet som bruger under " + accessLevel);
        }
        else {
            statusLabel.setText("Status: En fejl er opstået. Prøv igen.");
            logger.warning("Fejl er opstået.");
        }
    }

    
}
