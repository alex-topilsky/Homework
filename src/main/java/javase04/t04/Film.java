package javase04.t04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Film implements Serializable {

    private ArrayList<String> actors;
    private String filmName;
    private GregorianCalendar date;
    private StringBuilder description;

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(String... actors) {
        this.actors.clear();
        for (String actor : actors) {
            this.actors.add(actor);
        }
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public GregorianCalendar  getDate() {
        return date;
    }

    public void setDate(GregorianCalendar  date) {
        this.date = date;
    }

    public StringBuilder getDescription() {
        return description;
    }

    public void setDescription(StringBuilder description) {
        this.description = description;
    }

    public Film() {
        this.actors = new ArrayList<String>();
        this.filmName = new String();
        this.date = new GregorianCalendar();
        this.description = new StringBuilder();
    }

    public Film(String filmName, GregorianCalendar  date, String description, String... actors) {
        this.actors = new ArrayList<String>();
        this.filmName = new String();
        this.date = new GregorianCalendar();
        this.description = new StringBuilder();

        setFilm(filmName, date, description, actors);
    }


    public void setFilm(String filmName, GregorianCalendar date, String description, String... actors) {
        this.filmName = filmName;
        this.date = date;
        this.description.append(description);
        for (String actor : actors) {
            this.actors.add(actor);
        }
    }

    public String getFilmInfo() {
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder filmInfo = new StringBuilder();

        filmInfo.append("Film: "+ this.filmName);
        filmInfo.append('\n');
        filmInfo.append("Date: " + this.date.get(Calendar.YEAR));
        filmInfo.append('\n');
        for (String actor : actors) {
            filmInfo.append("Actor: " + actor + ", ");
        }
        filmInfo.append('\n');
        filmInfo.append("Description: " + description);
        filmInfo.append('\n');
        return filmInfo.toString();
    }
}