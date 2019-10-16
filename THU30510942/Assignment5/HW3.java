import java.util.Scanner;
import java.lang.Math;

public class HW3 {
    public static int[][] generateMatrix (int n) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                mat[i][j] = (int)(Math.random() * 2);
            }
        }
        return mat;
    }
    public static void main (String[] arguments) {
        System.out.print("Please input the length of the matrix: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] mat = generateMatrix(n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }

        boolean lineFlag = false, rowFlag = false, diagonalFlag = false;
        System.out.print("\nLines with all 0s or all 1s: ");
        for (int i = 0; i < n; ++i) {
            int j = 1;
            for (; j < n; ++j) {
                if (mat[i][j] != mat[i][j - 1]) break;
            }
            if (j == n) {
                lineFlag = true;
                System.out.print(i + "; ");
            }
        }
        if (!lineFlag) System.out.print("none");

        System.out.print("\nRows with all 0s or all 1s: ");
        for (int j = 0; j < n; ++j) {
            int i = 1;
            for (; i < n; ++i) {
                if (mat[i][j] != mat[i - 1][j]) break;
            }
            if (i == n) {
                rowFlag = true;
                System.out.print(j + "; ");
            }
        }
        if (!rowFlag) System.out.print("none");

        System.out.print("\nDiagonals with all 0s or all 1s: ");
        int i = 1;
        for (; i < n; ++i) {
            if (mat[i][i] != mat[i - 1][i - 1]) break;
        }
        if (i == n) {
            diagonalFlag = true;
            System.out.print("main; ");
        }
        i = 1;
        for (; i < n; ++i) {
            if (mat[i][n - 1 - i] != mat[i - 1][n - i]) break;
        }
        if (i == n) {
            diagonalFlag = true;
            System.out.print("counter; ");
        }
        if (!diagonalFlag) System.out.print("none");
        System.out.println("");
    }
}