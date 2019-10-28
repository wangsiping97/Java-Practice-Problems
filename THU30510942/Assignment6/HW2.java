import java.util.Scanner;

public class HW2 {
    public static boolean judgePassword(String password) {
        if (password.length() < 8) return false;
        int n = password.length();
        int count = 0;
        for (int i = 0; i < n; ++i) {
            char c = password.charAt(i);
            int index = c - '0';
            if (index < 0 || (index > 9 && index < 17) || (index > 42 && index < 49) || (index > 74)) return false;
            if (index >= 0 && index <= 9) {
                count++;
            }
        }
        if (count < 2) return false;
        return true;
    }
    public static void main(String[] arguments) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input a password: ");
        String password = in.next();
        if (judgePassword(password)) {
            System.out.println("Valid password");
        }
        else {
            System.out.println("Invalid password");
        }
    }
}