import java.util.Random;

public class HW1 {
    static Random r = new Random(1000);
    public static void main (String[] arguments) {
        System.out.print("0-100之间的前50个随机整数为：");
        for (int i = 0; i < 50; ++i) {
            System.out.print(r.nextInt(100) + " ");
        }
        System.out.println("");
    }
}