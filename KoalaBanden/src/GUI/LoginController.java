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

    private final static Logger logger = Logger.getLogger(LoggerStart.class.getName());

    public LoginController() {
        System.out.println("Test");
    }

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
        
        if("".equals(username) || "".equals(password)) {
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


        
/*        // Act according to login status
        switch(i) {
            // An error has occurred
            case 0:
                // Inform user of error and break
                statusLabel.setText("Status: Fejl i brugernavn og/eller password");
                logger.warning("Fejl i brugernavn og/eller password");
                break;
            // System administrator login
            case 1:
                try {
                    logger.info(username + " er logget ind som system admin");
                    root = FXMLLoader.load(getClass().getResource("mainSystemAdministrator.fxml"));
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
            case 2:
                try {
                    logger.info(username + " er logget ind som sagsbehandler");
                    root = FXMLLoader.load(getClass().getResource("mainCaseWorker.fxml"));
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
            case 3:
            case 4:
            case 5:
                try {
                    logger.info(username + " er logget ind som borger");
                    root = FXMLLoader.load(getClass().getResource("mainUser.fxml"));
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
            default:
                statusLabel.setText("Status: Der er sket en fejl.");
                logger.warning("Der er sket en fejl.");
                break;
        }*/
    }

    @FXML
    private void handlePasswordTextfieldAction(ActionEvent event) {
        actionLogin(event);
    }
    
}
