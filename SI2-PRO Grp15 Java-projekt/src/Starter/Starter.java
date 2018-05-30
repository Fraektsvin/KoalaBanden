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
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Antonio
 */
public class Starter {

    private final static Logger logger = Logger.getLogger(LoggerStart.class.getName());

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        
        IData data = new DataFacade();
        
        IBusiness business = new BusinessFacade();
        
        IGUI GUI = new GUIFacade();
        
        GUI.injectBusiness(business);
        
        business.injectData(data);

        LoggerStart LOG = new LoggerStart();
        LOG.LoggerStart();
        
        // Used for testing
        
        SystemManager manager = new SystemManager();
        business.createCaseworker("Jonas1212", "jonas@jonas.com", "1212121212", 0, AccessLevel.SAGSBEHANDLER);
        manager.createUser("Admin111", "1234", "admin@admin.com", "1111111111", AccessLevel.SYSTEMADMINISTRATOR);

        GUI.startApplication(args);
            
    }
}