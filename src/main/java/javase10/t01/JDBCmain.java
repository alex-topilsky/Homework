package javase10.t01;
    /*
    Создайте таблицу в БД и с помощью JDBC выполните следующие действия:
    + извлеките информацию из таблицы с помощью подготовленного запроса;
    + обновите несколько записей в таблице;
    + выберите конкретную запись в таблице;
    + вставьте новую запись в таблицу;
    - удалите таблицу.
    */

public class JDBCmain {
    public static void main(String[] args) {
        DBwork dBwork = new DBwork();
        dBwork.connect();
    }

}
