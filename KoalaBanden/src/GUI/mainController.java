/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeView;
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
    

    private void handleButtonAction(MouseEvent event) {
        refreshNodes();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

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
        GUIFacade.business.createCaseworker("abc", "abc", "abc", 0, 0);
        GUIFacade.business.getCaseworker().createCase(12);
        try {
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
        // Adds every case ID from the case hashMap file to file sagerListe list. 
        for (int i = 1; i < GUIFacade.business.getCases().size(); i++) {
            sagerListe.getItems().add("Sag: " + i);
    }
    }

    private void userlist(ActionEvent even) {
        try {
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
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            scene = logoutButton.getScene();
            scene.setRoot(root);
            scene.getRoot().requestFocus();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
    }

}
