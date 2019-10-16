import java.util.Scanner;

public class HW4 {
    public static boolean isConsecutiveFoure (int[][] values) {
        int[][] lines = searchLines(values);
        int[][] rows = searchRows(values);
        int[][] md = searchMainDiagonal(values);
        int[][] cd = searchCounterDiagonal(values);
        if (lines[0][0] == -1 && rows[0][0] == -1 && md[0][0] == -1 && cd[0][0] == -1) return false;
        return true;
    }
    public static int[][] generateMatrix (int n) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                mat[i][j] = (int)(Math.random() * 2);
            }
        }
        return mat;
    }
    public static int[][] searchLines (int[][] mat) {
        int n = mat.length;
        int[][] lines = new int[n][3];
        for (int i = 0; i < n; ++i) {
            lines[i][0] = -1;
            lines[i][1] = -1;
            lines[i][2] = -1;
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= n - 4; ++j) {
                if (mat[i][j] == mat[i][j + 1] && mat[i][j + 1] == mat[i][j + 2] && mat[i][j + 2] == mat[i][j + 3]) {
                    lines[count][2] = mat[i][j];
                    lines[count][0] = i;
                    lines[count++][1] = j;
                }
            }
        }
        return lines;
    }
    public static int[][] searchRows (int[][] mat) {
        int n = mat.length;
        int[][] rows = new int[n][3];
        for (int i = 0; i < n; ++i) {
            rows[i][0] = -1;
            rows[i][1] = -1;
            rows[i][2] = -1;
        }
        int count = 0;
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i <= n - 4; ++i) {
                if (mat[i][j] == mat[i + 1][j] && mat[i][j] == mat[i + 2][j] && mat[i][j] == mat[i + 3][j]) {
                    rows[count][2] = mat[i][j];
                    rows[count][0] = i;
                    rows[count++][1] = j;
                }
            }
        }
        return rows;
    }
    public static int[][] searchMainDiagonal (int[][] mat) {
        int n = mat.length;
        int[][] md = new int[n][3];
        for (int i = 0; i < n; ++i) {
            md[i][0] = -1;
            md[i][1] = -1;
            md[i][2] = -1;
        }
        int count = 0;
        for (int i = 0; i <= n - 4; ++i) {
            if (mat[i][i] == mat[i + 1][i + 1] && mat[i][i] == mat[i + 2][i + 2] && mat[i][i] == mat[i + 3][i + 3]) {
                md[count][2] = mat[i][i];
                md[count][0] = i;
                md[count++][1] = i; 
            }
        }
        return md;
    }
    public static int[][] searchCounterDiagonal (int[][] mat) {
        int n = mat.length;
        int[][] cd = new int[n][3];
        for (int i = 0; i < n; ++i) {
            cd[i][0] = -1;
            cd[i][1] = -1;
            cd[i][2] = -1;
        }
        int count = 0;
        for (int i = 0; i <= n - 4; ++i) {
            if (mat[i][n - 1 - i] == mat[i + 1][n - 2 - i] && mat[i][n - 1 - i] == mat[i + 2][n - 3 - i] && mat[i][n - 1 - i] == mat[i + 3][n - 4 - i]) {
                cd[count][2] = mat[i][n - 1 - i];
                cd[count][0] = i;
                cd[count++][1] = n - 1 - i; 
            }
        }
        return cd;
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

        int[][] lines = searchLines(mat);
        int[][] rows = searchRows(mat);
        int[][] md = searchMainDiagonal(mat);
        int[][] cd = searchCounterDiagonal(mat);

        System.out.println(isConsecutiveFoure(mat));

        System.out.print("\nLines with 4 0s or 4 1s start by: ");
        for (int i = 0; i < n; ++i) {
            if (lines[i][0] == -1) {
                if (i == 0) System.out.print("none");
                break;
            }
            System.out.print("(" + lines[i][0] + "," + lines[i][1] + ") value=" + lines[i][2] + "; ");
        }

        System.out.print("\nRows with 4 0s or 4 1s start by: ");
        for (int i = 0; i < n; ++i) {
            if (rows[i][0] == -1) {
                if (i == 0) System.out.print("none");
                break;
            }
            System.out.print("(" + rows[i][0] + "," + rows[i][1] + ") value=" + rows[i][2] + "; ");
        }

        System.out.print("\nMain diagonals with 4 0s or 4 1s start by: ");
        for (int i = 0; i < n; ++i) {
            if (md[i][0] == -1) {
                if (i == 0) System.out.print("none");
                break;
            }
            System.out.print("(" + md[i][0] + "," + md[i][1] + ") value=" + md[i][2] + "; ");
        }

        System.out.print("\nCounter diagonals with 4 0s or 4 1s start by: ");
        for (int i = 0; i < n; ++i) {
            if (cd[i][0] == -1) {
                if (i == 0) System.out.print("none");
                break;
            }
            System.out.print("(" + cd[i][0] + "," + cd[i][1] + ") value=" + cd[i][2] + "; ");
        }
        System.out.println("");
    }
}