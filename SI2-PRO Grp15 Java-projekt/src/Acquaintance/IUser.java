/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
 */

public interface IUser {

    public String getUsername();

    public String getPassword();

    public String getEmail();

    public int getCPR();

    public String getAccessLevelString();

    public void setPassword(String userName, String password);

    public void setEmail(String userName, String email);

    public AccessLevel getAccessLevel();
}
