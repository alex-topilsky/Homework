package javase10.t02.DAO;

import javase10.t02.Records.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public abstract class AbstractJdbcDao implements DAOBook {

    private Connection connection;

    /**
     * Возвращает sql запрос для получения всех записей.
     * <p>
     * SELECT * FROM [Table]
     */
    public abstract String getSelectQuery();

    /**
     * Возвращает sql запрос для вставки новой записи в базу данных.
     * <p>
     * INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...);
     */
    public abstract String getCreateQuery();

    /**
     * Возвращает sql запрос для обновления записи.
     * <p>
     * UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
     */
    public abstract String getUpdateQuery();

    /**
     * Возвращает sql запрос для удаления записи из базы данных.
     * <p>
     * DELETE FROM [Table] WHERE id= ?;
     */
    public abstract String getDeleteQuery();

    /**
     * Разбирает ResultSet и возвращает список объектов соответствующих содержимому ResultSet.
     */
    protected abstract List<Book> parseResultSet(ResultSet rs);

    /**
     * Устанавливает аргументы insert запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForInsert(PreparedStatement statement, Book object);

    /**
     * Устанавливает аргументы update запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, Book object);

    @Override
    public Book persist(Book book) {
        Book persistInstance = null;
        // Добавляем запись
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, book);
            int count = statement.executeUpdate();
            if (count != 1) {
                //throw new PersistException("On persist modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            //throw new PersistException(e);
        }
        // Получаем только что вставленную запись
        sql = getSelectQuery() + " WHERE id = last_insert_id();";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            List<Book> list = parseResultSet(rs);
            if ((list == null) || (list.size() != 1)) {
                //throw new PersistException("Exception on findByPK new persist data.");
            }
            persistInstance = list.iterator().next();
        } catch (Exception e) {
            // throw new PersistException(e);
        }
        return persistInstance;
    }


    @Override
    public void update(Book book) {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            prepareStatementForUpdate(statement, book); // заполнение аргументов запроса оставим на совесть потомков
            int count = statement.executeUpdate();
            if (count != 1) {
                //throw new PersistException("On update modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            //throw new PersistException(e);
        }
    }

    @Override
    public void delete(Book book) {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                statement.setObject(1, book.getId());
            } catch (Exception e) {
                // throw new PersistException(e);
            }
            int count = statement.executeUpdate();
            if (count != 1) {
                //throw new PersistException("On delete modify more then 1 record: " + count);
            }
            statement.close();
        } catch (Exception e) {
            // throw new PersistException(e);
        }
    }

    @Override
    public List<Book> getAll() {
        List<Book> list = null;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            // throw new PersistException(e);
        }
        return list;
    }

    public AbstractJdbcDao(Connection connection) {
        this.connection = connection;
    }
}

