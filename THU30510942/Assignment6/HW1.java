import java.lang.Math;
import java.util.Scanner;

public class HW1 {
    public static double computeRadian(double _x) {
        return Math.PI * _x / 180;
    }
    public static double maxDistance (double _x1, double _y1, double _x2, double _y2) {
        return 6371 * Math.acos(Math.sin(_x1) * Math.sin(_x2) + Math.cos(_x1) * Math.cos(_x2) * Math.cos(_y1 - _y2));
    }
    public static void main(String[] arguments) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input longitude1: ");
        double x1 = in.nextDouble();
        System.out.print("Please input latitude1: ");
        double y1 = in.nextDouble();
        System.out.print("Please input longitude2: ");
        double x2 = in.nextDouble();
        System.out.print("Please input latitude2: ");
        double y2 = in.nextDouble();
        double ans = maxDistance(computeRadian(x1), computeRadian(y1), computeRadian(x2), computeRadian(y2));
        System.out.println("The maximum circle distance between them is: " + ans + " km.");
    }
}