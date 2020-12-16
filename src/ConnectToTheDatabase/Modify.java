/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectToTheDatabase;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public interface Modify<T> {
    ArrayList<T> findAll() throws SQLException;
    T find(int id) throws SQLException;

    void save(T t) throws SQLException;

    void update(T t) throws SQLException;

    void delete(T t) throws SQLException;

    void deleteById(int id) throws SQLException;
}
