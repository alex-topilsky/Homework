package javase02.t02_03_04.stationery;

import java.awt.*;

public abstract class WritingUtensils extends Stationery {
    public Color getColor() {
        return color;
    }

    private Color color;

    WritingUtensils() {
        super();
        this.color = Color.black;
    }

    WritingUtensils(int cost, String name, Color color) {
        super(cost, name);
        this.color = color;
    }
}