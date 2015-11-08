package javase02.t05test;

import java.util.ArrayList;

public class GroupList extends Group{

    ArrayList<Group> groups = new ArrayList<Group>();

    public GroupList()
    {

        
    }

    public void doGroup(Discipline discipline)
    {
        if(discipline==Discipline.LITERATURE)
        {
            groups.add(new Group<Integer>());
        }
        else
        {
            groups.add(new Group<Double>());
        }
    }






}
