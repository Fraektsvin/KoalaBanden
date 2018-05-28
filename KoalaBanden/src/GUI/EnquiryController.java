/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business.LoggerStart;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jonas
 */
public class EnquiryController implements Initializable {

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
    @FXML
    private JFXButton returnButton;

    private Boolean citizenAlreadyRegistered = false;

    private final static Logger logger = Logger.getLogger(LoggerStart.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dateField.setText(new Date(Calendar.getInstance().getTime().getTime()).toString());

    }

    /**
     * Method creates a enquiry & citizen in the database based on input.
     *
     * @param event
     * @throws SQLException
     */
    @FXML
    private void createEnquiry(ActionEvent event) throws SQLException {

        // Opretter henvendelsen i databasen.
        GUIFacade.business.getCaseworker().registerEnquiry((GUIFacade.business.getCaseworker().getEnquiries().size() + 1), sourceField.getText(), new java.sql.Date(Calendar.getInstance().getTime().getTime()), descriptionField.getText(), Integer.parseInt(CPRTextField1.getText() + CPRTextField2.getText()));
        GUIFacade.business.getCaseworker().createCitizen(Integer.parseInt(CPRTextField1.getText() + CPRTextField2.getText()), addressField.getText(), emailField.getText(), Integer.parseInt(phoneNumberField.getText()), nameField.getText(), lastNameField.getText());
        statusLabel.setText("Status: Henvendelse oprettet.");
        logger.info(GUIFacade.business.getCurrentUsername() + " oprettede ny henvendelse");
        logger.info(GUIFacade.business.getCurrentUsername() + " oprettede ny borger");

        // Tjekker om borgeren er registreret i systemet og opretter henvendelsen. 
//        for (int i = 0; i < GUIFacade.business.getCitizens().size(); i++) {
//            if (Integer.parseInt(CPRTextField1.getText() + CPRTextField2.getText()) == GUIFacade.business.getCitizens().get(i).getCpr()) {
//                statusLabel.setText("Status: Henvendelse oprettet til allerede eksisterende borger.");
//                logger.info(GUIFacade.business.getCurrentUsername() + " oprettede ny henvendelse");
//                citizenAlreadyRegistered = true;
//            }
//        }
    }

<<<<<<< HEAD
    /**
     * Method closes the current open FXML window.
     *
     * @param event
     */
=======
>>>>>>> b4ad264eae3cdb282158003acb345a3dc592f608
    @FXML
    private void HandleReturnButtonAction(ActionEvent event) {
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.close();
    }

}
