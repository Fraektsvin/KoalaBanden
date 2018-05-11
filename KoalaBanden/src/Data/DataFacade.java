/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.ICase;
import Acquaintance.IData;
import Acquaintance.IUser;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Antonio
 */
public class DataFacade implements IData {

    private UserData userData;
    private caseData caseData;

    public DataFacade() {
        this.userData = new UserData();
        this.caseData = new caseData();
    }

    @Override
    public boolean userExists(String userName) {
        return userData.userExists(userName);
    }

    @Override
    public void createUser(IUser user) {
        userData.createUser(user);
    }

    @Override
    public IUser getUser(String userName, String password) {
        return userData.getUser(userName, password);
    }

    @Override
    public void saveCase(ICase c) {
        caseData.saveCase(c);
    }

    public Map<Integer, ICase> getCases() {
        return caseData.getCaseMap();
    }

    @Override
    public Map<String, IUser> getUsers() {
        return userData.getUserMap();
    }

    @Override
    public void deleteUser(String username) {
        userData.deleteUser(username);
    }

}
