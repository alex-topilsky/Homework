package javase10.t01;


import java.sql.*;
import com.mysql.fabric.jdbc.FabricMySQLDriver;


public class DBwork {
    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String lOGIN = "root";
    private static final String PASSWORD = "root";


    public void connect() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection(URL, lOGIN, PASSWORD);
                Statement statement = connection.createStatement();
            ) {
            //Добавить запись
//            statement.execute("INSERT INTO user(name, email, age) VALUES('Piter', 'piter@mail.com', 5)");
//            statement.execute("INSERT INTO user(name, email, age) VALUES('Alex', 'alex@mail.com', 25)");
//            statement.execute("INSERT INTO user(name, email, age) VALUES('Dima', 'dima@mail.com', 15)");
//            statement.execute("INSERT INTO user(name, email, age) VALUES('Vova', 'vova@mail.com', 35)");

            //Обновить записи
            //statement.executeUpdate("UPDATE user SET name ='Karl', email ='karl@karl.ru' WHERE id = 2");
            //statement.executeUpdate("UPDATE user SET age = 11 WHERE name = 'Piter'");

            //Выбрать все записи в таблице
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM user");
            while (resultSet1.next()) {
                int id = resultSet1.getInt(1);
                String name = resultSet1.getString(2);
                String email = resultSet1.getString(3);
                int age = resultSet1.getInt(4);

                System.out.println("id: "+id+" name: "+name+" email: "+email+" age: "+age);
            }

            //Выбрать конкретную запись в таблице
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM user WHERE id = 3 ");
            while (resultSet2.next()) {
                int id = resultSet2.getInt(1);
                String name = resultSet2.getString(2);
                String email = resultSet2.getString(3);
                int age = resultSet2.getInt(4);

                System.out.println("id: "+id+" name: "+name+" email: "+email+" age: "+age);
            }

            //Удаление таблицы
            //statement.execute("DROP TABLE user");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
