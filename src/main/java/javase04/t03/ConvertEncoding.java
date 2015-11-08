package javase04.t03;

public class ConvertEncoding {
    /*
    Дан файл, содержащий буквы текст на кириллице.
    Кодировка файла utf-8.
    Прочитайте информацию из файла и перепишите ее в файл в кодировкой utf-16.
    */
    public static void main(String[] args) {
        WordProcessing.loadFile();
        WordProcessing.saveFile();
    }
}
