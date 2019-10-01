import java.lang.Math;

public class HW5 {
    public static void main(String[] arguments) {
        double pi = 0;
        for (int j = 1; j <= 10; ++j) {
            for (int i = (j - 1) * 10000 + 1; i <= j * 10000; ++i) {
                pi += (double)4 * Math.pow(-1, i - 1) / (double)(2 * i - 1);
            }
            System.out.printf("i = %d, pi = %f\n", j * 10000, pi);
        }
    }
}