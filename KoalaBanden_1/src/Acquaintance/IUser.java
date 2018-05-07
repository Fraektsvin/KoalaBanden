/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author viktorianadarajah
 */
public interface IUser {
    
    public String getUsername();
    public String getPassword();
    public String getEmail();
    public int getCPR();
    public String getAccessLevelString();
    public void setPassword(String password);
    public void setEmail(String email);
    
    public boolean checkPassword(String password);
}
