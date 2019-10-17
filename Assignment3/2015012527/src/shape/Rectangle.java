package shape;

import org.w3c.dom.css.Rect;

class Rectangle extends Shape {
    double width;
    double height;
    Rectangle () {
        super();
    }
    Rectangle (double _width, double _height) {
        super();
        width = _width;
        height = _height;
    }
    Rectangle (double _width, double _height, String _color) {
        super(_color);
        width = _width;
        height = _height;
    }
    public double getWidth () {
        return width;
    }
    public void setWidth (double _width) {
        width = _width;
    }
    public double getHeight () {
        return height;
    }
    public void setHeight (double _height) {
        height = _height;
    }
    public double getArea () {
        return width * height;
    }
    public double getPerimeter () {
        return 2 * (width + height);
    }
    public String toString() {
        return "Rectangle (" + color + ")";
    }
}