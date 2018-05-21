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
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.WindowEvent;

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
    @FXML
    private Label userlistDate;
    @FXML
    private Label userlistMonth;
    
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
        GUIFacade.business.getUsers().remove(username);
    }
    
    @FXML
    private void handleEditUserButtonAction(ActionEvent event) {
        // Stores the old username to temporarily set the logged in user to the selected user.
        String oldUsername = GUIFacade.business.getCurrentUsername();
        // Makes sure that a user is selected in the listView or it would set the logged in user to null and cause and error.
        if(!userListView.getSelectionModel().isEmpty()) {
        // Stores the original username in a string.
        String username = userListView.getSelectionModel().getSelectedItem();
        // Sets the user logged in to be the selected one in the userListView, so that we can edit the user info.
        GUIFacade.business.setUser(username);
            try {
                logger.info(GUIFacade.business.getCurrentUsername() + "Bruger manager åbnet");
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editUser.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                // Makes sure that no other action can be done while edit user scene is open.
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                // Sets the user back to the real user logged in on scene close.
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    public void handle(WindowEvent we) {
                        GUIFacade.business.setUser(oldUsername);
                    }
                    
                });                
            } catch (IOException io) {
                io.printStackTrace();
            }
        } else {
          statusLabel.setText("Status: Vælg en bruger.");  
        }       
        
  
        this.updateUserList();
    }
    
    private void updateUserList() {
        userListView.getItems().clear();        
        logger.info("Brugerliste opdateret");
        for (int i = 0; i < GUIFacade.business.getUsers().size(); i++) {
            userListView.getItems().add(GUIFacade.business.getUsers().get(i).getUsername());            
        }
        
    }
    
    @FXML
    private void handleUpdateListButton(ActionEvent event) {
        this.updateUserList();
        logger.info("Brugerliste opdateret");
    }
    
}
