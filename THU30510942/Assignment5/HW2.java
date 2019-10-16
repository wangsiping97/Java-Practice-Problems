import java.util.Scanner;
import java.io.FileInputStream;

public class HW2 {
    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        int m = a.length;
        int k1 = a[0].length;
        int k2 = b.length;
        assert(k1 == k2);
        int n = b[0].length;
        double[][] ans = new double[m][n];
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < k1; ++j) {
                    ans[i][k] += a[i][j] * b[j][k];
                }
            }
        }
        return ans;
    }
    public static void main (String[] arguments) throws Exception {
        FileInputStream fis1 = new FileInputStream("Data2-1.txt");
        System.setIn(fis1);
        Scanner in = new Scanner(System.in);
        double[][] a = new double[3][3];
        int i = 0;
        while(in.hasNextLine())
		{
            String[] temp = in.nextLine().split(" ");
            for (int j = 0; j < 3; ++j) {
                a[i][j] = Double.parseDouble(temp[j]);
            }
            i++;
        }
        double[][] b = new double[3][3];
        i = 0;
        in.close();
        FileInputStream fis2 = new FileInputStream("Data2-2.txt");
        System.setIn(fis2);
        Scanner in2 = new Scanner(System.in);
        while(in2.hasNextLine())
		{
            String[] temp = in2.nextLine().split(" ");
            for (int j = 0; j < 3; ++j) {
                b[i][j] = Double.parseDouble(temp[j]);
            }
            i++;
        }
        in2.close();
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(multiplyMatrix(a, b)[i][j] + " ");
            }
            System.out.println("");
        }
    }
}