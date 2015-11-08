package javase06.t02;

public class LoadPropertiesMain {
    /*
   Создать “универсальный” класс, позволяющий получить значение из любого properties-файла.
   Физическое чтение файла должно происходить только один раз.
   Результаты чтения храните в коллекции типа Map.
   */

    // Проект аналогичен javase05.t02
    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        consoleReader.Console();
    }

     /*
    Ответьте на вопрос: как ведет себя map-коллекция если в нее добавить элемент с ключом, который уже присутствует?
    Ответ: Map-коллекция заменяет существующий элемент новым значением и возвращает объект старого значения.
    */
}
