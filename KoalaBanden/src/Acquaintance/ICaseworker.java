/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.sql.Date;

/**
 *
 * @author Jonas
 */
public interface ICaseworker {

    public void createCase(int cpr, int id, Date dateCreated, Date lastModified, String lastModifiedBy);
}
