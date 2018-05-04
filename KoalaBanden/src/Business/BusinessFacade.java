/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.ICase;
import Acquaintance.IData;
import java.util.Map;

/**
 *
 * @author Antonio
 */
public class BusinessFacade implements IBusiness {
    
    
   
    private static IData data;
    int caseID = 0;
   
    public static boolean userExists(String userName) {
        return data.userExists(userName);
    }
    
    @Override
    public void injectData(IData data) {
        this.data = data;
    }
    
    public static void createUser(User user) {
        data.createUser(user);
    }
    
    public static User getUser(String userName, String password) {
        return (User) data.getUser(userName, password);
    }
    
    @Override
    public void createCase(int citizenSSN) {
      caseID++;
        System.out.println(caseID);
      ICase c = new Case(caseID, citizenSSN);
      data.saveCase(c);
    }
    
   
    
  
    
    
  
    
   
    
    @Override
    public Map<Integer, ICase> getCases() {
        return data.getCases();
    }

    @Override
    public IData getData() {
        return this.data;
    }
    
}
