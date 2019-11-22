public class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;
    MyRectangle2D () {
        x = 0;
        y = 0;
        width = 1;
        height = 1;
    }
    MyRectangle2D (double _x, double _y, double _w, double _h) {
        x = _x;
        y = _y;
        width = _w;
        height = _h;
    }
    public void setX (double _x) {
        x = _x;
    }
    public void setY (double _y) {
        y = _y;
    }
    public void setWidth (double _w) {
        width = _w;
    }
    public void setHeight (double _h) {
        height = _h;
    }
    public double getX () {
        return x;
    }
    public double getY () {
        return y;
    }
    public double getWidth () {
        return width;
    }
    public double getHeight () {
        return height;
    }
    public double getArea () {
        return width * height;
    }
    public double getPerimeter () {
        return 2 * (width + height);
    }
    public boolean contains (double _x, double _y) {
        return (_x > x - width / 2) && (_x < x + width / 2) && (_y > y - height / 2) && (_y < y + height / 2);
    }
    public boolean contains (MyRectangle2D r) {
        double left = r.getX() - r.getWidth()/2;
        double right = r.getX() + r.getWidth()/2;
        double up = r.getY() + r.getHeight()/2;
        double down = r.getY() - r.getHeight()/2;
        return (left > x - width/2) && (right < x + width/2) && (up < y + height/2) && (down > y - height/2);
    }
    public boolean overlaps (MyRectangle2D r) {
        double left = r.getX() - r.getWidth()/2;
        double right = r.getX() + r.getWidth()/2;
        double up = r.getY() + r.getHeight()/2;
        double down = r.getY() - r.getHeight()/2;
        return !((left > x + width/2) || (right < x - width/2) || (up < y - height/2) || (down > y + height/2));
    }
    public static void main (String[] args) {
        MyRectangle2D r1 = new MyRectangle2D (2,2,5.5,4.9);
        System.out.println ("Area: " + r1.getArea());
        System.out.println ("Perimeter: " + r1.getPerimeter());
        System.out.println ("Contains (3, 3): " + r1.contains(3, 3));
        System.out.println ("Contains r: " + r1.contains(new MyRectangle2D(4,5,10.5,3.2)));
        System.out.println ("Overlaps: " + r1.overlaps(new MyRectangle2D(3,5,2.3,5.4)));
    }
}