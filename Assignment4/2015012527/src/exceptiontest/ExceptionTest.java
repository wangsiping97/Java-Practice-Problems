package exceptiontest;
import java.lang.Math;

public class ExceptionTest {
    public static int getFirstValidInt () {
        while (true) {
            try {
                return Test.readInt();
            } catch (Exception e) {}
        }
    }
    public static double getX (double y) throws Exception {
        double x = Math.log(y);
        if (x < 0) throw new XLessThanZeroException(y);
        if (x > 1) throw new XGreaterThanOneException();
        return x;
    }
    public static double solve (double y) {
        double x;
        try {
            x = Test.solve2(y);
        } catch (XLessThanZeroException e) {
            return -1;
        } catch (XGreaterThanOneException e) {
            return -2;
        }
        return x;
    }
}