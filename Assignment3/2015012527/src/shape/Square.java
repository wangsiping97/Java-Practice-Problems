package shape;

class Square extends Rectangle {
    Square () {
        super();
    }
    Square (double _side) {
        super(_side, _side);
    }
    Square (double _side, String _color) {
        super(_side, _side, _color);
    }
    public double getSide () {
        return width;
    }
    public void setSide (double _side) {
        width = _side;
        height = _side;
    }
    public String toString() {
        return "Square (" + color + ")";
    }
}