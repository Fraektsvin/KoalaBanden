/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.IUser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.updateUserList();
    }    

    @FXML
    private void handleReturnButtonAction(ActionEvent event) {
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleCreateUserButtonAction(ActionEvent event) {
        try {
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
        this.updateUserList();
    }

    @FXML
    private void handleEditUserButtonAction(ActionEvent event) {
        this.updateUserList();
    }
    
    private void updateUserList() {
        userListView.getItems().clear(); 
        
        Map<String, IUser> userMap = GUIFacade.getUsers();
        for (Map.Entry<String, IUser> entry : userMap.entrySet()) {
            userListView.getItems().add(entry.getKey());
        }
    }
    
}
