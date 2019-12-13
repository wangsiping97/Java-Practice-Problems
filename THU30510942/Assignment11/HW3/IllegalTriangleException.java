package HW3;

public class IllegalTriangleException extends Exception {
    private static final long serialVersionUID = 1L;
    IllegalTriangleException() {
    }
    IllegalTriangleException(double a, double b, double c) {
        super("Invalid sides " + a + " " + b + " " + c);
    }
}