import java.util.Scanner;
import java.io.FileInputStream;

public class HW1 {
    public static int sumMajorDiagonal (int[][] m) {
        int l1 = m.length;
        int l2 = m[0].length;
        assert(l1 == l2);
        int sum = 0;
        for (int i = 0; i < m.length; ++i) {
            sum += m[i][i];
        }
        return sum;
    }
    public static void main (String[] arguments) throws Exception {
        FileInputStream fis = new FileInputStream("Data1.txt");
        System.setIn(fis);
        Scanner in = new Scanner(System.in);

        int[][] m = new int[4][4];
        int i = 0;
        while(in.hasNextLine())
		{
            String[] temp = in.nextLine().split(" ");
            for (int j = 0; j < 4; ++j) {
                m[i][j] = Integer.parseInt(temp[j]);
            }
            i++;
        }
        System.out.println("The sum of the main diagonal is: " + sumMajorDiagonal(m));
    }
}