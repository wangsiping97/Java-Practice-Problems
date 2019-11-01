import java.util.Scanner;
import java.io.FileInputStream;

public class HW1 {
    public static int findMax(int[] array, int start, int length) {
        if (start == length - 1) return array[length - 1];
        return array[start] > findMax(array, start + 1, length) ? array[start] : findMax(array, start + 1, length);
    }
    public static void main (String[] arguments) throws Exception {
        FileInputStream fis = new FileInputStream("Data for HW1.txt");
        System.setIn(fis);
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(in.nextLine());
        }
        System.out.println("The max integer is: " + findMax(array, 0, n));
    }
}