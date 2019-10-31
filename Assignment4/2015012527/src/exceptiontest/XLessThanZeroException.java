package exceptiontest;

public class XLessThanZeroException extends Exception {
    double y;
    XLessThanZeroException (double _y) {
        y = _y;
    }
    public String getInfo () {
        return y + " is too small";
    }
}