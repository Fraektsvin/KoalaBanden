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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author viktorianadarajah
 */
public class MainUserController implements Initializable {

    @FXML
    private JFXButton frontPageButton;
    @FXML
    private JFXButton casesButton;
    @FXML
    private JFXButton myProfileButton;
    @FXML
    private JFXButton logoutButton;
    @FXML
    private VBox news_scroll;
    @FXML
    private Label sager;
    @FXML
    private ListView<String> sagerListe;

    private Parent root;
    private Scene scene;

    private final static Logger logger = Logger.getLogger(LoggerStart.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Method gets all cases belonging to the user from the database through the
     * BusinessFacade and adds them to a ListView one by one.
     *
     * @param event
     */
    @FXML
    private void seeCases(ActionEvent event) {
        // Resets the list containing items everytime method is called.
        sagerListe.getItems().clear();
        // Adds every case ID from the case hashMap file to file sagerListe list. 
        for (int i = 0; i < GUIFacade.business.getCases().size(); i++) {
            if (GUIFacade.business.getUser(GUIFacade.business.getCurrentUsername()).getCPR() == GUIFacade.business.getCases().get(i).getCitizencpr()) {
                //If statement checks which cases belong to the user by comparing citizencpr() with the cases and prints it

                sagerListe.getItems().add("Sags ID: "
                        + GUIFacade.business.getCases().get(i).getId()
                        + "    CPR: " + GUIFacade.business.getCases().get(i).getCitizencpr()
                        + "    Sagsbehandler: " + GUIFacade.business.getCases().get(i).getUsersusername()
                        + "    Registreret: " + GUIFacade.business.getCases().get(i).getDateCreated()
                        + "    Sidst ændret: " + GUIFacade.business.getCases().get(i).getLastModified()
                        + "    Henvendelses ID: " + GUIFacade.business.getCases().get(i).getEnquiryid());
                logger.info(GUIFacade.business.getCurrentUsername() + " åbnet se sager");
            }
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
     * @see GUIFacade#instance#showLoginScene()
     * @param event
     */
    @FXML
    private void handleLogoutButtonAction(ActionEvent event) {
        try {
            logger.info(GUIFacade.business.getCurrentUsername() + " er logget ud");
            GUIFacade.instance.showLoginScene();
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
