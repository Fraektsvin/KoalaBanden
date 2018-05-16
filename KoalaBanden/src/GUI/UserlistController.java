/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.IUser;
import Business.LoggerStart;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.Calendar;

/**
 * FXML Controller class
 *
 * @author trium
 */
public class UserlistController implements Initializable {

    @FXML
    private JFXButton returnButton;
    @FXML
    private JFXButton createUserButton;
    @FXML
    private JFXButton deleteUser;
    @FXML
    private JFXButton editUserButton;
    @FXML
    private JFXListView<String> userListView;
    @FXML
    private Label statusLabel;
    @FXML
    private JFXButton updateListButton;

    private final static Logger logger = Logger.getLogger(LoggerStart.class.getName());
    
    Calendar calendar = Calendar.getInstance();
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.updateUserList();
        System.out.println("Dags dato: " + calendar.get(Calendar.DATE));
    }    

    @FXML
    private void handleReturnButtonAction(ActionEvent event) {
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleCreateUserButtonAction(ActionEvent event) {
        try {
            logger.info(GUIFacade.business.getCurrentUsername() + " åbnede lav bruger værktøjet");

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createuser.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @FXML
    private void handleDeleteUserButton(ActionEvent event) {
        String username = userListView.getSelectionModel().getSelectedItem();
        GUIFacade.business.deleteUser(username);
        this.updateUserList();
        statusLabel.setText("Status: " + username + " er slettet.");
        logger.info(username + " er blevet slettet");
    }

    @FXML
    private void handleEditUserButtonAction(ActionEvent event) {
        String username = userListView.getSelectionModel().getSelectedItem();
        GUIFacade.currentUsername = username;
        
        if (username != null) {
            try {
                logger.info(GUIFacade.business.getCurrentUsername() + "Bruger manager åbnet");

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editUser.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
        else {
            statusLabel.setText("Status: Vælg en bruger.");
        }
        
        this.updateUserList();
    }
    
    private void updateUserList() {
        userListView.getItems().clear(); 
        logger.info("Brugerliste opdateret");
        Map<String, IUser> userMap = GUIFacade.getUsers();
        for (Map.Entry<String, IUser> entry : userMap.entrySet()) {
            userListView.getItems().add(entry.getKey());
        }
    }

    @FXML
    private void handleUpdateListButton(ActionEvent event) {
        this.updateUserList();
        logger.info("Brugerliste opdateret");
    }
    
}
