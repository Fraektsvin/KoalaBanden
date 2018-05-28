/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.AccessLevel;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author trium
 */
public class mainController implements Initializable {

    @FXML
    private VBox news_scroll;

    @FXML
    private JFXButton opretbtn;

    @FXML
    private Label sager;
    @FXML
    private ListView<String> sagerListe;
    @FXML
    private JFXButton logoutButton;

    private Parent root;
    private Scene scene;
    @FXML
    private JFXButton userButton;
    @FXML
    private JFXButton frontPageButton;
    @FXML
    private JFXButton casesButton;
    @FXML
    private JFXButton enquiryButton;
    @FXML
    private JFXButton administratorButton;

    private final static Logger logger = Logger.getLogger(LoggerStart.class.getName());

    private void handleButtonAction(MouseEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AccessLevel currentAccessLevel = GUIFacade.business.getCurrentAccessLevel();
        switch (currentAccessLevel) {
            case SYSTEMADMINISTRATOR:
                opretbtn.setVisible(false);
                casesButton.setVisible(false);
                enquiryButton.setVisible(false);
                userButton.setVisible(true);
                break;
            case SAGSBEHANDLER:
                opretbtn.setVisible(true);
                casesButton.setVisible(true);
                enquiryButton.setVisible(true);
                userButton.setVisible(false);
                break;
            case PARTSREPRÆSENTANT:
                opretbtn.setVisible(false);
                casesButton.setVisible(true);
                enquiryButton.setVisible(false);
                userButton.setVisible(false);
                break;
            default:
                break;
        }
    }

    /**
     * Method gets the list of cases from the data package through the
     * BusinessFacade and adds them to the ListView one by one.
     *
     * @param event
     */
    @FXML
    private void seeCases(ActionEvent event) {
        // Resets the list containing items everytime method is called.
        sagerListe.getItems().clear();
        logger.info("Se sager åbnet");
        // Adds every case ID from the case hashMap file to file sagerListe list. 
        for (int i = 1; i < GUIFacade.business.getCases().size(); i++) {
            sagerListe.getItems().add("Sag: " + i);
        }
    }

    /**
     * @see GUIFacade#instance#showLoginScene()
     * @param event
     */
    @FXML
    private void handleLogoutButtonAction(ActionEvent event) {
        try {
            logger.info(GUIFacade.business.getCurrentUsername() + " Logged ud");
            GUIFacade.instance.showLoginScene();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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

}
