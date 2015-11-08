package javase04.t01;

public class JavaReader {
    /**
     * Прочитайте файл, содержащий код на языке Java.
     * Определите, какие ключевые слова языка Java этот код содержит.
     * Выведите эти слова и их количество в другой файл.
     * Используйте только байтовые потоки ввода-вывода.
     */

    public static void main(String[] args) {
        WordProcessing.loadFile();
        WordProcessing.findKeyWord();
        WordProcessing.saveFile();
    }
}
