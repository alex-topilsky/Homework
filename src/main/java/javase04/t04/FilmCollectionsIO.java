package javase04.t04;

import java.io.*;

public class FilmCollectionsIO{
    public static void save(FilmCollection filmCollection) {
        try (ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("FilmCollections"))) {
            FilmCollection fc = filmCollection;
            objOStrm.writeObject(fc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FilmCollection load() {
        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("FilmCollections"))) {
            FilmCollection fc = (FilmCollection) objIStrm.readObject();
            return fc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}