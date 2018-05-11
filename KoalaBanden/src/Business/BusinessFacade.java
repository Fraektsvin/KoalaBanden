/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.ICase;
import Acquaintance.ICaseworker;
import Acquaintance.IData;
import Acquaintance.IUser;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Antonio
 */
public class BusinessFacade implements IBusiness {
    
    private SystemManager manager;
    private ICaseworker worker; 
    public  static IData data;
    int caseID = 0;
    
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
    
    public User getUser(String userName, String password) {
        return (User) data.getUser(userName, password);
    }
   
    public ICaseworker getCaseworker() {
        return worker;
    }
    
    public void createCaseworker(String username, String password, String email, int SSN, int accesslevel ) {
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
    
    public int login(String userName, String password) {
        return manager.login(userName, password);
    }

    @Override
    public boolean createUser(String username, String password, String email, String SSN, String accessLevel) {
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

}
