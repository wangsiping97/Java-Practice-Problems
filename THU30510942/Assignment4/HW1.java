import java.util.Scanner;

public class HW1 {
    static Scanner in = new Scanner(System.in);

    public static void main (String[] arguments) {
        int[] array = new int[10];
        int count = 0;
        for (int i = 0; i < 10; ++i) {
            int temp = in.nextInt();
            boolean flag = true;
            for (int j = 0; j < count; ++j) {
                if (array[j] == temp) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                array[count] = temp;
                count++;
            }
        }
        for (int i = 0; i < count; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}