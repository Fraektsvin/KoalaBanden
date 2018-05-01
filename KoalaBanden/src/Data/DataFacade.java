/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.IData;

/**
 *
 * @author Antonio
 */
public class DataFacade implements IData {

    private UserData userData;
    
    public DataFacade() {
        this.userData = new UserData();
    }
    
    @Override
    public boolean userExists(String userName) {
        return userData.userExists(userName);
    }
    
}
