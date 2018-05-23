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
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
        refreshNodes();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Initialize not called when changing scenes
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
        // refreshNodes();
    }

    private void refreshNodes() {
        news_scroll.getChildren().clear();

        Node[] nodes = new Node[15];

        for (int i = 0; i < 10; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("news.fxml"));
                news_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void createCase(ActionEvent event) {
        
        try {
             logger.info(GUIFacade.business.getCurrentUsername() + " åbnede opret sag");

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("caseOpening.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException io) {
            io.printStackTrace();
        }

    }

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

    private void userlist(ActionEvent even) {
        try {
            logger.info("brugerliste åbnet");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userlist.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @FXML
    private void handleLogoutButtonAction(ActionEvent event) {
        try {
            logger.info(GUIFacade.business.getCurrentUsername() + " JoLogged ud");

            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            scene = logoutButton.getScene();
            Stage stage = (Stage)scene.getWindow();
            stage.setWidth(494);
            stage.setHeight(472);
            stage.centerOnScreen();
            scene.setRoot(root);
            scene.getRoot().requestFocus();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
    }

    @FXML
    private void handleUserButtonAction(ActionEvent event) {
        try {
            logger.info(GUIFacade.business.getCurrentUsername() + " åbnede brugerliste");

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userlist.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

}
