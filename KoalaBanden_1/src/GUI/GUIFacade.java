/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.IBusiness;
import Acquaintance.IGUI;
import Acquaintance.IUser;
import java.util.Collection;
import java.util.Map;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Antonio
 */
    public class GUIFacade extends Application implements IGUI {
    
    static IBusiness business;
    static String currentUsername;
    
    public static int login(String username, String password) {
        return business.login(username, password);
    }
    
    public static boolean createUser(String username, String password, String email, String CPR, String accessLevel) {
        return business.createUser(username, password, email, CPR, accessLevel);
    }
    
    public static Collection getAccessLevels() {
        return business.getAccessLevels();
    }
    
    public static Map<String, IUser> getUsers() {
        return business.getUsers();
    }
        
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void injectBusiness(IBusiness business) {
        this.business = business;
    }

    @Override
    public void startApplication(String[] args) {
        launch(args);
    }
    
   
}