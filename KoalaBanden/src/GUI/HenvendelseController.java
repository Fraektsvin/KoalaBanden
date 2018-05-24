/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.AccessLevel;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jonas
 */
public class HenvendelseController implements Initializable {

    @FXML
    private Label statusLabel;
    @FXML
    private TextField CPRTextField1;
    @FXML
    private TextField CPRTextField2;
    @FXML
    private TextField nameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField sourceField;
    @FXML
    private TextField dateField;
    @FXML
    private TextArea descriptionField;
    @FXML
    private JFXButton createButton;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneNumberField;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       dateField.setText(new Date(Calendar.getInstance().getTime().getTime()).toString());
        
    }    

    @FXML
    private void createEnquiry(ActionEvent event) throws SQLException {
        GUIFacade.business.getCaseworker().registerEnquiry((GUIFacade.business.getCaseworker().getEnquiries().size() + 1), sourceField.getText(),new java.sql.Date(Calendar.getInstance().getTime().getTime()), descriptionField.getText(), Integer.parseInt(CPRTextField1.getText() + CPRTextField2.getText()));
        GUIFacade.business.getCaseworker().createCitizen(Integer.parseInt(CPRTextField1.getText() + CPRTextField2.getText()), addressField.getText(), emailField.getText(), Integer.parseInt(phoneNumberField.getText()), nameField.getText(), lastNameField.getText());
    }
    
}
