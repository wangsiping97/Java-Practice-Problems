import java.util.Scanner;

public class HW4 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] arguments) {
        System.out.println("Please input several integers endding with 0: ");
        int countPositive = 0, countNegative = 0, sum = 0;
        while (true) {
            int temp = in.nextInt();
            if (temp == 0) break;
            sum += temp;
            if (temp > 0) countPositive++;
            else countNegative++;
        }
        double ave = (double)(sum)/(double)(countNegative + countPositive);
        System.out.printf("There are %d positive integers.\n", countPositive);
        System.out.printf("There are %d negative integers.\n", countNegative);
        System.out.printf("The sum of the integers is %d.\n", sum);
        System.out.printf("The average of the integers is %f.\n", ave);
    }
}