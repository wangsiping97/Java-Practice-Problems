import java.util.Scanner;
public class HW1 {
    static Scanner in = new Scanner(System.in);
    public static void main (String[] arguments) {
        System.out.print("Please input a celsius degree: ");
        double c = in.nextDouble();
        System.out.println("The fahrenheit degree is: " + celsiusToFahrenheit(c) + "\n");
        System.out.print("Please input a fahrenheit degree: ");
        double f = in.nextDouble();
        System.out.println("The celsius degree is: " + fahrenheitToCelsius(f) + "\n");
    }
    /** Convert from Celsius to Fahrenheit */
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 1.8 + 32;
    }
    /** Converts from Fahrenheit to Celsius */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }
}