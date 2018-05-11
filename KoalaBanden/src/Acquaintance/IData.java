/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.Map;



/**
 *
 * @author Jonas
 */
public interface IData {
    public boolean userExists(String userName);
    public void createUser(IUser user);
    public IUser getUser(String userName, String password);
    public void saveCase(ICase c);
    public Map<Integer, ICase> getCases();
    public Map<String, IUser> getUsers();
    public void deleteUser(String username);
}
