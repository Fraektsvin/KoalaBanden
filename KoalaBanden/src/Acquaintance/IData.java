/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author Jonas
 */
public interface IData {
    public boolean userExists(String userName);
    public void createUser(IUser user);
}
