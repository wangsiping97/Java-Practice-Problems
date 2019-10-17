package shape;
import java.lang.Math;

class Circle extends Shape {
    double radius;
    Circle () {
        super();
    }
    Circle (double _radius) {
        super();
        radius = _radius;
    }
    Circle (double _radius, String _color) {
        super(_color);
        radius = _radius;
    }
    public double getRadius () {
        return radius;
    }
    public void setRadius (double _radius) {
        radius = _radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getPerimeter () {
        return 2 * Math.PI * radius;
    }
    public String toString() {
        return "Circle (" + color + ")";
    }
}