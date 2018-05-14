/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleUserButtonAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userlist.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @FXML
    private void handleMyProfileButtonAction(ActionEvent event) {
        GUIFacade.currentUsername = GUIFacade.business.getCurrentUsername();
        try {
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
    private void handleLogoutButtonAction(ActionEvent event) {
        try {
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
    
}
