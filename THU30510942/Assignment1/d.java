import java.util.Scanner;
import java.lang.Math;

public class d {
    public static void main(String[] arguments) {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print("Please input t_a(-58 ~ 41) and v(>=2):\n");
            String s_t_a = in.next(), s_v = in.next();
            float t_a = Float.parseFloat(s_t_a);
            float v = Float.parseFloat(s_v);
            if (t_a >= -58 && t_a <= 41 && v >= 2) {
                System.out.println("t_wc = " + String.valueOf(35.74 + 0.6215 * t_a - 35.75 * Math.pow(v, 0.16) + 0.4275 * t_a * Math.pow(v, 0.16)));
                flag = false;
            }
            else {
                System.out.print("Invalid input! ");
            }
        }
    }
}