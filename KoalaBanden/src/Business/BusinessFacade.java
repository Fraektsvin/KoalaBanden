/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Antonio
 */
public class BusinessFacade implements IBusiness {
    
    private static IData data;
    
    public boolean userExists(String userName) {
        return true;
    }

    @Override
    public void injectData(IData data) {
        this.data = data;
    }
    
    
}
