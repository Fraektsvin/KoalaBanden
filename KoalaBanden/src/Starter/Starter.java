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
        
        GUI.startApplication(args);
        
        
    }
    
}
