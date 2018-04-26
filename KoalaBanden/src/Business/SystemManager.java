/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Antonio
 */
public class SystemManager {
    private ArrayList<User> Users = new ArrayList<>();
    private ArrayList<User> Case = new ArrayList<>();

    public SystemManager() {
    }

    public void setUsers(ArrayList<User> Users) {
        this.Users = Users;
    }

    public void setCase(ArrayList<User> Case) {
        this.Case = Case;
    }

    public ArrayList<User> getUsers() {
        return Users;
    }

    public ArrayList<User> getCase() {
        return Case;
    }

   
}
