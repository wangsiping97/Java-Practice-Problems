import java.util.Scanner;
import java.lang.Math;

public class MyTriangle {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] arguments) {
        System.out.println("Please input three sides of a triangle: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        if (isValid(a, b, c) == true) {
            System.out.println("The area of the triangle is: " + area(a, b, c));
        }
        else {
            System.out.println("Invalid input!");
        }
    }
    /** Return true if the sum of any 2 sides is greater than the 3rd*/
    public static boolean isValid(double side1, double side2, double side3) {
        return side1 > 0 && side2 > 0 && side3 > 0 && side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1;
    }
    /** Return the area of the triangle */
    public static double area(double side1, double side2, double side3) {
        if (isValid(side1, side2, side3) == false) return 0;
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
}