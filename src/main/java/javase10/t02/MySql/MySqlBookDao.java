package javase10.t02.MySql;


import javase10.t02.Records.Book;
import javase10.t02.DAO.AbstractJdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MySqlBookDao extends AbstractJdbcDao {
    public MySqlBookDao(Connection connection) {
        super(connection);
    }

    private class PersistGroup extends Book {
        public void setId(int id) {
            super.setId(id);
        }
    }


    @Override
    public String getSelectQuery() {
        return "SELECT id, number, department FROM daotalk.Group";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO daotalk.Group (number, department) \n" +
                "VALUES (?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE daotalk.Group SET number= ? department = ? WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM daotalk.Group WHERE id= ?;";
    }



    @Override
    public Book create() {
        Book book = new Book();
        return persist(book);
    }

    @Override
    public Book read(int key) throws SQLException {
        return null;
    }

//    public Book(Connection connection) {
//        super(connection);
//    }

    @Override
    protected List<Book> parseResultSet(ResultSet rs) {
        LinkedList<Book> result = new LinkedList<Book>();
        try {
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthorName(rs.getString("authorName"));
                book.setAuthorSurname(rs.getString("authorSurname"));
                book.setDate(rs.getDate("date"));
                result.add(book);
            }
        } catch (Exception e) {
            //throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Book book) {
        try {
            statement.setInt(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthorName());
            statement.setString(4, book.getAuthorSurname());
            statement.setDate(5, book.getDate());

        } catch (Exception e) {
          //  throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Book book)  {
        try {
            statement.setInt(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthorName());
            statement.setString(4, book.getAuthorSurname());
            statement.setDate(5, book.getDate());
        } catch (Exception e) {
           // throw new PersistException(e);
        }
    }
}
