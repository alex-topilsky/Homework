package javase04.t04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class FilmCollection implements Serializable {
    private ArrayList<Film> filmCollection;

    public FilmCollection() {
        this.filmCollection = new ArrayList<Film>();
    }

    public void addFilm(String filmName, GregorianCalendar date, String description, String... actors) {
        filmCollection.add(new Film(filmName, date, description, actors));
    }

    public String getFilm(String filmName) {
        for (Film film : filmCollection) {
            if (film.getFilmName().equals(filmName)) return film.getFilmInfo();
        }
        return null;
    }

    public void changeFilmDate(String filmName, GregorianCalendar newDate) {
        for (Film film : filmCollection) {
            if (film.getFilmName().equals(filmName)) {
                film.setDate(newDate);
            }
        }
    }

    public void changeFilmDescription(String filmName, String description) {
        for (Film film : filmCollection) {
            if (film.getFilmName().equals(filmName)) {
                film.setDescription(new StringBuilder(description));
            }
        }
    }

    public void changeFilmName(String filmName, String newFilmName) {
        for (Film film : filmCollection) {
            if (film.getFilmName().equals(filmName)) {
                film.setFilmName(newFilmName);
            }
        }
    }

    public void changeFilmActors(String filmName, String... actors) {
        for (Film film : filmCollection) {
            if (film.getFilmName().equals(filmName)) {
                film.setActors(actors);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder filmInfo = new StringBuilder();
        for (Film film : filmCollection) {
            filmInfo.append(film);
        }
        return filmInfo.toString();
    }
}