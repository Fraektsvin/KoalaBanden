package Acquaintance;

import java.sql.SQLException;


/**
 * Interface for CRUD operations
 * https://en.wikipedia.org/wiki/Create,_read,_update_and_delete
 * Supports create, read, update, delete operations to databases.
 * Read operations must be supported in constructer functions
 */
public interface IModel {
    void saveToDB() throws SQLException;
    void updateToDb() throws SQLException;
    void deleteFromDB() throws SQLException;
}

