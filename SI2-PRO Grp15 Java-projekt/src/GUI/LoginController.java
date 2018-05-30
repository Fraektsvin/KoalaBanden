/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.IUser;
import Business.LoggerStart;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
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

    private final static Logger logger = Logger.getLogger(LoggerStart.class.getName());

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Method checks if the username and password input exists in the database
     * and shows start user screen if input is correct.
     *
     * @param event
     */
    @FXML
    private void actionLogin(ActionEvent event) {
        // Read the input values for username and password.
        String username = loginuser.getText();
        String password = loginpass.getText();

        if ("".equals(username) || "".equals(password)) {
            statusLabel.setText("Status: Alle felter skal udfyldes.");
            logger.warning("Mislykkedes forsøg på login - felter mangler at udfyldes");
            return;
        }

        // Call login. Return value indicates status of login
        IUser user = GUIFacade.login(username, password);

        if (user == null) {
            // Could not login
            statusLabel.setText("Status: Fejl i brugernavn og/eller password");
            logger.warning("Fejl i brugernavn og/eller password");
            return;
        }

        GUIFacade.instance.showUserStartScreen(user);

        logger.info(username + " er logget ind som " + user.getAccessLevelString());
    }

    /**
     * Method executes actionLogin() method on ENTER pressed.
     *
     * @param event
     */
    @FXML
    private void handlePasswordTextfieldAction(ActionEvent event) {
        actionLogin(event);
    }

}
