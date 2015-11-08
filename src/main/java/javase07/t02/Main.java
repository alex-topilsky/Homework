package javase07.t02;

public class Main {
    /*
    Создать “универсальный” класс, позволяющий получить значение из любого properties-файла.
    Физическое чтение файла должно происходить только один раз.
    Учтите ситуацию, когда несколько потоков одновременно обращаются к одному и тому же файлу.
     */

    public static void main(String[] args) {
    ConsoleReader consoleReader = new ConsoleReader();
    consoleReader.Console();
    }
}
