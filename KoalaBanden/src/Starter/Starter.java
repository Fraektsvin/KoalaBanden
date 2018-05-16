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
<<<<<<< HEAD
import Data.Database;
import java.sql.SQLException;
=======
import java.util.logging.Logger;
>>>>>>> fb012a80dafc7cbb70ef99cf3394d13da652d40d

/**
 *
 * @author Antonio
 */
public class Starter {
<<<<<<< HEAD
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
=======
       private final static Logger logger = Logger.getLogger(LoggerStart.class.getName());

    public static void main(String[] args) {
>>>>>>> fb012a80dafc7cbb70ef99cf3394d13da652d40d
        IData data = new DataFacade();
        
        IBusiness business = new BusinessFacade();
        
        IGUI GUI = new GUIFacade();
        
        GUI.injectBusiness(business);
        
        business.injectData(data);
<<<<<<< HEAD

        
        // Used for testing
        SystemManager manager = new SystemManager();
        manager.createUser("Hassan", "1234", "email", "1231111111", "Systemadministrator");
        
=======
        // Used for testing
        SystemManager manager = new SystemManager();
        manager.createUser("Jonas", "1234", "email", "1231111111", "Systemadministrator");
        LoggerStart LOG = new LoggerStart();
        LOG.LoggerStart();
>>>>>>> fb012a80dafc7cbb70ef99cf3394d13da652d40d
        GUI.startApplication(args);
            
    }
}