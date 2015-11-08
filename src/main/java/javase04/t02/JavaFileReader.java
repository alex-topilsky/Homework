package javase04.t02;

public class JavaFileReader {
  /*
  Прочитайте файл, содержащий код на языке Java.
  Определите, какие ключевые слова языка Java это код содержит.
  Выведите эти слова и их количество в другой файл.
  Используйте только символьные потоки ввода-вывода.
  */
    public static void main(String[] args) {
        WordProcessing.loadFile();
        WordProcessing.findKeyWord();
        WordProcessing.saveFile();
    }
}
