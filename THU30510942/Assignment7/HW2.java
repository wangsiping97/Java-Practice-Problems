import java.util.Scanner;
import java.io.FileInputStream;

public class HW2 {
    public static boolean dfs(int x, int y, int[][] array, int[][] row, int[][] column, int[][][] cube) {
        if (x == 9 && y == 0) {
            print(array);
            return true;
        }
        int xx, yy;
        if (y == 8) {
            xx = x + 1;
            yy = 0;
        }
        else{
            xx = x;
            yy = y + 1;
        }
        if (array[x][y] != 0) return dfs(xx, yy, array, row, column, cube);
        for (int k = 1; k <= 9; k++)
            if (row[x][k] == 0 && column[y][k] == 0 && cube[x/3][y/3][k] == 0){
                array[x][y] = k;
                row[x][k] = 1;
                column[y][k] = 1;
                cube[x/3][y/3][k] = 1;
                boolean temp = dfs(xx, yy, array, row, column, cube);
                array[x][y] = 0;
                row[x][k] = 0;
                column[y][k] = 0;
                cube[x/3][y/3][k] = 0;
                if (temp) {
                    return true;
                }
            }
        return false;
    }
    public static void print(int[][] array) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                System.out.print(array[i][j] + " ");
                if (j % 3 == 2) {
                    System.out.print(" ");
                }
            }
            if (i % 3 == 2) {
                System.out.println("");
            }
            System.out.println("");
        }
    }
    public static void main (String[] arguments) throws Exception {
        FileInputStream fis = new FileInputStream("Data3.txt");
        System.setIn(fis);
        Scanner in = new Scanner(System.in);
        int[][] array = new int[9][9];
        for (int i = 0; i < 9; ++i) {
            String[] temp = in.nextLine().split(" ");
            for (int j = 0; j < 9; ++j)
                array[i][j] = Integer.parseInt(temp[j]);
        }
        int[][] row = new int[9][10];
        int[][] column = new int[9][10];
        int[][][] cube = new int[3][3][10];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                row[i][array[i][j]]=1;
                column[j][array[i][j]]=1;
                cube[i/3][j/3][array[i][j]]=1;
            }
        }
        dfs(0,0,array,row,column,cube);
    }
}