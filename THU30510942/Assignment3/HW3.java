import java.lang.Math;

public class HW3 {
    public static void main(String[] arguments) {
        System.out.println("i     m(i)");
        double early = 0;
        for (int i = 1; i <= 20; ++i) {
            System.out.printf("%2d%10.4f\n", i, m(i));
        }
    }
    public static double m(int i) {
        if (i == 1) return (double)1 / 2;
        else return m(i - 1) + (double)i / (i + 1);
    }
}