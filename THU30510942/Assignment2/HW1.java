import java.util.Scanner;

public class HW1 {
    static Scanner in = new Scanner(System.in);
    public static void printIntegers (int x, int y, int z) {
        System.out.println("\nThe sorted intergers are: ");
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
    public static void main (String[] arguments) {
        System.out.println("Please input 3 integers: ");
        String s1 = in.next(), s2 = in.next(), s3 = in.next();
        int d1 = Integer.parseInt(s1), d2 = Integer.parseInt(s2), d3 = Integer.parseInt(s3);
        if (d1 <= d2) {
            if (d3 <= d1) {
                printIntegers(d3, d1, d2);
            }
            else if (d3 > d2) {
                    printIntegers(d1, d2, d3);
            }
            else {
                printIntegers(d1, d3, d2);
            }
        }
        else {
            if (d3 <= d2) {
                printIntegers(d3, d2, d1);
            }
            else if (d3 > d1) {
                printIntegers(d2, d1, d3);
            }
            else {
                printIntegers(d2, d3, d1);
            }
        }
    }
}