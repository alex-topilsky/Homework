package javase05.t02;

public class LoadPropertiesMain {
    /*
        Создать “универсальный” класс, позволяющий получить значение из любого properties-файла.
        Физическое чтение файла должно происходить только один раз.

        Обработайте следующие исключительные ситуации:
        нет файла *.properties, нет ключа в properties-файле.
        */

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        consoleReader.Console();
    }
}
