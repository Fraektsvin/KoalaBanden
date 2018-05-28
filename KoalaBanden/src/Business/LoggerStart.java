/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
 */
public class LoggerStart {

    private final static Logger logger = Logger.getLogger(LoggerStart.class.getName()); // Instanciates logger from Java
    private static FileHandler fh; // fileHandler used for creating local log file

    /**
     * Constructor creates a logger which inputs logtext into a local log file (1)
     * Logger is formatted to simpleforamatter for layout purposes to read the logger in txt file(2)
     * Logger level is set to log everything which also includes the class name(3)
     * Custom information logging statement (4)
     * Runtime thread method to close the logger upon closing the application(5)
     */
    public void LoggerStart() {

        try {

            // This block configure the logger with handler and formatter  
            fh = new FileHandler("LogFile.log", true); //(1)
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();//(2)
            fh.setFormatter(formatter);

            // the following statement is used to log any messages  
            logger.setLevel(Level.ALL);//(3)
            logger.setUseParentHandlers(true);
            logger.log(Level.INFO, "Initializing Logger");//(4)

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() { //(5)
            @Override
            public void run() {
                fh.close();
            }
        });

    }
}
