package javase02.t02_03_04.stationery;

import java.util.Comparator;

public abstract class Stationery implements Comparator<Stationery>, Comparable<Stationery> {
    private int cost;
    private String name;
    private static int number = 0;
    private int id;

    Stationery() {
        setCost(0);
        setId();
        this.name = "Stationery:" + id;
    }

    Stationery(int cost) {
        setCost(cost);
        setId();
        this.name = "Stationery:" + id;
    }

    Stationery(int cost, String name) {
        setCost(cost);
        setId();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setId() {
        id = number;
        number++;
    }

    public int getId() {
        return this.id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = Math.abs(cost);
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + ":Name=" + getName() + ":Cost=" + getCost());
    }

    @Override
    public int compare(Stationery st1, Stationery st2) {
        if (st1.getCost() > st2.getCost()) {
            return 1;
        } else if (st1.getCost() < st2.getCost()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(Stationery stationery) {
        return (this.getName()).compareTo(stationery.getName());
    }
}