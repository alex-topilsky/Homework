package javase02.t01;

import java.awt.*;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Pen pen1 = new Pen(10, Color.RED);
        Pen pen2 = new Pen(10, Color.RED);
        Pen pen3 = new Pen(10, Color.RED);

        out.println("Транзетивность:");
        out.println("pen1.equals(pen3) = " + pen1.equals(pen3));
        out.println("pen2.equals(pen3) = " + pen2.equals(pen3));
        out.println("pen1.equals(pen2) = " + pen1.equals(pen2));
        out.println();
        out.println("Симметричность:");
        out.println("pen1.equals(pen2) = " + pen1.equals(pen2));
        out.println("pen2.equals(pen1) = " + pen2.equals(pen1));
        out.println();
        out.println("Рефлексивность:");
        out.println("pen1.equals(pen1): " + pen1.equals(pen1));
        out.println();
        out.println("Ненулевая ссылка:");
        out.println("pen1.equals(null) = " + pen1.equals(null));
        out.println();
        out.println("pen1.hashCode(): " + pen1.hashCode());
        out.println("pen2.hashCode(): " + pen2.hashCode());
        pen2.setCost(15);
        out.println("pen1.hashCode():  " + pen1.hashCode());
        out.println("pen2.hashCode():  " + pen2.hashCode());
        out.println();

        out.println("Pen to String: " + pen1.toString());
    }
}
