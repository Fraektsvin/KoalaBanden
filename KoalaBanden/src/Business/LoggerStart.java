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
 *
 * @author trium
 */
public class LoggerStart {
    
    private final static Logger logger = Logger.getLogger(LoggerStart.class.getName());
    private static FileHandler fh;
    
    public void LoggerStart() {
    
    try {  

        // This block configure the logger with handler and formatter  
        fh = new FileHandler("LogFile.log", true);  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  

        // the following statement is used to log any messages  
       logger.setLevel(Level.ALL);
       logger.setUseParentHandlers(true);
       logger.log(Level.INFO, "Initializing Logger"); 
       

    } catch (SecurityException e) {  
        e.printStackTrace();  
    } catch (IOException e) {  
        e.printStackTrace();  
    }  

     Runtime.getRuntime().addShutdownHook(new Thread(){
				/* Closes the logger upon closing the application. */
				@Override
				public void run() {
					fh.close();
        }
     });
         
}
}