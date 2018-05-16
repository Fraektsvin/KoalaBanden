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
import Data.Database;
import java.sql.SQLException;

/**
 *
 * @author Antonio
 */
public class Starter {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        IData data = new DataFacade();
        
        IBusiness business = new BusinessFacade();
        
        IGUI GUI = new GUIFacade();
        
        GUI.injectBusiness(business);
        
        business.injectData(data);

        
        // Used for testing
        SystemManager manager = new SystemManager();
        manager.createUser("Hassan", "1234", "email", "1231111111", "Systemadministrator");
        
        GUI.startApplication(args);
            
    }
}