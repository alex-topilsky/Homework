package javase02.t05test;

import java.util.HashMap;

public class Group <T extends Number> {
    private Discipline thisDiscipline;
    private HashMap<String, T> students = new HashMap<String, T>();

    Group()
    {

    }

    public void Mark(T mark)
    {

    }
}
