/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jonas
 */
public class OpretSagController implements Initializable {

    @FXML
    private Label statusLabel;
    @FXML
    private TextField usernameTextField1;
    @FXML
    private JFXComboBox<?> accessLevelComboBox;
    @FXML
    private JFXButton naestebtn;
    @FXML
    private TextField usernameTextField11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
