package by.itacademy.library.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;


public interface DAO<T> {

    /**
     * @param t entity to save
     * @return saved entity
     * @throws SQLException
     */
    T save(T t) throws SQLException;

    /**
     *
     * @param id id of the entity
     * @return entity
     * @throws SQLException
     */
    T get(Serializable id) throws SQLException;

    /**
     *
     * @param t entity to update
     * @throws SQLException
     */
    void update(T t) throws SQLException;

    /**
     *
     * @param id id of the entity
     * @return affected rows
     * @throws SQLException
     */
    int delete(Serializable id) throws SQLException;

    /**
     *
     * @return list of all entities
     * @throws SQLException
     */
    List<T> getAll() throws SQLException;

}
