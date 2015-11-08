package javase03.t01;

import java.util.Date;

public class CrazyLoggerMain {
    /*
    Необходимо создать класс CrazyLogger, ведущий журнал лога,
    используя как накопитель объект типа StringBuilder.
    Логгер должен содержать методы поиска определенной информации в таком логе
    [с возможностью вывода ее в поток ввода вывода].
    Информацию логгер хранит в форматированном виде: dd-mm-YYYY : hh-mm – message;.
     */
    public static void main(String[] arg) {
        CrazyLogger crazyLogger = new CrazyLogger();

        crazyLogger.addMessage(new StringBuilder("Первое сообщение в логе"));
        crazyLogger.addMessage(new StringBuilder("Второе сообщение в логе"));
        crazyLogger.addMessage(new StringBuilder("Второе новое сообщение в логе"));
        crazyLogger.addMessage(new StringBuilder("Третье сообщение в логе"));
        crazyLogger.addMessage(new StringBuilder("Четвертое сообщение в логе"));
        crazyLogger.addMessage(new StringBuilder("Пятое сообщение в логе"));

        //Вывод всех сообщений
        crazyLogger.showAllMessage();
        //Поиск по ключевому слову
        crazyLogger.searchMessagesByKeyword("Второе");
        //Поиск по дате
        crazyLogger.searchMessagesByDate(new Date());
        //Поиск несуществующего слова
        crazyLogger.searchMessagesByKeyword("абажур");
    }
}
