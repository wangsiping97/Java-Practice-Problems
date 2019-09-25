import java.util.Scanner;

public class HW3 {
    static Scanner in = new Scanner(System.in);
    public static void main (String[] argument) {
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        System.out.print("YEAR: ");
        int year = in.nextInt();
        int j = year / 100 + 1;
        int k = year % 100;
        System.out.print("MONTH: ");
        int month = in.nextInt();
        System.out.print("DATE: ");
        int date = in.nextInt();
        int day = (date + (int)(26 * (month + 1) / 10) + k + (int)(k / 4) + (int)(j / 4) + 5 * j) % 7;
        System.out.print("The day of the week of the date is ");
        System.out.println(weekdays[day]);
    }
}