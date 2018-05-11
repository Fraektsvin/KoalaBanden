/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;
import Acquaintance.*;
import GUI.GUIFacade;
import Data.DataFacade;
import Business.BusinessFacade;
import Business.SystemManager;

/**
 *
 * @author Antonio
 */
public class Starter {
    
    public static void main(String[] args) {
        IData data = new DataFacade();
        
        IBusiness business = new BusinessFacade();
        
        IGUI GUI = new GUIFacade();
        
        GUI.injectBusiness(business);
        
        business.injectData(data);
        
        // Used for testing
        SystemManager manager = new SystemManager();
        manager.createUser("Jonas", "1234", "email", "123", "1");
        
        GUI.startApplication(args);
            
    }
}