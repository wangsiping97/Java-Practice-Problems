import java.lang.Math;

public class RegularPolygon {
    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;
    RegularPolygon () { }
    RegularPolygon (int _n, double _side) {
        n = _n;
        side = _side;
    }
    RegularPolygon (int _n, double _side, double _x, double _y) {
        n = _n;
        side = _side;
        x = _x;
        y = _y;
    }
    public int getN () {
        return n;
    }
    public double getSide () {
        return side;
    }
    public double getX () {
        return x;
    }
    public double getY () {
        return y;
    }
    public void setN (int _n) {
        n = _n;
    }
    public void setSide (double _side) {
        side = _side;
    }
    public void setX (double _x) {
        x = _x;
    }
    public void setY (double _y) {
        y = _y;
    }
    public double getPerimeter () {
        return n * side;
    }
    public double getArea () {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }
    public static void main (String[] arguments) {
        RegularPolygon rp1 = new RegularPolygon();
        RegularPolygon rp2 = new RegularPolygon(6, 4);
        RegularPolygon rp3 = new RegularPolygon(10, 4, 5.6, 7.8);
        System.out.println("The 1st object: ");
        System.out.println("Premeter: " + rp1.getPerimeter() + "; Area: " + rp1.getArea());
        System.out.println("The 2nd object: ");
        System.out.println("Premeter: " + rp2.getPerimeter() + "; Area: " + rp2.getArea());
        System.out.println("The 3rd object: ");
        System.out.println("Premeter: " + rp3.getPerimeter() + "; Area: " + rp3.getArea());
    }
}