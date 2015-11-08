package javase02.t02_03_04.employees;

import javase02.t02_03_04.stationery.Stationery;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private String name;
    private Status status;

    public enum Status
    {
        BEGINNER,
        DIRECTOR
    }

    List stationery = new ArrayList();

    public Employees(String name, Status status)
    {
        this.name = name;
        this.status = status;
    }

    public Employees(String name, Status status, ArrayList<Object> stationery)
    {
        this.name = name;
        this.status = status;
        this.stationery.add(stationery);
    }

    public void setStationery(List stationery)
    {
        this.stationery.addAll(stationery);
    }

    public void setStationery(Stationery stationery)
    {
        this.stationery.add(stationery);
    }

    public List getStationery() {
        return stationery;
    }

    /**
     * Определяет полную стоимость всех канцелярских товаров у сотрудника
     * @return полная стоимость всех канцелярских товаров
     */
    public int costOfAllStationery()
    {
        int cost=0;
        for(Object obj: stationery)
        {
            if(obj instanceof Stationery)
            {
                cost+=((Stationery) obj).getCost();
            }
        }
        return cost;
    }
}