package javase05.t02;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

import static java.lang.System.out;

public class LoadProperties {
    static private Map<File, ResourceBundle> propertiesFile = new HashMap<>();

    public static String findKey(File path, String file, String keyWord) throws RuntimeException {
        ResourceBundle rb = null;
        File fileProperties = new File(path + "//" + file + ".properties");
        if (!fileProperties.isFile()) throw new NullPointerException("Нет такого файла!");

        if (!propertiesFile.containsKey(fileProperties)) {
            try {
                String[] langCountry = file.split("_");
                Locale current = new Locale(langCountry[1], langCountry[2]);
                URL[] url = {path.toURI().toURL()};
                ClassLoader loader = new URLClassLoader(url);
                rb = ResourceBundle.getBundle(file, current, loader);
                propertiesFile.put(fileProperties, rb);
            }catch(ArrayIndexOutOfBoundsException aib)
            {

            }
            catch (Exception e) {
            }
        }
        String answer= "";
        try {
            answer = new String(propertiesFile.get(fileProperties).getString(keyWord));
        } catch (MissingResourceException mrExc) {
            out.println("В файле "+file+" не найдено ключевое слово "+ keyWord);
        } catch (IllegalArgumentException iaExc) {
            throw new IllegalArgumentException();
        } catch (NullPointerException npExc) {
            throw new NullPointerException();
        }
        try {
            return new String(answer.getBytes("ISO-8859-1"));
        } catch (UnsupportedEncodingException exc) {
            return answer;
        }
    }
}