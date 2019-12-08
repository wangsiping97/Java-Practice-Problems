import java.lang.Math;
import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    QuadraticEquation () {}
    QuadraticEquation (double _a, double _b, double _c) {
        a = _a;
        b = _b;
        c = _c;
    }
    public double getA () {
        return a;
    }
    public double getB () {
        return b;
    }
    public double getC () {
        return c;
    }
    public double getDiscriminant () {
        return b * b - 4 * a * c;
    }
    public double getRoot1 () {
        double delta = getDiscriminant();
        if (delta < 0) return 0;
        if (a == 0) return (-c / b);
        return (-b + Math.sqrt(delta)) / (2 * a);
    }
    public double getRoot2 () {
        double delta = getDiscriminant();
        if (delta < 0) return 0;
        if (a == 0) return (-c / b);
        return (-b - Math.sqrt(delta)) / (2 * a);
    }
    public static void main (String[] arguments) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the value of a, b and c: ");
        double a, b, c;
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();
        QuadraticEquation qe = new QuadraticEquation(a, b, c);
        double delta = qe.getDiscriminant();
        if (delta == 0) {
            double root = qe.getRoot1();
            System.out.println("The root of the equation is: " + root);
            return;
        }
        if (delta > 0) {
            double root1 = qe.getRoot1();
            double root2 = qe.getRoot2();
            System.out.println("The roots of the equation is: " + root1 + " and " + root2);
            return;
        }
        else {
            System.out.println("The equation has no root. ");
        }
    }
}