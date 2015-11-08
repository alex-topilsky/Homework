package javase01.t03;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h.
Результат представить в виде таблицы, первый столбец которой – значения аргумента,
второй - соответствующие значения функции: F(x) = tg(2x) - 3
 */
public class Loops {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(in);
        getTableFunction();
        scanner.close();
    }

    private static double funTg2xMinus3(double x) {
        return Math.tan(2 * x) - 3.0;
    }

    private static double getValue() {
        boolean noError;
        double value = 0;
        do {
            try {
                noError = true;
                value = Double.parseDouble(scanner.next());
            } catch (Exception exception) {
                out.println("It is not number, try again: ");
                noError = false;
            }
        } while (!noError);
        out.println("You entered : " + value);
        return value;
    }

    public static void getTableFunction() {
        out.print("Enter the beginning of the segment: ");
        double pointA = getValue();

        out.println("Enter the end of the segment: ");
        double pointB = getValue();

        out.print("Enter the step: ");
        double stepH = Math.abs(getValue());

        if (pointA > pointB) {
            double temp = pointA;
            pointA = pointB;
            pointB = temp;
        }

        for (double x = pointA; x <= pointB; x += stepH) {
            out.println(x + " | " + funTg2xMinus3(x));
        }
    }
}
