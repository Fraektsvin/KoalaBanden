/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public interface IDatabase {
    void createUser(IUser u) throws SQLException;
    void updateUser(IUser u) throws SQLException;
    void deleteUser(String username) throws SQLException;

    void createCase(ICase c) throws SQLException;
    void updateCase(ICase c) throws SQLException;
    void deleteCase(int id) throws SQLException;
}
