package javase02.t02_03_04.stationery;

import java.awt.*;

public class Pen extends WritingUtensils {
    public enum Type {
        GEL,
        INK
    }

    public Type getTypeInk() {
        return typeInk;
    }

    private Type typeInk;

    public Pen() {
        super();
        this.typeInk = Type.INK;
    }

    public Pen(int cost, String name, Color color, Type type) {
        super(cost, name, color);
        this.typeInk = type;
    }
}