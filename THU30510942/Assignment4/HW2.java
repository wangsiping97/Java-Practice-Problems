import java.util.Scanner;

public class HW2 {
    static Scanner in = new Scanner(System.in);
    public static int average (int[] array) {
        int n = array.length;
        int sum = 0;
        for (Integer value: array) {
            sum += value;
        }
        return sum / n;
    }
    public static double average (double[] array) {
        int n = array.length;
        double sum = 0;
        for (Double value: array) {
            sum += value;
        }
        return sum / n;
    }
    public static void main (String[] arguments) {
        System.out.println("Please input 10 integers: ");
        int[] a = new int[10];
        for (int i = 0; i < 10; ++i) {
            a[i] = in.nextInt();
        }
        System.out.println("The average of the inputs is: " + average(a));

        System.out.println("Please input 10 real numbers: ");
        double[] b = new double[10];
        for (int i = 0; i < 10; ++i) {
            b[i] = in.nextDouble();
        }
        System.out.println("The average of the inputs is: " + average(b));
    }
}