package javase10.t02.DAO;

import javase10.t02.DAO.DAOBook;

import java.sql.Connection;
import java.sql.SQLException;

interface DAOFactory {
    /** Возвращает подключение к базе данных */
    public Connection getConnection() throws SQLException;

    public DAOBook getBookDAO(Connection connection);
}
