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
import Business.LoggerStart;
import Business.SystemManager;
import java.util.logging.Logger;

/**
 *
 * @author Antonio
 */
public class Starter {
       private final static Logger logger = Logger.getLogger(LoggerStart.class.getName());

    public static void main(String[] args) {
        IData data = new DataFacade();
        
        IBusiness business = new BusinessFacade();
        
        IGUI GUI = new GUIFacade();
        
        GUI.injectBusiness(business);
        
        business.injectData(data);
        // Used for testing
        SystemManager manager = new SystemManager();
        manager.createUser("Jonas", "1234", "email", "1231111111", "Systemadministrator");
        LoggerStart LOG = new LoggerStart();
        LOG.LoggerStart();
        GUI.startApplication(args);
            
    }
}