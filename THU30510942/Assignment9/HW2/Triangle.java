import java.lang.Math;

public class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    Triangle () { }
    Triangle (double _side1, double _side2, double _side3) {
        side1 = _side1;
        side2 = _side2;
        side3 = _side3;
    }
    public double getSide1 () {
        return side1;
    }
    public double getSide2 () {
        return side2;
    }
    public double getSide3 () {
        return side3;
    }
    public double getArea () {
        double p = (side1 + side2 + side3) / 2;
        double temp = p * (p - side1) * (p - side2) * (p - side3);
        if (temp < 0) return 0;
        return Math.sqrt(temp);
    }
    public double getPerimeter () {
        return side1 + side2 + side3;
    }
    public String toString () {
        return "Triangle: side1= "+side1+ " side2= "+side2+ " side3= "+side3;
    }

    public static void main (String[] args) {
        Triangle test = new Triangle(1.2, 1.5, 1);
        test.setColor("yellow");
        test.setFilled(true);
        System.out.println(test.getArea());
        System.out.println(test.getPerimeter());
        System.out.println(test.getColor());
        System.out.println(test.ifFilled());
        System.out.println(test.toString());
    }
}