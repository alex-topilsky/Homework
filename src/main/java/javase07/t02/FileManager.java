package javase07.t02;

import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.MissingResourceException;

import static java.lang.System.out;

public class FileManager {
    private File file;
private LoadProperties loadProperties;
    FileManager() {
        file = new File(System.getProperty("user.dir"));
        loadProperties = new LoadProperties();
    }

    public void upDirectory() throws Exception {
        file = new File(file.getParent());
    }

    public void downDirectory(String dir) throws Exception {

        file = new File(file.getPath() + "//" + dir);
        if (!file.isDirectory()) {
            file = new File(file.getParent());
            throw new NotDirectoryException(file.toString());
        } else {
            showCurrentDirectory();
        }
    }

    public void showCurrentDirectory() {
        out.println("Текущая директория: " + file.toString());
    }

    public void showFilesInThisDirectory() {
        out.println("Список файлов в директории: ");
        for (File file : this.file.listFiles()) {
            out.println(file.getName());
        }
    }

    public void openFile(String fileName, String keyWord) throws RuntimeException {
        try {

            String answer = loadProperties.findKey(file, fileName, keyWord);
            out.println(answer);
        } catch (MissingResourceException mrExc) {
            out.println("Не найден файл ресурсов" + fileName);
        } catch (NullPointerException npExc) {
            throw npExc;
        } catch (IllegalArgumentException iaExc) {
            throw iaExc;
        }
    }
}
