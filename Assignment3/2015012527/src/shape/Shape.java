package shape;

abstract class Shape {
    String color;
    Shape () {
        color = "#";
    }
    Shape (String strColor) {
        color = strColor;
    }
    public String getColor () {
        return color;
    }
    public void setColor (String _strColor) {
        color = _strColor;
    }
    public boolean isFilled () {
        return !(color == "#");
    }
    abstract public double getArea ();
    abstract public double getPerimeter ();
    abstract public String toString ();
}