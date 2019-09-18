public class HW3 {
    public static void main(String[] arguments) {
        long nownum = 329447467;
        long second = 365 * 24 * 60 * 60;
        for (int i = 1; i <= 5; ++i) {
            long birth = i * second / 7;
            long death = i * second / 13;
            long immigrant = i * second / 45;
            System.out.println(nownum + birth - death + immigrant);
        }
    }
}