/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author finch
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField loginuser;
    @FXML
    private JFXTextField loginpass;
    @FXML
    private Label statusLabel;
    
    private Parent root;
    private Scene scene;
    
    @FXML
    private JFXButton loginButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionLogin(ActionEvent event) {
        // Read the input values for username and password.
        String username = loginuser.getText();
        String password = loginpass.getText();
        
        // Call login. Return value indicates status of login
        int i = GUIFacade.login(username, password);
        
        // Act according to login status
        switch(i) {
            // An error has occurred
            case 0:
                // Inform user of error and break
                statusLabel.setText("Fejl");
                break;
            // Caseworker login
            default:
                try {
                    root = FXMLLoader.load(getClass().getResource("main.fxml"));
                    
                    scene = loginButton.getScene();
                    Stage stage = (Stage)scene.getWindow();
                    stage.setWidth(1257);
                    stage.setHeight(763);
                    stage.centerOnScreen();
                    scene.setRoot(root);
                    
                   
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
                
        }
    }

    @FXML
    private void handlePasswordTextfieldAction(ActionEvent event) {
        actionLogin(event);
    }
    
}
