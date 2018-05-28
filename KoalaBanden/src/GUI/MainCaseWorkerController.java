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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author viktorianadarajah
 */
public class MainCaseWorkerController implements Initializable {

    @FXML
    private JFXButton frontPageButton;
    @FXML
    private JFXButton opretbtn;
    @FXML
    private JFXButton casesButton;
    @FXML
    private JFXButton enquiryButton;
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
    @FXML
    private JFXButton myProfileButton;

    private final static Logger logger = Logger.getLogger(LoggerStart.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * @see GUIFacade#instance#showCreateCaseScene()
     * @param event
     */
    @FXML
    private void createCase(ActionEvent event) {
        try {
            logger.info(" Opret sag startet af:  " + GUIFacade.business.getCurrentUsername());
            GUIFacade.instance.showCreateCaseScene();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    /**
     * Method loops through all cases in the database and adds them to the list if any of them are connected to the caseworker.
     * @param event
     */
    @FXML
    private void seeCases(ActionEvent event) {
        // Resets the list containing items everytime method is called.
        sagerListe.getItems().clear();
        // Adds every case ID from the case hashMap to sagerListe list. 
        for (int i = 0; i < GUIFacade.business.getCases().size(); i++) {
           if(GUIFacade.business.getCurrentUsername().equals(GUIFacade.business.getCases().get(i).getUsersusername())) {
           //if statements checks currentl users username and checks if it equals caseworkers username, this will print all cases belonging to the right username
            sagerListe.getItems().add("Sags ID: "
            + GUIFacade.business.getCases().get(i).getId()
            + "    CPR: " + GUIFacade.business.getCases().get(i).getCitizencpr()
            + "    Sagsbehandler: " + GUIFacade.business.getCases().get(i).getUsersusername()
            + "    Registreret: " + GUIFacade.business.getCases().get(i).getDateCreated()
            + "    Sidst ændret: " + GUIFacade.business.getCases().get(i).getLastModified()
            + "    Henvendelses ID: " + GUIFacade.business.getCases().get(i).getEnquiryid());
            logger.info(GUIFacade.currentUsername + " har åbnet se sager.");
        }
        }
    }

    /**
     * Method sets the scene to login.fxml.
     *
     * @param event
     */
    @FXML
    private void handleLogoutButtonAction(ActionEvent event) {
        try {
            logger.info(GUIFacade.business.getCurrentUsername() + "Logged ud");
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            scene = logoutButton.getScene();
            Stage stage = (Stage) scene.getWindow();
            stage.setWidth(494);
            stage.setHeight(472);
            stage.centerOnScreen();
            scene.setRoot(root);
            scene.getRoot().requestFocus();
        } catch (IOException ex) {
            ex.printStackTrace();
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
            logger.info(GUIFacade.business.getCurrentUsername() + " åbnede sin egen profil");
            GUIFacade.instance.showEditUserScene();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    /**
     * @see GUIFacade#instance#showEnquiryScene()
     * @param event
     * @throws IOException
     */
    @FXML
    private void createEnquiry(ActionEvent event) throws IOException {
        try {
            logger.info(GUIFacade.business.getCurrentUsername() + " åbnede en ny henvendelse");
            GUIFacade.instance.showEnquiryScene();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
