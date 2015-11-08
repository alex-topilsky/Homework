package javase02.t01;

import java.awt.*;

public class Pen {
    private int cost;
    private int inkValue;
    private Color inkColor;

    public int getInkValue() {
        return inkValue;
    }

    public Color getInkColor() {
        return inkColor;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Pen(int cost, Color inkColor) {
        this.cost = cost;
        this.inkValue = 100;
        this.inkColor = inkColor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Pen pen = (Pen) obj;
        return (this.getCost() == pen.getCost() && this.getInkColor() == pen.getInkColor());
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + getCost() + getInkColor().hashCode();
        return result;
    }

    @Override
    public String toString() {
        if (inkColor == Color.BLACK) return ("Black pen:cost = " + getCost());
        if (inkColor == Color.RED) return "Red pen:cost = " + getCost();
        if (inkColor == Color.GREEN) return "Green pen:cost = " + getCost();
        if (inkColor == Color.BLUE) return "Blue pen:cost = " + getCost();
        return inkColor + " pen:cost = " + getCost();
    }
}
