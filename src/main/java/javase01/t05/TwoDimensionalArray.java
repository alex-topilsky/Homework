package javase01.t05;

/*
Получить матрицу вида
1 0 0 ... 0 1
0 1 0 ... 1 0
0 0 1 ... 0 0
  ... ... ...
0 1 0 ... 1 0
1 0 0 ... 0 1
 */

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class TwoDimensionalArray {
  public static void main(String[] args) {
    showMatrixX();
  }

  public static int getArraySize() {
    Scanner scanner = new Scanner(in);
    int sizeMas = 0;
    out.print("Enter size array: ");
    boolean noError = false;
    do {
      try {
        sizeMas = Math.abs(Integer.parseInt(scanner.next()));
        noError = true;
      } catch (Exception exeption) {
        out.println("It is not number, try again: ");
        noError = false;
      }
    } while (!noError);
    scanner.close();
    return sizeMas;
  }

  public static void showMatrixX()
  {
    int matrixSize = getArraySize();
    int[][] xMatrix = new int [matrixSize][matrixSize];

    for (int i = 0; i < matrixSize; i++) {
      for (int j = 0; j < matrixSize; j++) {
        if (i == j || j == matrixSize - i - 1) {
          xMatrix[i][j] = 1;
        } else {
          xMatrix[i][j] = 0;
        }
        out.print(xMatrix[i][j] + " ");
      }
      out.println();
    }
  }
}
