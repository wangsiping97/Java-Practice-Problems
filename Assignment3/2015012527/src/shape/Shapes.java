package shape;

class Shapes {
    Shape[] shapes;
    Shapes (Shape[] _shapes) {
        shapes = _shapes;
    }
    public double getArea () {
        double sum = 0;
        for (Shape shape: shapes) {
            sum += shape.getArea();
        }
        return sum;
    }
    public double getFilledArea () {
        double sum = 0;
        for (Shape shape: shapes) {
            if (shape.isFilled()) {
                sum += shape.getArea();
            }
        }
        return sum;
    }
    public String toString() {
        String str = "";
        for (Shape shape: shapes) {
            str += shape.toString();
            str += ", ";
        }
        str = str.substring(0,str.length() - 2);
        return "[" + str + "]";
    }
}