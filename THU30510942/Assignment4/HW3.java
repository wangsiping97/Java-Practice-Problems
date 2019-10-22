import java.util.Scanner;

public class HW3 {
    static Scanner in = new Scanner(System.in);
    public static double[] bubbleSort (double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    public static void main (String[] arguemnts) {
        System.out.println("Please input 10 real numbers: ");
        double[] array = new double[10];
        for (int i = 0; i < 10; ++i) {
            array[i] = in.nextDouble();
        }
        array = bubbleSort(array);
        System.out.println("The sorted array is: ");
        for (Double value: array) {
            System.out.print(value + " ");
        }
        System.out.println("");
    }
}