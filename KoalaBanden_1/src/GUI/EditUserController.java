/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.IUser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author laurabrinkholmjustesen
 */
public class EditUserController implements Initializable {

    @FXML
    private Label statusLabel;
    @FXML
    private JFXTextField emailTextField;
    @FXML
    private JFXTextField usernameTextField;
    @FXML
    private JFXTextField passwordTextField;
    @FXML
    private JFXTextField CPRTextField1;
    @FXML
    private JFXTextField CPRTextField2;
    @FXML
    private JFXButton editUserButton;
    @FXML
    private JFXTextField accessLevelTextField;
    private IUser user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String username = GUIFacade.currentUsername;
        user = GUIFacade.business.getUser(username);
        usernameTextField.setText(user.getUsername());
        passwordTextField.setText(user.getPassword());
        emailTextField.setText(user.getEmail());
        String CPR = user.getCPR() + "";
        CPRTextField1.setText(CPR.substring(0, 7));
        CPRTextField2.setText(CPR.substring(7));
        accessLevelTextField.setText(user.getAccessLevelString());
        
    }    

    @FXML
    private void handleEditUserButtonAction(ActionEvent event) {
        String password = passwordTextField.getText();
        String email = emailTextField.getText();
        if (!"".equals(password) && !"".equals(email)) {
            user.setPassword(password);
            user.setEmail(email);
            statusLabel.setText("Status: Brugerinformationer er opdateret.");
        }
        else {
            statusLabel.setText("Status: Alle felter skal udfyldes.");
        }
    }
    
}
