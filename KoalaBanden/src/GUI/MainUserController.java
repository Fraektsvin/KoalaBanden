/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

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
    private ListView<?> sagerListe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void seeCases(ActionEvent event) {
    }

    @FXML
    private void handleMyProfileButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleLogoutButtonAction(ActionEvent event) {
    }
    
}
