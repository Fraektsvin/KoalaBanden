/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.ICase;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonas
 */
public class caseData {
    
    private File file = new File("caseMap.obj");
    public Map<Integer, ICase> caseMap;
  
    
 
   
         caseData() {
                    if(!file.exists()) {
                        caseMap = new HashMap<>();
                        saveMap(); 
                    }
                    else 
                    {
                      readMap();      
                    }
                }
 
         public void saveCase(ICase c) {
             caseMap.put(c.getID(), c);
             saveMap();
         }

    
    
     private void saveMap() {
         ObjectOutputStream oos = null;
         try {
             oos = new ObjectOutputStream(new FileOutputStream(file));
             oos.writeObject(caseMap);
         } catch(FileNotFoundException e) {
             e.printStackTrace();
         } catch(IOException e) {
             e.printStackTrace();
         } finally {
             try {
                 oos.close();
             } catch(IOException e) {
                 e.printStackTrace();
             }
         }
     }
     
     private void readMap() {
         ObjectInputStream ois = null; 
         try {
             ois = new ObjectInputStream(new FileInputStream(file));
             Object obj = ois.readObject();
             caseMap = (Map<Integer, ICase>) obj;
         } catch(IOException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
     }

     public Map<Integer, ICase> getCaseMap() {
         return caseMap;
     }
  
}




