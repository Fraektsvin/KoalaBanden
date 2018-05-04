/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.IUser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeView;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author trium
 */
public class mainController implements Initializable{
      
    
 
   
    @FXML
    private VBox news_scroll;
    
   @FXML
   private JFXButton opretbtn;
   
   @FXML
   private JFXTreeView<?> h_sager;
    
    private void handleButtonAction(MouseEvent event) {        
       refreshNodes();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         refreshNodes();
    }    
    
    private void refreshNodes()
    {
        news_scroll.getChildren().clear();
        
        Node [] nodes = new  Node[15];
        
        for(int i = 0; i<10; i++)
        {
            try {
                nodes[i] = (Node)FXMLLoader.load(getClass().getResource("news.fxml"));
               news_scroll.getChildren().add(nodes[i]);
                
            } catch (IOException ex) {
                Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        } 
    
    }
    private void opretSag(MouseEvent event) throws IOException {
        {
          
        Parent root = FXMLLoader.load(getClass().getResource("caseOpening.fxml"));
        
        Scene scene = new Scene(root);
        
        
    }
     
}

    @FXML
    private void createCase(ActionEvent event) {
      GUIFacade.business.createCase((int)Math.random() * 1000);
    }

    @FXML
    private void seeCases(ActionEvent event) {
        System.out.println(GUIFacade.business.getCases().keySet());
    }


        
}




        
  
