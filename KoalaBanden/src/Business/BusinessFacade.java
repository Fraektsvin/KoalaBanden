/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

import java.util.HashMap;

/**
 *
 * @author Antonio
 */
public class BusinessFacade implements IBusiness {
    
    private SystemManager manager;
    private ICaseworker worker; 
    public  static IData data;
    int caseID = 0;
    private ICaseOpening CaseOpening;
    
    public BusinessFacade() {
        manager = new SystemManager();
        
    }
   
    public boolean userExists(String userName) {
        return data.userExists(userName);
    }
    
    @Override
    public void injectData(IData data) {
        this.data = data;
    }
    
    public void createUser(User user) {
        data.createUser(user);
    }
    
    public ICaseworker getCaseworker() {
        return worker;
    }
    
    public void createCaseworker(String username, String password, String email, int SSN, AccessLevel accesslevel ) {
        //manager.createCaseworker(username, password, email, SSN, accesslevel);
        this.worker = new Caseworker(username, password, email, SSN, accesslevel);
    }
    
    @Override
    // Returns the collection of cases from data.
    public Map<Integer, ICase> getCases() {
        return data.getCases();
    }

    @Override
    public IData getData() {
        return this.data;
    }
    
    @Override
    public IUser login(String userName, String password) {
        return manager.login(userName, password);
    }

    @Override
    public boolean createUser(String username, String password, String email, String SSN, AccessLevel accessLevel) {
        return manager.createUser(username, password, email, SSN, accessLevel);
    }
    
    
    

    @Override
    public Collection getAccessLevels() {
        return manager.getAccessLevels();
    }

    @Override
    public Map<String, IUser> getUsers() {
        return data.getUsers();
    }

    @Override
    public void deleteUser(String username) {
        manager.deleteUser(username);
    }

    @Override
    public AccessLevel getCurrentAccessLevel() {
        return manager.getCurrentAccessLevel();
    }

    @Override
    public IUser getUser(String userName, String password) {
        return data.getUser(userName, password);
    }
    
     @Override
    public IUser getUser(String userName) {
        return data.getUser(userName);
    }
    
     public ArrayList<Guardian>GetGuardian() {
        return CaseOpening.GetGuardian();
    }
    
    public ArrayList<Guardian> AddGuardian(Guardian guardian) {
    return CaseOpening.AddGuardian(guardian);
}
    
    public HashMap getCPRSMAP() {
        return CaseOpening.getCPRSMAP();
    }
    public void createEnquiry() {
       CaseOpening.createEnquiry();
    }
     public ICaseOpening saveCPR(Citizen citizen) {
         CaseOpening.saveCPR(citizen);
        return null;
     }

    @Override
    public String getCurrentUsername() {
        return manager.getCurrentUsername();
    }
}

  

