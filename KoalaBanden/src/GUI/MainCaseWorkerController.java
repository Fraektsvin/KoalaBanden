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
import java.sql.Date;
import java.util.Calendar;
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

    @FXML
    private void createCase(ActionEvent event) {
        GUIFacade.business.getCaseworker().createCase(0, (GUIFacade.business.getData().getCases().size() + 1), new Date(Calendar.getInstance().getTime().getTime()), new Date(Calendar.getInstance().getTime().getTime()), GUIFacade.business.getCurrentUsername());
        try {
            logger.info("Sag oprettet af " + GUIFacade.business.getCurrentUsername());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("caseOpening.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @FXML
    private void seeCases(ActionEvent event) {
        // Resets the list containing items everytime method is called.
        sagerListe.getItems().clear();
        // Adds every case ID from the case hashMap to sagerListe list. 
        for (int i = 0; i < GUIFacade.business.getCases().size(); i++) {
            sagerListe.getItems().add("Sag: " + GUIFacade.business.getCases().get(i).getSSN());
            logger.info("Se sager åbnet");
        }
    }

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

    @FXML
    private void handleMyProfileButtonAction(ActionEvent event) {
        GUIFacade.currentUsername = GUIFacade.business.getCurrentUsername();
        try {
            logger.info(GUIFacade.business.getCurrentUsername() + " åbnede sin egen profil");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editUser.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @FXML
    private void createEnquiry(ActionEvent event) throws IOException {
        try {
            logger.info(GUIFacade.business.getCurrentUsername() + " åbnede en ny henvendelse");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Enquiry.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException io) {
            io.printStackTrace();
        }
//        GUIFacade.instance.showEnquiryScene();
    }

    @FXML
    private void handleUserButtonAction(ActionEvent event) {
    }

}
