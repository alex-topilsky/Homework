package javase01.t04;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
Даны действительные числа a1, a2 … an.  Найти max(a(1)+a(n), a(2)+a(n-1), ...)

 */
public class Arrays {
    private static  int[] masNumber;

    public static void main(String[] args) {
        maxSum();
    }

    private static void getArray() {
        Scanner scanner = new Scanner(in);
        boolean noError;
        do {
            try {
                out.print("Enter a sequence of real numbers separated by spaces : ");
                String str = scanner.nextLine();

                String[] masStr = str.split(" ");
                masNumber = new int[masStr.length];

                for (int i = 0; i < masStr.length; i++) {
                    masNumber[i] = Integer.parseInt(masStr[i]);
                }
                noError = true;
            } catch (Exception exc) {
                out.println("An error has occurred , try again.");
                noError=false;
            }
        }while (!noError);
    }

    private static void maxSum()
    {
        getArray();
        int[] sumNumber = new int[masNumber.length];
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < masNumber.length; i++) {
            sumNumber[i] = masNumber[i] + masNumber[masNumber.length - i - 1];
            out.println(masNumber[i] + " + " + masNumber[masNumber.length - i - 1] + " = " + sumNumber[i]);
            if (maxSum < sumNumber[i]) {
                maxSum = sumNumber[i];
            }
        }

        out.println("maximum amount: " + maxSum);
    }

}
