package javase10.t02.DAO;


import javase10.t02.Records.Book;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface DAOBook{

    /** Создает новую книгу и соответствующий ей объект */
    public Book create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Book read(int key) throws SQLException;

    /** Сохраняет состояние объекта book в базе данных */
    public void update(Book book);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Book book);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Book> getAll() throws SQLException;

    /** Создает новую запись, соответствующую объекту object */
    public Book persist(Book object);
}
