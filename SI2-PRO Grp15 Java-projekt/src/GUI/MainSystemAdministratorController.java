/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business.LoggerStart;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author viktorianadarajah
 */
public class MainSystemAdministratorController implements Initializable {

    @FXML
    private JFXButton frontPageButton;
    @FXML
    private JFXButton userButton;
    @FXML
    private JFXButton myProfileButton;
    @FXML
    private JFXButton logoutButton;
    @FXML
    private VBox news_scroll;

    private Parent root;
    private Scene scene;

    private static final Logger logger = Logger.getLogger(LoggerStart.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * @see GUIFacade#instance#showUserListScene()
     * @param event
     */
    @FXML
    private void handleUserButtonAction(ActionEvent event) {
        try {
            logger.info(GUIFacade.business.getCurrentUsername() + " åbnede brugerliste");
            GUIFacade.instance.showUserListScene();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    /**
     * @see GUIFacade#instance#showEditUserScene()
     * @param event
     */
    @FXML
    private void handleMyProfileButtonAction(ActionEvent event) {
        GUIFacade.currentUsername = GUIFacade.business.getCurrentUsername();
        try {
            logger.info(GUIFacade.business.getCurrentUsername() + " åbnede brugermanager");
            GUIFacade.instance.showEditUserScene();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    /**
     * @see GUIFacade#instance#instance#showLoginScene()
     * @param event
     */
    @FXML
    private void handleLogoutButtonAction(ActionEvent event) {
        try {
            logger.info(GUIFacade.business.getCurrentUsername() + " er logget ud");
            GUIFacade.instance.showLoginScene();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @see GUIFacade#instance#showLogScene()
     * @param event
     */
    @FXML
    private void handleLogButtonAction(ActionEvent event) {
        try {
            logger.info(GUIFacade.business.getCurrentUsername() + " åbnede log listen");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException io) {
            io.printStackTrace();
        }

    }

}
