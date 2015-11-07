package javase01.t02;
/*
Найти наименьший номер элемента последовательности, для которого выполняется условие M.
Вывести на экран этот номер и все элементы a(i)  где i = 1, 2, ..., n.
a(n)=1/(n+1)^2
M: a(n)<eps
 */

import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class Loop {
    public static void main(String... arg) {
        searchItem();
    }

    private static double elementOfTheSequence(int i) {
        return 1 / Math.pow((i + 1), 2);
    }

    private static double getEps() {
        out.print("Enter Eps = : ");
        Scanner scanner = new Scanner(in);
        boolean noError;
        double Eps = 0;
        do {
            try {
                Eps = Double.parseDouble(scanner.next());
                noError = true;
            } catch (Exception exception) {
                out.println("It is not number, try again: ");
                noError = false;
            }
        } while (!noError);
        out.println("You entered E= " + Eps);
        scanner.close();
        return Eps;
    }

    private static void searchItem() {
        double Eps = getEps();
        double element = 0;

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            element = elementOfTheSequence(i);
            if (element < Eps) {
                System.out.println("The smallest element of a sequence satisfying M is A(" + i + ") = " + element);
                break;
            }
            System.out.println("A(" + i + ") = " + element);
        }


    }
}